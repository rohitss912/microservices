public class PlayPit {

    public static void main(String[] args) {
        int[] arrInts = {1, 2, 3};

        int size = arrInts.length;

        for (int i = 0; i < (1 << size); ++i) {

            for (int j = 0; j < size; ++j) {
                int temp = (i & (1 << j));

                if (temp >= 1) {
                    System.out.print(arrInts[j] + " ");
                }
            }
            System.out.println();
        }


    }
}
