import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        Checkpoint ivanica = new Checkpoint("Ivanica");
        Vehicle yugo = new Vehicle(500,false);
        Vehicle golf = new Vehicle(750,false);
        Vehicle fireTruck = new Vehicle(1000,true);
        Vehicle ambulance = new Vehicle(900,true);
        Vehicle Truck = new Vehicle(12000,false);

        ivanica.getOnQueue(yugo);
        ivanica.getOnQueue(golf);
        ivanica.getOnQueue(fireTruck);
        ivanica.getOnQueue(ambulance);
        ivanica.getOnQueue(Truck);

        while(ivanica.hasQueue()){
            System.out.println(ivanica.passThrough());
        }

    }
}
