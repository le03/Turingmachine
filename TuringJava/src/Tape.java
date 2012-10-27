import java.util.Stack;

/*
 * Represents a tape of a turing-machine
 */
public class Tape {
	private State state = new State(0);
	private String current; // Schreib-/Lesekopf
	private Stack<String> leftPart = new Stack<String>(); // Linke Teil unseres Bandes vom Schreib-/Lesekopf ausgesehen
	private Stack<String> rightPart = new Stack<String>(); // rechter Teil unseres Bandes vom Schreib-/Lesekopf ausgesehen
	private final static String BLANK ="B";
	
	/*
	 * In den folgenden 2 Konstruktoren wird eine Turingmaschine erzeugt
	 * und zurückgegeben
	 */
	public Tape(){
		this(BLANK);
	}
	
	public Tape(String init){
		if(init == null || init.equals(""))
			init = BLANK;
		/* Schreiben unser Eingabewort auf das Band */
		for(int i = init.length() -1; i>= 0; i--){
			current = init.substring(i, i+1);
			rightPart.push(current);
		}
		current = rightPart.pop();
	}
	
	/* Bewege Schreib-/Lesekopf nach Rechts */
	public void right(){
		leftPart.push(current);
		/* Evtl. muss unsere rechte Seite noch erweitert werden */
		if(rightPart.isEmpty()){
			rightPart.push(BLANK);
		}
		current = rightPart.pop();
	}
	
	/* Bewege Schreib-/Lesekopf nach Links */
	public void left(){
		rightPart.push(current);
		/* Evtl. muss unsere linke Seite noch erweitert werden */
		if(leftPart.isEmpty()){
			leftPart.push(BLANK);
		}
		current = leftPart.pop();
	}
	
	/* Den aktuelle Zelleninhalt auslesen */
	public String read(){
		return current;
	}
	
	/* Den aktuellen Bandinhalt überschreiben */
	public void write(String symbol){
		current = symbol;
	}
	
	/* Um den linken Teil vernuenftig auszugeben, muessen wir das ganze umdrehen, da wir das Ganze als Stack erzeugt haben*/
	public static String reverse(String s){
		int N = s.length();
        if (N <= 1){ 
        	return s;
        }
        String left = s.substring(0, N/2);
        String right = s.substring(N/2, N);
        
        return reverse(right) + reverse(left);
	}
	/* Ausgabe unseres Bandes */
	public String toString(){
		return BLANK + BLANK + reverse(leftPart.toString()) + state + rightPart + BLANK + BLANK;
	}
		
}
