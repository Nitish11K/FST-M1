package Activities;

import java.util.Arrays;

public class Activity4 {
    static void ascendingSort(int array[]) {
        int size = array.length, i;
        
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }   
    

    public static void main(String[] args) {
        int[] narr = {3,5,2,7,1,4};
        System.out.println("Before Sorting: " + Arrays.toString(narr));
        ascendingSort(narr);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(narr));

    }
}

