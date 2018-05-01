import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        int[] guessNumbers = new int [6];
        System.out.println("Podaj 6 roznych liczb od 1 do 49");
        for (int i = 0; i < 6; i++){
            int temp;
            try{
                Scanner scan = new Scanner(System.in);
                temp = scan.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("To nie liczba!");
                i--;
                continue;
            }
            if(temp < 1 || temp > 49){
                System.out.println("Liczba nie należy do przedziału 1 - 49");
                i--;
            }
            else{
                boolean repeat = false;
                for (int j = 0; j < i; j++){
                    if(temp == guessNumbers[j]){
                        i--;
                        repeat = true;
                        break;
                    }
                }
                if(!repeat){
                    guessNumbers[i] = temp;
                }
            }
        }

        System.out.println("Twoje liczby:");
        Arrays.sort(guessNumbers);
        for (int i = 0; i < 6; i++)
            System.out.print(guessNumbers[i] + " ");

        int [] lottery = new int[6];
        Random r = new Random();
        for (int i = 0; i < 6; i++){
            int temp = r.nextInt(49)+1;
            boolean repeat = false;
            for (int j = 0; j < i; j++){
                if(temp == lottery[j]){
                    i--;
                    repeat = true;
                    break;
                }
            }
            if(!repeat){
                lottery[i] = temp;
            }
        }

        System.out.println("\nWylosowane liczby:");
        Arrays.sort(lottery);
        for (int i = 0; i < 6; i++)
            System.out.print(lottery[i] + " ");

        int hits = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (guessNumbers[i] == lottery[j]){
                    hits++;
                    break;
                }
            }
        }

        if (hits >= 3)
            System.out.println("\nTrafiłeś " + hits + " liczb");

    }//main
}
