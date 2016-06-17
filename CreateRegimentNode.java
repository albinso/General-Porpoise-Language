public class CreateRegimentNode extends ParseNode {
	public int x, y;
	public String regimentVariableName;

	public CreateRegimentNode(TokenType type, int x, int y, String regimentVariableName) {
		super(type);
		this.x = x;
		this.y = y;
	}
}