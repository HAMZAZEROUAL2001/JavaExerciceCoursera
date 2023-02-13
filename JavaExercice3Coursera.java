

import java.util.Scanner;

class Geometrie {
	/**
	* Le programme principal se contente de construire un
	* triangle, d'afficher son périmètre et d'afficher
	* s'il est isocèle ou non.
	*/
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
	Point p1 = new Point();
	Point p2 = new Point();
	Point p3 = new Point();
	Triangle t = new Triangle();
	initPoint(p1); 
	initPoint(p2);
	initPoint(p3);
	t.setSomments(p1, p2, p3);
	double perimetre = t.calculerPerimetre();
	System.out.println("Perimetre : " + perimetre);
	boolean isocele = t.testerIsocele();
	if (isocele)
	System.out.println("Le triangle est isocèle");
	else
	System.out.println("Le triangle n'est pas isocèle");
	}
	/* Initialisation d'un point
	* on fait le choix de traiter les données entrées par l'utilisateur
	* en dehors de la méthode d'initialisation de l'objet Point
	* ceci permettrait de garantir que l'on ne fournit que des valeurs
	* valides à la méthode initilalisant le point
	* (non traités ici mais que vous pouvez ajouter en extension)
	*/
	static void initPoint(Point p) {
	double x = 0;
	double y = 0;
	System.out.println("Construction d'un nouveau point");
	System.out.print(" Veuillez entrer x : ");
	x = scanner.nextDouble();
	System.out.print(" Veuillez entrer y : ");
	y = scanner.nextDouble();
	// eventuellement des tests d'intégrité des données lues
	// et donner plusieurs chances de saisie à l'utilisateur
	p.init(x,y);
	}
}




class Triangle {
	private Point p1, p2, p3;
	private double longueur1, longueur2,longueur3;
	
	public void setSomments(Point point1,Point point2,Point point3){
	p1 = point1;
	p2 = point2;
	p3 = point3;
	// Les distances sont calculées et stockées dans des
	// attributs. Les méthodes calculerPerimetre et testerIsocele
	// peuvent ainsi accéder aux valeurs précalculées et nous évitons
	// de les recalculer plusieurs fois.
	longueur1 = p1.calculerDistance(p2);
	longueur2 = p2.calculerDistance(p3);
	longueur3 = p3.calculerDistance(p1);	
		
	}
	/**
	* Calcul du perimètre de l'instance courante (this).
	* @return le perimetre sous la forme d'un double
	*/
	
	public double calculerPerimetre() {
	return (longueur1 + longueur2 + longueur3);
	}
	/**
	* Teste si l'instance courante (this) est un triangle isocèle
	* 
	*/
	public boolean testerIsocele(){
		return (longueur1 == longueur3 || longueur2 == longueur3
			|| longueur3 == longueur1);
	}

}

class Point{
	private double x,y;
	
	/*
	* encore un constructeur en devenir 
	*/

	public void init (double x,double y){
		this.x = x ;
		this.y = y ;	
	}
	public double getX(){
		return x ;
	}
	public double getY(){
		return y;
	}
	
	/**
	* Calcule la distance entre this et un point p
	* @param p un Point par rapport auquel on calcule la distance
	* @return la distance de this à p
	*/
	public double calculerDistance(Point p){
	
	// Calcule la distance entre deux points. Le premier point est
	// l'objet actuel (this). Le deuxième point (p) est envoyé en
	// paramètre.
	double x1 =  this.x ;
	double y1 =  this.y ;
	
	double x2 = p.getX();
	double y2 = p.getY();
	
	double xdiff = x1 - x2;
	double ydiff = y1 - y2;
	
	double somme = xdiff * xdiff + ydiff * ydiff ;
	double distance = Math.sqrt(somme);
	
	return distance ;
	
	}
	
	

}


