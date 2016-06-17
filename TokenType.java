public enum TokenType {
	CREATE("CREATE"), ADD("ADD"), REMOVE("REMOVE"), TRANSFER("TRANSFER"), MOVE("MOVE"), GET("GET"),
	TO("TO"), DOT("\\."),
	TEXT(""), SPACE("(%.*\\n?|\\s)+"), INVALID(".");

	private String pattern;

	private TokenType(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

}