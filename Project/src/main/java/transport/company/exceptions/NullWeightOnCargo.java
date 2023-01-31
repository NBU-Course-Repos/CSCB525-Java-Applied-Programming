package transport.company.exceptions;

public class NullWeightOnCargo extends Exception {
    public NullWeightOnCargo() {
        super("When delivery is of type Cargo, the weight should not be null");
    }
}