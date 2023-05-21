import java.util.ArrayList;
import java.util.List;

public class ProductionPlant {

    private Storage storage;
    private ArrayList<ProductionLine> productionLines;
    private ArrayList<DeliveryTruck> deliveryTrucks;

    public ProductionPlant(Storage storage, ArrayList<ProductionLine> productionLines,
                           ArrayList<DeliveryTruck> deliveryTrucks) {
        this.storage = storage;
        this.productionLines = productionLines;
        this.deliveryTrucks = deliveryTrucks;
    }

    public void startProduction() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (ProductionLine p : productionLines) {
            Thread thread = new Thread(p::run);
            threads.add(thread);
            thread.start();
        }

        for (DeliveryTruck d : deliveryTrucks) {
            Thread thread = new Thread(d::run);
            threads.add(thread);
            thread.start();
        }


    }
}
