package RandomArray;

public class RandomArray {
    static final int MAX_INDEX = 10;
    public static void main(String[] args) {
        int[][] a = new int[MAX_INDEX][MAX_INDEX];
        //用于数组初始化
        int value = 0;
        int temp;
        int row, column;

        for(int i = 0; i < MAX_INDEX; i++)
            for(int j = 0; j < MAX_INDEX; j++) {
                a[i][j] = value;
                value++;
            }

        for(int i = 0; i < MAX_INDEX; i++) {
            for(int j = 0; j < MAX_INDEX; j++) {
                row = (int)(Math.random() * MAX_INDEX);
                column = (int)(Math.random() * MAX_INDEX);
                temp = a[i][j];
                a[i][j] = a[row][column];
                a[row][column] = temp;
            }
        }

        System.out.println("The content of array a is: ");
        for(int i = 0; i < MAX_INDEX; i++) {
            for(int j = 0; j < MAX_INDEX; j++)
                System.out.printf("%4d",a[i][j]);
            System.out.println();
        }
    }
}
