package fereastraGlisanta;

public class Message {

	private int theExpectedBit;
	private int ACK;
	private int SYN;
	private int FIN;
	private int f;
	private StringBuilder window;
	private String message;

	public Message() {

	}

	public Message(int x, int ack, int syn, int fin, Integer f, String message) {
		this.theExpectedBit = x;
		this.ACK = ack;
		this.SYN = syn;
		this.FIN = fin;
		this.f = f;
		this.message = message;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getTheExpectedBit() {
		return theExpectedBit;
	}

	public void setTheExpectedBit(int theExpectedBit) {
		this.theExpectedBit = theExpectedBit;
	}

	public int getACK() {
		return ACK;
	}

	public void setACK(int aCK) {
		ACK = aCK;
	}

	public int getSYN() {
		return SYN;
	}

	public void setSYN(int sYN) {
		SYN = sYN;
	}

	public int getFIN() {
		return FIN;
	}

	public void setFIN(int fIN) {
		FIN = fIN;
	}

	public StringBuilder getWindow() {
		return window;
	}

	public void setWindow(StringBuilder window) {
		this.window = window;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {

		return "x:(" + theExpectedBit + ") (\t ACK: " + ACK + ") (\t SYN: " + SYN + ") (\t received message:" + window
				+ ") (\t message: " + message + ") (\t f " + f + ") (\t Fin: " + FIN+")";
	}

}
