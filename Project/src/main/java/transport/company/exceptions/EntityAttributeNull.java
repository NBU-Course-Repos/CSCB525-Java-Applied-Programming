package transport.company.exceptions;

public class EntityAttributeNull extends Exception{
    public EntityAttributeNull(String attribute){
        super(String.format("Entity Attribute %s can not be of null type", attribute));
    }
}
