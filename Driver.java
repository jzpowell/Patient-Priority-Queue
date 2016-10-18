import java.sql.*;

import com.mysql.jdbc.SQLError;


public class Driver {
	
	public static void addDatabase(String name){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String add = "CREATE DATABASE " + name+"";
			int updateEntry = stmt.executeUpdate(add);
			con.close();
			
			System.out.println("Database added.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
	
	public static void addTable(String dbName, String tName){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/"+dbName+"","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String add = "CREATE TABLE "+tName+ " (null int(1))";
			int updateEntry = stmt.executeUpdate(add);
			con.close();
			
			System.out.println("Table added.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
	
	public static void addEntry(String dbName, int ptNum, String ptFName, String ptLName, String address, String city){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Patient","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String add = "Insert into Persons values ('"+ptNum+"', '"+ptFName+"', '"+ptLName+"', '"+address+"', '"+city+"')";
			int updateEntry = stmt.executeUpdate(add);
			con.close();
			
			System.out.println("Entry added.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
	
	public static void pullAll(String dbName) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/"+ dbName + "","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String add = "Select * From Patient";
			ResultSet rs = stmt.executeQuery(add);
			
			while(rs.next()){
				int id = rs.getInt("Pat_ID");
				String fName = rs.getString("Pat_Name");
				String lName = rs.getString("Pat_LName");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				System.out.println(id + "\t" + fName + "\t" + lName + "\t" + address + "\t" + city + "\t");
			}
			
			con.close();
			
			System.out.println("End Return.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
}