package machine;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int cash = 550;

    public static void main(String[] args) {
//        System.out.println("Starting to make a coffee");
//        System.out.println("Grinding coffee beans");
//        System.out.println("Boiling water");
//        System.out.println("Mixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup");
//        System.out.println("Pouring some milk into the cup");
//        System.out.println("Coffee is ready!");

//     ====================================================

//        System.out.println("Write how many cups of coffee you will need: ");
//        Scanner scanner = new Scanner(System.in);
//        int cups = scanner.nextInt();
//        int water = cups * 200;
//        int milk = cups * 50;
//        int beans = cups * 15;
//
//        System.out.println("For " + cups + " cups of coffee you will need:");
//        System.out.println(water + " ml of water\n" +
//                milk +" ml of milk\n" +
//                beans +" g of coffee beans");

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Write how many ml of water the coffee machine has: ");
//        int water = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has: ");
//        int milk = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//        int beans = scanner.nextInt();
////        System.out.println("Write how many cups the coffee machine has: ");
////        int cups = scanner.nextInt();
//
//        System.out.println("Write how many cups of coffee you want: ");
//        int wantCups = scanner.nextInt();
//        int needWater = wantCups * 200;
//        int needMilk = wantCups * 50;
//        int needBeans = wantCups * 15;
//
//        int canMake = Integer.MAX_VALUE;
//        if (needWater != water) {
//            if (water / 200 < canMake) {
//                canMake = water / 200;
//            }
//        }
//        if (needMilk != milk) {
//            if (milk / 50 < canMake) {
//                canMake = milk / 50;
//            }
//        }
//        if (needBeans != beans) {
//            if (beans / 15 < canMake) {
//                canMake = beans / 15;
//            }
//        }
////        if (wantCups != cups) {
////            if (cups < canMake) {
////                canMake = cups;
////            }
////        }
//        if (canMake == wantCups) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (canMake > wantCups) {
//            System.out.println("Yes, I can make that amount of coffee (and even " + (canMake - wantCups) + " more than that)");
//        } else {
//            System.out.println("No, I can only make " + canMake + " cup(s) coffee");
//        }

//     ====================================================
//        double cash = 550;
//        int water = 400;
//        int milk = 540;
//        int beans = 120;
//        int cups = 9;
//        printStatus();
        choice();

    }

    public static boolean canMake(int needWater, int needMilk, int needBeans, int wantCups){
        int canMakeWater = Integer.MAX_VALUE;
        int canMakeMilk = Integer.MAX_VALUE;
        int canMakeBeans = Integer.MAX_VALUE;
        int canMakeCups = Integer.MAX_VALUE;
        boolean canMakeFlag = true;

        String shortResource = "";
        if (water <= needWater) {
            canMakeFlag = false;
            shortResource = "water";
        }

        if (milk <= needMilk) {
            canMakeFlag = false;
            shortResource = "milk";
        }

        if (beans <= needBeans) {
            canMakeFlag = false;
            shortResource = "beans";
        }

        if (cups <= wantCups) {
            canMakeFlag = false;
            shortResource = "cups";
        }

        if (canMakeFlag) {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else {
            System.out.println("Sorry, not enough " + shortResource);
            return false;
        }
    }

    public static void choice(){
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        Scanner choiceScanner = new Scanner(System.in);
        String choice = choiceScanner.nextLine();
        switch (choice){
            case "buy":
                buy();
                choice();
                break;
            case "fill":
                fill();
                choice();
                break;
            case "take":
                take();
                choice();
                break;
            case "remaining":
                printStatus();
                choice();
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }

    public static void fill(){
        Scanner fillScanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int fillWater = fillScanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int fillMilk = fillScanner.nextInt();
        System.out.println("Write how many grams of beans do you want to add:");
        int fillBeans = fillScanner.nextInt();
        System.out.println("Write how many disposable cups do you want to add:");
        int fillCups = fillScanner.nextInt();

        water += fillWater;
        milk += fillMilk;
        beans += fillBeans;
        cups += fillCups;
        System.out.println();
    }

    public static void buy(){
        Scanner buyScanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String orderUp = buyScanner.next();
        switch (orderUp){
            case "1":
                if (canMake(250, 0, 16, 1)) {
                    water -= 250;
                    beans -= 16;
                    cash += 4;
                    cups -= 1;
                }
                break;
            case "2":
                if (canMake(350, 75, 20, 1)) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cash += 7;
                    cups -= 1;
                }
                break;
            case "3":
                if (canMake(200, 100, 12, 1)) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cash += 6;
                    cups -= 1;
                }
                break;
            case "back":
                choice();
                break;
            default:
                System.out.println("I'm sorry I didn't understand that.");
                buy();
        }
    }

    public static void take(){
        System.out.println("I gave you $"+cash);
        cash = 0;
        System.out.println();
    }


    public static void printStatus(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cups + " of disposable cups\n$" +
                cash + " of money");
    }

}
