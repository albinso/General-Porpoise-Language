public abstract class ParseNode {
	public TokenType type;
	public ParseNode next;

	public ParseNode(TokenType type) {
		this.type = type;
	}

	public String toString() {
		return type.name();
	}
}