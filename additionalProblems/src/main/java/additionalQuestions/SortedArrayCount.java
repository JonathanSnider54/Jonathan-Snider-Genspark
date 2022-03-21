package additionalQuestions;

public class SortedArrayCount {
    public static int binarySearch(int[] occurenceArray, int numberToCount, boolean countingFromLeft) {
        // Please implement a function to find how many times a number occurs in a sorted array.
        //For instance, the output is 4 when the inputs are an array {1, 2, 3, 3, 3, 3, 4, 5} and the number 3 because 3 occurs 4 times in the given array.
        int currentIndexLeft = 0;
        int currentIndexRight = occurenceArray.length - 1;
        int occurence = -1;

        while (currentIndexLeft <= currentIndexRight) {
            int middleOfSubArray = (currentIndexLeft + currentIndexRight) / 2;
            if (numberToCount == occurenceArray[middleOfSubArray]) {
                occurence = middleOfSubArray;

                if (countingFromLeft)
                {
                    currentIndexRight = middleOfSubArray - 1;
                }
                else
                {
                    currentIndexLeft = middleOfSubArray + 1;
                }
            }
            else if (numberToCount<occurenceArray[middleOfSubArray])
            {
                currentIndexRight=middleOfSubArray-1;
            }
            else
            {
                currentIndexLeft=middleOfSubArray+1;
            }
        }
        return occurence;
    }


    public static int sortedCount(int[] occurenceArray, int numberToCount) {
        int firstOccurence = binarySearch(occurenceArray, numberToCount, true);
        int lastOccurence = binarySearch(occurenceArray, numberToCount, false);
        return lastOccurence - firstOccurence + 1;
    }
}
