package com.cybertek.model;

import com.cybertek.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "teacher"}, ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseEntity{

    private String street;
    private String city;
    private String country;
    private String state;

    private String postalCode;
    private Integer currentTemperature;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parent parent;

    @OneToOne(mappedBy = "address")
    private Teacher teacher;

    private Integer getCurrentTemperature() {
        return consumeTemp(this.city);
    }

    public Integer consumeTemp(String city) {
        RestTemplate restTemplate = new RestTemplate();

        String BASE_URL = "http://api.weatherstack.com/current?access_key=ed60609d6e1582bafaa71464a763eeb1&query=";

        String URI = BASE_URL + city;

        Object currentWeather = restTemplate.getForObject(URI, Object.class);

        Map<String, Object> getWeather = (Map<String, Object>) currentWeather;

        Map<String, Object> getTemperature = (Map<String, Object>) getWeather.get("current");

        return Integer.parseInt(getTemperature.get("temperature").toString());
    }

}
