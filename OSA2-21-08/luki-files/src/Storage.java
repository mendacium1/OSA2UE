import java.util.concurrent.locks.Lock;

/**
 * Implementation of the Storage which consists of the storages capacity and the current amount of items in stock
 *
 * @author Lukas Kaiser
 */
public class Storage {

    private int storageCapacity;
    private int currentStock;

    /**
     * @param storageCapacity
     * @param stock
     */
    public Storage(int storageCapacity, int stock) {
        this.storageCapacity = storageCapacity;
        this.currentStock = stock;
    }

    /**
     * @param amount
     */
    public synchronized void storeItems(int amount) {
        while (currentStock + amount >= this.storageCapacity) {
            System.out.println("Not enough storage space available (current stock level: " + currentStock + ", items " +
                    "to stock: " + amount + ".Waiting...");
        }
        this.storageCapacity += amount;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
}

