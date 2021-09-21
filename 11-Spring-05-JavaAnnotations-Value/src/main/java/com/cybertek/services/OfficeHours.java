package com.cybertek.services;

import com.cybertek.interfaces.ExtraSessions;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 4;
    }
}
