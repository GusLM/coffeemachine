package model;

public class CoffeeDrink {
    private String name;
    private int waterMlRequired;
    private int coffeeGramsRequired;
    private int milkMlRequired;

    public CoffeeDrink(String name, int waterMlRequired, int coffeeGrams, int milkMlRequired) {
        this.name = name;
        this.waterMlRequired = waterMlRequired;
        this.coffeeGramsRequired = coffeeGrams;
        this.milkMlRequired = milkMlRequired;
    }

    public String getName() {
        return name;
    }

    public int getWaterMlRequired() {
        return waterMlRequired;
    }

    public int getMilkMlRequired() {
        return milkMlRequired;
    }

    public int getCoffeeGramsRequired() {
        return coffeeGramsRequired;
    }

}
