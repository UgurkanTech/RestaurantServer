import java.util.LinkedList;
import java.util.Queue;

public class Server {

	public static Queue<String> sendQueue = new LinkedList<String>();
	
	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		new DatabaseManager("RMS", "root", "");
	}

}
