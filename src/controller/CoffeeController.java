package controller;

import model.CoffeeDrink;
import model.MachineStatus;
import model.MachineStatusReport;
import service.CoffeeService;

public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    public void makeCoffee(int drinkType) {
         coffeeService.makeCoffee(drinkType);
    }

    public boolean hasIngredients(CoffeeDrink coffeeDrink) {
        return coffeeService.hasIngredients(coffeeDrink);
    }

    public void consumeResources(CoffeeDrink coffeeDrink) {
        coffeeService.consumeResources(coffeeDrink);
    }

    public void addWater(int waterQuantity) {
        coffeeService.addWater(waterQuantity);
    }

    public void addCoffee(int coffeeQuantity) {
        coffeeService.addCoffee(coffeeQuantity);
    }

    public void addMilk(int milkQuantity) {
        coffeeService.addMilk(milkQuantity);
    }

    public void removeWater(int waterQuantity) {
        coffeeService.removeWater(waterQuantity);
    }

    public void removeCoffee(int coffeeQuantity) {
        coffeeService.removeCoffee(coffeeQuantity);
    }

    public void removeMilk(int milkQuantity) {
        coffeeService.removeMilk(milkQuantity);
    }

    public void updateStatusAfterUse() {
        coffeeService.updateStatusAfterUse();
    }

    public MachineStatusReport getMachineStatus() {
       return coffeeService.getMachineStatus();
    }

    public void setMachineStatus(MachineStatus status) {
        coffeeService.setMachineStatus(status);
    }

}
