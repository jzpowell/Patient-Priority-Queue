/******************************************************************
* This is the Driver class. It houses all of the callabe methods our
* Priority Queue and GUI will implement. If you come across a method
* that needs to be added, let me know and I will make sure it gets
* entered in. 
*
* Zach Powell
* jpowell26@student.gsu.edu
* 678-447-8723
*******************************************************************/


package Priority_Queue;
import java.sql.*;


public class Driver {
	
	public static void addDatabase(String name){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306?autoReconnect=true&useSSL=false","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String add = "CREATE DATABASE " + name+"";
			stmt.executeUpdate(add);
			con.close();
			
			System.out.println("Database added.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
	
	public static void addTable(String dbName, String tName){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false"+dbName+"","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String add = "CREATE TABLE "+tName+ " (null int(1))";
			stmt.executeUpdate(add);
			con.close();
			
			System.out.println("Table added.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
	
	public static void addEntry(int ptNum, String ptFName, String ptLName, String address, String city){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String add = "Insert into Patient values ('"+ptNum+"', '"+ptFName+"', '"+ptLName+"', '"+address+"', '"+city+"')";
			stmt.executeUpdate(add);
			con.close();
			
			System.out.println("Entry added.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
	
	public static void pullAll(String dbName) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/"+ dbName + "?autoReconnect=true&useSSL=false","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String add = "Select * From Patient";
			ResultSet rs = stmt.executeQuery(add);
			
			while(rs.next()){
				int id = rs.getInt("Pat_ID");
				String fName = rs.getString("Pat_Name");
				String lName = rs.getString("Pat_LName");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				System.out.println(id + "\t\t" + fName + "\t\t" + lName + "\t\t" + address + "\t\t" + city + "\t\t");
			}
			
			con.close();
			
			System.out.println("End Return.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
	
	public static void pullTop(String dbName) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/"+ dbName + "?autoReconnect=true&useSSL=false","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String cmnd = "Select Pat_Id, Pat_Name, Pat_LName, Address, City"+
					" From Patient" +
					" Limit 1";
			ResultSet rs = stmt.executeQuery(cmnd);
			
			while(rs.next()){
				int id = rs.getInt("Pat_ID");
				String fName = rs.getString("Pat_Name");
				String lName = rs.getString("Pat_LName");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				System.out.println(id + "\t\t" + fName + "\t\t" + lName + "\t\t" + address + "\t\t" + city + "\t\t");
			}
			
			con.close();
			
			System.out.println("End Return.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
}
