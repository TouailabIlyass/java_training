package pfe;


public class Student {
    
    private int id;
    private String nom,prenom,adresse,user,pass,date,filiere;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getDate() {
        return date;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    
    
}
