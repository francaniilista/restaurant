package com.restaurant.commons;

import static com.restaurant.commons.PreparationUnitType.GRILL;
import static com.restaurant.commons.PreparationUnitType.SLICE;
import static java.util.Arrays.asList;

public class Beef extends Ingredient {

    public Beef(int preparationTime) {
        super("Beef", preparationTime, asList(SLICE, GRILL, GRILL));
    }
}