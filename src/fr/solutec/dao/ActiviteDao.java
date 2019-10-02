/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;

import fr.solutec.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esic
 */
public class ActiviteDao {
    
     public static void insert(Activite act) throws SQLException{
        String sql = "INSERT INTO activite (Type, Valeur, Date, User_idUser) VALUES (?, ?, ?, ?)";
        
        Connection connexion = AccessBd.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, act.getType());
        requete.setDouble(2, act.getValeur());
        requete.setDate(3, (Date) act.getDateAct());
        requete.setInt(4, act.getIdUser());
        
        requete.execute();
     }
     
     public static List<Activite> getActivitesUser(User u) throws SQLException{
         
        List<Activite> result = new ArrayList<>();
        int idUserActif = u.getIdUser();
        String sql = "SELECT * FROM activite WHERE User_idUser =" + idUserActif;
        Connection connexion = AccessBd.getConnection();
        
        Statement requette = connexion.createStatement();
        
        ResultSet rs = requette.executeQuery(sql);
        
        while (rs.next()){
            Activite act = new Activite();
            act.setType(rs.getString("Type"));
            act.setValeur(rs.getDouble("Valeur"));
            act.setDateAct(rs.getDate("Date"));
            
            result.add(act);
        }
        return result;
    }
}
