/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javafx.scene.control.TableView;

/**
 *
 * @author ZaCCC
 */


public class Consultation {
     
    
    private Connection myConn;
   
  
    int idConsultation;
    int idPatient;
    String nomPatient;
    String prenomPatient;
    int agePatient;
    int poidsPatient;
    int taillePatient;
    int numTelPatient;
    String statutVaccinalPatient;
    String sexePatient;
    String situationFamillePatient;
    String villePatient; 
    String enfantsPatient; 
    String nombreDeGrossesse; 
    String nombreEnfant;
    String antcdsFPatient;
    String antcdsPPatient;
    String motifDeConsultation;
    String compteRenduConsultation;
    String dateConsultation; 
    
   
  
    
  
    
    public Consultation (String cNomPatient, String cPrenomPatient, int cAgePatient, int cPoidsPatient, int cTaillePatient, int cNumTelPatient,
                         String cStatutVaccinalPatient, String cSexePatient, String cSituationFamillePatient, String cVillePatient, String cEnfantsPatient, String cNombreDeGrossesse, 
                        String cNombreEnfant, String cAntcdsFPatient, String cAntcdsPPatient, String cMotifDeConsultation, String cCompteRenduConsultation, String cDateConsultation) throws ClassNotFoundException{
       // est ce que nfwtou les ids wla lala ?????
      	this.nomPatient=cNomPatient;
        this.prenomPatient=cPrenomPatient;
        this.agePatient=cAgePatient;
        this.poidsPatient=cPoidsPatient;
        this.taillePatient=cTaillePatient;
        this.numTelPatient=cNumTelPatient;
        this.statutVaccinalPatient=cStatutVaccinalPatient;
        this.sexePatient=cSexePatient;
        this.situationFamillePatient=cSituationFamillePatient;
        this.villePatient=cVillePatient;
        this.enfantsPatient=cEnfantsPatient;
        this.nombreDeGrossesse=cNombreDeGrossesse;
        this.nombreEnfant=cNombreEnfant; 
        this.antcdsFPatient=cAntcdsFPatient;
        this.antcdsPPatient=cAntcdsPPatient;
        this.motifDeConsultation=cMotifDeConsultation; 
        this.compteRenduConsultation=cCompteRenduConsultation; 
        this.dateConsultation=cDateConsultation; 
        
         try {
         Class.forName("org.sqlite.JDBC");
         String url = "jdbc:sqlite:C:\\Users\\imad_\\Documents\\pfee\\src\\pfe\\DBpfee.db"; // The Url of your database 'Strecture be like: xD' jbdc:sqlite: + the path of your db
        
       // Create the Connection ## Pass url (Path) as param
         myConn = DriverManager.getConnection(url); 
        }catch (SQLException e) {
         System.out.println("Error : " + e.getMessage());
        }           
   }
    
    
    		// I'm going to add the ADD method first then we go back to Constr
    

    public void Ajouter(){
     
        String sqlQuery = "INSERT INTO patient (nomPatient, prenomPatient, agePatient, poidsPatient, taillePatient, numTelPatient, statutVaccinalPatient, sexePatient, situationFamillePatient, villePatient, enfantsPatient, nombreDeGrossesse, nombreEnfant, antcdsFPatient, antcdsPPatient, motifDeConsultation, compteRenduConsultation, dateConsultation  )" 
                         +"VALUES(?, ?, ?, ? , ?, ? , ?, ? , ?, ? , ?, ?, ?, ?, ?, ?, ?, ? )";
                
                
                
                
       	// this is the try statment 
   							
        // so this PreparedStatement class is going to hold our query and also help us to merge our attrs with our query
              		
          try {
     	       PreparedStatement statement = myConn.prepareStatement(sqlQuery);
              
               statement.setString(1, this.nomPatient); // This inst is going to replace the first ? with the prenomPatient attr Right ?
  	       statement.setString(2, this.prenomPatient);
               statement.setInt(3, this.agePatient);
               statement.setInt(4, this.poidsPatient);	
               statement.setInt(5, this.taillePatient);	
               statement.setInt(6, this.numTelPatient);
               statement.setString(7, this.statutVaccinalPatient);
               statement.setString(8, this.sexePatient);
               statement.setString(9, this.situationFamillePatient);
               statement.setString(10, this.villePatient);
               statement.setString(11,this.enfantsPatient);
               statement.setString(12,this.nombreDeGrossesse);
               statement.setString(13,this.nombreEnfant);
               statement.setString(14,this.antcdsFPatient);
               statement.setString(15,this.antcdsPPatient);
               statement.setString(16,this.motifDeConsultation);
               statement.setString(17,this.compteRenduConsultation);
               statement.setString(18,this.dateConsultation);
              
               
               
               statement.executeUpdate();
            	
             }catch (Exception e) {
             System.out.println(e.getMessage()); // this msg is just for showing the error 
    
             } 
    
    }
  
  
    public void Modifier(int id  ){
      
      
        	String sqlQuery = "UPDATE patient SET `nomPatient` = ?, `prenomPatient` = ? , `agePatient` = ?, `poidsPatient` = ?,`taillePatient` = ?,`numTelPatient` = ?, `statutVaccinalPatient` = ?, `sexePatient` = ?,`situationFamillePatient`=?, `villePatient` = ?,`enfantsPatient` = ?, `nombreDeGrossesse` = ?, `nombreEnfant`= ? , `antcdsFPatient`= ?, `antcdsPPatient`= ?,`motifDeConsultation`= ?, `compteRenduConsultation`=?, `dateConsultation`=? "
            		       
                                
                                + " WHERE `id_patient` = "+id;;
          
      
      		try {
            
            	PreparedStatement statement = myConn.prepareStatement(sqlQuery);
                statement.setString(1, this.nomPatient); // This inst is going to replace the first ? with the prenomPatient attr Right ?
  	       statement.setString(2, this.prenomPatient);
               statement.setInt(3, this.agePatient);
               statement.setInt(4, this.poidsPatient);	
               statement.setInt(5, this.taillePatient);	
               statement.setInt(6, this.numTelPatient);
               statement.setString(7, this.statutVaccinalPatient);
               statement.setString(8, this.sexePatient);
               statement.setString(9, this.situationFamillePatient);
               statement.setString(10, this.villePatient);
               statement.setString(11,this.enfantsPatient);
               statement.setString(12,this.nombreDeGrossesse);
               statement.setString(13,this.nombreEnfant);
               statement.setString(14,this.antcdsFPatient);
               statement.setString(15,this.antcdsPPatient);
               statement.setString(16,this.motifDeConsultation);
               statement.setString(17,this.compteRenduConsultation);
               statement.setString(18,this.dateConsultation);
               
            
                statement.executeUpdate();
                
            
          }catch (SQLException e){
            System.out.println(e.getMessage());
          }
    }
  
  public void Supprimer(int ID){
       String sqlQuery = "DELETE patient WHERE id = ?";
         
         try{
           PreparedStatement statement = myConn.prepareStatement(sqlQuery);
           statement.setInt(1, ID);
           statement.executeUpdate();
         }catch (SQLException e){
           System.out.println(e.getMessage());
         }
   }
    
}