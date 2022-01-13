import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * A TCP Server
 * 
 * @author Uğurkan Hoşgör
 *
 */
public class ServerTCP extends Thread{

	//connectivity
	public boolean reconnectOnError = true;
	public boolean multipleClients = true;
	public int clientLimit = 4;
	
	
	//communication settings
	public boolean compressData = true;
	public boolean encryptData = true;
	private final boolean DEBUG = false;
	
	private ServerSocket serversocket;
	
	
	private ArrayList<ReceiverTCP> clients = new ArrayList<ReceiverTCP>();

	private final int serverSecret = 1337;

	
	private int getNewClientID() {
		for (int i = 0; i < 250; i++) {
			for (int j = 0; j < clients.size(); j++) {
				if(clients.get(j).getClientID() != i) 
					return i;
			}
			
		}
		return 0;
	}
	
	
	public ServerTCP() {
		startServer();
	}
	
	private void startServer() {
		start();
	}
	
	@Override
	public void run() {
		try {
			serversocket = new ServerSocket(5555);
		} catch (IOException e1) {e1.printStackTrace();}
		System.out.println("Server Started! - Port: " + serversocket.getLocalPort());
	
		do {
			
			try {
					
				while ((clients.size() >= clientLimit && clientLimit != -1) || clients.size() >= 255) {
					Thread.sleep(100);
					for (int i = 0; i < clients.size(); i++) {
						if (!clients.get(i).isAlive()) {
							clients.remove(i);
						}
					}
				}

				 
				System.out.println("Server is waiting for connections...");	
				Socket socket = serversocket.accept();

				int clientID = getNewClientID();
				
				socket.getOutputStream().write(clientID); //assign an id
				
				//send communication protocol
				if (!compressData && !encryptData) {
					socket.getOutputStream().write(0);
				}
				else if (compressData && !encryptData) {
					socket.getOutputStream().write(1);
				}
				else if (!compressData && encryptData) {
					socket.getOutputStream().write(2);	
				}
				else if (compressData && encryptData) {
					socket.getOutputStream().write(3);
				}
				
					
				System.out.println("Connection estabished! Client ID: " + clientID);	
				
				ReceiverTCP receiver =  new ReceiverTCP(socket, clientID, serverSecret, compressData, encryptData);
				SenderTCP sender =  new SenderTCP(socket, clientID, serverSecret, compressData, encryptData);
				
				clients.add(receiver); //client id
				
				receiver.setName("Receiver-" + clientID);
				sender.setName("Sender-" + clientID);
				
				//They will finish if connection fails
				if (!multipleClients) {
					receiver.join();
				}
					
			} catch (Exception e) {if (DEBUG) e.printStackTrace(); else System.err.println("Error while connecting a new client!");}
			
			//Delay for reconnecting..
			try {Thread.sleep(100);} catch (Exception e) {e.printStackTrace();}
			
		} while (reconnectOnError || multipleClients);
		
	}
	
	
}
