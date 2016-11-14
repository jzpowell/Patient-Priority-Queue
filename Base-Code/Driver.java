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


	
class Driver {
	
	public static int Pat_ID = 1000;
	public static String Pat_FName;
	public static String Pat_LName;
	public static String Pat_MName;
	public static String Pat_StreetAddrs;
	public static String Pat_City;
	public static String Pat_State; 
	public static String Pat_Height; 
	public static String Pat_Weight;
	public static String Pat_DOB;
	
	
	
	
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
	
	public static void addEntry(String Pat_FName, String Pat_LName ,String Pat_MName, String Pat_StreetAddrs, String Pat_City, String Pat_State, String Pat_Height, String Pat_Weight, String Pat_DOB){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Patient_Queue?autoReconnect=true&useSSL=false","root","password");  
			
			
			Statement stmt=con.createStatement();  
			
			
			
			String add = "INSERT INTO Pat_List VALUES ('"+Pat_ID+"', '"+Pat_FName+"', '"+Pat_LName+"', '"+Pat_MName+"', '"+Pat_StreetAddrs+"', '"+Pat_City+"', '" + Pat_State+"', '"+Pat_Height+"', '"+Pat_Weight+"', '"+Pat_DOB+"');";
			stmt.executeUpdate(add);
			con.close();
			
			Pat_ID++;
			
			//for console testing
			//System.out.println("Entry added.");
				
			}catch(Exception e){ System.out.println(e);
		}
	}
	
	public static void pullAll(String dbName) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Pat_List?autoReconnect=true&useSSL=false","root","password");  
			
			
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
			"jdbc:mysql://localhost:3306/Pat_List?autoReconnect=true&useSSL=false","root","password");  
			
			
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
			"jdbc:mysql://localhost:3306/Pat_List?autoReconnect=true&useSSL=false","root","password");  
			
			
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
			"jdbc:mysql://localhost:3306/Pat_List?autoReconnect=true&useSSL=false","root","password");  
			
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
			"jdbc:mysql://localhost:3306/Pat_List?autoReconnect=true&useSSL=false","root","password");  
			
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

	public int getPat_ID() {
		return Pat_ID;
	}

	public void setPat_ID(int pat_ID) {
		Pat_ID = pat_ID;
	}

	public static String getPat_FName() {
		return Pat_FName;
	}

	public static void setPat_FName(String pat_FName) {
		Pat_FName = pat_FName;
	}

	public static String getPat_LName() {
		return Pat_LName;
	}

	public static void setPat_LName(String pat_LName) {
		Pat_LName = pat_LName;
	}

	public static String getPat_MName() {
		return Pat_MName;
	}

	public static void setPat_MName(String pat_MName) {
		Pat_MName = pat_MName;
	}

	public static String getPat_StreetAddrs() {
		return Pat_StreetAddrs;
	}

	public static void setPat_StreetAddrs(String pat_StreetAddrs) {
		Pat_StreetAddrs = pat_StreetAddrs;
	}

	public static String getPat_City() {
		return Pat_City;
	}

	public static void setPat_City(String pat_City) {
		Pat_City = pat_City;
	}

	public static String getPat_State() {
		return Pat_State;
	}

	public static void setPat_State(String pat_State) {
		Pat_State = pat_State;
	}

	public static String getPat_Height() {
		return Pat_Height;
	}

	public static void setPat_Height(String pat_Height) {
		Pat_Height = pat_Height;
	}

	public static String getPat_Weight() {
		return Pat_Weight;
	}

	public static void setPat_Weight(String pat_Weight) {
		Pat_Weight = pat_Weight;
	}

	public static String getPat_DOB() {
		return Pat_DOB;
	}

	public static void setPat_DOB(String pat_DOB) {
		Pat_DOB = pat_DOB;
	}

}
