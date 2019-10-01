/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;


import fr.solutec.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


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
            resultat.setIdUser(rs.getInt("idUser"));
            resultat.setNom(rs.getString("Nom"));
            resultat.setPrenom(rs.getString("Prenom"));
            resultat.setMdp(rs.getString("Mdp"));
            resultat.setMail(rs.getString("Mail"));
            resultat.setAge(rs.getInt("Age"));
            resultat.setSexe(rs.getString("Sexe"));
            resultat.setPoids(rs.getDouble("Poids"));
            resultat.setTaille(rs.getDouble("Taille"));
           resultat.setDateCo(rs.getDate("DateCo"));
        }
        
        return resultat;
    }
    
    public static void insert(User person) throws SQLException{
        String sql = "INSERT INTO user (Nom, Prenom, Mdp, Mail, Age, Sexe, Poids, Taille) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connexion = AccessBd.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, person.getNom());
        requete.setString(2, person.getPrenom());
        requete.setString(3, person.getMdp());
        requete.setString(4, person.getMail());
        
        requete.setInt(5, person.getAge());
        requete.setString(6, person.getSexe());
        requete.setDouble(7, person.getPoids());
        requete.setDouble(8, person.getTaille());
        
        requete.execute();
        
   
    }
    
    public static void MajDateCo(User person) throws SQLException{
        Date date = Date.valueOf(LocalDate.now());
        
        String sql = "UPDATE user SET DateCO = ?";
        
        Connection connexion = AccessBd.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setDate(1, date);
        
        requete.execute();
       
        
    }
}
