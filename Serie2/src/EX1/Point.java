
package EX1;

/**
 *
 * @author Touailab ilyase
 */
public class Point {
    
    private char nom;
    private double x;

    public Point(char nom, double x) {
        this.nom = nom;
        this.x = x;
    }

    public char getNom() {
        return nom;
    }

    public void setNom(char nom) {
        this.nom = nom;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    
    public void Afficher()
    {
        System.out.println("le nom du point est : "+nom+", l 'abscisse : "+x);
    }
    
}
