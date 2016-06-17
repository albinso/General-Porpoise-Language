public class CreateUnitNode extends ParseNode {
	public int unitType;
	public String unitVariableName;

	public CreateUnitNode(TokenType type, int unitType, String unitVariableName) {
		super(type);
		this.unitType = unitType;
		this.unitVariableName = unitVariableName;
	}
}