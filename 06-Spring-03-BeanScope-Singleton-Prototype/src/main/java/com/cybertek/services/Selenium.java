package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.Data;

@Data
public class Selenium implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours = 15");
    }
}
