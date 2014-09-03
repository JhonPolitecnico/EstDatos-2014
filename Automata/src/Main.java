/**
 * Test input
 * 
 * <pre>
 * <code>
import java.io.FileInputStream;
import java.io.FileNotFoundException;
 * </code>
 * </pre>
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classroom Project Delivery 1
 * 
 * Professor Rafael Niquefa
 * 
 * @author Jhon Jairo Eslava 1310012946
 * 
 */
public class Main {

	public static void main(String[] args) {

		/**
		 * Test input
		 * 
		 * <pre>
		 * <code>
		 * 		try {
		 * 			System.setIn(new FileInputStream("input.txt"));
		 * 		} catch (FileNotFoundException e) {
		 * 			e.printStackTrace();
		 * 		}
		 * </code>
		 * </pre>
		 */

		Scanner sN = new Scanner(System.in);
		sN.useDelimiter(System.lineSeparator());

		Input input = new Input();

		while (sN.hasNext())
			input.addLine(sN.next());

		sN.close();

		// unserialize automaton
		Automaton automaton = input.unserialize();

		if (args.length == 1 && args[0].equalsIgnoreCase("1"))
			// simple
			automaton.setMode(Mode.SIMPLE);
		else
			// step to step
			automaton.setMode(Mode.STEPTOSTEP);

		// query all from automaton
		System.out.print(automaton.queryAll());

	}
}

/**
 * Processes and converts the input format into an Automaton
 * 
 */
class Input {

	/**
	 * collection lines
	 */
	private ArrayList<String> lines = new ArrayList<String>();

	/**
	 * Add one line
	 * 
	 * @param line
	 *            content of line
	 */
	public void addLine(String line) {
		this.lines.add(line);
	}

	/**
	 * Obtain a specific element of a specific line
	 * 
	 * @param line
	 *            number of line
	 * @param element
	 *            number of element
	 * @return String the selected element
	 */
	private String getElementFromLine(int line, int element) {
		return this.lines.get(line).split(" ")[element];
	}

	/**
	 * Unserialize an automaton from plain text
	 * 
	 * @return Automaton
	 */
	public Automaton unserialize() {
		// new automaton
		Automaton automaton = new Automaton();
		// Z
		automaton.setCardinalityZ(Integer.parseInt(this.getElementFromLine(0, 0)));
		// N
		automaton.setStatesN(Integer.parseInt(this.getElementFromLine(0, 1)));

		// symbols of alphabet
		String[] symbols = new String[automaton.getCardinalityZ()];

		for (int i = 0; i < automaton.getCardinalityZ(); i++)
			symbols[i] = this.getElementFromLine(1, i);

		automaton.setSymbols(symbols);

		// transitions
		int[][] transitions = new int[automaton.getStatesN()][automaton.getCardinalityZ()];

		for (int i = 0; i < automaton.getStatesN(); i++)
			for (int j = 0; j < automaton.getCardinalityZ(); j++)
				transitions[i][j] = Integer.parseInt(this.getElementFromLine(2 + i, j));

		automaton.setTransitions(transitions);

		// final states
		int[] finalStates = new int[Integer.parseInt(this.getElementFromLine(2 + automaton.getStatesN(), 0))];

		for (int i = 0; i < finalStates.length; i++)
			finalStates[i] = Integer.parseInt(this.getElementFromLine(3 + automaton.getStatesN(), i));

		automaton.setFinalStates(finalStates);

		// queries
		String[] queries = new String[Integer.parseInt(this.getElementFromLine(4 + automaton.getStatesN(), 0))];

		for (int i = 0; i < queries.length; i++)
			queries[i] = this.lines.get(5 + automaton.getStatesN() + i);

		automaton.setQueries(queries);

		return automaton;
	}
}

/**
 * Display mode from automaton
 * 
 */
enum Mode {
	/**
	 * Simple mode
	 */
	SIMPLE,
	/**
	 * Step to step mode
	 */
	STEPTOSTEP
}

/**
 * Deterministic finite automaton generic programmable
 * 
 */
class Automaton {

	private int cardinalityZ, statesN, currentState = 0;
	private String[] symbols, queries;
	private int[][] transitions;
	private int[] finalStates;
	private Mode mode = Mode.SIMPLE;

	public int getCardinalityZ() {
		return cardinalityZ;
	}

	public int getStatesN() {
		return statesN;
	}

	public int getCurrentState() {
		return currentState;
	}

	public String[] getSymbols() {
		return symbols;
	}

	public String[] getQueries() {
		return queries;
	}

	public int[][] getTransitions() {
		return transitions;
	}

	public int[] getFinalStates() {
		return finalStates;
	}

	public Mode getMode() {
		return mode;
	}

	public void setCardinalityZ(int cardinalityZ) {
		this.cardinalityZ = cardinalityZ;
	}

	public void setStatesN(int statesN) {
		this.statesN = statesN;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	public void setSymbols(String[] symbols) {
		this.symbols = symbols;
	}

	public void setQueries(String[] queries) {
		this.queries = queries;
	}

	public void setTransitions(int[][] transitions) {
		this.transitions = transitions;
	}

	public void setFinalStates(int[] finalStates) {
		this.finalStates = finalStates;
	}

	/**
	 * Set display mode
	 * 
	 * @param mode
	 *            display mode
	 */
	public void setMode(Mode mode) {
		this.mode = mode;
	}

	/**
	 * Execute all queries
	 * 
	 * @return String result of queries
	 */
	public String queryAll() {
		String output = "";

		for (int i = 0; i < this.queries.length; i++)
			output += this.query(i) + "\n";

		return output.trim();
	}

	/**
	 * Execute a query
	 * 
	 * @param query
	 *            number of query
	 * @return String result of query
	 */
	public String query(int query) {
		String output = "", current = this.queries[query];
		int state;

		// Reset automaton
		this.currentState = 0;

		output += (this.mode == Mode.STEPTOSTEP) ? "Prosesando consulta " + query + " ...\n" : "";

		if (!this.checkSymbols(current))
			return (this.mode == Mode.STEPTOSTEP) ? output + "La palabra NO fue aceptada, contiene simbolos ilegibles." : "NO";

		String symbol;

		for (int i = 0; i < current.length(); i++) {
			symbol = current.substring(i, i + 1);

			// save current state
			state = this.currentState;
			// change to new state
			this.currentState = this.transitions[this.currentState][this.findSymbol(symbol)];

			output += (this.mode == Mode.STEPTOSTEP) ? "Del estado " + state + " procesando el simbolo " + symbol + " paso al estado " + this.currentState + ".\n" : "";
		}

		boolean success = false;

		for (int i = 0; i < this.finalStates.length; i++)
			if (this.currentState == this.finalStates[i]) {
				success = true;
				break;
			}

		if (success)
			output += (this.mode == Mode.STEPTOSTEP) ? "La palabra SI fue aceptada, el estado " + this.currentState + " es estado de aceptación.\n" : "SI\n";
		else
			output += (this.mode == Mode.STEPTOSTEP) ? "La palabra NO fue aceptada, el estado " + this.currentState + " no es estado de aceptación.\n" : "NO\n";

		return output.trim();
	}

	/**
	 * Find the position of a symbol in the alphabet
	 * 
	 * @param symbol
	 *            a string of size one
	 * @return Integer position of symbol or -1 if he finds nothing
	 */
	private int findSymbol(String symbol) {

		if (!this.checkSymbols(symbol))
			return -1;

		for (int i = 0; i < this.symbols.length; i++)
			if (symbol.substring(0, 1).equals(this.symbols[i]))
				return i;

		return -1;
	}

	/**
	 * Check if {@code query} is in the alphabet
	 * 
	 * @param query
	 *            any string
	 * @return boolean true if exists in alphabet or false if not
	 */
	private boolean checkSymbols(String query) {
		boolean flag;

		for (int i = 0; i < query.length(); i++) {

			flag = false;

			for (int j = 0; j < this.symbols.length; j++)
				if (query.substring(i, i + 1).equals(this.symbols[j])) {
					flag = true;
					break;
				}

			if (!flag)
				return false;

		}

		return true;
	}

}
