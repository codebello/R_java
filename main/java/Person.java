package ma.tdi.tinghir;

import java.util.Date;
import java.util.Objects;

public class Person {

    private int id = 0;
    private String nom = "";
    private String prenom = "";
    private Date naissance = new Date();

    public Person() {
    }

    public Person(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Person(int id, String nom, String prenom, Date naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                getNom().equals(person.getNom()) &&
                getPrenom().equals(person.getPrenom()) &&
                getNaissance().equals(person.getNaissance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getPrenom(), getNaissance());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", naissance=" + naissance +
                '}';
    }

    public  class Pays {
        private String nom = "";

        public Pays(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pays)) return false;
            Pays pays = (Pays) o;
            return getNom().equals(pays.getNom());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getNom());
        }

        @Override
        public String toString() {
            return "Pays{" +
                    "nom='" + nom + '\'' +
                    '}';
        }
    }
}
