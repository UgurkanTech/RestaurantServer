
public class Server {

	
	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		new GUI();
		new DatabaseManager("RMS", "root", "root");
		if(DatabaseManager.ready)
			new ServerTCP();
	}
	
}
