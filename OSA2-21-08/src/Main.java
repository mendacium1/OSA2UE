import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Storage storage1 = new Storage(1000);

        ProductionLine productionLine1 =
                new ProductionLine(200, 200, 200, storage1);
        ProductionLine productionLine2 =
                new ProductionLine(200, 200, 200, storage1);
        ProductionLine productionLine3 =
                new ProductionLine(100, 200, 200, storage1);

        DeliveryTruck deliveryTruck1 =
                new DeliveryTruck(100, 50, storage1);
        DeliveryTruck deliveryTruck2 =
                new DeliveryTruck(100, 50, storage1);
        DeliveryTruck deliveryTruck3 =
                new DeliveryTruck(100, 50, storage1);

        ProductionPlant productionPlant1 = new ProductionPlant(storage1,
                new ArrayList<ProductionLine>(Arrays.asList(productionLine1, productionLine2, productionLine3)),
                new ArrayList<DeliveryTruck>(Arrays.asList(deliveryTruck1, deliveryTruck2, deliveryTruck3)));

        productionPlant1.startProduction();
    }
}