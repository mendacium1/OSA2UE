/**
 * The Main class represents the entry point of the program.
 * It initializes and executes the production process in a production plant.
 *
 * @author Jakob Mayr, Lukas Kaiser
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Create a storage instance
        Storage storageOne = new Storage(1000, 0);

        // Create the production lines
        ProductionLine productionLineOne =
                new ProductionLine(200, 100, 110, storageOne);
        ProductionLine productionLineTwo =
                new ProductionLine(200, 200, 220, storageOne);
        ProductionLine productionLineThree =
                new ProductionLine(100, 300, 330, storageOne);

        // Create delivery trucks
        DeliveryTruck deliveryTruckOne =
                new DeliveryTruck(100, 50, storageOne);
        DeliveryTruck deliveryTruckTwo =
                new DeliveryTruck(200, 70, storageOne);
        DeliveryTruck deliveryTruckThree =
                new DeliveryTruck(300, 90, storageOne);

        // Create the production plant using the previously created production lines and delivery trucks
        // This variable initialization can not be done beforehand as the required parameters (production lines and
        // delivery trucks have had to be initialized)
        ProductionPlant productionPlant1 = new ProductionPlant(storageOne,
                new ArrayList<>(Arrays.asList(productionLineOne, productionLineTwo, productionLineThree)),
                new ArrayList<>(Arrays.asList(deliveryTruckOne, deliveryTruckTwo, deliveryTruckThree)));

        // Start the production process
        productionPlant1.startProduction();
    }
}