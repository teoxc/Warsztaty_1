import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Szukajka_słow {
    public static void main(String[] args) {
        String link1 = "https://www.onet.pl/";
        String link2 = "http://www.gazeta.pl/0,0.html";
        String link3 = "https://www.wp.pl/";

        findWords(link1);
        findWords(link2);
        findWords(link3);

        String[] exludedWords = {"oraz", "ponieważ", "przynajmniej", "lub", "czy", "nie", "jak", "nad",
                "może", "jest","być", "też", "się"};

        filterWords(exludedWords);
    }


    public static void findWords (String link){
        Connection connect = Jsoup.connect(link);
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            try {     // zapis do pliku
                FileWriter out = new FileWriter("popular_words.txt", true);
                for (Element elem : links) {
                    StringTokenizer sToken = new StringTokenizer(elem.text().toLowerCase(), " ,.\"?!:;[]-'");
                    while (sToken.hasMoreTokens()) {
                        out.append(sToken.nextToken() + " ");
                    }
                }
                out.close();
            } catch (IOException ex) {
                System.out.println("Błąd zapisu do pliku.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void filterWords (String[] excludedWodrs){
        File file = new File("popular_words.txt"); // odczyt
        String line = "";
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }

        StringBuilder filteredWords = new StringBuilder();
        StringTokenizer strToken = new StringTokenizer(line); // filtrowanie
        while (strToken.hasMoreTokens()) {
            String word = strToken.nextToken();
            if (word.length() < 3)
                continue;
            boolean isExcluded = false;
            for(int i = 0; i < excludedWodrs.length; i++){
                if (excludedWodrs[i].equals(word)) {
                    isExcluded = true;
                    break;
                }
            }
            if (!isExcluded)
                filteredWords.append(word + " ");
        }
        try {     // zapis do pliku
            FileWriter out = new FileWriter("filtered_popular_words.txt", false);
            out.append(filteredWords.toString());
            out.close();
        } catch (IOException ex) {
            System.out.println("Błąd zapisu do pliku.");
        }
    }
}

