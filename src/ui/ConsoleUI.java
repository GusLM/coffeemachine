package ui;

import controller.CoffeeController;
import model.CoffeeDrink;
import model.MachineStatus;
import util.validators.InputValidator;

import java.util.Scanner;

public class ConsoleUI {

    private final CoffeeController controller;
    private final Scanner sc = new Scanner(System.in);

    public ConsoleUI(CoffeeController controller) {
        this.controller = controller;
    }

    public void run(){
        boolean running = true;
        while(running) {
            printMenu();
            int option = InputValidator.readValidInteger(sc, "\nSelect a valid option: ");

            switch (option) {
                case 1:
                    drinkMenu();
                    break;
                case 2:
                    System.out.println(controller.getMachineStatus());
                    break;
                case 3:
                    System.out.println("\nRecipients values:");
                    System.out.printf(
                            "Water: %dml, Coffee: %dg, Milk: %dml.%n",
                            controller.getMachineStatus().getWaterLevel(),
                            controller.getMachineStatus().getCoffeeGrams(),
                            controller.getMachineStatus().getMilkLevel()
                    );
                    refillIngredients();
                    System.out.println("Refueling completed successfully!");
                    break;
                case 4:
                    controller.setMachineStatus(MachineStatus.MAINTENANCE);
                    System.out.println("Maintenance mode activated!");
                    break;
                case 5:
                    resumeOperation();
                    break;
                case 6:
                    controller.setMachineStatus(MachineStatus.OFF);
                    System.out.println("\nTurning off the machine");
                    running = false;
                    break;
                default: throw new IllegalArgumentException("Invalid option!");
            }


        }
    }

    public void printMenu() {
        System.out.println("\n=== Coffee Machine Menu ===");
        System.out.println("1. Select drink type");
        System.out.println("2. View machine status");
        System.out.println("3. Refill ingredients");
        System.out.println("4. Enter maintenance mode");
        System.out.println("5. Resume operation");
        System.out.println("6. Turn off");
        System.out.println("\nRecipients values:");
        System.out.printf(
                "Water: %dml, Coffee: %dg, Milk: %dml.%n",
                controller.getMachineStatus().getWaterLevel(),
                controller.getMachineStatus().getCoffeeGrams(),
                controller.getMachineStatus().getMilkLevel()
        );
    }

    public void drinkMenu() {
        System.out.println("\n=== Coffee Menu ===");
        System.out.println("1. Black Coffee");
        System.out.println("2. Latte");
        System.out.println("3. Macchiato");
        System.out.println("4. Café au Lait");
        System.out.println("5. Long Black");
        System.out.println("6. Flat White");

        int option = InputValidator.readValidInteger(sc, "\nSelect a valid option: ");

        String result = controller.makeCoffee(option); // Captura a resposta
        System.out.println(result); // Exibe a resposta
    }

    public void refillIngredients() {
            int waterQuantity = InputValidator.readValidInteger(sc, "\nEnter the amount of water to be refilled\n");
            controller.refillWater(waterQuantity);
            int coffeeQuantity = InputValidator.readValidInteger(sc, "\nEnter the amount of coffee to be refilled\n");
            controller.refillCoffee(coffeeQuantity);
            int milkQuantity = InputValidator.readValidInteger(sc, "\nEnter the amount of milk to be refilled\n");
            controller.refillMilk(milkQuantity);
    }

    public void resumeOperation() {
        boolean waterLack = controller.getMachineStatus().getWaterLevel() < 30;
        boolean coffeeLack = controller.getMachineStatus().getCoffeeGrams() < 7;

        if (!waterLack || !coffeeLack) {
            controller.setMachineStatus(MachineStatus.READY);
            System.out.println("\nThe machine is ready!");
        } else {
            controller.setMachineStatus(MachineStatus.INSUFFICIENT_RESOURCES);
            System.out.println("\nInsufficient Resources!");
        }
    }

}
