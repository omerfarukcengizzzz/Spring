package com.cybertek.enums;

public enum State {
    NEW_YORK("new_york"), VIRGINIA("virginia"), TEXAS("texas"), MIAMI("miami"), CALIFORNIA("california");

    private String value;

    State(String value) {
        this.value = value;
    }
}
