/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;


import fr.solutec.model.Objectif;
import fr.solutec.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esic
 */
public class ObjectifDao {
    
    public static List<Objectif> getObjectifByUser(User u) throws SQLException{
        List<Objectif> recap = new ArrayList<>();
        
        String sql = "SELECT Type, Valeur, dateDeb, DateFin FROM objectif WHERE fk_idUser = ?";
        
        Connection connexion = AccessBd.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setInt(1, u.getIdUser());
        
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
    
}
