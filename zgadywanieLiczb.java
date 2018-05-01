import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class zgadywanieLiczb {
    public static void main(String[] args) {
        Random r = new Random();
        int number = r.nextInt(100)+1;
        //System.out.println("wylosowano: " + number);//temp
        boolean isGood = false;
        int guess=0;
        while(!isGood){
            try {
                System.out.print("Zgadnij liczbę od 1 do 100: ");
                Scanner scan = new Scanner(System.in);
                guess = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("To nie jest liczba!");
                continue;
            }
            if(guess == number){
                System.out.println("Zgadles!");
                isGood = true;
            }
            else if(guess > number){
                System.out.println("Za duzo!");
            }
            else if(guess < number){
                System.out.println("Za malo!");
            }
        }
    }
}
