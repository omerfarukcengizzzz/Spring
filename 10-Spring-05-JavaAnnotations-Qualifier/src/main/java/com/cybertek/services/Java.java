package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    // Field Injection
    @Autowired
    private ExtraSessions extraSessions;

    /*
        // Constructor Injection
        // we can also do constructor injection with the help of lombok annotations(@AllArgsConstructor)
        @Autowired  // we don't need to put @Autowired annotation if there is only one constructor
        public Java(ExtraSessions extraSessions) {
            this.extraSessions = extraSessions;
        }
    */

    /*
        // Setter Injection
        // we can also do setter injection with the help of lombok annotations(@Setter)
        @Autowired
        public void setExtraSessions(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
        }
    */



    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours = " + (30 + extraSessions.getHours()));
    }
}
