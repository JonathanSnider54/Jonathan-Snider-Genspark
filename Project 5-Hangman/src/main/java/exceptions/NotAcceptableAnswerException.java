package exceptions;

public class NotAcceptableAnswerException extends Exception{


    public static void NotAcceptableAnswerReason(String currentAnswer) throws NotAcceptableAnswerException {
        if(currentAnswer.length()>1)
        {

            if(!currentAnswer.matches("[a-zA-Z]+"))
            {
                throw new NotAcceptableAnswerException("this answer was longer than one character AND it contains non-letter items");
            }
        }
        else if (!currentAnswer.matches("[a-zA-Z]+"))
        {
            throw new NotAcceptableAnswerException("this answer was the correct length but the character was a non-letter item");
        }
        else
        {
            throw new NotAcceptableAnswerException("I don't know what you did wrong, you just did something wrong");
        }


    }
    public NotAcceptableAnswerException(String reason) {
        super(reason);
    }
}
