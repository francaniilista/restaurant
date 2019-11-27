package com.restaurant.commons;

import static com.restaurant.commons.PreparationUnitType.BAKE;
import static com.restaurant.commons.PreparationUnitType.RINSE;
import static java.util.Arrays.asList;

public class Rice extends Ingredient {

    public Rice(int preparationTime) {
        super("Rice", preparationTime, asList(RINSE, BAKE));
    }
}
