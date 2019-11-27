package com.restaurant;

import com.restaurant.commons.Dish;

import java.util.List;

public interface KitchenService {
    void prepare(Dish dish);
    void prepare(List<Dish> dishes);
    void shutDownKitchen();
}
