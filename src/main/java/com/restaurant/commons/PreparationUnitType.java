package com.restaurant.commons;

public enum PreparationUnitType {
    CHOP("Chop", 180),
    SLICE("Slice", 300),
    BAKE("Bake",600),
    FRY("Fry", 300),
    GRILL("Grill", 180),
    RINSE("Rinse", 120),
    PEEL("Peel", 120),
    BOIL("Boil", 300);

    private String name;
    private int timeInSeconds;

    PreparationUnitType(String name, int timeInSeconds) {
        this.name = name;
        this.timeInSeconds = timeInSeconds;
    }

    public String getName() {
        return name;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }
}