import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classroom Project Delivery 2
 * 
 * Professor Rafael Niquefa
 * 
 * @author Jhon Jairo Eslava 1310012946
 * 
 */
public class Main {

	public static void main(String[] args) {

		try {
			System.setIn(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Scanner sN = new Scanner(System.in);
		sN.useDelimiter(System.lineSeparator());

		Input input = new Input();

		while (sN.hasNext())
			input.addLine(sN.next());

		sN.close();

		// unserialize automaton
		Automaton automaton = input.unserialize();

		// generate AFD from AFN-E
		System.out.print(automaton.generateAFD());

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
		// Q
		automaton.setStatesQ(Integer.parseInt(this.getElementFromLine(0, 0)));
		// N
		automaton.setEdgesN(Integer.parseInt(this.getElementFromLine(0, 1)));
		// Z
		automaton.setCardinalityZ(Integer.parseInt(this.getElementFromLine(0, 2)));

		// empty symbol
		automaton.setEmptySymbol(this.getElementFromLine(1, 0));

		// final states
		int[] finalStates = new int[Integer.parseInt(this.getElementFromLine(0, 3))];

		for (int i = 0; i < finalStates.length; i++)
			finalStates[i] = Integer.parseInt(this.getElementFromLine(2, i));

		automaton.setFinalStates(finalStates);

		// symbols of alphabet
		String[] symbols = new String[automaton.getCardinalityZ()];

		for (int i = 0; i < automaton.getCardinalityZ(); i++)
			symbols[i] = this.getElementFromLine(3, i);

		automaton.setSymbols(symbols);

		// transitions
		Transition[] transitions = new Transition[automaton.getEdgesN()];

		for (int i = 0; i < automaton.getEdgesN(); i++)
			transitions[i] = new Transition(Integer.parseInt(this.getElementFromLine(4 + i, 0)), Integer.parseInt(this.getElementFromLine(4 + i, 2)), automaton.findSymbol(this.getElementFromLine(
					4 + i, 1)));

		automaton.setTransitions(transitions);

		return automaton;
	}
}

class Transition {

	private int initialState, symbol, targetState;

	public Transition(int initialState, int targetState, int symbol) {
		super();
		this.initialState = initialState;
		this.targetState = targetState;
		this.symbol = symbol;
	}

	public int getInitialState() {
		return initialState;
	}

	public int getTargetState() {
		return targetState;
	}

	public int getSymbol() {
		return symbol;
	}

}

class SetOfStates {

	private ArrayList<Integer> states;

	public ArrayList<Integer> getStates() {
		return states;
	}

	public void addState(int state) {
		this.states.add(state);
	}
}

/**
 * Nondeterministic finite automaton with E-moves generic programmable
 * 
 */
class Automaton {

	private int statesQ, edgesN, cardinalityZ, currentState = 0;
	private Transition[] transitions;
	private String emptySymbol;
	private String[] symbols;
	private int[] finalStates;

	public int getStatesQ() {
		return statesQ;
	}

	public int getEdgesN() {
		return edgesN;
	}

	public int getCardinalityZ() {
		return cardinalityZ;
	}

	public int getCurrentState() {
		return currentState;
	}

	public Transition[] getTransitions() {
		return transitions;
	}

	public String getEmptySymbol() {
		return emptySymbol;
	}

	public String[] getSymbols() {
		return symbols;
	}

	public int[] getFinalStates() {
		return finalStates;
	}

	public void setStatesQ(int statesQ) {
		this.statesQ = statesQ;
	}

	public void setEdgesN(int edgesN) {
		this.edgesN = edgesN;
	}

	public void setCardinalityZ(int cardinalityZ) {
		this.cardinalityZ = cardinalityZ;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	public void setTransitions(Transition[] transitions) {
		this.transitions = transitions;
	}

	public void setEmptySymbol(String emptySymbol) {
		this.emptySymbol = emptySymbol;
	}

	public void setSymbols(String[] symbols) {
		this.symbols = symbols;
	}

	public void setFinalStates(int[] finalStates) {
		this.finalStates = finalStates;
	}

	public String generateAFD() {

		ArrayList<SetOfStates> setOfSets = new ArrayList<SetOfStates>();

		// Initial state
		SetOfStates set = new SetOfStates();
		set.addState(0);
		setOfSets.add(set);

		// temporal sets
		SetOfStates[] tmpSets = new SetOfStates[this.symbols.length];

		while (true) {

			// Actual state
			for (int state : set.getStates()) {

				// clear temporal sets
				for (int i = 0; i < tmpSets.length; i++)
					tmpSets[i] = new SetOfStates();

				// symbol
				for (int symbol = 0; symbol < this.symbols.length; symbol++) {

					// transition
					for (Transition transition : this.transitions) {

						// (symbol)E*
						if (transition.getInitialState() == state && transition.getSymbol() == symbol) {
							tmpSets[symbol].addState(transition.getTargetState());
						}
					}
				}

			}

		}

		return "okei";
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
	public int findSymbol(String symbol) {

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
