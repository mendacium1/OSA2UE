public class ClockTime {

	private static final int SECONDS_A_DAY = 60 * 60 * 24;

	private int totalSeconds;

	public ClockTime(int hours, int minutes, int seconds) {
		this(hours * 60 * 60 + minutes * 60 + seconds);
	}

	public ClockTime(int hours, int minutes) {
		this(hours, minutes, 0);
	}

	public ClockTime(ClockTime time) {
		this(time.totalSeconds);
	}

	private ClockTime(int totalseconds) {
		setTotalSeconds(totalseconds);
	}

	private void setTotalSeconds(int seconds) {
		this.totalSeconds = seconds;
		normalize();
	}

	private void normalize() {
		totalSeconds %= SECONDS_A_DAY;
		if (totalSeconds < 0) {
			totalSeconds += SECONDS_A_DAY;
		}
	}

	public int getHours() {
		return this.totalSeconds / 60 / 60;
	}

	public int getMinutes() {
		return this.totalSeconds / 60 % 60;
	}

	public int getSeconds() {
		return this.totalSeconds % 60;
	}

	@Override
	public int hashCode() {
		return totalSeconds;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ClockTime)) {
			return false;
		}
		ClockTime other = (ClockTime) obj;
		if (totalSeconds != other.totalSeconds) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getHours() + ":" + getMinutes() + ":" + getSeconds();
	}
}
