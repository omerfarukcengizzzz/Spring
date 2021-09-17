package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.Data;

@Data
public class Selenium implements Course {

    private ExtraSessions extraSessions;

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours = " + (15 + extraSessions.getHours()));
    }
}
