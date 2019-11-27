package com.restaurant.commons;

import static com.restaurant.commons.PreparationUnitType.BAKE;
import static com.restaurant.commons.PreparationUnitType.FRY;
import static com.restaurant.commons.PreparationUnitType.SLICE;
import static java.util.Arrays.asList;

public class Pork extends Ingredient {

    public Pork(int preparationTime) {
        super("Pork", preparationTime, asList(SLICE, FRY, BAKE, BAKE));
    }
}