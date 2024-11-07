public class Main {
    public static void main(String[] args) {
        int[][] A = {{12, 2, 4},
                     {10, 1, 1}};

        int[][] B = {{2, 2},
                     {1, 2},
                     {1, 1}};

        multiplyMatrix(A, B);
    }

    private static void multiplyMatrix(int[][] firstArray, int[][] secondArray) {
        if (firstArray.length != secondArray[0].length)
            throw new BadInput("Mismatched dimensions of matrix");

        int[][] results = new int[firstArray.length][secondArray[0].length];

        for (int row = 0; row < firstArray.length; row++)
            for (int column = 0; column < secondArray[0].length; column++)
                for (int i = 0; i < firstArray[0].length; i++)
                    results[row][column] += firstArray[row][i] * secondArray[i][column];

        for (int[] row: results) {
            System.out.print("| ");
            for (int element : row)
                System.out.print(element + " ");

            System.out.println(" |");
        }
    }

    static class BadInput extends RuntimeException {
        public BadInput(String message) {
            super(message);
        }
    }
}