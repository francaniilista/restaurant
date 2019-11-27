package com.restaurant;

import com.restaurant.commons.Dish;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadKitchenService implements KitchenService {

    private ExecutorService stoveExecutor;

    public FixedThreadKitchenService() {
        stoveExecutor = Executors.newFixedThreadPool(4);
    }

    @Override
    public void prepare(Dish dish) {
        dish.getIngredients().forEach(ingredient -> stoveExecutor.submit(ingredient));
    }

    @Override
    public void prepare(List<Dish> dishes) {
        dishes.forEach(dish -> prepare(dish));
    }

    @Override
    public void shutDownKitchen() {
        stoveExecutor.shutdown();
    }
}