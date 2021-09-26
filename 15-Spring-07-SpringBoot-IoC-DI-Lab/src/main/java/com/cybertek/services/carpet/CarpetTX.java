package com.cybertek.services.carpet;

import com.cybertek.enums.City;
import com.cybertek.interfaces.carpetPrices.Carpet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CarpetTX implements Carpet {

    public static final Map<City, BigDecimal> prices = new HashMap<>();

    static {
        prices.put(City.SAN_ANTONIO, BigDecimal.valueOf(4.13));
        prices.put(City.AUSTIN, BigDecimal.valueOf(3.22));
        prices.put(City.DALLAS, BigDecimal.valueOf(5.99));
    }

    @Override
    public BigDecimal getSqFtPrice(City city) {
        return prices.entrySet().stream()
                .filter(x -> x.getKey() == city).findFirst().get().getValue();
    }
}