
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {
	static Statement st;
	
	static String iSep = "_";
	static String lSep = "@";
	
	
	public DatabaseManager(String database, String user, String pass){
		String url = "jdbc:mysql://localhost:3306/" + database;
		
		try {
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			st = conn.createStatement(); 
			
		} catch (SQLException e) {e.printStackTrace();} 
        
         
        //AddItem(0,"batu","asd", 100, 10);
        //System.out.println(GetItems());
        //RemoveItem(0);
       
        //System.out.println(RMSUtils.Password.toHash("admin"));
		
		System.out.println(GetItems());
	}
	
	//ITEMS
	public static boolean AddItem(int item_id , String item_name , String description , int price , int stock) {
		try {
			st.executeUpdate("INSERT INTO ITEMS Values (" + item_id + ", '" + item_name + "', '" + description + "', " + price + ", " +  stock + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveItem(int item_id) {
		try {
			st.executeUpdate("DELETE FROM ITEMS WHERE item_id=" + item_id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String GetItems() {
		ResultSet rs;
		String str = "";
		try {
			rs = st.executeQuery("SELECT * FROM ITEMS");
			while (rs.next()) {
				String item = rs.getString("item_id") + iSep + rs.getString("item_name") + iSep + rs.getString("description") + iSep + rs.getString("price") + iSep + rs.getString("stock");
				str += item + lSep;
			}
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return str;
	}
	
	//TABLES
	public static boolean AddTable(int item_id , String item_name , String description , int price , int stock) {
		try {
			st.executeUpdate("INSERT INTO TABLES Values (" + item_id + ", '" + item_name + "', '" + description + "', " + price + ", " +  stock + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveTable(int item_id) {
		try {
			st.executeUpdate("DELETE FROM TABLES WHERE item_id=" + item_id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String GetTable() {
		ResultSet rs;
		String str = "";
		try {
			rs = st.executeQuery("SELECT * FROM TABLES");
			while (rs.next()) {
				String item = rs.getString("item_id") + iSep + rs.getString("item_name") + iSep + rs.getString("description") + iSep + rs.getString("price") + iSep + rs.getString("stock");
				str += item + lSep;
			}
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return str;
	}
	//TABLEITEMS
	public static boolean AddTableItems(int item_id , String item_name , String description , int price , int stock) {
		try {
			st.executeUpdate("INSERT INTO TABLES Values (" + item_id + ", '" + item_name + "', '" + description + "', " + price + ", " +  stock + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveTableItems(int item_id) {
		try {
			st.executeUpdate("DELETE FROM TABLES WHERE item_id=" + item_id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String GetTableItems() {
		ResultSet rs;
		String str = "";
		try {
			rs = st.executeQuery("SELECT * FROM TABLES");
			while (rs.next()) {
				String item = rs.getString("item_id") + iSep + rs.getString("item_name") + iSep + rs.getString("description") + iSep + rs.getString("price") + iSep + rs.getString("stock");
				str += item + lSep;
			}
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return str;
	}
	
	
	//EMPLOYEES
	public static boolean AddEmployee(int item_id , String item_name , String description , int price , int stock) {
		try {
			st.executeUpdate("INSERT INTO EMPLOYEES Values (" + item_id + ", '" + item_name + "', '" + description + "', " + price + ", " +  stock + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveEmployee(int item_id) {
		try {
			st.executeUpdate("DELETE FROM EMPLOYEES WHERE item_id=" + item_id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String GetEmployees() {
		ResultSet rs;
		String str = "";
		try {
			rs = st.executeQuery("SELECT * FROM EMPLOYEES");
			while (rs.next()) {
				String item = rs.getString("item_id") + iSep + rs.getString("item_name") + iSep + rs.getString("description") + iSep + rs.getString("price") + iSep + rs.getString("stock");
				str += item + lSep;
			}
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return str;
	}
	
	//EARNINGS
	public static boolean AddEarning(int item_id , String item_name , String description , int price , int stock) {
		try {
			st.executeUpdate("INSERT INTO EARNINGS Values (" + item_id + ", '" + item_name + "', '" + description + "', " + price + ", " +  stock + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveEarning(int item_id) {
		try {
			st.executeUpdate("DELETE FROM EARNINGS WHERE item_id=" + item_id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String GetEarning() {
		ResultSet rs;
		String str = "";
		try {
			rs = st.executeQuery("SELECT * FROM EARNINGS");
			while (rs.next()) {
				String item = rs.getString("item_id") + iSep + rs.getString("item_name") + iSep + rs.getString("description") + iSep + rs.getString("price") + iSep + rs.getString("stock");
				str += item + lSep;
			}
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return str;
	}
	
	
	
	
	
}
