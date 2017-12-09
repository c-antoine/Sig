import javax.swing.*;
import java.util.Scanner;

public class Calcul {
    
    private double longA	;
    private double longB	;
    private double latA	;
    private double latB	;
    private double distance;

    public void calcul(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez les valeurs dans cette ordre : longA longB LatA, LatB");
        this.longA = sc.nextFloat()* 3.14 / 180;
        this.longB = sc.nextFloat()* 3.14 / 180;
        this.latA = sc.nextFloat()* 3.14 / 180;
        this.latB = sc.nextFloat()* 3.14 / 180;

        System.out.println("vos valeur sont "+this.longA+", "+ this.longB+" , "+this.latA+", "+ this.latB);
        // (A, B) = R * arccos (sin (lata) sin * (LATB) + cos (lata) cos * (LATB) cos * (Lona-lonB))
        distance = 6372.795477598* Math.acos(Math.sin(this.latA) * Math.sin(this.latB) + Math.cos(this.latA) * Math.cos(this.latB) * Math.cos(this.longA - this.longB));
        System.out.println(distance);
    }

    // Test values
    //        double longA1 = 46.221334 * 3.14 / 180;
    //        double longB1 = 46.181819 * 3.14 / 180;
    //        double latA1 = 5.244226 * 3.14 / 180;
    //        double latB1 = 5.205233 * 3.14 / 180;

    public static void main(String[] args) {

    }

}