public class Task extends Entry {
	private String description;
	private String category;

	public Task(final String title) {
		this(title, null, null);
	}

	public Task(final String title, final String description, final String category) {
		super(title);
		this.description = description;
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		updateModified();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
		updateModified();
	}

	@Override
	public String toString() {
		return super.toString() + ": " + description + " (" + category + ")";
	}
}
