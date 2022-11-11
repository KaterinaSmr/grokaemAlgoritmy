public class SortingSelection {
    public static void main(String[] args) {

    }

    public static <T extends Comparable<? super T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int minPos = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j].compareTo(array[minPos]) < 0) {
                    minPos = j;
                }
            }
            T saveValue = array[minPos];
            array[minPos] = array[i];
            array[i] = saveValue;
        }
    }
}
