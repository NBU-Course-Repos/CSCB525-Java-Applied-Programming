import javax.xml.crypto.dsig.keyinfo.PGPData;
import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        PhotoStudio photoStudio = new PhotoStudio("Neshto");
        Picture ivan2 = new Picture(1,2, LocalDate.now(),"Ivan", OrderType.EXPRESS);
        Picture ivan1 = new Picture(3,3, LocalDate.of(2000,10,10),"Ivan", OrderType.EXPRESS);
        photoStudio.addPhoto(ivan2);
        photoStudio.addPhoto(new Picture(2,1, LocalDate.of(1999,12,21),"George", OrderType.STANDARD));
        photoStudio.addPhoto(ivan1);
        photoStudio.addPhoto(new Picture(4,4, LocalDate.of(2020,05,3),"Bojidar", OrderType.FAST));
        Picture dragomir = new Picture(5,2, LocalDate.now(),"Dragomir", OrderType.STANDARD);
        photoStudio.addPhoto(dragomir);

        //photoStudio.showSortedPhotos();
//        photoStudio.largerThan2MB();
//        photoStudio.highestId();
//        Set<Picture> express = photoStudio.getExpressOrders();
//        express.forEach(System.out::println);
        photoStudio.addPhotoToArchive(ivan2, LocalDate.now());
        photoStudio.addPhotoToArchive(ivan1, LocalDate.of(2020,01,01));
        photoStudio.addPhotoToArchive(dragomir,LocalDate.now());

        //photoStudio.showArchiveByOwnerName();
        //photoStudio.showIvansArchivedPhotos();

        photoStudio.showPrintingOrder();
    }
}
