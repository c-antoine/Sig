import javax.swing.*;
import java.util.Scanner;

public class Calcul {

    public static void main(String[] args) {

        float longA	;
        float longB	;
        float latA	;
        float latB	;
        double distance;

        //        double longA1 = 46.221334 * 3.14 / 180;
        //        double longB1 = 46.181819 * 3.14 / 180;
        //        double latA1 = 5.244226 * 3.14 / 180;
        //        double latB1 = 5.205233 * 3.14 / 180;

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez les valeurs dans cette ordre : longA longB LatA, LatB");
        double longA1 = sc.nextFloat()* 3.14 / 180;
        double longB1 = sc.nextFloat()* 3.14 / 180;
        double latA1 = sc.nextFloat()* 3.14 / 180;
        double latB1 = sc.nextFloat()* 3.14 / 180;

        System.out.println("vos valeur sont "+longA1+", "+ longB1+" , "+latA1+", "+ latB1);
        // (A, B) = R * arccos (sin (lata) sin * (LATB) + cos (lata) cos * (LATB) cos * (Lona-lonB))
        distance = 6372.795477598* Math.acos(Math.sin(latA1) * Math.sin(latB1) + Math.cos(latA1) * Math.cos(latB1) * Math.cos(longA1 - longB1));
        System.out.println(distance);

    }

}