package com.horizon.fps.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.horizon.fps.Model.User;

public class UserDB {
	
	
	public void insertToDB(User user){
		Connection c = null;
	      Statement stmt = null;
	      try {
	    	  Class.forName("org.postgresql.Driver");
	    	  c = DriverManager.getConnection("jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/d6d38dp6fnlb5u?"+
	    			    "user=nxomzfynxtfbwx&password=CTNlpUsfCT4DJj6ke7FpTkTHzK&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"); // NOSONAR
	         c.setAutoCommit(false);

	         stmt = c.createStatement();
	         String sql = "INSERT INTO users "
	               + "VALUES ('"+100+"', '"+user.getName()+"', '"+user.getLastname()+
	               "', '"+user.getUsername()+"', '"+user.getPassword()+"', '"+user.getEmail()+
	               "', '"+user.getPhone()+"', '"+user.getAdress()+"' );";
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	      } catch (Exception e) {
	    	  e.printStackTrace();
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	      }
	      System.out.println("Records created successfully");
	}
	
	public List<User> selectAllFromDB(){
		   Connection c = null;
	       Statement stmt = null;
	       List<User> list = new ArrayList<User>();  // NOSONAR
	       
	       try {
	    	   Class.forName("org.postgresql.Driver");
		    	  c = DriverManager.getConnection("jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/d6d38dp6fnlb5u?"+
		    			    "user=nxomzfynxtfbwx&password=CTNlpUsfCT4DJj6ke7FpTkTHzK&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"); // NOSONAR

	         String  name,lastname,username,passw,email,phone,address;
	         int auth;
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM users ;" );
	         while ( rs.next() ) {
	        	int id = rs.getInt("id");
	            name = rs.getString("name");
	            lastname = rs.getString("lastname");
	            username = rs.getString("username");
	            passw = rs.getString("password");
	            email = rs.getString("email");
	            phone = rs.getString("phone");
	            address = rs.getString("address");
	            auth = rs.getInt("auth");
	            list.add(new User(id, name, lastname , username , passw , email , phone, address ,auth ));
	         }
	         
	         rs.close();
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	       }
	       
		return list;
	}
	
	public User selectByIdFromDB(int ID){
		   Connection c = null;
	       Statement stmt = null;
	       User send = null;
	       
	       try {
	    	   Class.forName("org.postgresql.Driver");
		    	  c = DriverManager.getConnection("jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/d6d38dp6fnlb5u?"+
		    			    "user=nxomzfynxtfbwx&password=CTNlpUsfCT4DJj6ke7FpTkTHzK&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"); // NOSONAR

	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM user where id = "+ID+" ;" );
	         while ( rs.next() ) {
	        	 int id = rs.getInt("id");
		         String name = rs.getString("name");
		         String lastname = rs.getString("lastname");
		         String username = rs.getString("username");
		         String passw = rs.getString("password");
		         String email = rs.getString("email");
		         String phone = rs.getString("phone");
		         String address = rs.getString("address");
		         int auth = rs.getInt("auth");
		         send = new User(id, name, lastname , username , passw , email , phone, address, auth );
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	       }

		return send;
	}
	
	public User selectForLoginFromDB(String uname, String pass){
		   Connection c = null;
	       Statement stmt = null;
	       User send = null;
	       
	       try {
	    	   Class.forName("org.postgresql.Driver");
		    	  c = DriverManager.getConnection("jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/d6d38dp6fnlb5u?"+
		    			    "user=nxomzfynxtfbwx&password=CTNlpUsfCT4DJj6ke7FpTkTHzK&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"); // NOSONAR

	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM users where username = '"+uname+"' and password = '"+pass+"';" );
	         while ( rs.next() ) {
	        	 int id = rs.getInt("id");
		         String name = rs.getString("name");
		         String lastname = rs.getString("lastname");
		         String username = rs.getString("username");
		         String passw = rs.getString("password");
		         String email = rs.getString("email");
		         String phone = rs.getString("phone");
		         String address = rs.getString("address");
		         int auth = rs.getInt("auth");
		         send = new User(id, name, lastname , username , passw , email , phone, address, auth);
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	       }

		return send;
	}
	
}
