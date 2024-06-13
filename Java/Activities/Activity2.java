package Activities;

import java.util.Arrays;

public class Activity2 {
    public static void main (String[] args){
        int[] numArray = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(numArray));
        
        int srchNum = 10;
        int fxdSum = 30;

        //Print result
        System.out.println("Result: " + result(numArray, srchNum, fxdSum));
    }
    public static boolean result(int[] numbers, int srchNum, int fxdSum) {
        int temp_sum = 0;
        //Loop through array
        for (int number : numbers) {
            //If value is 10
            if (number == srchNum) {
                //Add them
                temp_sum += srchNum;
            }

            //Sum should not be more than 30
            if (temp_sum > fxdSum) {
                break;
            }
        }

        //Return true if condition satisfies
        return temp_sum == fxdSum;
    }
}
