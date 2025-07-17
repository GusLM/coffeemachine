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

    public String makeCoffee(int drinkType) {
         return coffeeService.makeCoffee(drinkType);
    }

    public boolean hasIngredients(CoffeeDrink coffeeDrink) {
        return coffeeService.hasIngredients(coffeeDrink);
    }

    public void consumeResources(CoffeeDrink coffeeDrink) {
        coffeeService.consumeResources(coffeeDrink);
    }

    public void refillWater(int waterQuantity) {
        coffeeService.refillWater(waterQuantity);
    }

    public void refillCoffee(int coffeeQuantity) {
        coffeeService.refillCoffee(coffeeQuantity);
    }

    public void refillMilk(int milkQuantity) {
        coffeeService.refillMilk(milkQuantity);
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
