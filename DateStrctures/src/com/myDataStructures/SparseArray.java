package com.myDataStructures;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个11*11二维数组
        //0表示没有棋子，1--黑，2--白
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //原始的二维数组
        for (int[] row:chessArr) {
           for(int date: row) {
               System.out.printf("%d\t",date);
           }
            System.out.println();
        }
        //确定有多少个元素sum
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                if(chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);
        //创建新的数组sparseArr 第一行
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //sparseArr 其余行
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                if(chessArr[i][j] != 0) {
                    count++;
                   sparseArr[count][0] = i;
                   sparseArr[count][1] = j;
                   sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();
        //将稀疏数组恢复为原始的二维数组
        //创建二维数组
        int chessArray2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //读取稀疏数组后几行数据，赋给原始二维数组
        for (int i =1; i < sparseArr.length; i++) {
            chessArray2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int row[]:chessArray2) {
            for (int date:row) {
                System.out.printf("%d\t",date);
            }
            System.out.println();
        }


    }

}
