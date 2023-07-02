public class Memo extends Note {
	private String recipients;

	public Memo(final String title) {
		this(title, null, null);
	}

	public Memo(final String title, final String content) {
		this(title, null, null);
	}

	public Memo(final String title, final String content, final String recipients) {
		super(title, content);
		this.recipients = recipients;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
		updateModified();
	}

	@Override
	public String toString() {
		return super.toString() + "; Recipients: " + recipients;
	}
}
