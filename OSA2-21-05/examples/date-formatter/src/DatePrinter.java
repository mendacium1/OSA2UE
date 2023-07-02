import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DatePrinter {

	public static void main(String[] args) {
		localDateTime();
		calendar();
	}

	private static void localDateTime() {
		LocalDateTime now = LocalDateTime.now();

		System.out.println(now);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy HH:mm:ss");
		System.out.println(formatter.format(now));
	}

	private static void calendar() {
		Calendar now = Calendar.getInstance();

		System.out.println(now);

		DateFormat formatter = DateFormat.getDateTimeInstance();
		System.out.println(formatter.format(now.getTime()));
	}

}
