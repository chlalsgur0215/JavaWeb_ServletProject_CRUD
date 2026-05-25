package idusw.javaweb.sba2.domain;

// Model - DTO(Data Transfer Object) : Beans 객체 또는 POJO(Plain Old Java Object)임
public class City {
    private int id; // 접두어는 대문자를 사용하기도 함, 자바 필드명은 소문자로 시작
    private String name;
    private String countryCode; // country_code 또는 countryCode
    private String district;
    private int population;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
