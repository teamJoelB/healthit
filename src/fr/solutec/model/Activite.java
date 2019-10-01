/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.model;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author esic
 */
public class Activite {
    
    private int idActivite;
    private String type;
    private Double valeur;
    private Date dateAct; 
    
    public Activite(){}
    
    public Activite (String type, Double valeur, Date dateAct){
        this.type = type;
        this.valeur = valeur;
        this.dateAct = dateAct;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public String getType() {
        return type;
    }

    public Double getValeur() {
        return valeur;
    }

    public Date getDateAct() {
        return dateAct;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public void setDateAct(Date dateAct) {
        this.dateAct = dateAct;
    }
   
    
}


