import java.util.HashMap;

public class WordsTable {
    public static int dictionarySize;
    Object[][] WordsTable;
    public Object[][] generageWordsTable(HashMap dictionary){
        dictionarySize = dictionary.size();
        WordsTable = new Object[dictionarySize][3];

        int i =0;
        for (Object key : dictionary.keySet()){
            WordsTable[i][0]= key;
            i++;
        }

        i=0;
        for(Object value : dictionary.values()){
            WordsTable[i][1] = value;
            i++;
        }


        for(int j =0;j < dictionarySize;j++){
            Boolean check = false;
            WordsTable[j][2] = check;
        }

        return WordsTable;
    }

    public static int getDictionarySize(){
        return dictionarySize;
    }

    public Object getRusWord(int index){
        Object word = WordsTable[index][0];

        return word;
    }

    public Object getEngWord(int index){
        Object word = WordsTable[index][1];

        return word;
    }

    public boolean getWordMark(int number){
        Boolean wordMark = false;
        wordMark = (Boolean) WordsTable[number][2];
        return wordMark;
    }

    public void setWordMark (int number){
        Boolean falseBool = true;
        WordsTable[number][2] = falseBool;

    }
}
