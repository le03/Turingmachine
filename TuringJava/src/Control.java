import java.util.HashMap;

public class Control {

	private HashMap<String, State> states; // Liste von allen Zuständen
	private HashMap<String, Transition> transitions; // Liste von allen Übergangsfunktionen
	private State state; // Speicherung des aktuellen Zustandes
	
	public Control() {
        states      = new HashMap<String, State>();
        transitions = new HashMap<String, Transition>();
    }
	
	/* Aktuellen Zustand ausgeben */
	public State getState(){
		return state;
	}
	/* Aktuellen Zustand setzen */
	public void setState(State state){
		this.state = state;
	}
	
	/* Bestimmten Zustand suchen */
	private State findState(String name){
		return states.get(name);
	}
	
	/* Eine Zustandsübergansfunktion hinzufügen */
	public void addTransition(String f, String t, String read, String write, String direction) {
	    State from = findState(f);
	    State to = findState(t);
	    Transition transition = new Transition(from, read, to, write, direction);
	    if (transitions.get(f + read) != null)
	    	throw new RuntimeException("Nondeterministic Turing machine");
	    transitions.put(f + read, transition);
	 }
	
	/* Gib die passende Zustandsübergangsfunktion zurück */
    public Transition getTransition(String read) {
        Transition t = transitions.get(state.getName()  + read);
        return t;
    }

}
