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
	private SetOfStates[] symbolTarget;

	public SetOfStates(int cardinalityOfAlphabet) {
		super();
		this.states = new ArrayList<Integer>();
		this.symbolTarget = new SetOfStates[cardinalityOfAlphabet];
	}

	public ArrayList<Integer> getStates() {
		return states;
	}

	public void addState(int state) {
		this.states.add(state);
	}

	public boolean checkState(int state) {
		return this.states.contains(state);
	}

	public void setDestinationSet(SetOfStates set, int symbol) {
		this.symbolTarget[symbol] = set;
	}

	public SetOfStates getDestinationSet(int symbol) {
		return this.symbolTarget[symbol];
	}

	public boolean isEmpty() {
		return (this.states.size() == 0);
	}

	/**
	 * Check if a set is equal
	 */
	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof SetOfStates))
			return super.equals(obj);

		SetOfStates set = (SetOfStates) obj;

		if (set.getStates().size() != this.states.size())
			return false;

		for (int state : states) {
			if (!set.checkState(state))
				return false;
		}

		return true;
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
		SetOfStates set = new SetOfStates(this.cardinalityZ);
		set.addState(0);
		setOfSets.add(set);

		// temporal sets
		SetOfStates[] tmpSets = new SetOfStates[this.symbols.length];

		while (set != null) {

			// clear temporal sets
			for (int i = 0; i < tmpSets.length; i++)
				tmpSets[i] = new SetOfStates(this.cardinalityZ);

			// actual state
			for (int state : set.getStates()) {

				// actual symbol
				for (int symbol = 0; symbol < this.symbols.length; symbol++) {

					// transition
					for (Transition transition : this.transitions) {

						// (symbol)
						if (transition.getInitialState() == state && transition.getSymbol() == symbol) {

							// add state of set
							if (!tmpSets[symbol].checkState(transition.getTargetState()))
								tmpSets[symbol].addState(transition.getTargetState());

							// (symbol)E*
							this.getEmptyStates(transition.getTargetState(), tmpSets[symbol]);

							boolean isEqual = false;

							// check in set of sets
							for (SetOfStates tmpSet : setOfSets) {
								if (tmpSet.equals(tmpSets[symbol])) {
									isEqual = true;
									break;
								}
							}

							// add new set of list of sets
							if (!isEqual) {
								setOfSets.add(tmpSets[symbol]);
							}

						}
					}
				}

			}

			// create new edges
			for (int i = 0; i < tmpSets.length; i++)
				if (!tmpSets[i].isEmpty())
					set.setDestinationSet(tmpSets[i], i);

			// next set
			int index = setOfSets.indexOf(set) + 1;

			set = (index >= setOfSets.size()) ? null : setOfSets.get(index);

		}

		StringBuilder output = new StringBuilder();

		
		// check if exits error state
		int errorState = -1;

		for (SetOfStates state : setOfSets) {

			for (int symbol = 0; symbol < this.symbols.length; symbol++) {
				SetOfStates destSet = state.getDestinationSet(symbol);

				if (destSet == null) {
					errorState = this.statesQ + 1;
					break;
				}
			}

		}

		output.append((errorState != -1) ? errorState : this.statesQ); // N
		output.append(" ");
		output.append(this.cardinalityZ); // Z
		output.append("\n");

		// alphabet
		for (String symbol : this.symbols) {
			output.append(symbol);
			output.append(" ");
		}

		output.setLength(output.length() - 1);
		output.append("\n");

		// matriz

		for (SetOfStates state : setOfSets) {

			for (int symbol = 0; symbol < this.symbols.length; symbol++) {
				SetOfStates destSet = state.getDestinationSet(symbol);

				if (destSet != null)
					output.append(setOfSets.indexOf(destSet));
				else
					output.append(errorState);

				output.append(" ");

			}

			output.setLength(output.length() - 1);
			output.append("\n");

		}

		// error state
		if (errorState != -1) {
			for (int symbol = 0; symbol < this.symbols.length; symbol++) {
				output.append(errorState);
				output.append(" ");
			}
			output.setLength(output.length() - 1);
			output.append("\n");
		}

		// final states
		ArrayList<Integer> finalStates = new ArrayList<Integer>();

		for (SetOfStates finalSet : setOfSets) {

			for (int finalState : this.finalStates)
				if (finalSet.checkState(finalState)) {
					finalStates.add(setOfSets.indexOf(finalSet));
					break;
				}

		}

		output.append(finalStates.size());
		output.append("\n");

		for (int integer : finalStates) {
			output.append(integer);
			output.append(" ");
		}

		output.setLength(output.length() - 1);
		output.append("\n");
		output.append(0); // Queries

		return output.toString();
	}

	/**
	 * E* edges
	 * 
	 * @param initialState
	 * @param set
	 */
	private void getEmptyStates(int initialState, SetOfStates set) {
		// transition
		for (Transition transition : this.transitions) {

			// empty transition
			if (transition.getInitialState() == initialState && transition.getSymbol() == -1) {

				// new state
				if (set.checkState(transition.getTargetState()) == false) {

					// add new state
					set.addState(transition.getTargetState());

					// next empty state
					this.getEmptyStates(transition.getTargetState(), set);
				}
			}

		}
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
