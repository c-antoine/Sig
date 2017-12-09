import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) throws Exception {

        //Initialisation de la base de données
        Database db = new Database();
        if(db.setConnectionToDB()){
            System.out.println("Connection à la base de données effectué");
        }else{
            System.out.println("Connection à la base de données impossible");
        }

//        ArrayList<GeoPoint> GeoArray = db.getAllPointData();
//        System.out.println(GeoArray);


        Scanner firstPoint = new Scanner(System.in);
        System.out.println("Entrez votre arrêt de départ : ");
        String premierArret = firstPoint.nextLine();
        System.out.println("Point de départ : " + (String)premierArret);
        Djikstra djikstraAlgo = new Djikstra(db);
        if(djikstraAlgo.setDebutFromBusStop(premierArret)){
            System.out.println("Arret de bus lié");
        }else{
            System.out.println("Impossible de trouver l'arret de bus");
        }
    }
}
