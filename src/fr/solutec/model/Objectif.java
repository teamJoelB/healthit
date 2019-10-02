/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.model;

import java.util.Date;

/**
 *
 * @author esic
 */
public class Objectif {
    private int idobjectif;
    private String type;
    private Double valeur;
    private Date dateDeb;
    private Date dateFin;
    private int idUser;

    public Objectif() {
    }

    public Objectif(int idobjectif, String type, Double valeur, Date dateDeb, Date dateFin) {
        this.idobjectif = idobjectif;
        this.type = type;
        this.valeur = valeur;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

    public Objectif(String type, Double valeur, Date dateDeb, Date dateFin) {
        this.type = type;
        this.valeur = valeur;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

    public Objectif(String type, Double valeur, Date dateDeb, Date dateFin, int idUser) {
        this.type = type;
        this.valeur = valeur;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.idUser = idUser;
    }
    
    

    public int getIdobjectif() {
        return idobjectif;
    }

    public String getType() {
        return type;
    }

    public Double getValeur() {
        return valeur;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setIdobjectif(int idobjectif) {
        this.idobjectif = idobjectif;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    
    
    
    
}
