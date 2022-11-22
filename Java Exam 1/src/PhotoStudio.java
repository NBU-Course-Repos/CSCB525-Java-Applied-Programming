import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhotoStudio {
    private String name;
    private HashSet<Picture> photos;
    private HashMap<Picture, LocalDate> archive;
    private PriorityQueue<Picture> printQueue;


    public PhotoStudio(String name) {
        this.name = name;
        this.photos = new HashSet<>();
        this.archive = new HashMap<Picture, LocalDate>();
        this.printQueue = new PriorityQueue<Picture>(Picture.byOrderType);
    }

    public void showPrintingOrder(){
       PriorityQueue<Picture> copy = printQueue;
       while (copy.peek()!=null){
            System.out.println(copy.poll());
       }
    }

    public boolean addPhoto(Picture photo){
        printQueue.add(photo);
        return photos.add(photo);
    }

    public void showSortedPhotos(){
        Stream<Picture> str = photos.stream().sorted(Comparator.comparing(Picture::getDateCreated)
                .thenComparing(Comparator.comparing(Picture::getOwnerName)));
        str.forEach(System.out::println);
    }

    public void largerThan2MB(){
        List<Picture> ls = photos.stream().filter(picture -> picture.getSize() > 2)
                .collect(Collectors.toList());
        ls.forEach(System.out::println);
    }

    public void highestId(){
        System.out.println(photos.stream().max(Comparator.comparing(Picture::getId)));
    }

    public Set<Picture> getExpressOrders(){
        Set<Picture> express = photos.stream().filter(picture->picture.getOrderType() == OrderType.EXPRESS)
                .collect(Collectors.toSet());
        return express;
    }

    public void addPhotoToArchive(Picture photo, LocalDate date){
        archive.put(photo, date);
    }

    public void showArchiveByOwnerName(){
        List<Picture> pic = new ArrayList<Picture>();
        archive.entrySet().stream().forEach(pictureLocalDateEntry -> pic.add(pictureLocalDateEntry.getKey()));
        pic.sort(Picture.byOwner);
        pic.stream().forEach(picture -> System.out.println(picture));
    }

    public void showIvansArchivedPhotos(){
        archive.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .filter(pictureLocalDateEntry -> pictureLocalDateEntry.getKey().getOwnerName() == "Ivan")
                .forEach(pictureLocalDateEntry -> System.out.println(pictureLocalDateEntry.getKey()));
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Picture> getPhotos() {
        return photos;
    }

    public void setPhotos(HashSet<Picture> photos) {
        this.photos = photos;
    }
}
