/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;


import fr.solutec.model.Activite;
import fr.solutec.model.Objectif;
import fr.solutec.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esic
 */
public class ObjectifDao {
    
    public static List<Objectif> getObjectifByUser(User u) throws SQLException{
        List<Objectif> recap = new ArrayList<>();
        int id = u.getIdUser();
        
        String sql = "SELECT Type, Valeur, dateDeb, DateFin FROM objectif WHERE fk_idUser=" + id;
        
        Connection connexion = AccessBd.getConnection();
        
        Statement requete = connexion.createStatement();
              
                
        ResultSet rs = requete.executeQuery(sql);
        
        while(rs.next()){
            Objectif obj = new Objectif();
            obj.setType(rs.getString("Type"));
            obj.setValeur(rs.getDouble("Valeur"));
            obj.setDateDeb(rs.getDate("dateDeb"));
            obj.setDateFin(rs.getDate("DateFin"));
            
            recap.add(obj);
        }
        
     
        return recap;
    }
    
    
    public static void insert(Objectif o) throws SQLException{
        String sql = "INSERT INTO objectif (Type, Valeur, dateDeb, DateFin, fk_idUser) VALUES (?, ?, ?, ?, ?)";
        
        Connection connexion = AccessBd.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, o.getType());
        requete.setDouble(2, o.getValeur());
        requete.setDate(3, (Date) o.getDateDeb());
        requete.setDate(4, (Date) o.getDateFin());
        requete.setInt(5, o.getIdUser());
        
        
        requete.execute();
    }
    
    public static String etatObj(Objectif o, User u) throws SQLException{
        
        String sql1 = "SELECT * FROM objectif WHERE idobjectif = " + o.getIdobjectif();
        
        Connection connexion = AccessBd.getConnection();
        
        Statement requete1 = connexion.createStatement();
                   
        ResultSet rs1 = requete1.executeQuery(sql1);
        
        Objectif obj = new Objectif();
        String a = "";
        
        if(rs1.next()){
            obj.setType(rs1.getString("Type"));
            obj.setValeur(rs1.getDouble("Valeur"));
            obj.setDateDeb(rs1.getDate("dateDeb"));
            obj.setDateFin(rs1.getDate("DateFin"));
            
            String sql2 = "SELECT SUM(Valeur) as Somme FROM activite WHERE ( User_idUser = " + u.getIdUser() + " && Type =" + obj.getType() + " && Date > " + obj.getDateDeb() + "&& Date <" + obj.getDateFin() + ")";

            Statement requete2 = connexion.createStatement();

            ResultSet rs2 = requete2.executeQuery(sql2);    

            if(rs2.next()){

                double S;
                S = rs2.getDouble("Somme");

                if (S >= o.getValeur()){
                    a = "yeah";
                }
                else {
                    a = "Noooo";
                }    
            }
            else {
                a = "test";
            }
        }
        return a;
        
     }
}
