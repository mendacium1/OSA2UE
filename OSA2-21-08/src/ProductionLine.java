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
    }

    private void printLog(char c) {
        switch (c) {
            case 'p':
                System.out.println("[PRODUCTION LINE " + uid + "] Producing " + productionCapacity + " items in " +
                        productionTime + " seconds.");
                break;
            case 'f':
                System.out.println("[PRODUCTION LINE " + uid + "] Not enough free stock (current stock level: " +
                        storage.getStock() + ", items to store: " + productionCapacity + "). Waiting...");
                break;
            case 's':
                System.out.println("[PRODUCTION LINE " + uid + "] Storing " + productionCapacity + " items." +
                        " New sock level " + storage.getStock() + ".");
                break;
            case 'm':
                System.out.println("[PRODUCTION LINE " + uid + "] Doing maintenance for " + maintenanceTime +
                        " seconds.");
                break;
            default:
                System.out.println("invalid log request");
        }
    }

    @Override
    public void run() {
        System.out.println("[PRODUCTION LINE " + uid + "] Started.");
        while (true) {
            // produce
            printLog('p');
            try {
                Thread.sleep(productionTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //store
            if (storage.storeStock(productionCapacity) == false) {
                printLog('f');
                while (storage.storeStock(productionCapacity) == false) {
                    assert true;
                }
            }
            printLog('s');

            // maintenance
            printLog('m');
            try {
                Thread.sleep(maintenanceTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
