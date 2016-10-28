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
import java.util.*;

//import javax.sql.rowset.JdbcRowSet;
//import com.sun.rowset.JdbcRowSetImpl;



/**
class Patient {
	
 *****
 *  Testing consolidation of code. I'd like to not have to declare the Connection for every method. Having a global Connector would reduce code
 *  and make the program more slim. 
 *****
		
		
	private int patID;
	 private String fName;
	 private String mName;
	 private String lName; 
	 private String streetAddress;
	 private String city;
	 private int zipCode;
	 private int phoneNum;
	 
	 



	

  	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306?autoReconnect=true&useSSL=false";
	static final String DB_USER = "root";
	static final String DB_PASS = "password";
	private JdbcRowSet rowSet =null;
	
	public Driver(){
	

			
		try {
			Class.forName(JDBC_DRIVER);
			rowSet = new JdbcRowSetImpl();
			rowSet.setUrl(DB_URL);
			rowSet.setUsername(DB_USER);
			rowSet.setPassword(DB_PASS);
			rowSet.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		}
**/
	
class Driver {
	
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
	
	public static void addEntry(int ptNum, String ptFName, String ptLName ,String address, String city){
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
			String cmnd = "Select *"+
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
	
	public static void pullID (int patID){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false","root","password");  
			
			
			Statement stmt=con.createStatement();  
			String cmnd = "Select *"+
						  " From Patient" +
						  " Where Pat_ID='"+patID+"'";
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
	
	public static void deleteAll(){
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false","root","password");  
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Are you sure you want to delete all the entries? This cannot be undone. Enter Yes or No.");	
			String answer = scan.next().trim().toLowerCase();
			
			while((!answer.equals("yes") || !answer.equals("no"))){
				if(answer.equals("yes")){
			
					Statement stmt=con.createStatement();  
					String cmnd = "Delete from Patient";
					int rs = stmt.executeUpdate(cmnd);
		
					con.close();
			
					System.out.println("All Entries Deleted.");
					break;
				}else if (answer.equals("no")){
					System.out.println("No entries have been deleted.");
					break;
				}else{
					System.out.println("Not a valid answer.");
				}
			}
				
			}catch(Exception e){ System.out.println(e);
		}
	}

	public static void deletePat(int patID){
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false","root","password");  
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Are you sure you want to delete this entry? This cannot be undone. Enter Yes or No.");	
			String answer = scan.next().trim().toLowerCase();
			
			while((!answer.equals("yes") || !answer.equals("no"))){
			
				if(answer.equals("yes")){
					
					Statement stmt=con.createStatement();  
					String cmnd = "Delete from Patient"+
					      " Where Pat_ID='"+patID+"'";
					int rs = stmt.executeUpdate(cmnd);
		
					con.close();
			
					System.out.println("Entry Deleted.");
					break;
				}else if (answer.equals("no")){
					System.out.println("No entries have been deleted.");
					break;
				}else{
					System.out.println("Not a valid answer.");
				}
			}	
				
			}catch(Exception e){ System.out.println(e);
		}
	}

}
