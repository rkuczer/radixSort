package com.company;
//HW4 Bonus - Created by Ryan Kuczer - 11/14/22
//To run code the package above may have to be deleted, this is from the fact that I wrote the code in the intellij IDE and was the command line prompt selected.
import java.util.*; //import java utilities

class Main {

    public static void main(String[] args) //main function actual program starts here
    {
        //function path sortArray --> max --> countSort --> printSortedArray

        int[] arrayToSort ={9111,20,30,200,100,62,666,6600,800,10}; //pre made array with values

        System.out.println("Array to sort is: " + Arrays.toString(arrayToSort));

        int length=arrayToSort.length; //sets the length variable to the length of arrayToSort

        organizeArray(arrayToSort,length); //calls sortmain with the arraytoSort premade array with corresponding length

        System.out.println("Sorted array is below.");
        printSortedArray(arrayToSort,length);//calls printSortedArray method
    }

    static int max(int queue[],int length) //static method that passes int array and int to find max num in initial array
    {
        int maxvalue=queue[0];//sets the first value to "max"

        for (int i=1;i<length;i++) //for loop that starts at 1 and iterates for the length of the list

            if (queue[i]>maxvalue) //sets queue value to max if it is greater than the previous max value
                maxvalue=queue[i];

        return maxvalue; //returns final max
    }

    static void organizeArray(int array[],int length) // this method is the main function
    {
        int max = max(array, length); //calling find max method with array and length as inputs from main function
        for (int k=1;max/k >0;k*=10) //calls count sort with k starting at 1 going till max/k is greater than 0
            //here *= multiplies a variable by the value of 10 and assigns the result to the variable
            countSort(array, length,k); //call the count sort method on the sorted array
    }

    static void countSort(int queue[],int length,int k) //this method is used for doing counting sort
    {
        int sortedarray[] = new int[length]; //creates an alternative array with length as the index
        int i;
        int temp[] = new int[10]; //sets a temporary value for the secondary data structure for count sort
        Arrays.fill(temp,0); //sets all indexes of array to 0

        for (i=0;i<length;i++) // fills temp array with the remainder
            temp[(queue[i]/k)%10]++; //mod 10 over k

        for (i=1;i<10;i++)// I is 10 since we know array size to be 10
            temp[i]+=temp[i-1]; //decreases value by 1 for alternative distribution data structure

        for (i=length-1;i>=0;i--) // sort array, value starts at n-1 element, stops when i >=0 and decrements
        {
            sortedarray[temp[(queue[i]/k)%10]-1]=queue[i]; //whatever result of s/k mod 10 - 1 in your array
            temp[(queue[i]/k)%10]--; //finds the remainder with the element in queue over k
        }
        for (i=0;i<length;i++) //transfers data from beginning queue array to final sorted array
            queue[i]=sortedarray[i];
    }

    static void printSortedArray(int array[],int length) //function that prints the sorted array
    {
        for (int i=0;i<10;i++) //i starts at 0, goes till i is < length of array

            if(i==9) { //since we know the array is going to be of size 10, i is being set to 9 since it is the end of the list. Can change 9 to "length" if it is of an unknown size input
                System.out.print(array[i] + ".");
            }
            else {
                System.out.print(array[i] + ",");
            }

    }



}
