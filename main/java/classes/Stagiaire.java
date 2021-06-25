package ma.tdi.tinghir.objects;

import java.util.Date;
import java.util.Objects;

public class Stagiaire {

    private long numeroInscription;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Groupe groupe;

    public long getNumeroInscription() {
        return numeroInscription;
    }

    public void setNumeroInscription(long numeroInscription) {
        this.numeroInscription = numeroInscription;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stagiaire)) return false;
        Stagiaire stagiaire = (Stagiaire) o;
        return getNumeroInscription() == stagiaire.getNumeroInscription();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroInscription());
    }

    @Override
    public String toString() {
        return "Stagiaire{" +
                "numeroInscription=" + numeroInscription +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", groupe=" + groupe +
                '}';
    }

    public Stagiaire(long numeroInscription, String nom, String prenom, Date dateNaissance, Groupe groupe) {
        this.numeroInscription = numeroInscription;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.groupe = groupe;
    }
}
