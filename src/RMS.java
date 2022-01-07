
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RMS {
	static Statement st;
	
	static String iSep = "_";
	static String lSep = "@";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String url = "jdbc:mysql://localhost:3306/RMS";
		String username = "root";
		String password = "";
		
		Connection conn = DriverManager.getConnection(url,username,password); 
        st = conn.createStatement(); 
         
        //AddItem(0,"batu","asd", 100, 10);
        System.out.println(GetItems());
        RemoveItem(0);
        System.out.println(GetItems());
	}
	
	
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
		try {
			rs = st.executeQuery("SELECT * FROM ITEMS");
			String str = "";
			while (rs.next()) {
				String item = rs.getString("item_id") + iSep + rs.getString("item_name") + iSep + rs.getString("description") + iSep + rs.getString("price") + iSep + rs.getString("stock");
			
				str += item + lSep;
			}
			return str.substring(0, str.length() - lSep.length());
		} catch (SQLException e) {e.printStackTrace();}
			  
		return "";
	}
	
	public static boolean AddTable(int item_id,int t_id ,boolean isFull) {
		try {
			st.executeUpdate("INSERT INTO TABLESw Values" + item_id +" ," + t_id + " ," +isFull);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void RemoveTable(int t_id) {
		try {
			st.executeUpdate("DELETE FROM TABLES WHERE " + t_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String GetTable() {
		//return st.executeUpdate("Select * From ");
		return " " ;

	}
	
	public static boolean AddEmployee(String name,int e_id , String role, String password,int permissionLevel ) {
		try {
			st.executeUpdate("INSERT INTO EMPLOYEE Values" +"'"+ name +"'"+","+ e_id +","+"'"+ role + "'" +","+ password +","+ permissionLevel);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void RemoveEmployee(int e_id) {
		try {
			st.executeUpdate("DELETE FROM EMPLOYEE WHERE " + e_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String GetEmployee() {
		//return st.executeUpdate("Select * From ");
		return " " ;

	}
	
	public static boolean AddEarning(int price , String dates ) {
		try {
			st.executeUpdate("INSERT INTO EARNINGS Values" + price +","+ dates);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void RemoveEarning(int price , String dates) {
		try {
			st.executeUpdate("DELETE FROM EARNINGS WHERE " + price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static String GetEarning() {
		//return st.executeUpdate("Select * From ");
		return " " ;
	}
	
	
	
	
	
}
