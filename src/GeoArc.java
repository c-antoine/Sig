public class GeoArc {

    private int id;
    private int debut;
    private int fin;
    private float temps;
    private float distance;
    private int sens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public float getTemps() {
        return temps;
    }

    public void setTemps(float temps) {
        this.temps = temps;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getSens() {
        return sens;
    }

    public void setSens(int sens) {
        this.sens = sens;
    }

    @Override
    public String toString(){
        return" id(" + this.id + ") , debut(" + this.debut + ") , fin(" + this.fin + ") , temps(" + this.temps+ "), distance(" + this.distance + "), sens(" + this.sens + ")\n";
    }
}
