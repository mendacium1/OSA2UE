package singleton;

public final class LazySingleton {

	private static LazySingleton INSTANCE;

	public static synchronized LazySingleton get() {
		if (INSTANCE == null) {
			INSTANCE = new LazySingleton();
		}
		return INSTANCE;
	}

	private LazySingleton() {
		// noop
	}
}
