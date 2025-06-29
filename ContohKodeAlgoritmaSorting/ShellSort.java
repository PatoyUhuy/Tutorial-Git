public class ShellSort {
    public void sort(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements arr[0..gap-1] are already in gapped order
            // keep adding one more element until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add arr[i] to the elements that have been gap sorted
                // save arr[i] in temp and make a hole at position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until the correct location for arr[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11};
        System.out.println("Original list (Shell Sort): " + java.util.Arrays.toString(data));

        ShellSort shs = new ShellSort();
        shs.sort(data);

        System.out.println("Sorted list (Shell Sort): " + java.util.Arrays.toString(data));
        System.out.println("------------------------------");
    }
}