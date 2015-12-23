package com.horizon.fps.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.horizon.fps.Model.User;

public class UserDB {
	
	public void openConnectionToDB(){
		Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/horizon","postgres", "123");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	}
	
	public void insertToDB(int i,String n , String ln, String un, String ps, String em, String ph, String ad){
		Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/horizon",
	            "postgres", "123");
	         c.setAutoCommit(false);

	         stmt = c.createStatement();
	         String sql = "INSERT INTO users "
	               + "VALUES ('"+i+"', '"+n+"', '"+ln+"', '"+un+"', '"+ps+"', '"+em+"', '"+ph+"', '"+ad+"' );";
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	}
	
	public List<User> selectAllFromDB(){
		   Connection c = null;
	       Statement stmt = null;
	       List<User> list = new ArrayList<User>(); 
	       
	       try {
	       Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/horizon", "postgres", "123");
	         c.setAutoCommit(false);

	         String  name,lastname,username,passw,email,phone,address;
	         
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
	            list.add(new User(id, name, lastname , username , passw , email , phone, address ));
	         }
	         
	         rs.close();
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	       }
	       
		return list;
	}
	
	public User selectByIdFromDB(int ID){
		   Connection c = null;
	       Statement stmt = null;
	       User send = null;
	       
	       try {
	       Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/horizon","postgres", "123");
	         c.setAutoCommit(false);

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
		         send = new User(id, name, lastname , username , passw , email , phone, address );
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	       }

		return send;
	}
	
	public User selectForLoginFromDB(String uname, String pass){
		   Connection c = null;
	       Statement stmt = null;
	       User send = null;
	       
	       try {
	       Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/horizon","postgres", "123");
	         c.setAutoCommit(false);

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
		         send = new User(id, name, lastname , username , passw , email , phone, address );
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	       }

		return send;
	}
	
}
