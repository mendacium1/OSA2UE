public class Note extends Entry {
	private String content;

	public Note(final String title) {
		this(title, null);
	}

	public Note(final String title, final String content) {
		super(title);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return super.toString() + ": " + content;
	}
}
