package jaas.custom.module;

import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * Simple console input callback handler.
 * 
 * @author Claudia
 * @version 1.0
 */
public class CustomCallbackHandler implements CallbackHandler {

	@Override
	public void handle(final Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		for (Callback cb : callbacks) {
			if (cb instanceof TextOutputCallback) {
				TextOutputCallback toc = (TextOutputCallback) cb;
				switch (toc.getMessageType()) {
					case TextOutputCallback.INFORMATION:
						System.out.println(toc.getMessage());
						break;
					case TextOutputCallback.ERROR:
						System.err.println("ERROR: " + toc.getMessage());
						break;
					case TextOutputCallback.WARNING:
						System.err.println("WARNING: " + toc.getMessage());
						break;
					default:
						throw new IOException("Unsupported message type: " + toc.getMessageType());
				}
			} else if (cb instanceof NameCallback) {
				NameCallback nc = (NameCallback) cb;

				System.out.print(nc.getPrompt());
				if (input.hasNextLine()) {
					nc.setName(input.nextLine());
				}
			} else if (cb instanceof PasswordCallback) {
				PasswordCallback pc = (PasswordCallback) cb;
				System.out.print(pc.getPrompt());
				if (input.hasNextLine()) {
					pc.setPassword(input.nextLine().toCharArray());
				}
			}
		}

	}
}
