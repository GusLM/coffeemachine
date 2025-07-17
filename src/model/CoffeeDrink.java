package model;

public class CoffeeDrink {
    private String name;
    private int waterMlRequired;
    private int coffeeGramsRequired;
    private int milkMlRequired;

    public CoffeeDrink(String name, int waterMlRequired, int coffeeGrams, int milkMlRequired) {
        this.name = name;
        this.waterMlRequired = waterMlRequired;
        this.coffeeGramsRequired = coffeeGrams;
        this.milkMlRequired = milkMlRequired;
    }

    public String getName() {
        return name;
    }

    public int getWaterMlRequired() {
        return waterMlRequired;
    }

    public int getMilkMlRequired() {
        return milkMlRequired;
    }

    public int getCoffeeGramsRequired() {
        return coffeeGramsRequired;
    }

//    public final void BlackCoffee() {
//        name = "Black Coffee";
//        waterMlRequired = 150;
//        coffeeGramsRequired = 10;
//        milkMlRequired = 0;
//    }
//
//    public final void Latte() {
//        name = "Latte";
//        waterMlRequired = 30;
//        coffeeGramsRequired = 7;
//        milkMlRequired = 200;
//    }
//
//    public final void Macchiato() {
//        name = "Macchiato";
//        waterMlRequired = 30;
//        coffeeGramsRequired = 7;
//        milkMlRequired = 20;
//    }
//
//    public final void CafeAuLait() {
//        name = "Café au Lait";
//        waterMlRequired = 100;
//        coffeeGramsRequired = 10;
//        milkMlRequired = 100;
//    }
//
//    public final void LongBlack() {
//        name = "Long Black";
//        waterMlRequired = 150;
//        coffeeGramsRequired = 7;
//        milkMlRequired = 0;
//    }
//
//    public final void FlatWhite() {
//        name = "Flat White";
//        waterMlRequired = 30;
//        coffeeGramsRequired = 7;
//        milkMlRequired = 150;
//    }

}
