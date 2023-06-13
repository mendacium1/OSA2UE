package jaas.custom;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import jaas.custom.module.CustomCallbackHandler;

public class CustomTestApp {

	public static void main(final String[] args) {

		LoginContext lc = null;
		try {
			lc = new LoginContext("Custom", new CustomCallbackHandler());
		} catch (LoginException e) {
			System.out.println("Cannot create LoginContext. " + e.getMessage());
			System.exit(-1);
		}

		int i;
		for (i = 0; i < 3; i++) {
			try {
				lc.login();
				break;
			} catch (LoginException e) {
				System.out.println("Authentication failed:");
				System.out.println("  " + e.getMessage());
			}
		}

		if (i == 3) {
			System.out.println("Sorry, authentication failed!");
			System.exit(-1);
		}

		System.out.println("Authentication succeeded!");

		Subject subject = lc.getSubject();
		System.out.println(subject);
		// Subject.doAsPrivileged(subject, action, acc);

		try {
			lc.logout();
		} catch (LoginException e) {
			System.out.println("Logout failed.");
		}
	}

}
