import java.util.ArrayList;

public class Djikstra {
    private GeoPoint debut;
    private Database db;
    private GeoPoint fin;

    public Djikstra(Database db){
        this.db=db;
    }

    public boolean setDebutFromBusStop(String busStopName){
        ArrayList<GeoPoint> allPointData = db.getAllPointData();
        System.out.println("Nombre d'arrêts sur le réseau : "+allPointData.size());
        for(int i=0;allPointData.size()>i;i++){
//            System.out.println(allPointData.get(i).getNom().toString());
            if(allPointData.get(i).getNom().equals(busStopName)){
                System.out.println("Arret de bus trouvé !");
                System.out.println(allPointData.get(i).toString());
                this.debut=allPointData.get(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<GeoArc> getArcLinkedToPoint(GeoPoint point){
        //TODO - Faire une fonction qui retourne une liste d'Arc lié au point
        ArrayList<GeoArc> allArcData = db.getAllArcData();
        return allArcData;
    }

}
