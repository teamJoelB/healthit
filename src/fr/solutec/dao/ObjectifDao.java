 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;


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
    
}
