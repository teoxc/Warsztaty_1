import java.util.Scanner;

public class zgadywanie2 {
    public static void main(String[] args) {
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w maksymalnie 10 próbach");
        int min = 0, max = 1000;
        String answer = "";
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        int guess;
        while(!answer.equals("zgadles")) {
            guess = (max - min) / 2 + min;
            System.out.println("Zgaduję: " + guess);
            System.out.print("Dobrze? (duzo/malo/zgadles):  ");
            answer = scan.nextLine();
            System.out.println();
            if (answer.equals("duzo")) {
                max = guess;
            } else if (answer.equals("malo")) {
                min = guess;
            } else if (answer.equals("zgadles")) {
                System.out.println("Wygralem!");
            } else
                System.out.println("Oszukujesz");
        }
    }
}
