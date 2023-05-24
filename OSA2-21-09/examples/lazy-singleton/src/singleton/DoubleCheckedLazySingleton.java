package singleton;

public final class DoubleCheckedLazySingleton {

	private static DoubleCheckedLazySingleton INSTANCE;

	public static DoubleCheckedLazySingleton get() {
		if (INSTANCE == null) {
			synchronized (DoubleCheckedLazySingleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckedLazySingleton();
				}
			}
		}
		return INSTANCE;
	}

	private DoubleCheckedLazySingleton() {
		// noop
	}
}
