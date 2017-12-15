import java.util.ArrayList;

public class Djikstra {
    private GeoPoint debut;
    private Database db;
    private GeoPoint fin;

    public Djikstra(Database db){
        this.db=db;
    }

    public GeoPoint getDebut() {
        return debut;
    }

    public void setDebut(GeoPoint debut) {
        this.debut = debut;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public GeoPoint getFin() {
        return fin;
    }

    public void setFin(GeoPoint fin) {
        this.fin = fin;
    }

    //Fonction qui lie le premier arret avec son nom
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

    //Fonction qui retourne une liste d'Arc lié au point
    public ArrayList<GeoArc> getArcLinkedToPoint(GeoPoint point){
        ArrayList<GeoArc> allArcData = db.getAllArcData();
        ArrayList<GeoArc> linkedArcData = new ArrayList<GeoArc>();
        for(int i=0;allArcData.size()>i;i++){
            if(allArcData.get(i).getDebut()==point.getId() || allArcData.get(i).getFin()==point.getId()){
                linkedArcData.add(allArcData.get(i));
            }
        }
        return linkedArcData;
    }

}
