import java.util.Date;

public class Meeting extends Appointment {
	private String participants;

	public Meeting(final String title) {
		this(title, null, null, null, null);
	}

	public Meeting(final String title, final Date start, final Date end, final String place, final String participants) {
		super(title, start, end, place);
		this.participants = participants;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
		updateModified();
	}

	@Override
	public String toString() {
		return super.toString() + "; Participants: " + participants;
	}
}
