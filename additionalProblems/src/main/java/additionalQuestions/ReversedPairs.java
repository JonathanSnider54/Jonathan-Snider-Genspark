package additionalQuestions;

public class ReversedPairs {

    public static int reversedPairsCount(int[] countArray)
    {
            int reversePairCount = 0;
            for (int i = 0; i < countArray.length - 1; i++)
            {
                for (int j = i + 1; j < countArray.length; j++)
                {
                    if (countArray[i] > countArray[j])
                    {
                        reversePairCount++;
                    }
                }
            }
            return reversePairCount;


    }
}
