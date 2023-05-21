/**
 * Implementation of the production line which has a production capacity, a production time and a maintenance time
 *
 * @author Lukas Kaiser
 */
public class ProductionLine implements Runnable {

    private String productionLineName;
    private int productionCapacity;
    private int productionTime;
    private int maintenanceTime;
    private Storage storage;

    /**
     * Constructor for the Production Line class.
     *
     * @param productionLineName the name of the production line
     * @param productionCapacity the amount of items this production line can create
     * @param productionTime the time it needs for the items to be created
     * @param maintenanceTime the time needed to maintain the production line
     * @param storage the storage this production line can use
     */
    public ProductionLine(String productionLineName, int productionCapacity, int productionTime, int maintenanceTime,
                          Storage storage) {
        this.productionLineName = productionLineName;
        this.productionCapacity = productionCapacity;
        this.productionTime = productionTime;
        this.maintenanceTime = maintenanceTime;
        this.storage = storage;
    }

    /**
     * Function to simulate the production of items. Lets the function sleep for the amount of time an item needs to
     * be created
     *
     * @throws InterruptedException if the Thread gets suspended whilst sleeping
     */
    private void produceItems() {
        System.out.println("[" +this.productionLineName + "] Producing " + this.productionCapacity + " items in " +
                this.productionTime + " seconds.");
        // Sleep for the amount of time needed to create the products
        try {
            Thread.sleep(this.productionTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Simulates the storing of items by storing the amount of created items into the storage
     */
    public void storeItems() {
        this.storage.storeItems(this.productionCapacity);
        synchronized (storage){
            this.storage.notifyAll();           // tell everyone that there are new items
        }
    }

    /**
     * Simulates the time each production line needs maintainance by letting the Thread sleep for the specified
     * amount of time
     *
     * @throws InterruptedException if the Thread gets suspended whilst sleeping
     */
    private void maintainProductionLine() {
        System.out.println("[PRODUCTION LINE " + this.productionLineName + "] Doing maintenance for " +
                this.maintenanceTime + " seconds.");

        try {
            Thread.sleep(this.maintenanceTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The implemented run method from the Runnable class.
     * Inside is a forever ongoing while loop that simulates the creation and storage of items and the time a
     * production line has to be maintained for
     */
    @Override
    public void run() {
        while (true) {
            produceItems();
            storeItems();
            maintainProductionLine();
        }
    }
}
