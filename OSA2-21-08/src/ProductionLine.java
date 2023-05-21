/**
 * The ProductionLine class represents a production line in a production plant.
 * It implements the Runnable interface to enable concurrent execution.
 * <br>
 * Disclaimer: As not specifically asked, the identification of the production lines is visualised by numbers.
 *
 * @author Jakob Mayr, Lukas Kaiser
 */
public class ProductionLine implements Runnable {

    private static int productionLineId = 0;
    private final int uid = ++productionLineId;
    private final int productionCapacity;
    private final int productionTime;
    private final int maintenanceTime;
    private final Storage storage;

    /**
     * Constructs a ProductionLine object with the specified production capacity, production time,
     * maintenance time, and storage.
     *
     * @param productionCapacity the maximum production capacity of the production line
     * @param productionTime the time taken to produce items
     * @param maintenanceTime the time taken for maintenance tasks
     * @param storage the storage instance for storing produced items
     */
    public ProductionLine(int productionCapacity, int productionTime, int maintenanceTime, Storage storage) {
        this.productionCapacity = productionCapacity;
        this.productionTime = productionTime;
        this.maintenanceTime = maintenanceTime;
        this.storage = storage;
    }

    /**
     * Stores items produced by the production line into the storage.
     *
     * @return true if the items are successfully stored, false otherwise
     */
    private synchronized boolean storeItems() {
        return this.storage.storeStock(this.productionCapacity, this.uid);
    }

    @Override
    public void run() {
        System.out.println("[PRODUCTION LINE " + uid + "] Started.");

        while (!Thread.interrupted()) {
            // Simulate production of items
            System.out.println("[PRODUCTION LINE " + uid + "] Producing " + productionCapacity + " items in " +
                    productionTime + " seconds.");
            try {
                Thread.sleep(productionTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Simulate storing of items
            while (!storeItems()) {            //If there is not enough storage available, let thread wait
                synchronized (storage) {
                    try {
                        this.storage.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            // Simulate the maintenance of a production line with letting the thread sleep for the amount of time
            System.out.println("[PRODUCTION LINE " + uid + "] Doing maintenance for " + maintenanceTime +
                    " seconds.");
            try {
                Thread.sleep(maintenanceTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
