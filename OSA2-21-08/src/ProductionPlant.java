/**
 * The ProductionPlant class represents a production plant that manages the production process
 * and delivery of goods.
 *
 * @author Jakob Mayr, Lukas Kaiser
 */
import java.util.ArrayList;
import java.util.List;

public class ProductionPlant {
    private Storage storage;
    private ArrayList<ProductionLine> productionLines;
    private ArrayList<DeliveryTruck> deliveryTrucks;

    /**
     * Constructs a ProductionPlant object with the specified storage, production lines,
     * and delivery trucks.
     *
     * @param storage         the storage instance for storing goods
     * @param productionLines the list of production lines in the plant
     * @param deliveryTrucks  the list of delivery trucks for transporting goods
     */
    public ProductionPlant(Storage storage, ArrayList<ProductionLine> productionLines,
                           ArrayList<DeliveryTruck> deliveryTrucks) {
        this.storage = storage;
        this.productionLines = productionLines;
        this.deliveryTrucks = deliveryTrucks;
    }

    /**
     * Starts the production process in the production plant by running the production lines
     * and delivery trucks concurrently.
     *
     * @throws InterruptedException if any thread is interrupted during execution
     */
    public void startProduction() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        // Start production lines
        for (ProductionLine p : productionLines) {
            // ::run sets the Thread to only use the run() method, not the whole object
            Thread thread = new Thread(p::run);
            threads.add(thread);
            thread.start();
        }

        // Start delivery trucks
        for (DeliveryTruck d : deliveryTrucks) {
            Thread thread = new Thread(d::run);
            threads.add(thread);
            thread.start();
        }
    }
}
