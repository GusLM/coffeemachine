package app;

import controller.CoffeeController;
import model.CoffeeMachine;
import model.MachineStatus;
import service.CoffeeService;
import ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        CoffeeService coffeeService = new CoffeeService(coffeeMachine);
        CoffeeController coffeeController = new CoffeeController(coffeeService);
        ConsoleUI ui = new ConsoleUI(coffeeController);
        ui.run();
    }
}
