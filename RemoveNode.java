public class RemoveNode extends ParseNode {
	public Unit unit;
	public Regiment regiment;

	public RemoveNode(TokenType type, Unit unit, Regiment regiment) {
		super(type);
		this.unit = unit;
		this.regiment = regiment;
	}
}