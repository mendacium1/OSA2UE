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

    private void printLog(char c) {
        switch (c) {
            case 'p':
                System.out.println("[delivery truck " + uid + "] Picking up " + storageCapacity +
                        " items. New stock level " + storage.getStock() + ".");
                break;
            case 'e':
                System.out.println("[delivery truck " + uid + "] Not enough stock available (current sock level: " +
                        storage.getStock() + ", items to deliver: " + storageCapacity + "). Waiting...");
                break;
            case 'd':
                System.out.println("[delivery truck " + uid + "] Delivering " + storageCapacity + " items in " +
                        deliveryTime + " seconds.");
                break;
            default:
                System.out.println("invalid log request");
        }
    }

    @Override
    public void run() {
        while (true) {
            // check storage
            int storageLevel = storage.collectStock(storageCapacity);
            if (storageLevel > 0) {
                printLog('p');
                // deliver
                printLog('d');
                try {
                    Thread.sleep(deliveryTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {

            }
        }
    }

}
