package algos;

public class NumberOfIslands {
    public static void main(String[] args){
        int[][] a = {{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,0}};
        int islands = 0;
        int rowCount = a.length;
        int columnCount = a[0].length;
        int[][] b = new int[rowCount][columnCount];
        for(int i = 0; i < rowCount; i++){
            for(int  j = 0; j < columnCount; j++) {
                if(a[i][j] == 1){
                    if(i > 0){
                        if(a[i-1][j] == 1) {
                            b[i][j] = b[i-1][j];
                            continue;
                        }
                    }
                    if(j > 0){
                        if(a[i][j-1] == 1) {
                            b[i][j] = b[i][j-1];
                            continue;
                        }
                    }
                    islands++;
                    b[i][j] = islands;
                }
            }
        }

        System.out.println(b);
    }
}
