import com.jayway.jsonpath.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public  class DictionaryBuilder {

    String dictionary;
    public  void extractDataFromJsonFile() throws Exception {
        String file = "src/main/java/dictionary.json";
        dictionary = readFileAsString(file);
    }
    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public void returnDictionary(){
        try {
            extractDataFromJsonFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int sectionsCount = countSections();
        //countwords
        int[][] wordsCount = countWordsInEverySection(sectionsCount);
        //countTranslations
        //
    }

    public int countSections (){
        int sections = 0;
        sections = JsonPath.read(dictionary,"$['sections'].size()");
        return sections;
    }

    public int[][] countWordsInEverySection(int sectionsCount){
        int [][] wordsCount = new int[sectionsCount][1];
        for(int i=0;i < sectionsCount; i++){
            wordsCount[i][0] = JsonPath.read(dictionary,"$['sections'][" + i + "].['content'].size()");
        }
        return wordsCount;
    }

    public int countTranslations(int [][] wordsInEverySection){
        int translations = 0;
//        int sectionsCount = countSections();
//        int [] wordsCount = countWordsInEverySection();
//        int [][][] translationsCount = new int[][][];


        return translations;
    }
}