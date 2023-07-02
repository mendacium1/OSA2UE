package jackson;

import beans.Account;
import beans.Address;
import beans.Employee;
import beans.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class JsonMapper {

	private static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new JavaTimeModule()).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	public static void main(String[] args) throws IOException {
		JsonMapper mapper = new JsonMapper();

		Person person = new Person("Jane", "Doe", LocalDate.of(2000, 12, 12));
		person.setNickname("sue");
		Account account = new Account(new BigDecimal("20000"));
		Employee employee = new Employee("John");
		Address address = new Address();
		address.setStreet("Sesamstraße");
		address.setCity("Sesamstadt");

		System.out.println(mapper.toJson(person));
		System.out.println(mapper.toJson(account));
		System.out.println(mapper.toJson(employee));
		System.out.println(mapper.toJson(address));

		Object fromJson = mapper.fromJson();

	}

	public String toJson(final Object object) throws JsonProcessingException {
		return MAPPER.writeValueAsString(object);
	}

	public Object fromJson() throws IOException {
		return MAPPER.readerFor(Person.class).createParser(
						"{\"firstname\":\"Jane\",\"lastname\":\"Doe\",\"nickname\":\"sue\",\"dateOfBirth\":[2000,12,12],\"age\":21}")
				.readValueAs(Person.class);
	}
}
