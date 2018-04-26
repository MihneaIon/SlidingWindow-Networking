package fereastraGlisanta;

public class MessageUtility {

	Message message = new Message();

	boolean check = false;

	public synchronized void putMessage(Message myMessage) {
		while (check) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.message = myMessage;
		check = true;
		notify();
	}

	public synchronized Message getMessage() {
		while (!check) {

			try {
				wait();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		check = false;
		notify();
		return message;
	}

}
