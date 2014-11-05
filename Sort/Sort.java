package Sort;

import java.util.Arrays;

/**
 * 选择排序和插入排序获得降序数组
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = { 9, 4, 1, 8, 6, 5, 3, 2, 7, 0 };
        int[] b = { 5, 4, 6, 1, 5, 9, 8, 7, 2, 3 };

        selectionSort(a);
        insertionSort(b);
    }

    public static void selectionSort(int[] a) {
        System.out.println("This is selection sort: \n" + "original: " + Arrays.toString(a));
        int j, currentMaxIndex;

        for(int i = 0; i < a.length - 1; i++) {
            currentMaxIndex = i;

            for(j = i + 1; j < a.length; j++) {
                if(a[j] > a[currentMaxIndex])
                    currentMaxIndex = j;
            }
            
            if(currentMaxIndex != i) {
                int temp = a[currentMaxIndex];
                a[currentMaxIndex] = a[i];
                a[i] = temp;
            }
        }

        System.out.println("result:   " + Arrays.toString(a));
    }

    public static void insertionSort(int[] a) {
        System.out.println("This is insertion sort: \n" + "original: " + Arrays.toString(a));
        int j, currentMax;

        for(int i = 1; i < a.length; i++) {
            currentMax = a[i];
            for(j = i - 1; j >= 0 && a[j] < currentMax; j--)
                a[j + 1] = a[j];

            a[j + 1] = currentMax;
        }

        System.out.println("result:   " + Arrays.toString(a));
    }
}
