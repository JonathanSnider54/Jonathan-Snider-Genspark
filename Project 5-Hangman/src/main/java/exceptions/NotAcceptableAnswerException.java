package exceptions;

public class NotAcceptableAnswerException extends Exception{


    public static String NotAcceptableAnswerReason(String currentAnswer) throws NotAcceptableAnswerException {
        if(currentAnswer.length()>1)
        {

            if(!currentAnswer.matches("[a-zA-Z]+"))
            {
                return "this answer was longer than one character AND it contains non-letter items";
            }
            else
            {
                return "this answer was longer than one character";
            }
        }
        else if (!currentAnswer.matches("[a-zA-Z]+"))
        {
            return "this answer was the correct length but the character was a non-letter item";
        }
            return "I don't know what you did wrong, you just did something wrong";



    }
    public NotAcceptableAnswerException(String reason) {
        super(reason);
    }
}
