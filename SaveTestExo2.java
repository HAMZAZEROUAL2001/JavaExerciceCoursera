import java.util.Scanner;
class Magie
{
// L'histoire générale :
public static void main(String[] args) {
Spectateur thorin = new Spectateur(); // Il était une fois un spectateur...
thorin.arriver(); // ...qui venait voir un spectacle (!!)...
Magicien gandalf = new Magicien(); // ...où un magicien...
Assistant bilbo = new Assistant(); // ...et son assistant...
gandalf.tourDeMagie(bilbo, thorin); // ...lui firent un tour fantastique
}
}
// un bout de papier... pour ce tour de magie
class Papier {
// les données sur le papier
private int age;
private int argent;
// on peut écrire sur le papier
public void ecrire(int unAge, int unMontant) {
age = unAge;
argent = unMontant;
}
// et on peu lire les données depuis le papier
public int lireAge() { return age ; }
public int lireArgent() { return argent; }
}
// --------------------------------------
class Assistant {
/* l'assistant mémorise dans son cerveau les valeurs lues
* et le resultat du calcul.
*/
private int ageLu;
private int argentLu;
private int resultat;
public void lire(Papier billet) {
System.out.println("[Assistant] (je lis le papier)");
ageLu = billet.lireAge();
argentLu = billet.lireArgent();
}
public void calculer() {
System.out.println("[Assistant] (je calcule mentalement)");
resultat = ageLu * 2;
resultat += 5;
resultat *= 50;
resultat += argentLu;
resultat -= 365;
}
public int annoncer() {
System.out.println("[Assistant] J'annonce : " + resultat + " !" );
return resultat;
}
}
// --------------------------------------
class Spectateur {
// pour le moment a prendre comme tel (vu dans le MOOC précédent)
// nous y reviendrons dans ce cours:
private final static Scanner clavier = new Scanner(System.in);
// Les spécificités du spectateur
private int age;
private int argent;
// lorsqu'il entre dans la salle (avant il n'existe pas pour nous)
public void arriver() {
System.out.println("[Spectateur] (j'entre en scène)");
System.out.print("Quel âge ai-je ? ");
age = clavier.nextInt();
do {
System.out.print("Combien d'argent ai-je en poche (<100) ? ");
argent = clavier.nextInt();
} while (argent >= 100);
System.out.println("[Spectateur] (j'ai un montant qui convient)");
}
/* Dans cette modélisation on suppose que le papier
n'appartient à personne : il a été par exemple trouvé
dans la salle de spectacle
*/
// écrit sur un papier
public void ecrire(Papier billet) {
System.out.println("[Spectateur] (j'écris le papier)");
billet.ecrire(age, argent);
}
}
// --------------------------------------
class Magicien {
// ce que le magicien doit deviner:
private int ageDevine;
private int argentDevine;
// pour faire son tour, le magicien a besoin d'au moins
// un spectateur et d'un assistant
public void tourDeMagie(Assistant fidele, Spectateur quidam) {
Papier billet = new Papier();
System.out.println("[Magicien] un petit tour de magie...");
// le magicien donne ses instructions :
quidam.ecrire(billet);
fidele.lire(billet);
fidele.calculer();
calculer(fidele.annoncer());
annoncer();
}
// partie privée ici car seul le magicien sait ce qu'il doit
// faire dans son tour
private void calculer(int resultatRecu) {
resultatRecu += 115;
ageDevine = resultatRecu / 100;
argentDevine = resultatRecu % 100;
}
private void annoncer() {
System.out.println("[Magicien] "
+ " - hum... je vois que vous êtes agé de "
+ ageDevine + " ans ");
System.out.println(" et que vous avez " + argentDevine + " francs suisses en poche !");
}
}
