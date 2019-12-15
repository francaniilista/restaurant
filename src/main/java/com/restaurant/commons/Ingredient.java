package com.restaurant.commons;

import com.restaurant.util.ThreadUtil;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class Ingredient implements Cookable {
    private String name;
    private int preparationTime;
    private List<PreparationUnitType> preparationSteps;

    public Ingredient(String name, int preparationTime, List<PreparationUnitType> preparationSteps) {
        this.name = name;
        this.preparationTime = preparationTime;
        this.preparationSteps = preparationSteps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreparationTime() {
        return preparationTime + preparationSteps.stream()
                .map(PreparationUnitType::getTimeInSeconds)
                .collect(Collectors.reducing(0, (a, b) -> a + b));
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public List<PreparationUnitType> getPreparationSteps() { return preparationSteps; }

    public void setPreparationSteps(List<PreparationUnitType> preparationSteps) { this.preparationSteps = preparationSteps; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return preparationTime == that.preparationTime &&
                name.equals(that.name) &&
                Objects.equals(preparationSteps, that.preparationSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, preparationTime, preparationSteps);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ingredient{");
        sb.append("name='").append(name).append('\'');
        sb.append(", preparationTime=").append(getPreparationTime());
        sb.append(", preparationSteps=").append(preparationSteps);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public long cook() {
        long start = System.nanoTime();
        ThreadUtil.delay(getPreparationTime());
        System.out.println(name + " is being cooked, " + Thread.currentThread().getName());
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);

        return invocationTime;
    }

    @Override
    public Future<Long> cookAsync() {
        CompletableFuture<Long> futureMeal = new CompletableFuture<>();
        new Thread(() -> {
            long start = System.nanoTime();
            ThreadUtil.delay(getPreparationTime());
            System.out.println(name + " is being cooked, " + Thread.currentThread().getName());
            long invocationTime = ((System.nanoTime() - start) / 1_000_000);

            futureMeal.complete(invocationTime);
        }).start();

        return futureMeal;
    }
}