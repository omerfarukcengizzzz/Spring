package com.cybertek.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // where do you want it to be applicable
@Retention(RetentionPolicy.RUNTIME) // when will it be active
public @interface DefaultExceptionMessage {

    String defaultMessage() default "";

}
