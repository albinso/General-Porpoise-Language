import java.util.ArrayList;

public class ParseTree {
	public ParseNode start; // public so it can be reached from outside
	private ParseNode current; // private because it's only used to create the tree
	private ArrayList<Token> tokens;

	public ParseTree(ArrayList<Token> tokens) {
		this.tokens = tokens;

		createParseTree();
	}

	private void createParseTree() {
		if (tokens.size() == 0) {
			System.exit(0); // no tokens in list
		}

		while (!tokens.isEmpty()) {
			startNewStatement();
		}
	}

	/**
	 *	// TODO
	 *	// - create Node
	 *	// - add Node?s
	 */
	private void startNewStatement() {
		Token newCommandToken = tokens.remove(0);

		removeSpaces(newCommandToken);

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
				handleMoveStatement()
				break;
			case GET:
				handleGetStatement();
				break;
		}
	}

	private void handleCreateStatement() {
		// TODO
		// - REGIMENT
		// - UNIT (Gunman, Sniper, Artillery, Medic, Tank)
	}

	private void handleAddStatement() {
		// TODO
		// - add [unitname] TO [regname]
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
	private Token getToken(TokenType expectedTokenType, Token lastCodeToken) {
		if (tokens.size() == 0) {
			printError(lastCodeToken);
		}

		Token token = tokens.remove(0);

		if (token.getTokenType() != expectedTokenType) {
			printError(token);
		}

		return token;
	}

	/**
	 * Remove spaces between commands, must be at least one
	 */
	private void removeSpaces(Token lastCodeToken) {
		getToken(TokenType.SPACE, lastCodeToken); // it needs to be at least one space

		// removes the other spaces
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
	} 
}