
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {
	static Statement st;
	
	static String iSep = "_"; //Item Seperator
	static String lSep = "#"; //Line Seperator
	static String cSep = "@"; //Command Seperator
	
	static boolean ready = false;
	
	public DatabaseManager(String database, String user, String pass){
		String url = "jdbc:mysql://localhost:3306/" + database;
		
		try {
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			st = conn.createStatement(); 
			System.out.println("Database Connection Established!");
			ready = true;
			
		} catch (SQLException e) {
			System.err.println("Database Connection Failed! Try restarting MySQL Server!");
			//e.printStackTrace();
		} 
        
		//System.out.println(GetItems());
	}
	
	//ITEMS
	public static boolean AddItem(String item_id , String item_name , String description , String price , String stock) {
		try {
			st.executeUpdate("INSERT INTO ITEMS Values (" + item_id + ", '" + item_name + "', '" + description + "', " + price + ", " +  stock + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveItem(String item_id) {
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
			return "items" + cSep + str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return "items" + cSep + str;
	}
	
	//TABLES
	public static boolean AddTable(String t_id , String isFull) {
		try {
			st.executeUpdate("INSERT INTO TABLES Values (" + t_id + ", " +  isFull+ ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveTable(String t_id) {
		try {
			st.executeUpdate("DELETE FROM TABLES WHERE t_id=" + t_id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String GetTables() {
		ResultSet rs;
		String str = "";
		try {
			rs = st.executeQuery("SELECT * FROM TABLES");
			while (rs.next()) {
				String item = rs.getString("t_id") + iSep + rs.getString("isFull") ;
				str += item + lSep;
			}
			return "tables" + cSep + str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return "tables" + cSep + str;
	}
	//TABLEITEMS
	public static boolean AddTableItem(String t_id , String item_id , String item_count) {
		try {
			st.executeUpdate("INSERT INTO TABLEITEMS Values (" + t_id + "," + item_id + ", " +item_count+ ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveTableItem(String t_id , String item_id) {
		try {
			st.executeUpdate("DELETE FROM TABLEITEMS WHERE t_id=" + t_id +" AND item_id=" + item_id );
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
			rs = st.executeQuery("SELECT * FROM TABLEITEMS");
			while (rs.next()) {
				String item = rs.getString("t_id") + iSep + rs.getString("item_id") + iSep + rs.getString("item_count");
				str += item + lSep;
			}
			return "tableitems" + cSep + str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return "tableitems" + cSep + str;
	}
	
	
	//EMPLOYEES
	public static boolean AddEmployee(String name ,String e_id, String role , String password , String permissionLevel) {
		try {
			st.executeUpdate("INSERT INTO EMPLOYEES Values ('" + name + "', " + e_id + ", '" + role + "', '" + password + "', " +  permissionLevel + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveEmployee(String e_id) {
		try {
			st.executeUpdate("DELETE FROM EMPLOYEES WHERE e_id=" + e_id);
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
				String item = rs.getString("name") + iSep + rs.getString("e_id") + iSep + rs.getString("role") + iSep + rs.getString("password") + iSep + rs.getString("permissionLevel");
				str += item + lSep;
			}
			return "employees" + cSep + str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return "employees" + cSep + str;
	}
	
	//EARNINGS
	public static boolean AddEarning(String price , String dates) {
		try {
			st.executeUpdate("INSERT INTO EARNINGS Values (" + price +", '" + dates + "' )");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveEarning(String price) {
		try {
			st.executeUpdate("DELETE FROM EARNINGS WHERE price=" + price);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String GetEarnings() {
		ResultSet rs;
		String str = "";
		try {
			rs = st.executeQuery("SELECT * FROM EARNINGS");
			while (rs.next()) {
				String item = rs.getString("price") + iSep + rs.getString("dates");
				str += item + lSep;
			}
			return "earnings" + cSep + str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return "earnings" + cSep + str;
	}
	
}
