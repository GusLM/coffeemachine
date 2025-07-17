package service;

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


    public String makeCoffee(int drinkType) {
        if (coffeeMachine.getStatus() != MachineStatus.READY) {
            return "Máquina não está pronta para uso";
        }

        CoffeeDrink drink = createDrink(drinkType);

        if (!hasIngredients(drink)) return "Ingredientes insuficientes para " + drink.getName();

        consumeResources(drink);
        updateStatusAfterUse();

        return "Seu " + drink.getName() + " está pronto!";
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

    public void refillWater(int waterQuantity) {
        coffeeMachine.addWater(waterQuantity);
    }

    public void refillCoffee(int coffeeQuantity) {
        coffeeMachine.addCoffee(coffeeQuantity);
    }

    public void refillMilk(int milkQuantity) {
        coffeeMachine.addMilk(milkQuantity);
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
            default -> throw new IllegalArgumentException("Unknown coffee type.");
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
