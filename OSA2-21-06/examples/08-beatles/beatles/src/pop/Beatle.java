package pop;

public enum Beatle {

	JOHN("John", "Lennon") {
		@Override
		void play() {
			System.out.println("Vocals, guitar, keyboards, harmonica");
		}

		@Override
		void sayHelloTo(String name) {
			System.out.println(getFullname() + " says hello to " + name);
		}
	},
	PAUL("Paul", "McCartney") {
		@Override
		void play() {
			System.out.println("Vocals, bass guitar, guitar, keyboards");
		}

		@Override
		void sayHelloTo(String name) {
			System.out.println(getFullname() + " says hello to " + name);
		}
	},
	RINGO("Ringo", "Starr") {
		@Override
		void play() {
			System.out.println("Drums, Percussion vocals");
		}

		@Override
		void sayHelloTo(String name) {
			System.out.println(getLastname() + " says hello to " + name);
		}
	},
	GEORGE("George", "Harrison") {
		@Override
		void play() {
			System.out.println("Vocals, guitar, sitar");
		}

		@Override
		void sayHelloTo(String name) {
			System.out.println(getFirstname() + " says hi to " + name);
		}
	};

	private final String firstname;
	private final String lastname;

	private Beatle(final String firstname, final String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFullname() {
		return firstname + " " + lastname;
	}

	abstract void play();

	abstract void sayHelloTo(final String name);

}
