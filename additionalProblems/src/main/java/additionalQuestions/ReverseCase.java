package additionalQuestions;

public class ReverseCase {

    public static String reverseCase(String word)
    {
        char[] charArray=word.toCharArray();
        for(int i=0;i< charArray.length;i++)
        {
            Character c=charArray[i];
            if(Character.isUpperCase(c))
            {
                charArray[i] = Character.toLowerCase(c);
            }
            else
            {
                charArray[i] = Character.toUpperCase(c);
            }
        }
        return String.valueOf(charArray);
    }
}
