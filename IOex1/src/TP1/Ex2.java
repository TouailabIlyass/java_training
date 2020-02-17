/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kingdragon
 */
public class Ex2 {
    
    static void saveSalleToserialfile(Salle s,String file) throws FileNotFoundException, IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                
                oos.writeObject(s);
                oos.flush();
                oos.close();
    }
    static void getSalle(String file) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            
            Salle s=(Salle) ois.readObject();
            System.out.println(s.Total());
            s.Afficher();
    }
    
    public static void main(String[] args) {
        Etudiant e1 = new Etudiant("ilyase", "touailab", 19);
                Etudiant e2 = new Etudiant("ahmed", "ahmed", 20);
                Salle salle = new Salle();
                salle.Ajouter(e1);
                salle.Ajouter(e2);
        
        
        try {
            saveSalleToserialfile(salle,"test2.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
            
        try { 
            getSalle("test2.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
   
        
        
        
    }
    
}


class Etudiant implements Serializable{
    
    private String nom,prenom;
    private int age;

    public Etudiant(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
    
    public String toString()
    {
        return nom+" "+prenom+" "+age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}


class Salle implements Serializable{
    
    private ArrayList<Etudiant> etudiants =  new ArrayList<Etudiant>();
    
    public void Ajouter(Etudiant e)
    {
        etudiants.add(e);
    }
    
    public int Total()
    {
        return etudiants.size();
    }
    
    public void Afficher()
    {
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }
    }
    
}