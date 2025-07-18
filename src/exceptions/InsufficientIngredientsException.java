package exceptions;

import model.CoffeeDrink;

public class InsufficientIngredientsException extends RuntimeException {
    public InsufficientIngredientsException(CoffeeDrink drink) {
        super("Insufficient ingredients to make "
                + drink.getName()
                + "."
                + "\n"
                + "This drink needs: "
                + "Water " + drink.getWaterMlRequired() +"ml, "
                + "Coffee " + drink.getCoffeeGramsRequired() + "g, "
                + "Milk " + drink.getMilkMlRequired() + "ml.");
    }
}
