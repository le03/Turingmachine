import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class TuringMachine {
	//private Control control;
	private Tape tape;
	
	public TuringMachine(BufferedReader in) throws IOException{
		//control = new Control();
		String readData = in.readLine();
		System.out.println("Anzahl Zustaende: " + readData);
		readData = in.readLine();
		System.out.println("Eingabealphabet: " + readData);
		readData = in.readLine();
		System.out.println("Bandalphabet: " + readData);
		readData = in.readLine();
		System.out.println("Anfangszustand: " + readData);
		readData = in.readLine();
		System.out.println("Endzustand: " + readData);
		System.out.println("Zustandsübergangsfunktion: ");
		System.out.println("");
		while(readData != null){
			System.out.println(readData);
		}
		
	}
	
	public void simulate(String input){
		
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
