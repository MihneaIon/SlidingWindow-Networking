package fereastraGlisanta;

import java.util.Scanner;

public class Source implements Runnable {
	
	Scanner myScanner=new Scanner(System.in);
	String mesaj=myScanner.nextLine();
	

	Message message = new Message(0, 1, 0, 0, 0,mesaj);
	MessageUtility messageUtility = new MessageUtility();

	public Source(MessageUtility messageUtility) {
		this.messageUtility = messageUtility;
		Thread thread = new Thread(this, "Source");
		thread.start();
	}

	@Override
	public void run() {
		messageUtility.putMessage(message);
		while (message.getFIN() != 1) {
			System.out.println("I send to destination: " + message);
			message.setSYN(1);
			if (message.getTheExpectedBit() != 0) {
				message.setTheExpectedBit(message.getF()+message.getTheExpectedBit());
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
