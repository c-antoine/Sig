import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

    private Statement qStatement;

    public boolean setConnectionToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:8889/makhnoEzap";
            Connection m_Connection = DriverManager.getConnection(
                    url, "root", "root");

            this.qStatement = m_Connection.createStatement();
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public GeoPoint getLineData(int id) {
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

    public ArrayList<GeoPoint> getAllData() {
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


    public static void main(String[] args) throws Exception {

    }
}