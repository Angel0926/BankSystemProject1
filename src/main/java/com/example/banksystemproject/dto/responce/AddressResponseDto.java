package com.example.banksystemproject.dto.responce;

public class AddressResponseDto {

    private Long id;
    private String country;
    private String city;
    private String street;

    public AddressResponseDto() {
    }

    public AddressResponseDto(Long id, String country, String city, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
