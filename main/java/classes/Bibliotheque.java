package ma.tdi.tinghir.objects;

import java.util.ArrayList;

public class Bibliotheque {

    private String nom;
    private ArrayList<Livre> livres;

    public Bibliotheque() {
        livres = new ArrayList<>();
    }

    public Bibliotheque(String nom) {
        this.nom = nom;
        livres = new ArrayList<>();
    }

    public Bibliotheque(String nom, ArrayList<Livre> livres) {
        this.nom = nom;
        this.livres = livres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Livre> getLivres() {
        return livres;
    }

    public void setLivres(ArrayList<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Bibliotheque{" +
                "nom='" + nom + '\'' +
                ", nombre de livres=" + livres.size() +
                '}';
    }
}
