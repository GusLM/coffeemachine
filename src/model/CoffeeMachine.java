package model;

public class CoffeeMachine {
    private int waterLevel;
    private int coffeeGrams;
    private int milkLevel;
    private final int MAX_LIQUID_CAPACITY = 500;
    private MachineStatus status;

    public CoffeeMachine() {
    }

    public CoffeeMachine(int waterLevel, int coffeeQuantity, int milkLevel, MachineStatus status) {
        this.waterLevel = waterLevel;
        this.coffeeGrams = coffeeQuantity;
        this.milkLevel = milkLevel;
        this.status = status;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterQuantity(int waterQuantity) {
        this.waterLevel = Math.max(0, Math.min(waterQuantity, MAX_LIQUID_CAPACITY));
    }

    public int getCoffeeGrams() {
        return coffeeGrams;
    }

    public void setCoffeeGrams(int coffeeGrams) {
        this.coffeeGrams = Math.max(0, Math.min(coffeeGrams, 100));
    }

    public int getMilkLevel() {
        return milkLevel;
    }

    public void setMilkQuantity(int milkQuantity) {
        this.milkLevel = Math.max(0, Math.min(milkQuantity, MAX_LIQUID_CAPACITY));
    }

    public MachineStatus getStatus() {
        return status;
    }

    public void setStatus(MachineStatus status) {
        this.status = status;
    }

    public void addWater(int waterQuantity) {
        if (waterQuantity <= 0) return;
        this.waterLevel = Math.min(this.waterLevel + waterQuantity, MAX_LIQUID_CAPACITY);
    }

    public void addCoffee(int coffeeQuantity) {
        if (coffeeQuantity <= 0) return;
        this.coffeeGrams = Math.min(this.coffeeGrams + coffeeQuantity, 100);
    }

    public void addMilk(int milkQuantity) {
        if (milkQuantity <= 0) return;
        this.milkLevel = Math.min(this.milkLevel + milkQuantity, MAX_LIQUID_CAPACITY);
    }

    public void removeWater(int waterQuantity) {
        if (this.waterLevel + waterQuantity <= 0) {
            this.waterLevel = 0;
        } else {
            this.waterLevel = Math.min(this.waterLevel + waterQuantity, MAX_LIQUID_CAPACITY);
        }
    }

    public void removeCoffee(int coffeeQuantity) {
        if (coffeeQuantity + this.coffeeGrams <= 0) {
            this.coffeeGrams = 0;
        } else {
            this.coffeeGrams = Math.min(this.coffeeGrams + coffeeQuantity, MAX_LIQUID_CAPACITY);
        }
    }

    public void removeMilk(int milkQuantity) {
        if (this.milkLevel + milkQuantity <= 0) {
            this.milkLevel = 0;
        } else {
            this.milkLevel = Math.min(this.milkLevel + milkQuantity, MAX_LIQUID_CAPACITY);
        }
    }
}