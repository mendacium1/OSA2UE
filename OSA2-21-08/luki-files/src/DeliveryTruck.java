/**
 * Implementation of the delivery truck which has a maximum capacity of items to carry and a shipment time
 *
 * @author Lukas Kaiser
 */
public class DeliveryTruck implements Runnable{

    String deliveryTruckName;
    int carryingCapacity;
    int shipmentTime;
    private Storage storage;

    /**
     *
     * @param deliveryTruckName
     * @param carryingCapacity
     * @param shipmentTime
     * @param storage
     */
    public DeliveryTruck(String deliveryTruckName, int carryingCapacity, int shipmentTime, Storage storage) {
        this.deliveryTruckName = deliveryTruckName;
        this.carryingCapacity = carryingCapacity;
        this.shipmentTime = shipmentTime;
        this.storage = storage;
    }

    /**
     * get items with the amount the delivery truck can pick up
     */
    private synchronized boolean getItems(){
        if (this.storage.getCurrentStock() >= this.carryingCapacity){
            this.storage.setCurrentStock(this.storage.getCurrentStock() - this.carryingCapacity);
            System.out.println("[" + this.deliveryTruckName + "] Not enough stock available (current stock level: " +
                    this.storage.getCurrentStock() + ", items to deliver: " + this.carryingCapacity + "). Waiting...");
            return true;
        }
        return false;
    }

    /**
     *
     */
    private void deliverItems(){
        System.out.println("[" + this.deliveryTruckName + "] Delivering " + this.carryingCapacity + " items in " +
                this.shipmentTime + " seconds.");
        // Sleep for the amount of time needed to ship the products
        try {
            Thread.sleep(this.shipmentTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     */
    @Override
    public void run() {
        while(!Thread.interrupted()){
            if(!getItems()){
                try {
                    synchronized (storage){
                        this.storage.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            deliverItems();
        }
    }
}
