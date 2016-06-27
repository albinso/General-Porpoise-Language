import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Lexer {
	/*
	 * Performs lexical analysis on the source code, interpreting it as a list of tokens.
	 * The tokens and corresponding patterns are determined by the TokenType enum.
	 * No syntax check is performed and any non-matching segments are simply ignored.
	 * Inspired by http://giocc.com/writing-a-lexer-in-java-1-7-using-regex-named-capturing-groups.html
	 * @param	source	The source code to be lexized
	 * @return			A list of Token objects
	 */
	public static ArrayList<Token> lex(String source) {
		StringBuffer patterns = new StringBuffer();
		for(TokenType type : TokenType.values()) {
			// (?<%s>%s) first %s is group name while second is the pattern to match
			// Parenthesises marks a group while | separates groups
			patterns.append(String.format("(?<%s>%s)|", type.name(), type.getPattern()));
		}
		Pattern pattern = Pattern.compile(patterns.substring(0, patterns.length()-1)); //Removes final | and makes a pattern
		Matcher matcher = pattern.matcher(source);
		ArrayList<Token> tokens = new ArrayList<Token>();

		// Go through the entire thing and put in whatever token matches the point at which we read.
		// If no other match is found the final Token checked is the wildcard (".") giving an invalid token.
		int row = 1;
		while(matcher.find()) {
			for(TokenType t : TokenType.values()) {
				// Check against all pattern groups
				String match = matcher.group(t.name());
				
				if(match != null) {
					// If there is a match
					
					tokens.add(new Token(match, t, row));
					if(t == TokenType.SPACE) {
						row += countLines(match);
					}
					break;
				}
			}
		}
		return tokens;
	}

	public static String readFile(String path) {
		String content = "nonulollol";
		try {
			content = new Scanner(new File(path)).useDelimiter("\\Z").next();
		} catch(IOException e) {
			System.exit(-1);
		}
		content = content.toLowerCase();
		return content;
	}

	private static int countLines(String str) {
		if(str == null || str.isEmpty()) {
			return 0;
		}
		int lines = 0;
		int pos = 0;
		while ((pos = str.indexOf("\n", pos) + 1) != 0) {
			lines++;
		}
		return lines;
	}

	public static void main(String[] args) {
		String source = readFile(args[0]).toUpperCase();
		ArrayList<Token> lexed = Lexer.lex(source);

		for(Token t : lexed) {
			System.out.println(t);
		}
	}
}