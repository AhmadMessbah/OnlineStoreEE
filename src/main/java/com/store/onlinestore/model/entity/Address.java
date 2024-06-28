package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@NamedQueries({
        @NamedQuery(name = "Address.FindByPostalCode",query = "SELECT A FROM addressEntity A WHERE A.postalCode=:postalCode")
        ,@NamedQuery(name = "Address.FindByCountryAndState", query = "SELECT A FROM addressEntity A WHERE A.countryName=:countryName AND A.stateName=:stateName ")
}
)


@Entity(name="addressEntity")
@Table(name="address_tbl")
public class Address {
    @Id
    @SequenceGenerator(name = "addressSeq", sequenceName = "address_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;
    @Column(name = "country",length =30 ,nullable = false )
//    @Pattern(regexp = "^[a-zA-Z\\s]{5,30}$",message = "Invalid Country Name")
    private String countryName;
    @Column(name = "state",length =30,nullable = false )
//    @Pattern(regexp = "^[a-zA-Z\\s]{5,30}$",message = "Invalid State Name")
    private String stateName;
    @Column(name = "city",length = 30)
//    @Pattern(regexp = "^[a-zA-Z\\s]{5,30}$",message = "Invalid City Name")
    private String cityName;
    @Column(name = "village",length = 30)
//    @Pattern(regexp = "^[a-zA-Z\\s]{5,30}$",message = "Invalid Village Name")
    private String villageName;
    @Column(name = "region",length = 30)
//    @Pattern(regexp = "^[a-zA-Z0-9\\s]{5,30}$",message = "Invalid Region Name")
    private String regionName;
    @Column(name = "street",length =150)
//    @Pattern(regexp = "^[a-zA-Z0-9()&@$_\\-\\s]{5,150}$",message = "Invalid Street Name")
    private String streetName;
    @Column(name = "plates",length =5)
//    @Pattern(regexp = "^[A-Z0-9&_\\-]{5}$",message = "Invalid Plates Number")
    private String platesNumber;
    @Column(name = "floor",length =5)
//    @Pattern(regexp = "^[0-9]{5}$",message = "Invalid Floor Number")
    private String floorNumber;
    @Column(name = "home_unit",length =5)
//    @Pattern(regexp = "^[0-9]{5}$",message = "Invalid Home Unit")
    private String homeUnit;
    @Column(name = "postalCode",length = 10, unique = true)
//    @Pattern(regexp = "^[0-9]{10}$",message = "Invalid Postal Code")
    private String postalCode;

    public String getFullAddress (){
        return String.format("%s - %s - %s - %s %s",  countryName,stateName,cityName,villageName,regionName);
    }
}
