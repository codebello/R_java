package ma.tdi.tinghir.objects;

import java.util.List;

public class Langage {

    private int id;
    private String nom;
    private List<String> applications;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getApplications() {
        return applications;
    }

    public void setApplications(List<String> applications) {
        this.applications = applications;
    }

    public Langage(int id, String nom, List<String> applications) {
        this.id = id;
        this.nom = nom;
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "Langage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
