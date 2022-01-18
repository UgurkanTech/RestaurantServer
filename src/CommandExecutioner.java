import java.util.LinkedList;
import java.util.Queue;

public class CommandExecutioner {

	public static Queue<String> sendQueue = new LinkedList<String>();

	//Executes a command on the database
	public static void execute(String command) {
		
		
		try {
			String cmd = command.split(DatabaseManager.cSep)[0];
			String argStr = "";
			String[] args = {};
			try {
				argStr = command.split(DatabaseManager.cSep)[1];
				args = argStr.split(DatabaseManager.iSep);
			} catch (Exception e) {}
			
			
			switch (cmd) {
			case "additem":
				DatabaseManager.AddItem(args[0], args[1], args[2], args[3], args[4]);
				break;
			case "remoteitem":
				DatabaseManager.RemoveItem(args[0]);
				break;
			case "getitems":
				sendQueue.add(DatabaseManager.GetItems());
				break;
			case "addtable":
				DatabaseManager.AddTable(args[0], args[1]);
				break;
			case "removetable":
				DatabaseManager.RemoveTable(args[0]);
				break;
			case "gettables":
				sendQueue.add(DatabaseManager.GetTables());
				break;
			case "addtableitem":
				DatabaseManager.AddTableItem(args[0], args[1], args[2]);
				break;
			case "removetableitem":
				DatabaseManager.RemoveTableItem(args[0], args[1]);
				break;
			case "cleartableitem":
				DatabaseManager.ClearTableItem(args[0]);
				break;
			case "gettableitems":
				sendQueue.add(DatabaseManager.GetTableItems());
				break;
			case "addemployee":
				DatabaseManager.AddEmployee(args[0], args[1], args[2], args[3], args[4]);
				break;
			case "removeemployee":
				DatabaseManager.RemoveEmployee(args[0]);
				break;
			case "getemployees":
				sendQueue.add(DatabaseManager.GetEmployees());
				break;
			case "addearning":
				DatabaseManager.AddEarning(args[0], args[1]);
				break;
			case "clearearning":
				DatabaseManager.ClearEarning();
				break;
			case "removeearning":
				DatabaseManager.RemoveEarning(args[0]);
				break;
			case "getearnings":
				sendQueue.add(DatabaseManager.GetEarnings());
				break;
			default:
				System.err.println("Invalid command received! = " + cmd);
				break;
			}
		} catch (Exception e) {
			System.err.println("Execution Error! = " + e.getMessage());
		}
		
		System.out.println(command + " - executed!");
	}
	
}
