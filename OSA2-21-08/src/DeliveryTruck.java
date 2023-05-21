/**
 * The DeliveryTruck class represents a delivery truck responsible for transporting goods
 * from the storage to their destination.
 * It implements the Runnable interface to enable concurrent execution.
 * <br>
 * Disclaimer: As not specifically asked, the identification of the delivery trucks is visualised by numbers.
 *
 * @author Jakob Mayr, Lukas Kaiser
 */
public class DeliveryTruck implements Runnable {


    private static int deliveryTruckId = 0;
    private final int uid = ++deliveryTruckId;
    private final int carryingCapacity;
    private final int deliveryTime;
    private final Storage storage;

    /**
     * Constructs a DeliveryTruck object with the specified carrying capacity, delivery time,
     * and storage.
     * @param carryingCapacity the maximum carrying capacity of the truck
     * @param deliveryTime the time taken to deliver items
     * @param storage the storage instance for retrieving items
     */
    public DeliveryTruck(int carryingCapacity, int deliveryTime, Storage storage) {
        this.carryingCapacity = carryingCapacity;
        this.deliveryTime = deliveryTime;
        this.storage = storage;
    }

    /**
     * Retrieves items from the storage to be delivered by the truck.
     * @return true if the items are successfully retrieved, false if there is not enough stock available
     */
    private synchronized boolean getItems() {
        return this.storage.collectStock(this.carryingCapacity, this.uid);
    }

    @Override
    public void run() {
        System.out.println("[DELIVERY TRUCK " + uid + "] Started.");

        while (!Thread.interrupted()) {
            while (!getItems()) {       //If there are too little items available, let thread wait
                synchronized (storage) {
                    try {
                        this.storage.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            // Deliver
            System.out.println("[DELIVERY TRUCK " + uid + "] Delivering " + carryingCapacity + " items in " +
                    deliveryTime + " seconds.");
            try {
                Thread.sleep(deliveryTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
