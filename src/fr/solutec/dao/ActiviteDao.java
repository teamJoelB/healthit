/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;

import fr.solutec.model.Activite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author esic
 */
public class ActiviteDao {
    
     public static void insert(Activite act) throws SQLException{
        String sql = "INSERT INTO activite (Type, Valeur, Date) VALUES (?, ?, ?, ?)";
        
        Connection connexion = AccessBd.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, act.getType());
        requete.setDouble(2, act.getValeur());
        requete.setDate(3, (Date) act.getDateAct());
        requete.setInt(4, act.getIdUser());
        
        requete.execute();
     }
}
