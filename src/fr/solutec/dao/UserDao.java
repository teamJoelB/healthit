/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joel B
 */
public class UserDao {
    
    public static User getByLoginPass(String login, String mdp) throws SQLException{
        
        User resultat = null;
        
        String sql = "SELECT * FROM user WHERE Mail=? AND Mdp=?";
        Connection connexion = AccessBd.getConnection();
        
        PreparedStatement requette = connexion.prepareStatement(sql);
        requette.setString(1, login);
        requette.setString(2, mdp);
        
        ResultSet rs = requette.executeQuery();
        
        if(rs.next()){
            resultat = new User();
            resultat.setId(rs.getInt("idUser"));
            resultat.setNom(rs.getString("Nom"));
            resultat.setPrenom(rs.getString("Prenom"));
            resultat.setMdp(rs.getString("Mdp"));
            resultat.setMail(rs.getString("Mail"));
            resultat.setAge(rs.getInt("Age"));
            resultat.setSexe(rs.getString("Sexe"));
            resultat.setPoids(rs.getDouble("Poids"));
            resultat.setTaille(rs.getDouble("Taille"));
        }
        
        return resultat;
    }
    
}
