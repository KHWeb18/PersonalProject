package test.modify.domain;


import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Address {

    private String zipcode;
    private String street;
    private String city;

    public Address(String zipcode, String street, String city) {
        this.zipcode = zipcode;
        this.street = street;
        this.city = city;
    }
}
