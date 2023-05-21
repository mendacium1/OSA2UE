package test;

import comment.Comment;

@Comment(text = "This is my first commented class", author = "Claudia")
public class CommentedClass {

	@Comment(text = "This is a field")
	private String value;

	public String getValue() {
		return value;
	}

}
