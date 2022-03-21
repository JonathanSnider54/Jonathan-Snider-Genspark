package additionalQuestions;

import java.util.HashMap;

public class BiggestBinarySubarray {
    //int[] binaryArray={0,0,0,1,0,1,0,0,0,1,1,1,0,1,1};
    public static int[] biggestSubArray(int[] binaryArray)
    {
        HashMap<Integer,Integer> subArrayValue=new HashMap<>();
        subArrayValue.put(0,-1);
        int[] answerArray = {0, -1};
        int runningTotal = 0;
        int maxLengthFound=0;
        for (int i = 0; i < binaryArray.length; i++)
        {
            if (binaryArray[i] == 0)
            {
                runningTotal--;
            }
            else
            {
                runningTotal++;
            }

            if(subArrayValue.containsKey(runningTotal))
            {
                if (maxLengthFound < i - subArrayValue.get(runningTotal))
                {
                    maxLengthFound = i - subArrayValue.get(runningTotal);
                    answerArray[1] = i;
                }
            }
            else
            {
                subArrayValue.put(runningTotal,i);
            }
        }
        if(answerArray[1]!=-1)
        {
            answerArray[0]=answerArray[1]-maxLengthFound+1;
        }
        return answerArray;
    }

}
