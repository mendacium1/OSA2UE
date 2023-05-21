public class ProductionLine extends Thread {

    private static int productionLineId = 0;
    private int uid = ++productionLineId;
    private final int productionCapacity;
    private final int productionTime;
    private final int maintenanceTime;
    private Storage storage;

    public ProductionLine(int productionCapacity, int productionTime, int maintenanceTime, Storage storage) {
        this.productionCapacity = productionCapacity;
        this.productionTime = productionTime;
        this.maintenanceTime = maintenanceTime;
        this.storage = storage;
        System.out.println(uid);
    }


    @Override
    public void run() {
        while (true) {
            // produce
            System.out.println("[" + uid + "] Producing " + productionCapacity + " items in " + productionTime +
                    " seconds.");
            try {
                Thread.sleep(productionTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // store
            while (storage.storeStock(productionCapacity) == false) {
                System.out.println("[" + uid + "] Not enought stock available (current stock level: " +
                        storage.getStock() + ", items to deliver: " + productionCapacity + "). Wating...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            System.out.println("[" + uid + "] Storing " + productionCapacity + " items. New stock level " +
                    storage.getStock());

            // maintenance
            System.out.println("[" + uid + "] Doing maintenance for " + maintenanceTime + " seconds.");
            try {
                Thread.sleep(maintenanceTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
