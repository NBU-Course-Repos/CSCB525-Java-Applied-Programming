import java.util.Comparator;
import java.util.PriorityQueue;

public class Checkpoint {
    String name;
    PriorityQueue<Vehicle> vehicles;

    Checkpoint(String name){
        vehicles = new PriorityQueue<>(emergencyFirstThenWeight.thenComparing(Vehicle.byVehicleWeight));
    }



    private static Comparator<Vehicle> emergencyFirstThenWeight = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o2.compareTo(o1);
        }
    };

    public boolean hasQueue(){
        return !vehicles.isEmpty();
    }

    public void getOnQueue(Vehicle vehicle){
        vehicles.offer(vehicle);
    }

    public Vehicle passThrough(){
        if (vehicles.peek()!=null){
            return vehicles.poll();
        }
        else
            return null;
    }

}
