import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {

        int storageCapacity = 1000;

        //Storage all upcoming production lines and delivery trucks use
        Storage publicStorage = new Storage(storageCapacity, 0);

        List<Thread> productionLines = new ArrayList<>();
        List<Thread> deliveryTrucks = new ArrayList<>();

        productionLines.add(new Thread(new ProductionLine("PRODUCTION LINE ONE", 100, 50, 1000, publicStorage)));
        productionLines.add(new Thread(new ProductionLine("PRODUCTION LINE TWO", 200, 40, 900, publicStorage)));
        productionLines.add(new Thread(new ProductionLine("PRODUCTION LINE THREE", 300, 30, 800, publicStorage)));
        productionLines.add(new Thread(new ProductionLine("PRODUCTION LINE FOUR", 400, 20, 700, publicStorage)));
        productionLines.add(new Thread(new ProductionLine("PRODUCTION LINE FIVE", 500, 10, 400, publicStorage)));

        deliveryTrucks.add(new Thread(new DeliveryTruck("delivery truck one", 110, 110, publicStorage)));
        deliveryTrucks.add(new Thread(new DeliveryTruck("delivery truck two", 220, 220, publicStorage)));
        deliveryTrucks.add(new Thread(new DeliveryTruck("delivery truck three", 330, 330, publicStorage)));
        deliveryTrucks.add(new Thread(new DeliveryTruck("delivery truck four", 440, 440, publicStorage)));

        ProductionPlant productionPlant = new ProductionPlant(publicStorage, productionLines, deliveryTrucks);

        productionPlant.startSimulation();

    }
}