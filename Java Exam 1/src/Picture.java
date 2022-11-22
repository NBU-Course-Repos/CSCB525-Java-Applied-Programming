import java.time.LocalDate;
import java.util.Comparator;

public class Picture implements Comparator<Picture> {
    private long id;
    private double size;
    private LocalDate dateCreated;
    private String ownerName;
    private OrderType orderType;

    public Picture(long id, double size, LocalDate dateCreated, String ownerName, OrderType orderType) {
        this.id = id;
        this.size = size;
        this.dateCreated = dateCreated;
        this.ownerName = ownerName;
        this.orderType = orderType;
    }

    @Override
    public int compare(Picture o1, Picture o2) {
        return 0;
    }

    public LocalDate getDateCreated(){
        return this.dateCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public static Comparator<Picture> byOwner = new Comparator<Picture>() {
        @Override
        public int compare(Picture p1, Picture p2) {
            return p1.ownerName.compareTo(p2.ownerName);
        }
    };

    public static Comparator<Picture> byOrderType = new Comparator<Picture>() {
        @Override
        public int compare(Picture p1, Picture p2) {
            return p1.orderType.compareTo(p2.orderType);
        }
    };


    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", size=" + size +
                ", dateCreated=" + dateCreated +
                ", ownerName='" + ownerName + '\'' +
                ", orderType=" + orderType +
                '}';
    }
}
