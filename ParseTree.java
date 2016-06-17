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

	private void startNewStatement() {

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
	 * Remove spaces between commands
	 */
	private void removeSpace() {
		while (tokens.size() != 0 && tokens.get(0).getTokenType() == TokenType.SPACE) {
			tokens.remove(0);
		}
	}

	/**
	 * If error occurs
	 */
	public void printError(Token t) {
		System.out.println("Syntaxfel på rad " + t.getRow());
		System.exit(0);
	}
}