
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {
	static Statement st;
	
	static String iSep = "_"; //Item Seperator
	static String lSep = "@@@"; //Line Seperator
	
	
	public DatabaseManager(String database, String user, String pass){
		String url = "jdbc:mysql://localhost:3306/" + database;
		
		try {
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			st = conn.createStatement(); 
			
		} catch (SQLException e) {e.printStackTrace();} 
        
        //RemoveItem(6);
       // AddItem(6,"coffe","latte", 100, 10);
        //System.out.println(GetItems());
        //RemoveItem(0);
       
        //System.out.println(RMSUtils.Password.toHash("admin"));
		//AddTable(10, true);
		//AddEmployee("batusss", 3, "bakanyardýmcý", "pass", 120);
		//AddEarning(200,"2021-10-07");
		//AddTableItems(10, 1, 3);
		//RemoveTableItems(10, 6, 2);
		//RemoveEarning(200);
		System.out.println(GetTableItems());
		//System.out.println(GetItems());
		//System.out.println(GetTable());
		//System.out.println(GetEarning());
		//System.out.println(GetEmployees());
		RemoveTableItems(4, 2);
		System.out.println(GetTableItems());
		
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
	public static boolean AddTable(int t_id , boolean isFull) {
		try {
			st.executeUpdate("INSERT INTO TABLES Values (" + t_id + ", " +  isFull+ ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveTable(int t_id) {
		try {
			st.executeUpdate("DELETE FROM TABLES WHERE t_id=" + t_id);
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
				String item = rs.getString("t_id") + iSep + rs.getString("isFull") ;
				str += item + lSep;
			}
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return str;
	}
	//TABLEITEMS
	public static boolean AddTableItems(int t_id , int item_id , int item_count) {
		try {
			st.executeUpdate("INSERT INTO TABLEITEMS Values (" + t_id + "," + item_id + ", " +item_count+ ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveTableItems(int t_id , int item_id) {
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
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return str;
	}
	
	
	//EMPLOYEES
	public static boolean AddEmployee(String name ,int e_id, String role , String password , int permissionLevel) {
		try {
			st.executeUpdate("INSERT INTO EMPLOYEES Values ('" + name + "', " + e_id + ", '" + role + "', '" + password + "', " +  permissionLevel + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveEmployee(int e_id) {
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
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return str;
	}
	
	//EARNINGS
	public static boolean AddEarning(int price , String dates) {
		try {
			st.executeUpdate("INSERT INTO EARNINGS Values (" + price +", '" + dates + "' )");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean RemoveEarning(int price) {
		try {
			st.executeUpdate("DELETE FROM EARNINGS WHERE price=" + price);
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
				String item = rs.getString("price") + iSep + rs.getString("dates");
				str += item + lSep;
			}
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
		
		return str;
	}
	
	
	
	
	
}
