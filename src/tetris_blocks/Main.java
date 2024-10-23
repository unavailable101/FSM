package tetris_blocks;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] tbl = {
                0,  //block drop
                1,  //block rotate -90 degrees
                2,  //block move down
                3,  //block move left
                4   //block move right
        };
        char[] tetrominoes = { 'I', 'O', 'T', 'L', 'J', 'S', 'Z'};
        int state = 0;

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Tetris Blocks Actions");
        char c;
        String str = null;

        do {
            System.out.println("Block: " + tetrominoes[rand.nextInt(tetrominoes.length)]);
            do {
                System.out.print("Key: ");
                c = sc.nextLine().charAt(0);
                switch (c) {
                    case 'w':   //arrow up
                        state = 1;
                        str = "rotate";
                        break;
                    case 's':   //arrow down
                        state = 2;
                        str = "move down";
                        break;
                    case 'a':   //arrow left
                        state = 3;
                        str = "move left";
                        break;
                    case 'd':   //arrow right
                        state = 4;
                        str = "move right";
                        break;
                    case ' ':   //spacebar
                        state = 0;
                        str = "drop block";
                        break;
                    case 'x':
                        System.out.println("Stop program...");
                        return;
                }
                System.out.println("State: " + state + " (" + str + ") ");
            } while (c != ' ');
        } while (true);
    }
}
