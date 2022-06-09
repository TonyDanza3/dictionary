import com.jayway.jsonpath.*;
import net.minidev.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public  class DictionaryBuilder {

    String dictionary;
    public  void readJsonDictionary() throws Exception {
        String file = "src/main/java/dictionary.json";
        dictionary = readFileAsString(file);
    }
    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }




    public void returnDictionary(){
        try {
            readJsonDictionary();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int sectionsCount = countSections();
        //countwords
        int[] wordsCount = countWords();
        //countTranslations
        //
    }

    public int countSections (){
        int sections = 0;
        sections = JsonPath.read(dictionary,"$['sections'].size()");
        return sections;
    }

    public int[] countWords (){
        int sectionsCount = JsonPath.read(dictionary,"$['sections'].size()");
        int [] wordsCount = new int[sectionsCount];
        for(int i=0;i < sectionsCount; i++){
            wordsCount[i] = JsonPath.read(dictionary,"$['sections'][" + i + "].['content'].size()");
        }
        return wordsCount;
    }

    public int countTranslations(String word){
        int translations = 0;

        return translations;
    }
}