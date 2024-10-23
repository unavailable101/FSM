package vending_machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Water Bottle Vending Machine
        // assuming that the water costs P20.00 and it only accepts coins

        int[][] tbl = new int[21][4]; //transition table

//        col1 = P1, col2 = P5, col3 = P10, col4 = P20
        for (int i=0; i<21; i++){
            tbl[i][0] = (i+1 >= 20) ? 20 : i+1;
            tbl[i][1] = (i+5 >= 20) ? 20 : i+5;
            tbl[i][2] = (i+10 >= 20) ? 20 : i+10;
            tbl[i][3] = 20;
        }

        int state = 0;
        int col = 0;

        int price = 20;     //price of the water

        Scanner sc = new Scanner(System.in);
        int money = 0;
        int change = 0;

        System.out.println("Insert coins (Enter x to stop): ");
        String input;

        do {
            input = sc.next();
            switch (input){
                case "1":
                    money += 1;
                    col = 0;
                    break;
                case "5":
                    money += 5;
                    col = 1;
                    break;
                case "10":
                    money += 10;
                    col = 2;
                    break;
                case "20":
                    money += 20;
                    col = 3;
                    break;
                case "x":
                    System.out.println("Processing...");
                    break;
                default:
                    System.out.println("There is no P" + input + " coin. Please insert coin again");
                    change = money;
                    money = -1;
                    break;
            }
            state = tbl[state][col];
            if (money == -1) state = -1;
        } while ( input.charAt(0) != 'x' && state != -1);

        if (state != -1) {
            System.out.println("Total: " + money);
            if (state != 20) {     //a condition where the money is insufficient to buy a single water bottle, meaning it didn't reach the final state
                System.out.println("Insufficient money");
                change += money;
            } else {
                System.out.print("Quantity of water bottle: ");
                int quantity = sc.nextInt();

                if (quantity * price > money) {
                    do {
                        System.out.println("Insufficient money");
                        System.out.print("Quantity of water bottle: ");
                        quantity = sc.nextInt();
                    } while (quantity * price > money);
                }

                change = money - (quantity * price);
                System.out.println("Change: P" + change);
            }
        }

//        giving change
//        assuming that this vending machine has unlimited coins

        int tblChange[][] = new int[6][5];  //transition table for the change
        int stateChange = 0;

        for (int i = 0; i<6; i++){
            for (int j = 0; j<5; j++){
                if (j+1 >= i) tblChange[i][j] = j+1;
                else tblChange[i][j] = -1;
            }
        }

        int twenty = 0;
        int ten = 0;
        int five = 0;
        int one = 0;

        while (change != 0){
            System.out.print(stateChange + " -> ");     //to see the states

            if (change >= 20){
                twenty++;
                change -= 20;
                stateChange = 1;
            } else if (change >= 10){
                ten++;
                change -= 10;
                stateChange = 2;
            } else if (change >= 5){
                five++;
                change -= 5;
                stateChange = 3;
            } else {
                one++;
                --change;
                stateChange = 4;
            }

            if (change <= 0) System.out.print(stateChange);
        }
        System.out.println();
        System.out.println("Twenty: " + twenty);
        System.out.println("Ten: " + ten);
        System.out.println("Five: " + five);
        System.out.println("One: " + one);
    }
}
