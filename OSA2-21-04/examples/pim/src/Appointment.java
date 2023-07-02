import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment extends Entry {
	private Date start;
	private Date end;
	private String place;

	public Appointment(final String title) {
		this(title, null, null, null);
	}

	public Appointment(final String title, final Date start, final Date end, final String place) {
		super(title);
		this.start = start;
		this.end = end;
		this.place = place;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
		updateModified();
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
		updateModified();
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
		updateModified();
	}

	@Override
	public String toString() {
		DateFormat formatter = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT);
		return super.toString() + " from " + formatter.format(start) + " to " + formatter.format(end) + " at " + place;
	}
}
