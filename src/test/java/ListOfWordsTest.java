import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ListOfWordsTest {

    private ListOfWords listOfWords;
    private Map<String, List<String>> exceptedMap;

    @Before
    public void beforeTest() { listOfWords = new ListOfWords();
        exceptedMap = new HashMap<>(); }

    @Test

    public void addingFirstWords() {

         String s1 ="b";
         List<String> list1 = new ArrayList<>();
         list1.add("b");
        exceptedMap.put("a",list1);
        listOfWords.addNewPairOfWords("a", "b");

        assertTrue(exceptedMap.equals(listOfWords.getMapOfWords()));


    }

    @Test
    public void addingTheSameWords() {

        String s1 ="b";
        List<String> list1 = new ArrayList<>();
        list1.add("b");
        list1.add("b");
        exceptedMap.put("a",list1);
        listOfWords.addNewPairOfWords("a", "b");
        listOfWords.addNewPairOfWords("a", "b");


        assertTrue(exceptedMap.equals(listOfWords.getMapOfWords()));
   }

   @Test
   public void addingDiffrentFirstWord(){
       String s1 ="b";
       List<String> list1 = new ArrayList<>();
       list1.add("b");
       List<String> list2 = new ArrayList<>();
       list2.add("b");
       exceptedMap.put("a",list1);
       exceptedMap.put("c",list1);

       listOfWords.addNewPairOfWords("a", "b");
       listOfWords.addNewPairOfWords("c", "b");


       assertTrue(exceptedMap.equals(listOfWords.getMapOfWords()));
   }

    @Test
    public void addingDiffrentSecondWord(){
        String s1 ="b";
        List<String> list1 = new ArrayList<>();
        list1.add("b");
        list1.add("c");
        exceptedMap.put("a",list1);

        listOfWords.addNewPairOfWords("a", "b");
        listOfWords.addNewPairOfWords("a", "c");


        assertTrue(exceptedMap.equals(listOfWords.getMapOfWords()));
    }

    @Test
    public void returnWords(){
        listOfWords.addNewPairOfWords("a", "b");
        listOfWords.addNewPairOfWords("a", "c");
        listOfWords.addNewPairOfWords("a", "d");
        listOfWords.addNewPairOfWords("e", "f");
        listOfWords.addNewPairOfWords("e", "g");
        listOfWords.addNewPairOfWords("e", "h");

        for(int i=0;i<100; i++){
            String s1 = listOfWords.getWord("a");

            if(s1.equals("b") || s1.equals("c") || s1.equals("d")){}
            else { fail("Something is worng");}
        }

        for(int i=0;i<100; i++){
            String s1 = listOfWords.getWord("e");

            if(s1.equals("f") || s1.equals("g") || s1.equals("h")){}
            else { fail("Something is worng");}
        }

    }

@After
    public void afterTest() {listOfWords.getMapOfWords().clear();
    exceptedMap.clear();}




    }
