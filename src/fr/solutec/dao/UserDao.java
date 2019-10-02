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
    
    public static void MajProfil (User person) throws SQLException{
        String sql = "UPDATE user SET Nom = ? WHERE IdUser = ?";
        
        Connection connexion = AccessBd.getConnection();
        
        PreparedStatement requete1 = connexion.prepareStatement(sql);
        requete1.setString(1, person.getNom());
        requete1.setInt(2, person.getIdUser());
        requete1.execute();
         
        String sql2 = "UPDATE user SET Prenom = ? WHERE IdUser = ?";
                  
        PreparedStatement requete2 = connexion.prepareStatement(sql2);
        requete2.setString(1, person.getPrenom());
        requete2.setInt(2, person.getIdUser());
        requete2.execute();
        
        String sql3 = "UPDATE user SET Mdp = ? WHERE IdUser = ?";
        
        PreparedStatement requete3 = connexion.prepareStatement(sql3);
        requete3.setString(1, person.getMdp());
        requete3.setInt(2, person.getIdUser());
        requete3.execute();
        
         String sql4 = "UPDATE user SET Mail = ? WHERE IdUser = ?";
        
        PreparedStatement requete4 = connexion.prepareStatement(sql4);
        requete4.setString(1, person.getMail());
        requete4.setInt(2, person.getIdUser());
        requete4.execute();
        
         String sql5 = "UPDATE user SET Age = ? WHERE IdUser = ?";
        
        PreparedStatement requete5 = connexion.prepareStatement(sql5);
        requete5.setInt(1, person.getAge());
        requete5.setInt(2, person.getIdUser());
        requete5.execute();
        
         String sql6 = "UPDATE user SET Sexe = ? WHERE IdUser = ?";
        
        PreparedStatement requete6 = connexion.prepareStatement(sql6);
        requete6.setString(1, person.getSexe());
        requete6.setInt(2, person.getIdUser());
        requete6.execute();
        
         String sql7 = "UPDATE user SET Poids = ? WHERE IdUser = ?";
        
        PreparedStatement requete7 = connexion.prepareStatement(sql7);
        requete7.setDouble(1, person.getPoids());
        requete7.setInt(2, person.getIdUser());
        requete7.execute();
        
         String sql8 = "UPDATE user SET Taille = ? WHERE IdUser = ?";
        
        PreparedStatement requete8 = connexion.prepareStatement(sql8);
        requete8.setDouble(1, person.getTaille());
        requete8.setInt(2, person.getIdUser());
        requete8.execute();
       
         String sql9 = "UPDATE user SET DateCo = ? WHERE IdUser = ?";
        
        PreparedStatement requete9 = connexion.prepareStatement(sql9);
        requete9.setDate(1, (Date) person.getDateCo());
        requete9.setInt(2, person.getIdUser());
        requete9.execute();
        
    }
}
