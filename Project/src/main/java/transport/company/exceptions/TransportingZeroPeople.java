package transport.company.exceptions;

public class TransportingZeroPeople extends Exception{
    public TransportingZeroPeople(){
        super("TransportZeroPeople exception: Can not transport less" +
                " than 1 person when delivery type is of type DeliveryOf.PEOPLE");
    }
}
