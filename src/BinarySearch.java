import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {45,88,90,12,-4,33,-46,10,0,11,12,67,-3,-22,99};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 10));
    }

    public static int binarySearch(int [] arr, int number){
        int low = 0;
        int high = arr.length-1;
        int mid;
        while (low <= high){
            mid = (low + high)/2;
            if(arr[mid] == number){
                return mid;
            }
            if (number < arr[mid]){
                high = mid;
            } else {
                low = mid;
            }
        }
        return -1;
    }
}
