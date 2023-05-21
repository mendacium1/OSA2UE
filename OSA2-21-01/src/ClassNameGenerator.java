import java.util.Random;

/**
 * Create random &quot;enterprise&quot; Java class names.
 * <p>
 * This class is a port of &quot;Enterprise&quot; - a class name generator
 * written in JavaScript. It generates a classname with a max count of words.
 *
 * @author Claudia Maderthaner
 * @see <a href=
 * "https://gist.github.com/hay/1351230">https://gist.github.com/hay/1351230</a>
 */
public class ClassNameGenerator {

    /**
     * The default number of words used in the generated class name.
     * <p>
     * This value is used, if there is no number or an invalid number is given.
     */
    public static final int DEFAULT_NUMBER_OF_WORDS = 3;
    
	/**
	 * The minimum number of words used in the generated class name.
	 * <p>
	 * This value is used, if there is no number or an invalid number is given.
	 */
    public static final int MINIMUM_NUMBER_OF_WORDS = 2;

	/**
	 * All possible base names the generated class can be.
	 * <p>
	 * The class-name will be randomly taken out of this string-array.
	 */
    private static final String[] BASE_NAMES = {"Factory", "Bean", "Wrapper", "Visitor", "Model", "Singleton", "Method",
			"Configuration", "Exception", "Error", "Property", "Value", "Identifier", "Attribute", "Authentication",
			"Policy", "Container", "Order", "Info", "Parameter", "Request", "Adapter", "Bridge", "Decorator", "Facade",
			"Proxy", "Worker", "Interpreter", "Iterator", "Observer", "State", "Strategy", "Template", "Comparator",
			"Clone", "Task", "Resolver", "Candidate", "Expression", "Predicate", "Thread", "Pool", "Descriptor",
			"Interceptor", "Definition", "Getter", "Setter", "Listener", "Processor", "Printer", "Prototype",
			"Composer", "Event", "Helper", "Utils", "Invocation", "Exporter", "Importer", "Serializer", "Callback",
			"Tag", "Context", "Mapping", "Advisor", "Filter", "Field", "Test", "Tests", "Connection", "Annotation",
			"Service", "Repository", "Stub", "Mock", "Instance", "Dispatcher", "Client", "Server", "Message", "Map",
			"List", "Collection", "Queue", "Manager", "Database", "Response", "Broadcaster", "Watcher", "Schema",
			"Mapper", "Publisher", "Consumer", "Producer", "Controller"};

	/**
	 * All possible decorators the generated class can have.
	 * <p>
	 * The class-name will be randomly taken out of this string-array.
	 */
    private static final String DECORATORS[] = {"Composite", "Invalid", "Supported", "Focus", "Traversal", "Abstract",
			"Transformer", "Common", "Concrete", "Autowire", "Simple", "Aware", "Aspect", "Principal", "Driven",
			"Interruption", "Batch", "Prepared", "Statement", "Remote", "Stateless", "Session", "Transaction",
			"Transactional", "Based", "Meta", "Data", "Jms", "Readable", "Literal", "Reflective", "Scope", "Multipart",
			"Xml", "Generic", "Interface", "Advisable", "Observable", "Identifiable", "Iterable", "Distributed",
			"Notification", "Failure", "Type", "Http", "Jdbc", "User", "Custom", "Geo", "Management", "Domain"};

    private final int maxWords;

    /**
     * Constructor for optional maxWords count.
     * @param maxWords
     */
    public ClassNameGenerator(final int maxWords) {
        this.maxWords = maxWords;
    }

    /**
     * Default Constructor.
	 * <p>
	 * This generator gets called if no value has been given in class-call.
     */
    public ClassNameGenerator() {
        this(3);
    }

	/**
	 * This function randomly picks a name and a decorator for the class.
	 * <p>
	 * This .
	 */
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();
        Random randomIndex = new Random();

        for (int i = 0; i < getValidMaxWords() - 1; i++) {
            String word = DECORATORS[randomIndex.nextInt(DECORATORS.length)];
            if (stringBuilder.indexOf(word) < 0) stringBuilder.append(word);
        }
		stringBuilder.append(BASE_NAMES[randomIndex.nextInt(BASE_NAMES.length)]);

        return stringBuilder.toString();
    }

    private int getValidMaxWords() {
        int calculatedNumberOfWords = new Random().nextInt(maxWords) + 1;
        return calculatedNumberOfWords > MINIMUM_NUMBER_OF_WORDS ? calculatedNumberOfWords : MINIMUM_NUMBER_OF_WORDS;
    }

    /**
     * Generate a random class name.
     * <p>
     * The generated class name is printed to the console.
     * @param args maximum number of words (optional)
     */
    public static void main(String[] args) {
        ClassNameGenerator Generator;
        Generator = new ClassNameGenerator(getMaxWords(args));

        String className = Generator.generate();
        System.out.println(className);
    }

    /**
     * Determine the maximum number of words.
     * <p>
     * Determines if there are arguments in the program call.
     * If so, sets the maximum words count to the argument-value or the minimum words count. Else the default value will be taken.
     * @param args maximum number of words
     */
    private static int getMaxWords(String[] args) {
        int maxWords = DEFAULT_NUMBER_OF_WORDS;
        if (args.length > 0) {
            try {
                int input = Integer.parseInt(args[0]);
                if
                (input > MINIMUM_NUMBER_OF_WORDS) {
					maxWords = input;
                } else {
                    System.err.print("Input param is not valid.");
                }
            } catch (NumberFormatException e) {
                System.err.print("Input param is not valid.");
            }
        }
        return maxWords;
    }
}
