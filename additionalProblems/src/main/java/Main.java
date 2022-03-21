import additionalQuestions.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("---Parantheses check---");
        String parCheckStringBad = "[}[]()))}{{}{}";
        Boolean parCheckBad = ParanthesesBalance.checkParanthesesBalance(parCheckStringBad);
        System.out.println(parCheckStringBad+" : "+parCheckBad);
        String parCheckStringGood = "()(){}{}[]";
        Boolean parCheckGood = ParanthesesBalance.checkParanthesesBalance(parCheckStringGood);
        System.out.println(parCheckStringGood+" : "+parCheckGood);
        System.out.println("---Train station platforms---");
        float arr[] = {9.00f, 9.40f, 9.50f, 11.00f, 15.00f, 18.00f};
        float dep[] = {9.10f, 12.00f, 10.00f, 11.30f, 19.00f, 20.00f};
        int highestTrainsInStation = BusSchedule.maxPlatform(arr, dep);
        System.out.println(highestTrainsInStation);
        System.out.println("---binary subarray---");
        int[] binaryArray = {0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1};
        int[] binarySubArray = BiggestBinarySubarray.biggestSubArray(binaryArray);
        System.out.println(binarySubArray[0]);
        System.out.println(binarySubArray[1]);
        System.out.println("---anagram checker---");
        String badAnagram1 = "healthy";
        String badAnagram2 = "heartly";
        String goodAnagram1 = "fried";
        String goodAnagram2 = "fired";
        Boolean anagramCheckBad = AnagramCheck.compareWord(badAnagram1, badAnagram2);
        Boolean anagramCheckGood = AnagramCheck.compareWord(goodAnagram1, goodAnagram2);
        System.out.println(badAnagram1+" , "+badAnagram2+" : "+anagramCheckBad);
        System.out.println(goodAnagram1+" , "+goodAnagram2+" : "+anagramCheckGood);
        System.out.println("---reverse pair counter---");
        int[] reversedPairsArray={7, 5, 6, 4};
        int reversePairCount= ReversedPairs.reversedPairsCount(reversedPairsArray);
        System.out.println(reversePairCount);
        System.out.println("---sorted occurence counter---");
        int[] sortedArray = {1, 2, 3, 3, 3, 3, 4, 5};
        int numberToFind = 3;
        int occurenceCount = SortedArrayCount.sortedCount(sortedArray, numberToFind);
        System.out.println(occurenceCount);
        System.out.println("---2 item sum array---");
        int[] sumArrayGood={1, 2, 4, 7, 11, 15};
        int sumToGetGood=15;
        boolean sumTwoFoundGood= SortedArraySum.twoSum(sumArrayGood,sumToGetGood);
        System.out.println(sumTwoFoundGood);
        int[] sumArrayBad={1, 2, 4, 7, 11, 15};
        int sumToGetBad=36;
        boolean sumTwoFoundBad= SortedArraySum.twoSum(sumArrayBad,sumToGetBad);
        System.out.println(sumTwoFoundBad);
        System.out.println("---3 item sum 0 array---");
        int[] threeZeroSumGood = {0, -1, 9, -8, 16};
        boolean hasZeroSumGood=ThreeNumbersEqualZero.threeEqualZero(threeZeroSumGood);
        System.out.println(hasZeroSumGood);
        int[] threeZeroSumBad = {0, -35, 9, -17, 16};
        boolean hasZeroSumBad=ThreeNumbersEqualZero.threeEqualZero(threeZeroSumBad);
        System.out.println(hasZeroSumBad);
        System.out.println("---reverse casing---");
        String initialWord="Hello";
        String inversedCasing=ReverseCase.reverseCase(initialWord);
        System.out.println(initialWord+" , "+inversedCasing);
        System.out.println("---palindrome check---");
        String badPalindrome="panama";
        String goodPalindrome="kayak";
        boolean badPalindromeCheck=Palindrome.palindromeCheck(badPalindrome);
        boolean goodPalindromeCheck=Palindrome.palindromeCheck(goodPalindrome);
        System.out.println(badPalindrome+" : "+badPalindromeCheck);
        System.out.println(goodPalindrome+" : "+goodPalindromeCheck);
        System.out.println("---substring printer---");
        SubStringFinder.findSubStrings("abcde");
        System.out.println("---thread counting to 10---");
        MultithreadPrintHolder mtph=new MultithreadPrintHolder();
        Thread t1 = new Thread(new MultiThreadPrint(mtph, 0), "T1");
        Thread t2 = new Thread(new MultiThreadPrint(mtph, 1), "T2");
        Thread t3 = new Thread(new MultiThreadPrint(mtph, 2), "T3");
        t1.start();
        t2.start();
        t3.start();

    }
}

