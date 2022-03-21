package additionalQuestions;

public class Palindrome {
    public static Boolean palindromeCheck(String word)
    {
        char[] charArray=word.toCharArray();
        for(int i=0;i<charArray.length-1;i++)
        {
            if(charArray[i]!=charArray[charArray.length-(i+1)])
            {
                return false;
            }
        }
        return true;
    }
}
