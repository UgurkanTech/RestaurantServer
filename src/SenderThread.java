
public class SenderThread  implements Runnable{

	public SenderThread() {
		
	}

	@Override
	public void run() {
		while (true) {
			if(!Server.sendQueue.isEmpty()) {
				System.out.println("Sending: " + Server.sendQueue.poll());
			}
			try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}
		}
		
	}

}
