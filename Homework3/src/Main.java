import java.math.BigDecimal;

public class Main {
    public static void Main(String[] args){
        PlasticGoodsManufacturer jumbo = new PlasticGoodsManufacturer("jumbo");
        jumbo.addProduct(new PlasticGoods("toy", BigDecimal.valueOf(20)));
        jumbo.addProduct(new PlasticGoods("bottle", BigDecimal.valueOf(40)));
        jumbo.addProduct(new PlasticGoods("box", BigDecimal.valueOf(50)));
        jumbo.addProduct(new PlasticGoods("headphones", BigDecimal.valueOf(90)));

        System.out.println(jumbo.getClosestToAvg());
    }
}
