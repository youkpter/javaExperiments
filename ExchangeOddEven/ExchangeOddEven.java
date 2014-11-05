package ExchangeOddEven;

public class ExchangeOddEven {
    public static void main(String[] args) {
        int[][] a = new int[6][5];
        for(int i = 0; i < 6; i++)
            for(int j = 0; j < 5; j++)
                a[i][j] = i + j;

        exchangeArray(a);
        displayArray(a);
    }

    public static void exchangeArray(int[][] a) {
        int temp;
        for(int i = 0; i < a.length - 1; i += 2) {
            for(int j = 0; j < a[i].length; j++) {
                temp = a[i][j];
                a[i][j] = a[i+1][j];
                a[i+1][j] = temp;
            }
        }
    }

    public static void displayArray(int[][] a) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 5; j++)
                System.out.print(a[i][j] + "  ");
            System.out.println();
        }
    }
}
