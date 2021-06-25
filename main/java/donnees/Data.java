package ma.tdi.tinghir.dao;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ma.tdi.tinghir.StagiairesActivity;
import ma.tdi.tinghir.objects.Contact;
import ma.tdi.tinghir.objects.Groupe;
import ma.tdi.tinghir.objects.Langage;
import ma.tdi.tinghir.objects.Stagiaire;

public class Data {
    private static List<Langage> langages;
    private static List<Stagiaire> stagiaires;
    private static List<Groupe> groupes;
    private static List<Contact> contacts;


    public static List<Langage> getLangages() {
        return langages;
    }
    public  static  List<Stagiaire> getStagiaires() { return stagiaires; }
    public  static  List<Groupe> getGroupes() { return groupes; }
    public  static  List<Contact> getContacts() { return contacts; }

    // Fetch data from data source....
    public static void load() {
        langages = new ArrayList<>();
        Langage lang = null;
        List<String> applications = new ArrayList<>();

        applications.add("Desktop");
        applications.add("Web");
        applications.add("Data Science");
        applications.add("IA");
        lang = new Langage(1, "Python", applications);
        langages.add(lang);
        applications = new ArrayList<>();

        applications.add("Desktop");
        applications.add("Web");
        applications.add("Gaming");
        applications.add("Mobile");
        lang = new Langage(2, "C#", applications);
        langages.add(lang);
        applications = new ArrayList<>();

        applications.add("Desktop");
        applications.add("Web");
        applications.add("Mobile");
        applications.add("Big Data");
        lang = new Langage(3, "JAVA", applications);
        langages.add(lang);
        applications = new ArrayList<>();

        applications.add("Desktop");
        applications.add("Web");
        applications.add("Mobile");
        lang = new Langage(4, "JavaScript", applications);
        langages.add(lang);
        applications = new ArrayList<>();

    }

    public static void load2() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        stagiaires = new ArrayList<>();

        Groupe grp = new Groupe(1, "TDI201A");

        Stagiaire stg = new Stagiaire(10, "Ahmed", "Youssef", formatter.parse("12/07/2001"), grp);
        stagiaires.add(stg);

        stg = new Stagiaire(12, "Amine", "Karim", formatter.parse("22/03/1999"), grp);
        stagiaires.add(stg);

        grp = new Groupe(2, "TDI201B");

        stg = new Stagiaire(15, "Imane", "Hayat", formatter.parse("05/07/2000"), grp);
        stagiaires.add(stg);

        stg = new Stagiaire(16, "Younes", "Hicham", formatter.parse("30/12/1997"), grp);
        stagiaires.add(stg);

        stg = new Stagiaire(17, "Yassine", "Ali", formatter.parse("02/01/2000"), grp);
        stagiaires.add(stg);

        loadGroupes();

    }

    public static int getNombreStagiairesParGroupe(int idg) {
        int resultat = 0;
        for(int i = 0; i < stagiaires.size(); i++) {
            if(idg == stagiaires.get(i).getGroupe().getId()) {
                resultat++;
            }
        }
        return resultat;
    }

    public static void loadGroupes() {
        groupes = new ArrayList<>();
        for (int i = 0; i < stagiaires.size(); i++) {
            if(!groupes.contains(stagiaires.get(i).getGroupe())) {
                groupes.add(stagiaires.get(i).getGroupe());
            }
        }
        Log.d(StagiairesActivity.TAG, "loadGroupes: " + groupes);
    }

    public static List<Stagiaire> getStagiairesParGroupe(Groupe grp) {
        List<Stagiaire> liste = new ArrayList<>();
        for (Stagiaire stg: stagiaires) {
            if(stg.getGroupe().equals(grp)) {
                liste.add(stg);
            }
        }
        Log.d(StagiairesActivity.TAG, "getStagiairesParGroupe: " + liste);
        return liste;
    }

    public static void loadContacts() {
        Contact ct = null;
        contacts = new ArrayList<>();

        ct = new Contact("Nom 1", "Prénom 1", "0512457891");
        contacts.add(ct);

        ct = new Contact("Nom 2", "Prénom 2", "0512457893");
        contacts.add(ct);

        ct = new Contact("Nom 3", "Prénom 3", "0512457895");
        contacts.add(ct);

        ct = new Contact("Nom 4", "Prénom 4", "0512457899");
        contacts.add(ct);

        ct = new Contact("Nom 5", "Prénom 5", "0512457897");
        contacts.add(ct);

        ct = new Contact("Nom 6", "Prénom 6", "0512457890");
        contacts.add(ct);
    }
}
