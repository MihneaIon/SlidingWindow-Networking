package fereastraGlisanta;

public class Main {
	public static void main(String[] args) {

		MessageUtility messageUtility = new MessageUtility();
		System.out.println("Citeste mesajul:");
		new Source(messageUtility);
		new Destination(messageUtility);

	}

}
