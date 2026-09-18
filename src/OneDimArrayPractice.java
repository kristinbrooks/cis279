// OneDimArrayPractice.java
// Kristin Brooks
// creates an array of random integers and then get various info about it and sorts it, etc.

import java.util.Random;

public class OneDimArrayPractice {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int largestIndex; // index of the largest array element
        int largestValue; // the value of the largest array element
        int smallestIndex; // index of the smallest array element
        int smallestValue; // the value of the smallest array element
        int sum; // sum of the array elements
        double average; // the average of the array elements

        fillArrayWithRandom(numbers);
        displayArray(numbers);

        largestIndex = findHighestValue(numbers);
        largestValue = numbers[largestIndex];

        smallestIndex = findLowestValue(numbers);
        smallestValue = numbers[smallestIndex];

        sum = sumArrayElements(numbers);
        average = averageArrayElements(numbers);

        displayResults(largestIndex, largestValue, smallestIndex, smallestValue, sum, average);

        insertionSort(numbers);
        displayArray(numbers);

        System.out.println();
        System.out.println("krbrooks@mail.pima.edu");
    } // end of main

    public static void fillArrayWithRandom(int[] nums) {
        Random rand = new Random();
        for ( int i = 0; i < nums.length; i++ ) {
            nums[i] = rand.nextInt(200); // assign a random int to each element in the array
        }
    } // end of method fillArrayWithRandom

    public static int findHighestValue(int[] nums) {
        int highest = nums[0]; // first value in the array is the current highest
        int index = 0;
        for ( int i = 1; i < nums.length; i++) {
            if ( highest < nums[i] ) { // check if new value is higher than the current highest
                highest = nums[i]; // if it is it becomes the new highest
                index = i; // and we record its index
            }
        }
        return index;
    } // end of function findHighestValue

    public static int findLowestValue(int[] nums) {
        int lowest = nums[0]; // first value in the array is the current lowest
        int index = 0;
        for ( int i = 1; i < nums.length; i++) {
            if ( nums[i] < lowest ) { // check if the new value is lower than the current lowest
                lowest = nums[i]; // if it is it becomes the new lowest
                index = i; // and we record its index
            }
        }
        return index;
    } //end of function findLowestValue

    public static int sumArrayElements(int[] nums) {
        int total = 0;
        for ( int num : nums ) {
            total += num; // add each element to the total
        }
        return total;
    } // end of function sumArrayElements

    public static double averageArrayElements(int[] nums) {
        return (double)sumArrayElements(nums) / nums.length;
    } //end of function averageArrayElements

    public static void insertionSort(int[] nums) {
        for (int i =1; i < nums.length; i++) {
            int temp = nums[i]; // the item to be inserted
            int j = i - 1; // item at the end of the sorted list
            while ( j >= 0 && nums[j] > temp ) { // compare the items to see which is larger
                nums[j + 1] = nums[j]; // previous sorted is larger so we move it up
                j--; // move to next item left in the sorted list
            }
            nums[j + 1] = temp; // insert the current item in the empty space
        }
    } // end of method insertionSort

    public static void printSeparatorLine() {
        System.out.println("*".repeat(80));
        System.out.println();
    } // end of method printSeparatorLine

    public static void displayArray(int[] nums) {
        printSeparatorLine();
        System.out.println("Array Elements");
        System.out.println();
        printSeparatorLine();
        for ( int num : nums ) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
    } // end of method displayArray

    public static void displayResults(int highestIndex, int highestValue, int lowestIndex, int lowestValue, int sum, double average) {
        printSeparatorLine();
        System.out.println("Results of Array Processing");
        System.out.println();
        printSeparatorLine();
        System.out.println("The index of the highest value is " + highestIndex + ".");
        System.out.println();
        System.out.println("Its value is " + highestValue + ".");
        System.out.println();
        System.out.println("The index of the lowest value is " + lowestIndex + ".");
        System.out.println();
        System.out.println("Its value is " + lowestValue + ".");
        System.out.println();
        System.out.println("The sum of the array elements is " + sum + ".");
        System.out.println();
        System.out.printf("The average of the array elements is %.1f.%n", average);
        System.out.println();
    } //end of method displayResults
} // end of class OneDimArrayPractice
