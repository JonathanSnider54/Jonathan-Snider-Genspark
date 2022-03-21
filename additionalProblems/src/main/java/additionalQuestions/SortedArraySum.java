package additionalQuestions;

public class SortedArraySum {
    public static boolean twoSum(int[] sumArray, int numberToEqual)
    {
        int leftIndex=0;
        int rightIndex=sumArray.length-1;
        while(leftIndex<=rightIndex)
        {
            if(sumArray[leftIndex]+sumArray[rightIndex]==numberToEqual)
            {
                return true;
            }
            else if(sumArray[leftIndex]+sumArray[rightIndex]>numberToEqual)
            {
                rightIndex--;
            }
            else
            {
                leftIndex++;
            }
        }
        return false;
    }

}
