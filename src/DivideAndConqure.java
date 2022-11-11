import java.util.Arrays;

public class DivideAndConqure {
    public static void main(String[] args) {
        int width = 1680;
        int height = 640;
        System.out.println("Largest square = " + biggestSquare(width,height));

        int[]arr={12, 24, 55, 0, 99, -3, 88, 30};
        System.out.println("Sum array: " + sumArray(arr));

        System.out.println("Max in array: " + maxInArr(arr));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int element = 30;
        System.out.println("Binary search for " + element + " : " + binarySearch(arr, element, 0, arr.length-1)[0] );
    }

    public static int biggestSquare(int side1, int side2){
        int height = Math.min(side1, side2);
        int width = Math.max(side1, side2);
        int newHeigth = width % height;
        if (newHeigth == 0){
            return height;
        }
        int newWidth = height;
        return biggestSquare(newWidth, newHeigth);
    }

    public static int sumArray(int [] arr){
        if (arr.length == 1){
            return arr[0];
        }
        return arr[arr.length-1] + sumArray(Arrays.copyOf(arr, arr.length-1));
    }

    public static int maxInArr(int[] arr){
        if (arr.length == 1){
            return arr[0];
        }
        return Math.max(arr[arr.length-1], maxInArr(Arrays.copyOf(arr, arr.length-1)));
    }

    public static int[] binarySearch(int[] arr, int element, int low, int high){
        if (low >= high){
            if (arr[low] == element){
                return new int[]{low};
            } else {
                return null;
            }
        }
        int mid = (low + high)/2;
        if (element == arr[mid]){
            return new int[]{mid};
        } else if (element < arr[mid]) {
            high = mid;
        } else {
            low = mid;
        }
        return binarySearch(arr, element, low, high);
    }

}
