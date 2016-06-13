public class CreateRegimentNode extends ParseNode {
	public int x, y;

	public CreateRegimentNode(TokenType type, int x, int y) {
		super(type);
		this.x = x;
		this.y = y;
	}
}