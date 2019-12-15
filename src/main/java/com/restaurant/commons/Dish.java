package com.restaurant.commons;

import java.util.ArrayList;
import java.util.List;

public class Dish implements Orderable {
    private final String name;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, List<Ingredient> ingredients, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.ingredients.addAll(ingredients);
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() { return ingredients; }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public void order() {
        ingredients.forEach(ingredient -> ingredient.cook());
    }

    @Override
    public void orderAsync() {
        ingredients.forEach(ingredient -> ingredient.cookAsync());
    }

    @Override
    public String toString() {
        return name;
    }
}