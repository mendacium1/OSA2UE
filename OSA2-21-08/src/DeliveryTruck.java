public class DeliveryTruck extends Thread {

    private static int deliveryTruckId = 0;
    private int uid = ++deliveryTruckId;
    private final int storageCapacity;
    private final int deliveryTime;
    private Storage storage;

    public DeliveryTruck(int storageCapacity, int deliveryTime, Storage storage) {
        this.storageCapacity = storageCapacity;
        this.deliveryTime = deliveryTime;
        this.storage = storage;
        System.out.println(uid);
    }

    @Override
    public void run() {
        while (true) {
            // check storage
            int storageLevel = storage.collectStock(storageCapacity);
            if (storageLevel > 0) {
                System.out.println("[" + uid + "] Picking up " + storageCapacity + " items. New stock level " +
                        storageLevel);

                // deliver
                System.out.println("[" + uid + "] Delivering " + storageCapacity + " items in " + deliveryTime +
                        "seconds");
                try {
                    Thread.sleep(deliveryTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
