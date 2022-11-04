package com.company;
import java.util.*;

class Main {
    static int max(int queue[],int length)
    {
        int maxvalue=queue[0];
        for (int i=1;i<length;i++)
            if (queue[i]>maxvalue)
                maxvalue=queue[i];
        return maxvalue;
    }

    static void countSort(int queue[],int length,int k) //this method is used for doing counting sort
    {
        int sortedarray[] = new int[length]; //creates an alternative array with length as the index
        int i;
        int temp[] = new int[10]; //sets a temporary value for the seconday data structure for count sort

        Arrays.fill(temp,0); //sets all indexes of array to 0

        for (i=0;i<length;i++) // fills temp array with
            temp[(queue[i]/k)%10]++; //mod 10

        for (i=1;i<10;i++)
            temp[i]+=temp[i-1]; //decreases value by 1 for alternative distribution data structure

        for (i=length-1;i>=0;i--) // sort array
        {
            sortedarray[temp[(queue[i]/k)%10]-1]=queue[i]; //whatever result of s/k mod 10 - 1 in your array
            temp[(queue[i]/k)%10]--; //decreases temp value in alt array
        }
        for (i=0;i<length;i++) //transfers data from array to array
            queue[i]=sortedarray[i];
    }

    static void sortArray(int array[],int length) // this method is main function
    {
        int max = max(array, length); //calling find max method
        for (int k=1;max/k >0;k*=10)
            countSort(array, length,k);
    }

    static void printSortedArray(int array[],int length)
    {
        for (int i=0;i<length;i++)
            if(length==i) {
                System.out.print(array[i]);
            }
            else {
                System.out.print(array[i] + ",");
            }
    }

    public static void main(String[] args) //main function actual starts here
    {
        //function path sortArray --> max --> countSort --> printSortedArray
        int[] arrayToSort ={1700,78,21,190,1802,24,200,6600,800,9000};
        int length=arrayToSort.length;
        sortArray(arrayToSort,length); //calls sortmain
        printSortedArray(arrayToSort,length);//calls printSortedArray method
    }

}
