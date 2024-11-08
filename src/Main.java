import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Enter number of rows for first matrix");
            Scanner userInput = new Scanner(System.in);
            int rowOneInput = userInput.nextInt();

            System.out.println("Enter number of columns for first matrix");
            int columnOneInput = userInput.nextInt();
            int[][] matrixOne = new int[rowOneInput][columnOneInput];

            // for inserting elements into matrix
            System.out.println("Enter matrix elements one row at a time: ");
            for (int i = 0; i < matrixOne.length; i++)
                for (int j = 0; j < matrixOne[0].length; j++)
                    matrixOne[i][j] = userInput.nextInt();

            System.out.println("Enter number of rows for second matrix");
            Scanner input = new Scanner(System.in);
            int rowTwoInput = input.nextInt();

            System.out.println("Enter number of columns for second matrix");
            int columnTwoInput = input.nextInt();
            int[][] matrixTwo = new int[rowTwoInput][columnTwoInput];

            // for inserting elements into matrix
            System.out.println("Enter matrix elements one row at a time: ");
            for (int i = 0; i < matrixTwo.length; i++)
                for (int j = 0; j < matrixTwo[0].length; j++)
                    matrixTwo[i][j] = userInput.nextInt();


            System.out.println("First matrix " +  Arrays.deepToString(matrixOne));
            System.out.println("Second matrix " + Arrays.deepToString(matrixTwo));
            multiplyMatrix(matrixOne, matrixTwo);

        } catch (InputMismatchException exception) {
            System.out.println("Enter valid elements only");
        }
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