import java.util.HashMap;

public class Control {

	private HashMap<String, State> states; // Liste von allen Zuständen. Können dadurch leichter erkennen, ob es sich um einen endzustand handelt oder sonstigen Zustand(evtl auch schneller?)
	private HashMap<String, Transition> transitions; // Liste von allen Übergangsfunktionen, vergleichbar mit Zustandsübergangstabelle
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
	protected State findState(String name){
		return states.get(name);
	}
	
	/* Einen Zustand in unsere Menge hinzufügen */
	public void addState(String name, String type){
		State s = new State(name, type);
		states.put(name, state);
		if(state == null)
			state = s;
	}
	
	/* Eine Zustandsübergansfunktion hinzufügen */
	public void addTransition(String f, String t, String read, String write, String direction) {
	    State from = findState(f);
	    State to = findState(t);
	    Transition transition = new Transition(from, read, to, write, direction);
	    /* 
	     * Kontrolliere, ob ein Eintrag in der Hastabelle bereits existiert
	     */
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
