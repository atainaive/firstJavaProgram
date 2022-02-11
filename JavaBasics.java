import java.util.Scanner;

/**
 * Atai Omorov, Itfuc-20, 20201750
 */
public class JavaBasics {
    public static void main(String[] args) {
        int a = 0, b = 0, n, m;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Your surname: ");
        String surname = scanner.nextLine();

        n = name.length();
        m = surname.length();

        System.out.println("\nRows: " + n + "\nColumns: " + m + "\n");

        //3. initializing the array
        int[][] myArray = new int[n][m];

        //4.Filling the array with random numbers a,b;
        // number of vowels
        for (int i = 0; i < n; i++) {
            if (name.charAt(i) == 'a' || name.charAt(i) == 'e' || name.charAt(i) == 'i'
                    || name.charAt(i) == 'o' || name.charAt(i) == 'u') a++;
        }

        b = n + m;

        for (int i = 0; i < n; i++) { //rows
            for (int j = 0; j < m; j++) {//cols
                myArray[i][j] = getRandomNumber(a, b);
            }
        }

        for (int i = 0; i < n; i++) { //rows
            for (int j = 0; j < m; j++) {//cols
                if (i == 0 && j == 0) {
                    System.out.print(" ");
                } else if (i == 0 && j != 0) {
                    System.out.print(" " + (j - 1));
                } else if (j == 0 && i != 0) {
                    System.out.print((i - 1));
                } else {
                    System.out.print(" " + myArray[i - 1][j - 1]);
                }
            }
            System.out.println();
        }


        //5. Creating two 2d arrays with the averages of cols and rows.
        float[] avgCols = new float[m];
        double[] avgRows = new double[n];

        //calculate an average of cols and storing them
        for (int i = 0; i < m; i++) {
            float sumCols = 0f;
            float avg;
            for (int j = 0; j < n; j++) {
                sumCols += myArray[j][i];
            }
            avg = sumCols / n;
            avgCols[i] = avg;
        }

        //calculate an average of rows and storing them
        for (int i = 0; i < n; i++) {
            float sumRows = 0f;
            float avg;
            for (int j = 0; j < m; j++) {
                sumRows += myArray[i][j];
            }
            avg = sumRows / m;
            avgRows[i] = avg;
        }

        // printing arrays
        System.out.println("\nArray with average of columns: ");

        for (int i = 0; i < m; i++) {
            System.out.printf("%.4f", avgCols[i]);
            System.out.print(" ");
        }

        System.out.println("\nArray with average of rows: ");

        for (int i = 0; i < n; i++) {
            System.out.printf("%.4f", avgRows[i]);
            System.out.print(" ");
        }

        //6. comparing variables of avgRows to the values of each line of main array
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (myArray[i][j] > avgRows[i]) {
                    count++;
                }
            }
        }

        System.out.println("\n\nNumber of values that are greater than the average: " + count + "\n");

        //7.finding max value of an array
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (i == a) continue;
            for (int j = 0; j < m; j++) {
                if (j == a) continue;
                else if (myArray[i][j] > max) {
                    max = myArray[i][j];
                }
            }
        }

        System.out.println("Max value of 2d array: " + max);

        //8. Make a copy of array for row number and printing it
        int[] copyArr = myArray[a];

        for (int i = 0; i < a; i++) {
            copyArr[i] = myArray[a][i];
        }

        //sorting array with Bubble sort
        for (int i = 0; i < a - 1; i++) {
            if (copyArr[i] > copyArr[i + 1]) {
                int temp = copyArr[i];
                copyArr[i] = copyArr[i + 1];
                copyArr[i + 1] = temp;
            }
        }

        System.out.println("\nValues of copied array:");
        for (int i = 0; i < a; i++) {
            System.out.print(copyArr[i] + " ");
        }

        //9. get column avg array and find the min value --> get index of that one --> go to main 2D array and in column of that index find min value
        float minF = avgCols[0];
        int min = (int) minF;


        for (int i = 0; i < m; i++) {
            if (min < avgCols[i]) {
                min = i;
            }
        }

        System.out.println("\n\nThe index of min value of the column average array: " + min);

        int minArr = myArray[0][min];

        for (int i = 0; i < n; i++) {
            if (myArray[i][min] < minArr) {
                minArr = myArray[i][min];
            }
        }

        System.out.println("The index of min value of the main array in index column: " + minArr);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
