package com.horizon.fps.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.horizon.fps.Model.Product;

public class ProductDB {

	
	public void openConnectionToDB(){
		Connection c = null;
	      try {
	    	  Class.forName("org.postgresql.Driver");
	    	  c = DriverManager.getConnection("jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/d6d38dp6fnlb5u?"+
	    			    "user=nxomzfynxtfbwx&password=CTNlpUsfCT4DJj6ke7FpTkTHzK&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	}
	
	public void insertToDB(){
		Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	    	  c = DriverManager.getConnection("jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/d6d38dp6fnlb5u?"+
	    			    "user=nxomzfynxtfbwx&password=CTNlpUsfCT4DJj6ke7FpTkTHzK&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");

	         stmt = c.createStatement();
	         String sql = "INSERT INTO product "
	               + "VALUES (1, 'kepap', 32 );";
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO product "
		               + "VALUES (2, 'doner', 20 );";
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
	
	public List<Product> selectAllFromDB(){
		   Connection c = null;
	       Statement stmt = null;
	       List<Product> list = new ArrayList<Product>(); 
	       
	       try {
	    	   Class.forName("org.postgresql.Driver");
	    	  c = DriverManager.getConnection("jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/d6d38dp6fnlb5u?"+
	    			    "user=nxomzfynxtfbwx&password=CTNlpUsfCT4DJj6ke7FpTkTHzK&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
	         System.out.println("Opened database successfully");
	         
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM product ;" );
	         while ( rs.next() ) {
	        	int id = rs.getInt("id");
	            String  name = rs.getString("name");
	            int price  = rs.getInt("price");
	            list.add(new Product(id, name, price));
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	       }
	       System.out.println("Operation done successfully");
		return list;
	}
	
	public Product selectByIdFromDB(int ID){
		   Connection c = null;
	       Statement stmt = null;
	       Product send = null;
	       try {
	    	   Class.forName("org.postgresql.Driver");
		    	  c = DriverManager.getConnection("jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/d6d38dp6fnlb5u?"+
		    			    "user=nxomzfynxtfbwx&password=CTNlpUsfCT4DJj6ke7FpTkTHzK&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
	         System.out.println("Opened database successfully");
	         
	         
	         
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM product where id = "+ID+" ;" );
	         while ( rs.next() ) {
	        	int id = rs.getInt("id");
	            String  name = rs.getString("name");
	            int price  = rs.getInt("price");
	            send = new Product(id, name, price);
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	       }
	       System.out.println("Operation done successfully");
		return send;
	}
	
	
}
