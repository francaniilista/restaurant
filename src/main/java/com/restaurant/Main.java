package com.restaurant;

import com.restaurant.commons.Beef;
import com.restaurant.commons.Chicken;
import com.restaurant.commons.Dish;
import com.restaurant.commons.Pork;
import com.restaurant.commons.Potato;
import com.restaurant.commons.Rice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating simple menu: ");
        List<Dish> menu = asList(
                new Dish("Pork", Arrays.asList(new Pork(3600)),false, 800, Dish.Type.MEAT),
                new Dish("Beef", Arrays.asList(new Beef(2700)), false, 700, Dish.Type.MEAT),
                new Dish("Chicken", Arrays.asList(new Chicken(1800)), false, 400, Dish.Type.MEAT),
                new Dish("French fries", Arrays.asList(new Potato(300)), true, 530, Dish.Type.OTHER),
                new Dish("Rice", Arrays.asList(new Rice(600)), true, 350, Dish.Type.OTHER));

        long start = System.nanoTime();
        menu.forEach(dish -> dish.order());
        long invocationTime = ((System.nanoTime() - start) /1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");


    }
}