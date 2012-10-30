
public class Transition {
	
	private State from;
	private State to;
	private String read;
	private String write;
	private String direction;
	
	public Transition(State from, String read, State to, String write, String direction){
		this.from = from;
		this.read = read;
		this.to = to;
		this.write = write;
		this.direction = direction;
	}
	
	/* Ausgabe unserer jeweiligen Zustandskonfiguration */
	public String toString(){
		return from + " " + read + " " + " " + to + " " + write + " " + direction;
	}
	
	public boolean isNo(){
		return direction.equals("N");
	}
	
	public boolean isLeft(){
		return direction.equals("L");
	}
	
	public boolean isRight(){
		return direction.equals("R");
	}
	
	/* Lediglich Getter-/Settermethoden */
	public State getFrom() {
		return from;
	}

	public void setFrom(State from) {
		this.from = from;
	}

	public State getTo() {
		return to;
	}

	public void setTo(State to) {
		this.to = to;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
