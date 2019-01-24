package YandexOlymp;

import java.util.Random;

public class QuickSort {
    public static int[] mass;

    public static void main(String[] args) {
        mass = new int[10];

//        quickSort(0, 10, mass);
        for (int i = 0; i < 10; i++) {
            mass[i] = new Random().nextInt(30);
            System.out.print(mass[i] + " ");
        }
        System.out.println();
        recQuickSort(0, 9, mass);
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }

    }

    public static void recQuickSort(int left, int right, int[] mass) {
        if (right - left <= 0) {
            return;
        } else {
            long privot = mass[right];

            int partition = partitionIt(left, right, privot, mass);
            recQuickSort(left, partition - 1, mass);
            recQuickSort(partition + 1, right, mass);
        }
    }

    public static int partitionIt(int left, int right, long privot, int[] mass) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (mass[++leftPtr] < privot) ;
            while (rightPtr > 0 && mass[--rightPtr] > privot) ;

            if (leftPtr > rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr, mass);
            }
        }
        swap(leftPtr, rightPtr, mass);
        return leftPtr;
    }

    private static void swap(int left, int right, int[] mass) {
        int c = mass[left];
        mass[left] = mass[right];
        mass[right] = c;
    }
}
