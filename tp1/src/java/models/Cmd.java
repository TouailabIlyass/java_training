/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author drging
 */
public class Cmd {
    private int num;
    private String date;
    private int qte;
    private int id_client,num_article;

    public Cmd() {
    }

    public Cmd(int num, String date, int qte, int id_client, int num_article) {
        this.num = num;
        this.date = date;
        this.qte = qte;
        this.id_client = id_client;
        this.num_article = num_article;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getNum_article() {
        return num_article;
    }

    public void setNum_article(int num_article) {
        this.num_article = num_article;
    }
    
    
}
