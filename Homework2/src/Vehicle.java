import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Vector;

public class Vehicle implements Comparable<Vehicle> {
    private BigDecimal weight;
    private boolean isEmergencyVehicle;

    @Override
    public int compareTo(Vehicle compared) {
        return Boolean.compare(this.isEmergencyVehicle, compared.isEmergencyVehicle);
    }

    public static Comparator<Vehicle> byVehicleWeight = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
                return o1.weight.compareTo(o2.weight);
            }
        };

    public Vehicle() {
    }

    public Vehicle(double weight, boolean isEmergencyVehicle) {
        this.weight = BigDecimal.valueOf(weight);
        this.isEmergencyVehicle = isEmergencyVehicle;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = BigDecimal.valueOf(weight);
    }

    public boolean isEmergencyVehicle() {
        return isEmergencyVehicle;
    }

    public void setEmergencyVehicle(boolean emergencyVehicle) {
        isEmergencyVehicle = emergencyVehicle;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "weight=" + weight +
                ", isEmergencyVehicle=" + isEmergencyVehicle +
                '}';
    }
}
