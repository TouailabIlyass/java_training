/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

/**
 *
 * @author drging
 */
public class CoursEnsaf implements Course{
    
 private int id;
    private String nom,photo,sdesc,fdesc;
    private int categorie_id,niveau,filear,user_id;
    private String username;

    public CoursEnsaf() {
    }

    public CoursEnsaf(int id, String nom, String photo, String sdesc, String fdesc, int categorie_id, int niveau, int filear, int user_id) {
        this.id = id;
        this.nom = nom;
        this.photo = photo;
        this.sdesc = sdesc;
        this.fdesc = fdesc;
        this.categorie_id = categorie_id;
        this.user_id = user_id;
        this.niveau = niveau;
        this.filear = filear;
    }

    public CoursEnsaf(int id, String nom, String photo, String sdesc, String fdesc, int categorie_id, int niveau, int filear, int user_id, String username) {
        this.id = id;
        this.nom = nom;
        this.photo = photo;
        this.sdesc = sdesc;
        this.fdesc = fdesc;
        this.categorie_id = categorie_id;
        this.user_id = user_id;
        this.niveau = niveau;
        this.filear = filear;
        this.username = username;
    }
    
    
    
    

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

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getFilear() {
        return filear;
    }

    public void setFilear(int filear) {
        this.filear = filear;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    
}
