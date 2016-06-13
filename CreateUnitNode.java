public class CreateUnitNode extends ParseNode {
	public int unitType;

	public CreateUnitNode(TokenType type, int unitType) {
		super(type);
		this.unitType = unitType;
	}
}