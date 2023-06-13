package providers;

import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.List;
import java.util.Set;

public class Algorithms {

	public static void main(String[] args) {
		List.of("Cipher", "MessageDigest", "Signature", "Mac", "SecureRandom", "SecretKeyFactory", "KeyPairGenerator",
				"KeyStore").forEach(Algorithms::list);
	}

	private static void list(final String type) {
		System.out.println(type + "\n");
		List.of(Security.getProviders()).stream().map(Provider::getServices).flatMap(Set<Service>::stream)
				.filter(service -> type.equals(service.getType())).map(Service::getAlgorithm).distinct().sorted()
				.forEach(System.out::println);
		System.out.println("\n\n");
	}
}
