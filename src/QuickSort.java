import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = random.ints(20, -100, 100).toArray();
//        System.out.println(Arrays.toString(arr));

        int[]arr1= {-67, -99, 87, -85, 71, -28, -22, 22, 78, 37, 3, 54, 6, -19, -84, 71, 39, -31, -62, 99};

        System.out.println(Arrays.toString(qSort(arr1)));

    }

    public static int[] qSort(int[] arr){
        if (arr.length < 2){
            return arr;
        }
        int pivotPos = arr.length-1;
        for (int i = 0; i < pivotPos;) {
            if (arr[i] > arr[pivotPos]){
                int temp = arr[i];
                arr[i] = arr[pivotPos-1];
                arr[pivotPos-1] = arr[pivotPos];
                arr[pivotPos] = temp;
                pivotPos--;
            } else {
                i++;
            }
        }
        int[] lessArray = Arrays.copyOf(arr, pivotPos);
        int[] biggerArray;
        if (pivotPos < arr.length) {
            biggerArray = Arrays.copyOfRange(arr, pivotPos + 1, arr.length);
        } else {
            biggerArray=new int[]{};
        }
        System.out.println("Less " + Arrays.toString(lessArray));
        System.out.println("Bigger " + Arrays.toString(biggerArray));

        return concatArrays(qSort(lessArray), qSort(biggerArray), arr[pivotPos]);
    }

    public static int[] concatArrays(int[] less, int [] bigger, int pivot){
        int newArrLength = less.length + bigger.length + 1;
        int[] newArr = new int[newArrLength];
        System.arraycopy(less, 0, newArr, 0, less.length);
        System.arraycopy(bigger, 0, newArr, less.length + 1, bigger.length);
        newArr[less.length] = pivot;
        return newArr;

    }

}
