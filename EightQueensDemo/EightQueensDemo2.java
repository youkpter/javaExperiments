package EightQueensDemo;

/**
 * 输出八皇后问题的所有解
 * 总共92种解
 */
public class EightQueensDemo2 {
    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.findSolutions();
        System.out.printf("总共有%d种情况\n", eightQueens.getSolutionCount());
    }
}

class EightQueens {
    /**
     * 按顺序存储各行皇后的Y坐标
     * 也就相当于存储了各皇后的坐标
     */
    int[] queensYCoordinate = new int[8];
    private int k = 0;   //表示当前正在确定第k(0-7)个皇后
    private int solutionCount = 0; //解的个数

    public void findSolutions() {
        //给各皇后赋初值，表示皇后的位置还未确定
        for(int i = 0; i < 8; i++)
            queensYCoordinate[i] = -1;

        queensYCoordinate[0] = 0; //先假设第1个皇后的位置为(0,0)
        k = 1;  //相应地更新k值

        int y = 0;
        while(k >= 0) {
            /*
             * 如果是第一次确定(通过k+1行皇后的坐标判断)k行皇后位置,则从第一列开始查找
             * 否则接着上一次确定的位置进行
             */
            y = queensYCoordinate[k] == -1 ? 0 : queensYCoordinate[k] + 1; 
            queensYCoordinate[k] = -1; //清除掉上一次确定的k+1行皇后的坐标
            for(; y < 8; y++) {
                //如果第k行的皇后可以放在位置(k,y)
                if(IsValid(k, y, queensYCoordinate)) { 
                    queensYCoordinate[k] = y;
                    k++;
                    break;
                }
            }
            if(y == 8) { //该行无法放置皇后
                //回退，重新确定上一行皇后的位置
                k--;
            }
            
            if(k == 8) { //八个皇后都确定了位置
                printQueens();
                k--; //返回确定第7行下一个皇后位置
                solutionCount++;
            }
        }
    }

    /**
     * 判断该皇后的位置是否有效
     * @param k 皇后的x坐标
     * @param y 皇后的y坐标
     * @param queensYCoordinate 所有皇后的位置
     */
    public boolean IsValid(int k, int y, int[] queensYCoordinate) {
        //对于已经确定位置的所有皇后
        for(int j = 0; j < k; j++) {
            //如果当前位置与已确认皇后在同一列上
            if(y == queensYCoordinate[j])
                return false;
            //如果当前位置与已确认皇后在同一对角线上
            if(Math.abs(k - j) == Math.abs(y - queensYCoordinate[j]))
                return false;
        }
        return true;
    }

    /**
     * 输出各皇后的位置
     * @param queensYCoordinate 所有皇后的位置
     */
    public void displayQueens(int[] queensYCoordinate) {
        for(int i = 0; i < queensYCoordinate.length; i++) {
            for(int j = 0; j < queensYCoordinate.length; j++)
                System.out.print(j == queensYCoordinate[i] ? "|Q" : "| ");
            System.out.println("|");
        }
    }

    public void printQueens() {
        for(int i : queensYCoordinate)
            System.out.printf("%3d",i);
        System.out.println();
    }

    public int getSolutionCount() {
        return solutionCount;
    }
}
