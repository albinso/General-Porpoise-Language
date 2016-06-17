/**
 * - can we subsitute TokenType in Nodes?
 * - want to put "lastCodeToken" in the "getToken"-method
 **/

import java.util.ArrayList;

public class ParseTree {
	public ParseNode start; // public so it can be reached from outside
	private ParseNode current; // private because it's only used to create the tree
	private ArrayList<Token> tokens;

	private Token lastCodeToken;

	public ParseTree(ArrayList<Token> tokens) {
		this.tokens = tokens;

		lastCodeToken = null;

		createParseTree();
	}

	/**
	 * Create manage all the statements given by the token-list
	 **/
	private void createParseTree() {
		if (tokens.size() == 0) {
			System.exit(0); // no tokens in list
		}

		while (!tokens.isEmpty()) {
			startNewStatement();
		}
	}

	/**
	 * TODO
	 * - create Node
	 * - add Node?
	 */
	private void startNewStatement() {
		Token newCommandToken = tokens.remove(0);

		// if current commandToken should be considerd
		if (isCodeToken(newCommandToken)) {
			lastCodeToken = newCommandToken;
		}

		removeSpaces(1);

		// decides which type of command that is being started
		switch (newCommandToken.getTokenType()) {
			case CREATE:
				handleCreateStatement();
				break;
			case ADD:
				handleAddStatement();
				break;
			case REMOVE:
				handleRemoveStatement();
				break;
			case TRANSFER:
				handleTransferStatement();
				break;
			case MOVE:
				handleMoveStatement();
				break;
			case GET:
				handleGetStatement();
				break;
		}

		// optional spaces after last command before dot
		// at least one space after dot before next command
		removeSpaces(0);

		getToken(TokenType.DOT);

		removeSpaces(1);
	}

	private void handleCreateStatement() {
		// TODO
		// - REGIMENT
		// - UNIT (Gunman, Sniper, Artillery, Medic, Tank)
	}

	/**
	 * Creates an AddNode containing unit-name and regiment-name
	 * 
	 * TODO
	 * extract '[unitname]', 'TO' and '[regname]'
	 **/
	private void handleAddStatement() {
		Token unitNameToken = getToken(TokenType.TEXT);

		removeSpaces(1);

		Token toToken = getToken(TokenType.TO);

		removeSpaces(1);

		Token regimentNameToken = getToken(TokenType.TEXT);

		// get the unit from the unit-name
		// get the regiment from the regiment-name
		// create addNode
	}

	private void handleRemoveStatement() {
		// TODO
		// - remove (by name or by index)
	}

	private void handleTransferStatement() {
		// TODO
		// TRANSFER [unitName] FROM [regname1] TO [regname2]
	}

	private void handleMoveStatement() {
		// TODO
		// MOVE [regname] [y] STEPS [NORTH/SOUTH] AND [x] STEPS [EAST/WEST]
		// MOVE [regname] TO [x, y]
		// MOVE ALL REGIMENTS WHERE [condition] TO [x, y]
	}

	private void handleGetStatement() {
		// GET POSITION FOR [regname]
		// GET SIZE OF [regname]
		// GET AMOUNT OF [unitType] IN [regname]
	}

	/***
	 * Checks that the next token is of expected type and retrieves it from the list
	 * If there is no more tokens or the next token is of the wrong type it calls 
	 *  the 'printError'-method
	 ***/
	private Token getToken(TokenType expectedTokenType) {
		if (tokens.size() == 0) {
			printError(lastCodeToken);
		}

		Token token = tokens.remove(0);

		if (token.getTokenType() != expectedTokenType) {
			printError(token);
		}

		if (isCodeToken(token)) {
			lastCodeToken = token;
		}

		return token;
	}

	/**
	 * If the given token should be counted as 'code' or something else
	 **/
	public boolean isCodeToken(Token token) {
		if (token.getTokenType() == TokenType.SPACE) {
			return false;
		}

		return true;
	}

	/**
	 * Remove spaces between commands, must be at least one
	 */
	private void removeSpaces(int minimumSpaces) {
		// the amount of spaces it needs to be
		for (int i = 0 ; i < minimumSpaces ; i++) {
			getToken(TokenType.SPACE);
		}

		// removes the other spaces (optional spaces)
		while (tokens.size() != 0 && tokens.get(0).getTokenType() == TokenType.SPACE) {
			tokens.remove(0);
		}
	}

	/**
	 * If error occurs
	 */
	private void printError(Token t) {
		System.out.println("Syntaxfel på rad " + t.getRow());
		System.exit(0);
	}

	public String toString() {
		// TODO
		return "";
	} 
}