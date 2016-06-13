public class RemoveAtIndexNode extends ParseNode {
	public Unit unit;
	public Regiment regiment;
	public int index;

	public RemoveAtIndexNode(TokenType type, Unit unit, Regiment regiment, int index) {
		super(type);
		this.unit = unit;
		this.regiment = regiment;
		this.index = index;
	}
}