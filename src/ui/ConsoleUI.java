package ui;

import controller.CoffeeController;
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
        controller.setMachineStatus(MachineStatus.ON);
        while(running) {
            printMenu();
            int option = InputValidator.readValidInteger(sc, "\nSelect a valid option: ");

            switch (option) {
                case 1:
                    drinkMenu();
                    break;
                case 2:
                    System.out.println(controller.getMachineStatus().getStatus());
                    break;
                case 3:
                    System.out.println("\nRecipients values:");
                    System.out.printf(
                            "Water: %dml, Coffee: %dg, Milk: %dml.%n",
                            controller.getMachineStatus().getWaterLevel(),
                            controller.getMachineStatus().getCoffeeGrams(),
                            controller.getMachineStatus().getMilkLevel()
                    );
                    System.out.println("\nEnter positive values for filling and negative values for withdrawal.");
                    adjustIngredients();
                    System.out.println("\nIngredient values updated successfully!");
                    break;
                case 4:
                    controller.setMachineStatus(MachineStatus.MAINTENANCE);
                    System.out.println("\nMaintenance mode activated!");
                    break;
                case 5:
                    resumeOperation();
                    break;
                case 6:
                    showDrinkList();
                    break;
                case 7:
                    controller.setMachineStatus(MachineStatus.OFF);
                    System.out.println("\nTurning off the machine");
                    running = false;
                    break;
                default:
                    try {
                        throw new IllegalArgumentException("\nInvalid menu option selected.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nError: " + e.getMessage());
                    }
            }

        }
    }

    public void printMenu() {
        System.out.println("\nMachine Status:" + controller.getMachineStatus().getStatus());
        System.out.printf(
                "Recipients values - Water: %dml, Coffee: %dg, Milk: %dml.%n",
                controller.getMachineStatus().getWaterLevel(),
                controller.getMachineStatus().getCoffeeGrams(),
                controller.getMachineStatus().getMilkLevel()
        );
        System.out.println("\n=== Coffee Machine Menu ===");
        System.out.println("1. Select drink type");
        System.out.println("2. View machine status");
        System.out.println("3. Adjust ingredients");
        System.out.println("4. Enter maintenance mode");
        System.out.println("5. Resume operation");
        System.out.println("6. Drink list made");
        System.out.println("7. Turn off");
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

        controller.makeCoffee(option); // Captura a resposta e Exibe a resposta
//        System.out.println(result); // Exibe a resposta
    }

    public void adjustIngredients() {
            int waterQuantity = InputValidator.readValidInteger(sc, "\nEnter the amount of water to be refilled\n");
            if (waterQuantity >= 0) {
                controller.addWater(waterQuantity);
            } else {
                controller.removeWater(waterQuantity);
            }

            int coffeeQuantity = InputValidator.readValidInteger(sc, "\nEnter the amount of coffee to be refilled\n");
            if (coffeeQuantity >= 0) {
                controller.addCoffee(coffeeQuantity);
            } else {
                controller.removeCoffee(coffeeQuantity);
            }

            int milkQuantity = InputValidator.readValidInteger(sc, "\nEnter the amount of milk to be refilled\n");
            if (milkQuantity >= 0) {
                controller.addMilk(milkQuantity);
            } else {
                controller.removeMilk(milkQuantity);
            }
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

    public void showDrinkList() {
        controller.showDrinkList();
    }

}
