package com.cybertek.calculator;

import com.cybertek.enums.City;
import com.cybertek.interfaces.carpetPrices.Carpet;
import com.cybertek.interfaces.floorTypes.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calculator {

    @Autowired
    @Qualifier("carpetTX")
    private Carpet carpet;

    @Autowired
    @Qualifier("bedroom")
    private Floor floor;

    public String getTotalCarpetCost(City city) {
        BigDecimal cost = carpet.getSqFtPrice(city).multiply(floor.getArea());

        return "Total Cost = $" + cost;
    }

}
