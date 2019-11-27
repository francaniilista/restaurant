package com.restaurant.commons;

import static com.restaurant.commons.PreparationUnitType.BAKE;
import static com.restaurant.commons.PreparationUnitType.CHOP;
import static com.restaurant.commons.PreparationUnitType.FRY;
import static java.util.Arrays.asList;

public class Chicken extends Ingredient {

    public Chicken(int preparationTime) {
        super("Chicken", preparationTime, asList(CHOP, BAKE, FRY));
    }
}
