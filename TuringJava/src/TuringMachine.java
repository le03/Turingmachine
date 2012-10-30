import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class TuringMachine {
	private Control control;
	private Tape tape;
	
	/* Hier initialsieren wir unsere Turingmaschine */
	public TuringMachine(BufferedReader in) throws IOException{
		control = new Control();
		String readData = in.readLine().trim();
		System.out.println("Anzahl Zustaende: " + readData);
		// Anzahl der Zustände zwischenspeichern
		int states = Integer.parseInt(readData);
		for(int i = 0; i < states; i++){
			String numberState = String.valueOf(i);
			control.addState(numberState, "N"); // N steht einfach für Normalenzustand, der kein Endzustand ist
		}
		readData = in.readLine();
		System.out.println("Eingabealphabet: " + readData);
		readData = in.readLine();
		System.out.println("Bandalphabet: " + readData);
		readData = in.readLine().trim();
		// Setze diesen Zustand als den Anfangszustand
		control.setState(control.findState(readData));
		System.out.println("Anfangszustand: " + readData);
		readData = in.readLine().trim();
		System.out.println("Endzustand: " + readData);
		// Speichern den angegebenen Endzustand
		control.addState(readData, "H");
		System.out.println("Zustandsübergangsfunktion: ");
		System.out.println("");
		while(readData != null){
			readData = in.readLine().trim();
			if(readData.length() != 4){
				throw new RuntimeException("Invalid Transition");
			}
			String[] fields = readData.split("\\readData");
			control.addTransition(fields[0], fields[1],  fields[2], fields[3], fields[4]);
		}
		System.out.println("Blanksymbol B");		
	}
	
	/* Starte die Turingmaschine auf Eingabe input */
	public void simulate(String input){
		tape = new Tape(input);	// Schreibe das Eingabewort auf das Band
		State state = control.getState(); // Hole den Anfangszustand heraus
		
		/* Solange wir wir nicht den Endzustand erreichen, führen wir die Turingmaschine aus */
		while(!state.isHalt()){
			String read = tape.read(); // Lesen Symbol
			Transition transition = control.getTransition(read); // Suchen uns die entsprechende Transition
			if(transition != null){
				state = transition.getTo(); // Holen uns den nächsten Zustand
				control.setState(state);	// und setzten den Aktuellenzustand neu
				tape.write(transition.getWrite()); // Schreiben das nächste Symbol auf das Band
			}
			// Müssen noch den Schreib-/Lesekopf entsprechen der Transition nach links oder rechts, oder gar nicht verschieben
			if(transition.isLeft()){
				tape.left();
			}
			else if(transition.isRight()){
				tape.right();
			}
		}
	}
	
	public static void main(String [] args) throws IOException{
		try {
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			TuringMachine tm = new TuringMachine(in);
			tm.simulate(args[1]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("File not found");
		}
	}
	
		
	
}
