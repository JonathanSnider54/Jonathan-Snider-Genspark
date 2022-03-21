package additionalQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ThreeNumbersEqualZero {
    public static Boolean threeEqualZero(int[] arrayToCheck)
    {
        ArrayList<Integer> foundTwoSums=new ArrayList<>();
        //int[] threeZeroSumGood = {16, -1, 9, -8, 0};
        //int[] threeZeroSumBad = {0, -35, 9, -17, 16};
        for(int i=0;i<arrayToCheck.length-1;i++)
        {
            foundTwoSums.clear();
            for(int j=i+1;j< arrayToCheck.length;j++)
            {

                int currentTwoSum=-(arrayToCheck[i]+arrayToCheck[j]);

                if(foundTwoSums.contains(currentTwoSum))
                {
                   return true;
                }
                else
                {
                    foundTwoSums.add(arrayToCheck[j]);
                }
            }
        }
        return false;
    }
}
