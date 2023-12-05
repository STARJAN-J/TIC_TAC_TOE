package TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    //#region
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    static String player1;
    static String player2;

    static char[] board = new char[9];

    static int dupCount;

    static String tossWinner;

    static String winnigPlayer;

    static int player1WinningRounds_Count;
    static int player2WinningRounds_Count;
    //#endregion
    
    public static void main(String[] args) {  
        
        TicTacToe();
        
    }


    //#region
    public static void printMessage(String message){
        System.out.print(message);
    }
    
    public static int getInt(String message){
        printMessage(message);
        int value = sc.nextInt();
        return value;
    }
    
    public static String getstring(String message){
        printMessage(message);
        String text = sc.next();
        return text;
    }
    //#endregion

    public static void TicTacToe(){
        int rounds = getInt("\n\tHow many rounds are you ready to play?\n Enter rounds :  ");
        System.out.println("So your game contains "+rounds+" round.\n");
        int count = 0;
        getName();
        toss();
        while (count<rounds) {

            dupCount = count+1;
            System.out.println("\nRound : "+dupCount+" starts now \n");

            if (count>0) {
                toss();
            }

            for (int i = 0; i < board.length; i++) {
            // int value = 48+i;
            // char value1 = (char)value;
            board[i]=' ';
            }

            Board();

            playGame();    

            playerWinningRounds_Count();       

            count++;
        }

        if (player1WinningRounds_Count > player2WinningRounds_Count) System.out.println("\n* * * * * * * * * * * * * * * * "+player1+" Won the game. * * * * * * * * * * * * * * * *");
        else if(player2WinningRounds_Count > player1WinningRounds_Count) System.out.println("\n* * * * * * * * * * * * * * * * "+player2+ " Won the game. * * * * * * * * * * * * * * * *");
        else if(player1WinningRounds_Count == player2WinningRounds_Count) System.out.printf("\n* * * * * * * * * * * * * * * * %s abd %s : Your game is TIE. * * * * * * * * * * * * * * * *", player1, player2);
        System.out.println();

    }

    public static void playGame(){

        while (true) {
            getFirstPlayer();
            if (isValidMove()) {
                break;
            }
        }
    }

    public static void Board(){

        System.out.println(" +"+"---"+"+ "+" +"+"---"+"+ "+" +"+"---"+"+ ");
        for (int i = 0; i < board.length; i=i+3) {
            
            for (int j = i; j < i+3; j++) {
                if (j%3==0 && j!=0) {
                    System.out.print(" | "+board[j]+" | ");
                }
                else System.out.print(" | "+board[j]+" | ");
            }
            System.out.println();
            System.out.println(" +"+"---"+"+ "+" +"+"---"+"+ "+" +"+"---"+"+ ");       
        }
    }

    public static void getName(){
        player1 = getstring("Enter player '1' name : ");
        player2  = getstring("Enter player '2' name : ");
        System.out.println("\nPlayer 1 is : "+player1);
        System.out.println("Player 2 is : "+player2);
    }

    public static String toss(){

        int toss = getInt("\nWho play's first?\nHead or Tail\nEnter 0 for Head and 1 for Tail :  ");
        if (toss==0) {
            System.out.println("\n'"+player1+"' you won the toss for round"+dupCount+", so you get 'x'");
            System.out.println("'"+player2+"' you get 'o'");
            tossWinner = player1;
        }
        else if(toss==1) {
            System.out.println("\n'"+player2+"' you won the toss for round"+dupCount+", so you get 'x'");
            System.out.println("'"+player1+"' you get 'o'");
            tossWinner = player2;
        }
        else {
            System.out.println("\nYou are chossing the number for toss is wrong, ReEnter your choice");
            return toss();
        }
        return tossWinner;
    }

    public static void getInput(int place, char choice){
        switch (place) {
            case 0:
                board [place]=choice;
                break;
            case 1:
                board[place]=choice;
                break;
            case 2:
                board[place]=choice;
                break;
            case 3:
                board[place]=choice;
                break;
            case 4:
                board[place]=choice;
                break;
            case 5:
                board[place]=choice;
                break;
            case 6:
                board[place]=choice;
                break;
            case 7:
                board[place]=choice;
                break;
            case 8:
                board[place]=choice; 
                break;
            default:
                break;
        }
    }

    public static void getFirstPlayer(){
        if (tossWinner.equals(player1)) {
            if (isBoardEmpty()) {
                player1_turn();
            }
            if (isBoardEmpty()) {
                player2_turn();
            }
        }
        else if (tossWinner.equals(player2)) {
            if (isBoardEmpty()) {
                player2_turn();
            }
            if (isBoardEmpty()) {
                player1_turn();
            }
        } 
    }

    public static boolean isValidMove(){

        if (board[0]=='x' && board[1]=='x' && board[2]=='x' ||
            board[3]=='x' && board[4]=='x' && board[5]=='x' ||
            board[6]=='x' && board[7]=='x' && board[8]=='x' ||
            board[0]=='x' && board[3]=='x' && board[6]=='x' ||
            board[1]=='x' && board[4]=='x' && board[7]=='x' ||
            board[2]=='x' && board[5]=='x' && board[8]=='x' ||
            board[0]=='x' && board[4]=='x' && board[8]=='x' ||
            board[2]=='x' && board[4]=='x' && board[6]=='x') {
            winnigPlayer = tossWinner;
            System.out.println(tossWinner+" won the round no : "+dupCount);
            return true;
        }

        else if (board[0]==111 && board[1]==111 && board[2]==111 ||
            board[3]=='o' && board[4]=='o' && board[5]=='o' ||
            board[6]=='o' && board[7]=='o' && board[8]=='o' ||
            board[0]=='o' && board[3]=='o' && board[6]=='o' ||
            board[1]=='o' && board[4]=='o' && board[7]=='o' ||
            board[2]=='o' && board[5]=='o' && board[8]=='o' ||
            board[0]=='o' && board[4]=='o' && board[8]=='o' ||
            board[2]=='o' && board[4]=='o' && board[6]=='o') {
            if (tossWinner.equals(player1)) {
                winnigPlayer = player2;
                System.out.println(player2+" won the round no : "+dupCount);
            }
            else if (tossWinner.equals(player2)) {
                winnigPlayer = player1;
                System.out.println(player1+" won the round no : "+dupCount);
            } 
            return true;
        }
        else if (!(isBoardEmpty())){             
            System.out.printf("%s and %s : your match is tie in the round no : %d \n", player1, player2, dupCount);
            return true;            
        }
        return false;
    }

    public static boolean isBoardEmpty(){
        boolean boxEmpty = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i]==' ') {
                boxEmpty = true;
            }
        }
        return boxEmpty;
    }

    public static void player1_turn(){
        System.out.println("\n"+player1+" enter your choice 'x' | 'o' from place of 0 to 8");
        int place = getInt(player1+" enter place : ");

        if (isBoardEmpty()) {
            if (board[place]==' ') {
                if (tossWinner.equals(player1)) {
                    getInput(place, 'x');
                    }
                else getInput(place, 'o');
    
                Board();
            }
            else{
                System.out.println("'"+place + "' already exist, Try to input other place.");
                player1_turn();
            }
        }
        else{
            System.err.println();
        }
        
    }

    public static void player2_turn(){
        System.out.println("\n"+player2+" enter your choice 'x' | 'o' from place of 0 to 8");
        int place = getInt(player2+" enter place : ");
        
        if (isBoardEmpty()) {
            if (board[place]==' ') {
                if (tossWinner.equals(player2)) {
                    getInput(place, 'x');
                    }
                else getInput(place, 'o');
    
                Board();
            }
            else{
                System.out.println("'"+place + " already exist, Try to input other place.");
                player2_turn();
            }
        }
        else{
            System.out.println();
        }
    }
    
    public static void playerWinningRounds_Count(){
        if (winnigPlayer==player1) {
            player1WinningRounds_Count++;
        }
        else if (winnigPlayer==player2) {
            player2WinningRounds_Count++;
        }
    }
}
