package com.restaurant.commons;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ingredient implements Runnable {
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
    public void run() {
        System.out.println("Preparing: " + this);

        long start = System.nanoTime();
        int delay = getPreparationTime();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("The " + name + " got prepared after " + invocationTime + " msecs");
        System.out.println("----------");
    }
}