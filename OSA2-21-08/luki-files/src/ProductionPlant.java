import java.util.List;

/**
 * Implementation of the production plant that consists of a storage, a list of production lines and a list of
 * delivery trucks.
 *
 * @author Lukas Kaiser
 */
public class ProductionPlant {

    private Storage storage;
    private List<Thread> productionLines;
    private List<Thread> deliveryTrucks;

    /**
     *
     * @param storage
     * @param productionLines
     * @param deliveryTrucks
     */
    public ProductionPlant(Storage storage, List<Thread> productionLines, List<Thread> deliveryTrucks) {
        this.storage = storage;
        this.productionLines = productionLines;
        this.deliveryTrucks = deliveryTrucks;
    }

    /**
     *
     */
    public void startSimulation() {
        for (Thread productionLine : this.productionLines) {
            productionLine.start();
        }

        for (Thread deliveryTruck : this.deliveryTrucks) {
            deliveryTruck.start();
        }
    }
}
