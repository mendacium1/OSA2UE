package providers;

import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProvidersAndServices {

	public static void main(String[] args) {

		for (Provider provider : Security.getProviders()) {
			System.out.printf("Provider %s in Version %s\n", provider.getName(), provider.getVersionStr());

			List<Provider.Service> services = new ArrayList<>(provider.getServices());
			Collections.sort(services, Comparator.comparing(Provider.Service::getType));
			for (Provider.Service service : services) {
				System.out.println("\t" + service.getType() + ": " + service.getAlgorithm());
			}
		}

	}

}
