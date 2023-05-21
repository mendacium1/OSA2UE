import java.util.ArrayList;

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
        for (ProductionLine p : productionLines) {
            p.run();
        }
        for (DeliveryTruck d : deliveryTrucks) {
            d.run();
        }

    }
}
