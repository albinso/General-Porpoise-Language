public class Token {
	private final TokenType type;
	private final String data;
	private final int row;

	public Token(String s, TokenType t, int row) {
		this.type = t;
		this.data = s;
		this.row = row;
	}

	public TokenType getTokenType() {
		return type;
	}

	public String getData() {
		return data;
	}

	public int getRow() {
		return row;
	}

	public String toString() {
		return "Type: " + type.name() + ", Data: " + data + ", Row: " + row;
	}
}