package com.restaurant;

import com.restaurant.commons.Pork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestRestaurant {
    public static void main(String[] args) {
        Pork pork = new Pork(1000);
        Future<Long> future = pork.cookAsync();
        System.out.println("Preparing: " + pork);
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        try {
            long timeSpent = future.get();
            System.out.println("time spent: " + timeSpent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
