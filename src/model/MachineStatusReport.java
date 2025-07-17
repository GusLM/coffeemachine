package model;

public class MachineStatusReport {

    private int waterLevel;
    private int coffeeGrams;
    private int milkLevel;
    private MachineStatus status;

    public MachineStatusReport(int waterLevel, int coffeeGrams, int milkLevel, MachineStatus status) {
        this.waterLevel = waterLevel;
        this.coffeeGrams = coffeeGrams;
        this.milkLevel = milkLevel;
        this.status = status;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getCoffeeGrams() {
        return coffeeGrams;
    }

    public int getMilkLevel() {
        return milkLevel;
    }

    public MachineStatus getStatus() {
        return status;
    }
}
