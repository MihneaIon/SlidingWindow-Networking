package fereastraGlisanta;

public class Destination extends Thread {

	Message message = new Message();
	MessageUtility messageUtility = new MessageUtility();
	StringBuilder myStringBuilder = new StringBuilder();

	public Destination(MessageUtility messageUtility) {
		this.messageUtility = messageUtility;
		Thread thread2 = new Thread(this, "Destination");
		thread2.start();
	}

	public void run() {
		while (message.getFIN() != 1) {
			message = messageUtility.getMessage();
			if (message.getTheExpectedBit() == 0) {
				message.setSYN(1);
			}
			message = prelucreazaMesajDestinatie(message);
			System.out.println("I send to the source " + message+"\n");
			
			if (message.getFIN() == 1) {
				System.out.println("I arrive at the end");
				message.setFIN(1);
				System.out.println(message.toString());
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Message prelucreazaMesajDestinatie(Message message) {
		int lenght = 0;
		String rezult = "";
		if (message.getMessage().length() == 0) {
			System.out.println("..............................................................................");
			message.setFIN(1);
		} else if (message.getSYN() == 1) {
			// lenght = genereazaRandom(message.getMessage());
			lenght = RandomF(message.getMessage().length());
			for (int i = 0; i < lenght; i++) {
				char c = message.getMessage().charAt(i);
				rezult = rezult + c;
			}
			myStringBuilder.append(rezult);
			message.setSYN(1);
			message.setWindow(myStringBuilder);
			message.setF(lenght);
			message.setTheExpectedBit(message.getTheExpectedBit() + 1);
			message.setMessage(message.getMessage().substring(lenght));
		}
		messageUtility.putMessage(message);
		return message;
	}

	public int RandomF(int length) {
		int rand = (int) (Math.random() * 10);
		while (rand > length) {
			rand = (int) (Math.random() * 10);
		}
		return rand;
	}

}
