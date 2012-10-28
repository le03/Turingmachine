import java.util.Enumeration;
import java.util.Vector;

/*
 * Objekt, welches alle Transitionen einer Turingmaschine abspeichert
 * Objekt ist vergleichbar mit Funktionsübergangstabelle
 */
public class TransitionList {
	private Vector<Transition> allTransitions;
	
	public TransitionList(){
		this.allTransitions = new Vector<Transition>();
	}
	
	/* Suche nach einer bestimmten Transition und gib sie zurück */
	public Transition getTransition(String from, String read){
		Transition transition;
		Enumeration<Transition> e = allTransitions.elements();
		while (e.hasMoreElements()) {
		    transition = (Transition) e.nextElement(); 
		    if ((transition.getFrom().equals(from)) && (transition.getRead().equals(read))) {
			return transition;
		    }
		}
		return null;
	}
	
	public void addTransition(Transition transition){
		allTransitions.add(transition);
	}
	public boolean removeTransition(Transition transition){
		return allTransitions.add(transition);
	}
}
