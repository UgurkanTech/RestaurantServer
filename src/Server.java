import java.util.LinkedList;
import java.util.Queue;

public class Server {

	public static Queue<String> sendQueue = new LinkedList<String>();
	
	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		Thread listener = new Thread(new ListenerThread());
		Thread sender = new Thread(new SenderThread());
		
		listener.start();
		sender.start();
	}

}
