package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int availableWater = 400;
    static int availableMilk = 540;
    static int availableCoffeeBeans = 120;
    static int availableCups = 9;
    static int availableMoney = 550;
    static boolean powerOn = true;

    public static void main(String[] args) {
        /*System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");*/
        while (powerOn) {
            getUserAction();
        }
    }
    public static void printMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(availableWater + " of water");
        System.out.println(availableMilk + " of milk");
        System.out.println(availableCoffeeBeans + " of coffee beans");
        System.out.println(availableCups + " of disposable cups");
        System.out.println("$" + availableMoney + " of money\n");
    }

    public static void getUserAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();
        scanner.close();
        switch (action) {
            case "buy":
                sellCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                releaseMoney();
                break;
            case "remaining":
                printMachineStatus();
                break;
            case "exit":
                powerOn = false;
                break;
            default:
                break;
        }
    }

    public static void sellCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeSelection = scanner.next();
        scanner.close();
        makeACupOfCoffee(coffeeSelection);
    }

    public static void makeACupOfCoffee(String coffeeSelection) {
        switch (coffeeSelection) {
            case "1":
                makeACupOfEspresso();
                break;
            case "2":
                makeACupOfLate();
                break;
            case "3":
                makeACupOfCappuccino();
                break;
            /*case "back":
                getUserAction();
                break;*/
            default:
                break;
        }
    }
    private static void makeACupOfEspresso() {
        // Ingrediants for a cup of Espresso
        int waterPerAnEspressoCup = 250;
        int beansPerAnEspressoCup = 16;
        int pricePerAnEspressonCup = 4;
        // Make a cup of espresso by reducing available machine stock of ingredients and adding money
        if (hasEnoughIngrediants(waterPerAnEspressoCup, 0, beansPerAnEspressoCup)) {
            System.out.println("I have enough resources, making you a coffee!");
            availableWater -= waterPerAnEspressoCup;
            availableCoffeeBeans -= beansPerAnEspressoCup;
            availableCups -= 1;
            availableMoney += pricePerAnEspressonCup;
        } else {
            System.out.print("Sorry, not enough ");
            if (availableWater < waterPerAnEspressoCup) {
                System.out.println("water!");
            } else if (availableCoffeeBeans < beansPerAnEspressoCup) {
                System.out.println("coffee beans!");
            } else {
                System.out.println("cups!");
            }
        }

    }
    private static void makeACupOfLate() {
        // Ingrediants for a cup of Late
        int waterPerALateCup = 350;
        int milkPerALateCup = 75;
        int beansPerALateCup = 20;
        int pricePerALateCup = 7;
        // Make a cup of espresso by reducing available machine stock of ingredients and adding money
        if (hasEnoughIngrediants(waterPerALateCup, milkPerALateCup, beansPerALateCup)) {
            availableWater -= waterPerALateCup;
            availableMilk -= milkPerALateCup;
            availableCoffeeBeans -= beansPerALateCup;
            availableCups -= 1;
            availableMoney += pricePerALateCup;
        } else {
            System.out.print("Sorry, not enough ");
            if (availableWater < waterPerALateCup) {
                System.out.println("water!");
            } else if (availableMilk < milkPerALateCup) {
                System.out.println("milk!");
            } else if (availableCoffeeBeans < beansPerALateCup) {
                System.out.println("coffee beans!");
            } else {
                System.out.println("cups!");
            }
        }

    }
    private static void makeACupOfCappuccino() {
        // Ingrediants for a cup of Cappuccino
        int waterPerACappucinoCupc = 200;
        int milkPerACappucinoCupcup = 100;
        int beansPerACappucinoCupc = 12;
        int pricePerACappucinoCupc = 6;
        // Make a cup of espresso by reducing available machine stock of ingredients and adding money
        if (hasEnoughIngrediants(waterPerACappucinoCupc, milkPerACappucinoCupcup, beansPerACappucinoCupc)) {
            availableWater -= waterPerACappucinoCupc;
            availableMilk -= milkPerACappucinoCupcup;
            availableCoffeeBeans -= beansPerACappucinoCupc;
            availableCups -= 1;
            availableMoney += pricePerACappucinoCupc;
        } else {
            System.out.print("Sorry, not enough ");
            if (availableWater < waterPerACappucinoCupc) {
                System.out.println("water!");
            } else if (availableMilk < milkPerACappucinoCupcup) {
                System.out.println("milk!");
            } else if (availableCoffeeBeans < beansPerACappucinoCupc) {
                System.out.println("coffee beans!");
            } else {
                System.out.println("cups!");
            }
        }

    }

    public static void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        availableWater += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        availableMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        availableCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        availableCups += scanner.nextInt();
        scanner.close();
    }

    public static void releaseMoney() {
        System.out.println("I gave you " + availableMoney);
        availableMoney = 0;
    }

    public static boolean hasEnoughIngrediants (int requiredWater, int requiredMilk, int requiredBeans) {
        return (availableWater >= requiredWater && availableMilk >= requiredMilk
                && availableCoffeeBeans >= requiredBeans && availableCups >= 1);
    }
}
