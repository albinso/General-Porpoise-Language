public class AddNode extends ParseNode {
	public Unit unit;
	public Regiment regiment;

	public AddNode(TokenType type, Unit unit, Regiment regiment) {
		super(type);
		this.unit = unit;
		this.regiment = regiment;
	}
}