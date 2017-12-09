import java.sql.*;
import java.util.ArrayList;

public class Database {

    private Statement qStatement;

    public boolean setConnectionToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/makhnoEzap";
            Connection m_Connection = DriverManager.getConnection(
                    url, "root", "");

            this.qStatement = m_Connection.createStatement();
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public GeoPoint getLinePointData(int id) {
        GeoPoint geoPoint = new GeoPoint();
        try {
            String query = "SELECT * FROM GEO_POINT WHERE GEO_POI_ID = " + id;
            ResultSet m_ResultSet = this.qStatement.executeQuery(query);

            //On récupère les données de la query
            geoPoint.setId(id);
            geoPoint.setLatitude(m_ResultSet.getDouble("GEO_POI_LATITUDE"));
            geoPoint.setLongitude(m_ResultSet.getDouble("GEO_POI_LONGITUDE"));
            geoPoint.setLigne(m_ResultSet.getInt("GEO_POI_PARTITION"));
            geoPoint.setNom(m_ResultSet.getString("GEO_POI_NOM"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return geoPoint;
    }



    public ArrayList<GeoPoint> getAllPointData() {
        String query = "SELECT * FROM GEO_POINT";
        ArrayList<GeoPoint> GeoArray = new ArrayList<GeoPoint>();
        try{
            ResultSet m_ResultSet = this.qStatement.executeQuery(query);
            for(int i=0;m_ResultSet.next();i++){
                GeoPoint getPoint = new GeoPoint();
                getPoint.setId(m_ResultSet.getInt("GEO_POI_ID"));
                getPoint.setLatitude(m_ResultSet.getDouble("GEO_POI_LATITUDE"));
                getPoint.setLongitude(m_ResultSet.getDouble("GEO_POI_LONGITUDE"));
                getPoint.setLigne(m_ResultSet.getInt("GEO_POI_PARTITION"));
                getPoint.setNom(m_ResultSet.getString("GEO_POI_NOM"));
                GeoArray.add(getPoint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GeoArray;
    }



    public GeoArc getLineArcData(int id) {
        GeoArc geoArc = new GeoArc();
        try {
            String query = "SELECT * FROM GEO_ARC WHERE GEO_ARC_ID = " + id;
            ResultSet m_ResultSet = this.qStatement.executeQuery(query);

            //On récupère les données de la query
            geoArc.setId(id);
            geoArc.setDistance(m_ResultSet.getFloat("GEO_ARC_DISTANCE"));
            geoArc.setDebut(m_ResultSet.getInt("GEO_ARC_DEB"));
            geoArc.setFin(m_ResultSet.getInt("GEO_ARC_FIN"));
            geoArc.setTemps(m_ResultSet.getFloat("GEO_ARC_TEMPS"));
            geoArc.setSens(m_ResultSet.getInt("GEO_ARC_SENS"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return geoArc;
    }

    public ArrayList<GeoArc> getAllArcData() {
        String query = "SELECT * FROM GEO_ARC";
        ArrayList<GeoArc> GeoArcArray = new ArrayList<GeoArc>();
        try{
            ResultSet m_ResultSet = this.qStatement.executeQuery(query);
            for(int i=0;m_ResultSet.next();i++){
                GeoArc getArc = new GeoArc();
                getArc.setId(m_ResultSet.getInt("GEO_ARC_ID"));
                getArc.setDistance(m_ResultSet.getFloat("GEO_ARC_DISTANCE"));
                getArc.setDebut(m_ResultSet.getInt("GEO_ARC_DEB"));
                getArc.setFin(m_ResultSet.getInt("GEO_ARC_FIN"));
                getArc.setTemps(m_ResultSet.getFloat("GEO_ARC_TEMPS"));
                getArc.setSens(m_ResultSet.getInt("GEO_ARC_SENS"));
                GeoArcArray.add(getArc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GeoArcArray;
    }

    public ArrayList<GeoArc> getArcLinkToPoint(GeoPoint point) {
        //TODO - Faire une requête SQL qui lie le point à l'arc, puis retourne l'ensemble des arcs liés au point sous forme d'arrayList
        return null;
    }

}