package service;

import exceptions.InsufficientIngredientsException;
import exceptions.InvalidCoffeeSelectionException;
import exceptions.MaintenanceModeActiveException;
import exceptions.NotReadyStatusException;
import model.CoffeeDrink;
import model.CoffeeMachine;
import model.MachineStatus;
import model.MachineStatusReport;

public class CoffeeService {

    private final CoffeeMachine coffeeMachine;

    public CoffeeService( CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public MachineStatusReport getMachineStatus() {
        return new MachineStatusReport(
                coffeeMachine.getWaterLevel(),
                coffeeMachine.getCoffeeGrams(),
                coffeeMachine.getMilkLevel(),
                coffeeMachine.getStatus()
        );
    }


    public void makeCoffee(int drinkType) {
        try {
            if (coffeeMachine.getStatus() != MachineStatus.READY && coffeeMachine.getStatus() != MachineStatus.MAINTENANCE) {
                throw new NotReadyStatusException(
                        "The machine is not ready for use. Set the status to 'READY'."
                );
            }
            if (coffeeMachine.getStatus() == MachineStatus.MAINTENANCE) {
                throw new MaintenanceModeActiveException(
                        "The machine is in maintenance mode."
                );
            }

            CoffeeDrink drink = createDrink(drinkType);

            if (!hasIngredients(drink)) {
                throw new InsufficientIngredientsException(drink);
            }

            consumeResources(drink);
            updateStatusAfterUse();

            System.out.println("\nYour " + drink.getName() + " is ready!");

        } catch (NotReadyStatusException
                | MaintenanceModeActiveException
                | InvalidCoffeeSelectionException
                | InsufficientIngredientsException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    public boolean hasIngredients(CoffeeDrink drink) {
        return coffeeMachine.getWaterLevel() >= drink.getWaterMlRequired()
                && coffeeMachine.getMilkLevel() >= drink.getMilkMlRequired()
                && coffeeMachine.getCoffeeGrams() >= drink.getCoffeeGramsRequired();
    }

    public void consumeResources(CoffeeDrink drink) {
        coffeeMachine.setWaterQuantity(coffeeMachine.getWaterLevel() - drink.getWaterMlRequired());
        coffeeMachine.setCoffeeGrams(coffeeMachine.getCoffeeGrams() - drink.getCoffeeGramsRequired());
        coffeeMachine.setMilkQuantity(coffeeMachine.getMilkLevel() - drink.getMilkMlRequired());
    }

    public void addWater(int waterQuantity) {
        coffeeMachine.addWater(waterQuantity);
    }

    public void addCoffee(int coffeeQuantity) {
        coffeeMachine.addCoffee(coffeeQuantity);
    }

    public void addMilk(int milkQuantity) {
        coffeeMachine.addMilk(milkQuantity);
    }

    public void removeWater(int waterQuantity) {
        coffeeMachine.removeWater(waterQuantity);
    }

    public void removeCoffee(int coffeeQuantity) {
        coffeeMachine.removeCoffee(coffeeQuantity);
    }

    public void removeMilk(int milkQuantity) {
        coffeeMachine.removeMilk(milkQuantity);
    }

    // Método auxiliar para atualizar o status da máquina após o uso.
    public void updateStatusAfterUse() {
        boolean waterLack = coffeeMachine.getWaterLevel() < getMinWaterRequirement();
        boolean coffeeLack = coffeeMachine.getCoffeeGrams() < getMinCoffeeRequirement();

        if (waterLack || coffeeLack) {
            coffeeMachine.setStatus(MachineStatus.INSUFFICIENT_RESOURCES);
        } else {
            coffeeMachine.setStatus(MachineStatus.READY);
        }
    }

    public void setMachineStatus(MachineStatus status) {
        coffeeMachine.setStatus(status);
    }

    private CoffeeDrink createDrink(int drinkType) {
        return switch (drinkType) {
            case 1 -> new CoffeeDrink("Black Coffee", 150, 10, 0);
            case 2 -> new CoffeeDrink("Latte", 30, 7, 200);
            case 3 -> new CoffeeDrink("Macchiato", 30, 7, 20);
            case 4 -> new CoffeeDrink("Café au Lait", 100, 10, 100);
            case 5 -> new CoffeeDrink("Long Black", 150, 7, 0);
            case 6 -> new CoffeeDrink("Flat White", 30, 7, 150);
            default -> throw new InvalidCoffeeSelectionException("Invalid coffee type.");
        };
    }

    /*
    Esses métodos ajudam a definir os valores mínimos para alertar o usuário.
    Não foi criado variável com valor mínimo para o leite, pois existem tipos de café que não utilizam o leite na sua composição.
     */
    private int getMinWaterRequirement() {
        return 30; // base mínima para o tipo de café que menos utiliza água.
    }

    private int getMinCoffeeRequirement() {
        return 5; // base mínima para o tipo de café que menos utiliza gramas de café.
    }

}
