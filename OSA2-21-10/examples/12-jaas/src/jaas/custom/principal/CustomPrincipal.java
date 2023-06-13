package jaas.custom.principal;

import java.io.Serializable;
import java.security.Principal;

public class CustomPrincipal implements Principal, Serializable {

	private static final long serialVersionUID = 4332131797621676055L;

	private final String name;

	public CustomPrincipal(final String name) {
		if (name == null) {
			throw new NullPointerException("illegal null input");
		}
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "CustomPrincipal: " + this.name;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CustomPrincipal)) {
			return false;
		}
		CustomPrincipal that = (CustomPrincipal) obj;
		if (this.getName().equals(that.getName())) {
			return true;
		}
		return false;
	}

}
