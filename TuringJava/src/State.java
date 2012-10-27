/*
 * Represents a state of a turingmachine
 */
public class State {
	private int state;
	
	public State(int state){
		this.state = state;
	}
	
	public int getState(){
		return state;
	}
	
	public String toString(){
		return "[" + state + "]";
	}
}
