package com.cybertek.services.carpet;

import com.cybertek.enums.City;
import com.cybertek.interfaces.carpetPrices.Carpet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CarpetTX implements Carpet {

    private static final Map<City, BigDecimal> prices = new HashMap<>();

    static {
        prices.put(City.SAN_ANTONIO, BigDecimal.valueOf(2.13));
        prices.put(City.AUSTIN, BigDecimal.valueOf(1.22));
        prices.put(City.DALLAS, BigDecimal.valueOf(1.99));
    }

    @Override
    public BigDecimal getSqFtPrice(City city) {

        BigDecimal defaultValue = BigDecimal.ZERO;

        Optional<Map.Entry<City, BigDecimal>> collect = prices.entrySet().stream()
                .filter(x -> x.getKey() == city).findFirst();

        return collect.isPresent() ? collect.get().getValue() : defaultValue;
    }
}