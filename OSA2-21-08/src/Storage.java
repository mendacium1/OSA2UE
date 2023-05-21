public class Storage extends Thread{

    private int storageCapacity;
    private int stock = 0;

    public Storage(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public int getStock() {
        return stock;
    }
    public synchronized boolean storeStock(int amount) {
        if (stock + amount <= storageCapacity) {
            stock += amount;
            return true;
        }
        return false;
    }
    public synchronized int collectStock(int amount) {
        if (amount <= stock) {
            stock -= amount;
            return stock;
        }
        return 0;
    }
}
