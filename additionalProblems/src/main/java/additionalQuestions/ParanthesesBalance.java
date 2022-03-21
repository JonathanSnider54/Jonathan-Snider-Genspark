package additionalQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class ParanthesesBalance {

    public static boolean checkParanthesesBalance(String stringToCheck)
    {

        Map<Character,Character> paranPairs=new HashMap<>();
        paranPairs.put('(',')');
        paranPairs.put('[',']');
        paranPairs.put('{','}');
        if(stringToCheck.length()%2!=0 || stringToCheck.length()==0|| !paranPairs.containsKey(stringToCheck.charAt(0)) || !paranPairs.containsValue(stringToCheck.charAt(stringToCheck.length()-1)))
        {
            return false;
        }

        for (int i = 0; i < stringToCheck.length(); i=i+2)
        {
            if(stringToCheck.charAt(i+1)!=paranPairs.get(stringToCheck.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
}
