/**
 * This class represents a specific time of the day.
 * <p>
 * The time is represented in 24 h mode.
 * <p>
 * All <code>ClockTime</code> objects are immutable.
 *
 * @author Claudia
 * @version 1.0
 */
public class ClockTime {

	/**
	 * Total number of seconds in a day.
	 */
	private static final int SECONDS_A_DAY = 60 * 60 * 24;

	/**
	 * The total number of seconds representing the time.
	 */
	private int totalSeconds;

	/**
	 * Create a new <code>ClockTime<code> object with the given hours, minutes and seconds.
	 * <p>
	 * If the hours, minutes and seconds exceed in sum the number of seconds a day the exceeding amount will be ignored.
	 *
	 * @param hours
	 * @param minutes
	 * @param seconds
	 */
	public ClockTime(int hours, int minutes, int seconds) {
		this(hours * 60 * 60 + minutes * 60 + seconds);
	}

	/**
	 * Create a new <code>ClockTime<code> object with the given hours and minutes.
	 * <p>
	 * If the hours and minutes exceed in sum the number of seconds a day the exceeding amount will be ignored.
	 *
	 * @param hours
	 * @param minutes
	 */
	public ClockTime(int hours, int minutes) {
		this(hours, minutes, 0);
	}

	/**
	 * Create a new <code>ClockTime</code> object with the time represented by the given over <code>ClockTime</code>
	 * object.
	 *
	 * @param time
	 *            another <code>ClockTime</code> object; <code>time</code> must not be null, otherwise it will lead to
	 *            runtime exceptions
	 */
	public ClockTime(ClockTime time) {
		this(time.totalSeconds);
	}

	private ClockTime(int totalseconds) {
		setTotalSeconds(totalseconds);
	}

	/**
	 * Normalize the total number of seconds, so the do not exceed the number of seconds in one day.
	 * <p>
	 * Seconds exceeding the number of seconds a day will be ignored.
	 * <p>
	 * A negative amount of seconds will be treated like a time in the past.
	 */
	private void normalize() {
		totalSeconds %= SECONDS_A_DAY;
		if (totalSeconds < 0) {
			totalSeconds += SECONDS_A_DAY;
		}
	}

	/**
	 * Add the time represented by the given <code>ClockTime</code> object to this object.
	 * <p>
	 * The result will be normalized.
	 *
	 * @param time
	 *            the time to be added
	 * @return the resulting time
	 */
	public ClockTime add(ClockTime time) {
		return new ClockTime(this.totalSeconds + time.totalSeconds);
	}

	/**
	 * Add the given seconds to this object.
	 * <p>
	 * The result will be normalized.
	 *
	 * @param seconds
	 *            the seconds to be added
	 * @return the resulting time
	 */
	public ClockTime add(int seconds) {
		return new ClockTime(this.totalSeconds + seconds);
	}

	/**
	 * Subtract the time represented by the given <code>ClockTime</code> object from this object.
	 * <p>
	 * The result will be normalized.
	 *
	 * @param time
	 *            the time to be subtracted
	 * @return the resulting time
	 */
	public ClockTime subtract(ClockTime time) {
		return new ClockTime(this.totalSeconds - time.totalSeconds);
	}

	/**
	 * Subtract the given seconds from this object.
	 * <p>
	 * The result will be normalized.
	 *
	 * @param seconds
	 *            the seconds to be subtracted
	 * @return the resulting time
	 */
	public ClockTime subtract(int seconds) {
		return new ClockTime(this.totalSeconds - seconds);
	}

	/**
	 * @return the number of hours of the represented time
	 */
	public int getHours() {
		return this.totalSeconds / 60 / 60;
	}

	/**
	 * @return the number of minutes of the represented time
	 */
	public int getMinutes() {
		return this.totalSeconds / 60 % 60;
	}

	/**
	 * @return the number of seconds of the represented time
	 */
	public int getSeconds() {
		return this.totalSeconds % 60;
	}

	/**
	 * Set the total number of seconds for this object.
	 * <p>
	 * The number seconds will be normalized {@see #normalize()}.
	 *
	 * @param seconds
	 */
	private void setTotalSeconds(int seconds) {
		this.totalSeconds = seconds;
		normalize();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getHours() + ":" + getMinutes() + ":" + getSeconds();
	}
}
