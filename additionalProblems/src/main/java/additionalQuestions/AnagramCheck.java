package additionalQuestions;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramCheck {
    public static Boolean compareWord(String word1,String word2)
    {
        if(word1.length()!=word2.length())
        {
            return false;
        }
        List<Character> word1List=word1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> word2List=word2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.sort(word1List);
        Collections.sort(word2List);
        if(word1List.equals(word2List))
        {
            return true;
        }
        return false;
    }
}
