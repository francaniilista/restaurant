package com.restaurant.commons;

import java.util.Arrays;

public class Potato extends Ingredient {

    public Potato(int preparationTime) {
        super("Potato", preparationTime, Arrays.asList(PreparationUnitType.PEEL,PreparationUnitType.RINSE, PreparationUnitType.FRY));
    }
}