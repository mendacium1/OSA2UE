package jaas;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class CombinedTestApp {

	public static void main(final String[] args) {
		LoginContext lc = null;
		try {
			// create new login context with configuration from jaas.custom config file
			lc = new LoginContext("Combined");
		} catch (LoginException e) {
			System.err.println("Cannot create LoginContext. " + e.getMessage());
			System.exit(-1);
		}

		try {
			// try login
			lc.login();
		} catch (LoginException e) {
			// login did fail - stop program
			System.err.println("Authentication failed:");
			System.err.println("  " + e.getMessage());
			return;
		}

		// if login was successful
		Subject subject = lc.getSubject();
		System.out.println("Authenticated user name: " + subject.getPrincipals().iterator().next().getName());
	}
}
