/*
 * Represents a state of a turingmachine
 */
public class State {
	private String name;
	/* Wenn Zustand ein Endzustand so geben wir ihm eine besondere Typbezeichnung "H". Die anderen Zustaende sollen die Bezeichnung "N" bekommen */
	private String type;
	
	public State(String name, String type){
		this.name = name;
		this.type = type;
	}
	
	public String getName(){
		return name;
	}
	
	/* Wenn Zustand ein Endzustand ist so gebe true zurück */
	public boolean isHalt(){
		return type.equals("H");
	}
	
	public String toString(){
		return "[" + name + "]";
	}
}
