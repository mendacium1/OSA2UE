/**
 * The Storage class represents a storage facility for storing goods in a production plant.
 * It extends the Thread class to enable concurrent access to the storage.
 *
 * @author Jakob Mayr, Lukas Kaiser
 */
public class Storage extends Thread {

    private int storageCapacity;
    private int currentStock;

    /**
     * Constructs a Storage object with the specified storage capacity and current stock level.
     * @param storageCapacity the maximum capacity of the storage
     * @param currentStock the current stock level in the storage
     */
    public Storage(int storageCapacity, int currentStock) {
        this.storageCapacity = storageCapacity;
        this.currentStock = currentStock;
    }

    /**
     * Returns the current stock level in the storage.
     * @return the current stock level
     */
    public int getCurrentStock() {
        return currentStock;
    }

    /**
     * Returns the amount of free stock available in the storage.
     * @return the amount of free stock
     */
    public int getFreeStock() {
        return storageCapacity - currentStock;
    }

    /**
     * Stores the specified amount of stock into the storage.
     * @param amount the amount of stock to store
     * @param uid the unique identifier of the production line requesting storage
     * @return true if the stock is successfully stored, false if there is not enough free storage capacity
     */
    public synchronized boolean storeStock(int amount, int uid) {
        if (currentStock + amount <= storageCapacity) {
            currentStock += amount;
            System.out.println("[PRODUCTION LINE " + uid + "] Storing " + amount + " items. " +
                    "New stock level: " + this.getCurrentStock() + ".");
            notifyAll();
            return true;
        }
        System.out.println("[PRODUCTION LINE " + uid + "] Not enough free storage (current stock level: " +
                this.getCurrentStock() + ", items to store: " + amount + "). Waiting...");
        return false;
    }

    /**
     * Collects the specified amount of stock from the storage.
     * @param amount the amount of stock to collect
     * @param uid the unique identifier of the delivery truck requesting collection
     * @return true if the stock is successfully collected, false if there is not enough stock available
     */
    public synchronized boolean collectStock(int amount, int uid) {
        if (amount <= currentStock) {
            System.out.println("[DELIVERY TRUCK " + uid + "] Picking up " + amount +
                    " items. New stock level: " + this.getCurrentStock() + ".");
            currentStock -= amount;
            notifyAll();
            return true;
        }

        System.out.println("[DELIVERY TRUCK " + uid + "] Not enough stock available (current stock level: " +
                this.getCurrentStock() + ", items to deliver: " + amount + "). Waiting...");

        return false;
    }
}