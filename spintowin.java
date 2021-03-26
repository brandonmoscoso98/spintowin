package Spring2021;
import java.util.Random;
import  java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class spintowin{

    public static int getTotal( List <Integer> ls ) {
        int total = 0;
        for( int num: ls) {
            total += num;
        }

        return total;
    }

    public static boolean fortune(int range ) {

        List <Integer> evenList = new <Integer>ArrayList();
        List <Integer> oddList  = new <Integer>ArrayList();

        //generating random number
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        for( int i = 0; i< range; i++) {
            int num = random.nextInt( range );
            //check the number is even or odd
            if ( num%2==0 ) {
                evenList.add( num );
            }else {
                oddList.add( num );
            }
        }

        //get total for even
        int evenTotal = getTotal( evenList );
        //get total for odd
        int oddTotal = getTotal( oddList );

        //check the winner
        String winner = "";
        if( evenTotal > oddTotal) {
            winner = "even";
        }else {
            winner = "odd";
        }

        //validate user input
        System.out.println("Enter Your Guess: " );
        String userGuess = scan.next();
        if(userGuess.equalsIgnoreCase(winner) ) {
            System.out.println( "Congrats! you win " );
            return true;
        }else {
            System.out.println( "Better Luck next time. " );
            return false;
        }

    }

    public static void main( String[]args) {

        //limit
        int userLimit = 1000;
        int winLimit  = 10000;

        //keep track of user profit and loss
        //to start how much money each user will have
        int gain = 0;

        //user input virtual money
        Scanner scan = new Scanner(System.in);

        //keep playing the game unless user indicate stop
        boolean play = true;
        while( play && (userLimit >= 0 && gain <= winLimit ) ) {

            System.out.println("Enter How Much You Want to Win");
            int vMoney = scan.nextInt();

            //validate user input

            boolean isWin = fortune( vMoney );
            if ( isWin ) {
                gain += vMoney;
            }else {
                gain -= vMoney;
            }

            System.out.println("Do you want to play again?");
            String userChoice = scan.next();
            if( userChoice.equalsIgnoreCase("no")){
                play = false;
            }

            userLimit = userLimit - vMoney;

        }

        //how much money user gain or loss
        System.out.println("You gain: "+ gain);

    }

}
