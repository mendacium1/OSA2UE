public class TelephoneNote extends Note {
	private String caller;
	private String callee;

	public TelephoneNote(final String title) {
		this(title, null, null, null);
	}

	public TelephoneNote(final String title, final String content, final String caller, final String callee) {
		super(title, content);
		this.caller = caller;
		this.callee = callee;
	}

	public String getCaller() {
		return caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
		updateModified();
	}

	public String getCallee() {
		return callee;
	}

	public void setCallee(String callee) {
		this.callee = callee;
		updateModified();
	}

	@Override
	public String toString() {
		return super.toString() + " (from " + caller + " to " + callee + ")";
	}
}
