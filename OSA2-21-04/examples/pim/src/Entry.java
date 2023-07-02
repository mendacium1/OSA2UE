import java.util.Date;

public abstract class Entry {

	private String title;
	private String keyword;

	private final Date created;
	private Date modified;

	public Entry(final String title) {
		this.title = title;
		this.created = new Date();
		this.modified = this.created;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		updateModified();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		if (((this.keyword == null) && (keyword != null)) || !this.keyword.equals(keyword)) {
			this.keyword = keyword;
			updateModified();
		}
	}

	public Date getCreatedAt() {
		return created;
	}

	public Date getLastModifiedAt() {
		return modified;
	}

	protected void updateModified() {
		modified = new Date();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + title;
	}

}
