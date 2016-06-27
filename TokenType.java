public enum TokenType {
	CREATE("CREATE"), ADD("ADD"), REMOVE("REMOVE"), TRANSFER("TRANSFER"), MOVE("MOVE"), GET("GET"),
	TO("TO"), NUMBER("\\d+"), DOT("\\."), EXCL("!"), QUEST("\\?"), SPACE("(%.*\\n?|\\s)+"), TEXT("\\w+");

	private String pattern;

	private TokenType(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

}