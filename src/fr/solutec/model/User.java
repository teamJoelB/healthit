/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.model;

import java.util.Date;

/**
 *
 * @author Joel B
 */
public class User {
    
    private int idUser;
    private String nom; 
    private String prenom; 
    private String mdp;
    private String mail;
    private int age;
    private String sexe;
    private double poids;
    private double taille;
    private Date dateCo;

    public User() {
    }

    public User(int idUser, String nom, String prenom, String mdp, String mail, int age, String sexe, double poids, double taille, Date dateCo) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
        this.age = age;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.dateCo = dateCo;
    }

    public User(String nom, String prenom, String mdp, String mail, int age, String sexe, double poids, double taille) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
        this.age = age;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
    }
    
    



    public User(String nom, String prenom, String mdp, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
    }

    public User(String mdp, String mail) {
        this.mdp = mdp;
        this.mail = mail;
    }
    
    

    public int getIdUser() {
        return idUser;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public String getMail() {
        return mail;
    }

    public int getAge() {
        return age;
    }

    public String getSexe() {
        return sexe;
    }

    public double getPoids() {
        return poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public Date getDateCo() {
        return dateCo;
    }

    public void setDateCo(Date dateCo) {
        this.dateCo = dateCo;
    }
    
    
       
}
