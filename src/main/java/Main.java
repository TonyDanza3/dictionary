import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main (String []args){
        Checker checker = new Checker();
        HashMap dictionary = Dictionary.returnDitionary();
        WordsTable wordsTable = new WordsTable();
        wordsTable.generageWordsTable(dictionary);
        int dictionarySize = dictionary.size() - 1;
        Scanner sc = new Scanner(System.in);

        boolean wordsIsOver = false;
        while (!wordsIsOver){
            int i = RandomGenerator.generateIntFromZeroTo(dictionarySize);
            while (wordsTable.getWordMark(i)==true){
                i = RandomGenerator.generateIntFromZeroTo(dictionarySize);
                if(!checker.remainingWords(wordsTable)){
                    break;
                }
            }

            String rusWord = (String) wordsTable.getRusWord(i);
            String engWord = (String) wordsTable.getEngWord(i);
            System.out.print(rusWord + ": ");
            String userInput =sc.nextLine();
            boolean isRight =checker.checkTranslation(userInput,engWord);
            if(!isRight){
                System.out.print("\u274C");
            }
            if(isRight){
                System.out.print("\u2713");
            }
            wordsTable.setWordMark(i);
            if(!checker.remainingWords(wordsTable)){
                wordsIsOver = true;
                System.out.println("");
                System.out.println("That's all the words from dictionary. Exiting =)");
            }
            System.out.println("");

        }

    }
}
