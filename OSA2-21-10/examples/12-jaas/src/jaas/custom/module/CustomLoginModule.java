package jaas.custom.module;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import jaas.custom.principal.CustomPrincipal;

/**
 * Simple login module.
 * <p>
 * See http://docs.oracle.com/javase/8/docs/technotes/guides/security/jaas.custom/
 * JAASRefGuide.html for more detailed information.
 *
 * @author Claudia
 * @version 1.0
 */
public class CustomLoginModule implements LoginModule {
	private static Logger LOG = Logger.getLogger(CustomLoginModule.class.getSimpleName());

	private Subject subject;
	private CallbackHandler callbackHandler;
	@SuppressWarnings("unused")
	private Map<String, ?> sharedState;
	@SuppressWarnings("unused")
	private Map<String, ?> options;

	private boolean debug = false;

	private boolean succeeded = false;
	private boolean commitSucceeded = false;

	private String username;
	private char[] password;

	private CustomPrincipal userPrincipal;

	/*
	 * (non-Javadoc)
	 * @see javax.security.auth.spi.LoginModule#initialize(javax.security.auth.
	 * Subject , javax.security.auth.callback.CallbackHandler, java.util.Map,
	 * java.util.Map)
	 */
	@Override
	public void initialize(final Subject subject, final CallbackHandler callbackHandler,
			final Map<String, ?> sharedState, final Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;

		debug = Boolean.valueOf((String) options.get("debug"));
	}

	/*
	 * (non-Javadoc)
	 * @see javax.security.auth.spi.LoginModule#login()
	 */
	@Override
	public boolean login() throws LoginException {
		if (this.callbackHandler == null) {
			throw new LoginException("Error: no CallbackHandel available " + "to garner authentication from user");
		}

		// prepare callbacks to collect necessary information
		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("user name: ");
		callbacks[1] = new PasswordCallback("password: ", true);

		try {
			// call callbackhandler
			this.callbackHandler.handle(callbacks);
			this.username = ((NameCallback) callbacks[0]).getName();
			char[] tmpPassword = ((PasswordCallback) callbacks[1]).getPassword();
			if (tmpPassword == null) {
				tmpPassword = new char[0];
			}
			this.password = new char[tmpPassword.length];
			System.arraycopy(tmpPassword, 0, this.password, 0, tmpPassword.length);
			((PasswordCallback) callbacks[1]).clearPassword();
		} catch (IOException e) {
			throw new LoginException(e.toString());
		} catch (UnsupportedCallbackException e) {
			throw new LoginException("Error: " + e.getCallback().toString() + "not available to garner authentication "
					+ "information from user");
		}

		if (this.debug) {
			LOG.log(Level.FINE, "\t\t[CustomLoginModule] " + "user entered user name: " + this.username);
			LOG.log(Level.FINE,
					"\t\t[CustomLoginModule] " + "user entered password: " + Arrays.toString(this.password));
		}

		// do authentication
		boolean usernameCorrect = false;
		boolean passwordCorrect = false;
		if (this.username.equals("testUser")) {
			usernameCorrect = true;
		}
		if (usernameCorrect && (this.password.length == 12) && (this.password[0] == 't') && (this.password[1] == 'e')
				&& (this.password[2] == 's') && (this.password[3] == 't') && (this.password[4] == 'P')
				&& (this.password[5] == 'a') && (this.password[6] == 's') && (this.password[7] == 's')
				&& (this.password[8] == 'w') && (this.password[9] == 'o') && (this.password[10] == 'r')
				&& (this.password[11] == 'd')) {
			passwordCorrect = true;
			if (this.debug) {
				LOG.log(Level.FINE, "\t\t[CustomLoginModule] " + "authentication succeeded");
			}
		}
		if (usernameCorrect && passwordCorrect) {
			// authentication was successful
			this.succeeded = true;
			return true;
		} else {
			// authentication failed
			if (this.debug) {
				LOG.log(Level.FINE, "\t\t[CustomLoginModule] " + "authentication failed");
			}
			this.succeeded = false;
			wipeInput();
			if (!usernameCorrect) {
				throw new FailedLoginException("User Name Incorrect");
			} else {
				throw new FailedLoginException("Password Incorrect");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see javax.security.auth.spi.LoginModule#commit()
	 */
	@Override
	public boolean commit() throws LoginException {
		if (this.succeeded == false) {
			return false;
		} else {
			// create and set principals
			this.userPrincipal = new CustomPrincipal("admin");
			if (!this.subject.getPrincipals().contains(this.userPrincipal)) {
				this.subject.getPrincipals().add(this.userPrincipal);
			}

			if (this.debug) {
				LOG.log(Level.FINE, "\t\t[CustomLoginModule] " + "added SamplePrincipal to Subject");
			}

			wipeInput();

			this.commitSucceeded = true;
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see javax.security.auth.spi.LoginModule#abort()
	 */
	@Override
	public boolean abort() throws LoginException {
		if (this.succeeded == false) {
			return false;
		} else if ((this.succeeded == true) && (this.commitSucceeded == false)) {
			this.succeeded = false;

			this.userPrincipal = null;
			wipeInput();

		} else {
			this.logout();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.security.auth.spi.LoginModule#logout()
	 */
	@Override
	public boolean logout() throws LoginException {
		this.subject.getPrincipals().remove(this.userPrincipal);

		this.userPrincipal = null;
		wipeInput();

		this.succeeded = false;
		this.commitSucceeded = false;

		return true;
	}

	private void wipeInput() {
		this.username = null;
		if (this.password != null) {
			for (int i = 0; i < this.password.length; i++) {
				this.password[i] = ' ';
			}
			this.password = null;
		}
	}

}
