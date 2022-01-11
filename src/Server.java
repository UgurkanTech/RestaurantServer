import javax.swing.SwingUtilities;

public class Server {

	
	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		GUI gui = new GUI();

		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		new DatabaseManager("RMS", "root", "");
        		if(DatabaseManager.ready)
        			new ServerTCP();
            }
        });
		
		gui.revalidate();
		gui.repaint();
	}
	
}
