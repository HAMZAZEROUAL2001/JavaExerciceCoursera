
class Cercle {
	double rayon ;
	double x; // abscisse du centre
	double y; // ordonnee du centre
	/*void setCentre(double x , double y){
		return x,y;
	}
	void setRayon(double){
		return rayon;
	
	}
	*/
	// calcule de la surface du cercle 
	public double surface(){
		
		return Math.PI*rayon * rayon ; 
	}
	public boolean  estInterieur(double unx,double uny){
		return (((unx-x) * (unx-x) +(uny-y) * (uny-y))<= rayon *rayon);
		
	}
	
	public void setCentre(double unX,double unY){
		x= unX;
		y= unY;
	}
	public void setRayon(double r){
		if(r < 0.0) r=0.0 ;
		rayon = r ; 
	
	}
}

class TestCercle {
/**
programme principal testeur les fonctionnalites de la class cercle

**/
public static void main (String [] args ){
		Cercle c1 = new Cercle() ;
		Cercle c2 = new Cercle() ;
		Cercle c3 = new Cercle() ;
		
		c1.setCentre(1.0,2.0);
		c1.setRayon(Math.sqrt(5.0)); // passer par (0.0)
		
		c2.setCentre(-1.0,1.0);
		c2.setRayon(2.25);
		
		c3.setCentre(1.0,-5.0);
		c3.setRayon(1.0);
		System.out.println("surface de c1:"+ c1.surface());
		System.out.println("surface de c2:"+ c2.surface());
		System.out.println("surface de c3:"+ c3.surface());
		
		afficherPosition("c1",c1,0.0,0.0);
		afficherPosition("c2",c1,0.0,0.0);
		afficherPosition("c3",c1,0.0,0.0);
			
	}

	static void afficherPosition (String nom , Cercle c ,double x ,double y){
	System.out.print("Position du point ("+ x +","+ y +") : " );
	
	if (c.estInterieur(x,y)){
	
		System.out.print("dans ");
	}
	else {
	
	System.out.print("hors de ");
	
	}
	System.out.print(nom);
	}
}




	
