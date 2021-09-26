package com.cybertek.services.carpet;

import com.cybertek.enums.City;
import com.cybertek.interfaces.carpetPrices.Carpet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CarpetTX implements Carpet {


    @Override
    public BigDecimal getSqFtPrice(City city) {
        return null;
    }
}