package contains_HAHA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Language L is a set of all strings over alphabets {H, A} such that a string contains at least one HAHA
//        Regular Expression: (HA)*HAHA(HA)*
        int[][] tbl = {
                {1, 0}, //q0
                {1, 2}, //q1
                {3, 0}, //q2
                {1, 4}, //q3
                {4, 4}  //q4
        };
        int state = 0;  //starting state
        int i = 0;      //starting index of the string
        int col = 0;

        Scanner sc = new Scanner(System.in);
        String str;

        System.out.print("Enter a string: ");
        str = sc.nextLine();

        while(i < str.length()){
            // get column where H = 0 and A = 1
            switch(str.charAt(i)){
                case 'H':
                    col = 0; break;
                case 'A':
                    col = 1; break;
                default:
                    state = -1;
                    break;
            }
            if (state == -1) { //dead state
//                System.out.println(state);
                break;
            }

//                to see the current states
//            if (i < str.length()-1) System.out.print(state + " -> ");
//            else System.out.println(state);

            state = tbl[state][col];
            i++;
        }

        if (state == 4) System.out.println("String Accepted");
        else System.out.println("String Rejected");

    }
}
