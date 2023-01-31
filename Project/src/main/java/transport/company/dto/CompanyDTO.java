package transport.company.dto;

import transport.company.entity.Company;

import java.util.Comparator;

public class CompanyDTO implements Comparator<CompanyDTO>{
    private String name;
    private Double earnings;

    @Override
    public int compare(CompanyDTO o1, CompanyDTO o2) {
        return 0;
    }

    CompanyDTO(){}

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "name='" + name + '\'' +
                ", earnings=" + earnings +
                '}';
    }

    public CompanyDTO(String name, Double earnings){
        this.name = name;
        this.earnings = earnings;
    }

    public static Comparator<CompanyDTO> byName = new Comparator<CompanyDTO>() {
        @Override
        public int compare(CompanyDTO c1, CompanyDTO c2) {
            return c1.getName().compareTo(c2.getName());
        }
    };

    public static Comparator<CompanyDTO> byEarnings = new Comparator<CompanyDTO>() {
        @Override
        public int compare(CompanyDTO c1, CompanyDTO c2) {
            return c1.getEarnings().compareTo(c2.getEarnings());
        }
    };

    public int compareByEarnings(CompanyDTO other){
        return getEarnings().compareTo(other.getEarnings());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEarnings() {
        return earnings;
    }

    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }
}
