/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.webant.tournament.user.core.test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.Base64;

/**
 *
 * @author anthony
 */
public class Test {
    
    public static void main(String args[])  {
        	
      try{
		
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//         DB db = mongoClient.getDB( "TournamentDB" );
//         System.out.println("Connect to database successfully");
//         //boolean auth = db.authenticate(myUserName, myPassword);
//         //System.out.println("Authentication: "+auth);
//         System.out.println("Liste des utilisateurs");
//         DBCollection users = db.getCollection("users");        
//         DBCursor cursor = users.find(new BasicDBObject("firstname", "Anthony"));
//         System.out.println("Nombre de résultat : " + cursor.count());
//         while(cursor.hasNext()) {
//             DBObject user = cursor.next();
//             System.out.println(user.get("firstname"));
//         }    	
//         
//          BasicDBObject newUser = new BasicDBObject();
//          newUser.append("firstname", "titi");
//          newUser.append("lastname", "tata");
//          users.insert(newUser);
//          users.remove(newUser);
         mongoClient.close();
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      } 
   }
    
}
