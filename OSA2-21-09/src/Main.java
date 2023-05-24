public class Main {
    public static void main(String[] args) {

        Circuit firstExampleCircuit =
            new Parallel(new Resistor(600),
                new Parallel(
                    new Serial(new Resistor(400), new Resistor(500)),
                        new Serial(
                            new Parallel(new Resistor(100), new Resistor(300)),
                                new Resistor(200)
                        )
                )
            );
        System.out.println(firstExampleCircuit.getOhm());

        Circuit secondExampleCircuit =
            new Serial(
                new Parallel(new Resistor(100), new Resistor(200)),
                new Parallel(new Resistor(300), new Resistor(400))
            );
        System.out.println(secondExampleCircuit.getOhm());

        Circuit thirdExampleCircuit =
            new Parallel(
                new Serial(new Resistor(100), new Resistor(200)),
                new Serial(new Resistor(300), new Resistor(400))
            );
        System.out.println(thirdExampleCircuit.getOhm());
    }
}