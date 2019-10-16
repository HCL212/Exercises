/* Zero Matrix: Write an algorithm such that if an element 
 * in an MxN matrix is 0, it's entire row and column are set to 0
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
class exercise { 
   
    void setZeros(int[][] matrix){
        // use two arrays to keep track of all the rows with zeros
        // and all columns ith zeros
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        
        // rows + cols are used unintuitively
        // rows = the position in THAT row
        // cols = the position in THAT column
        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i])
                nullifyRow(matrix, i);
        }

        // Nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j])
                nullifyColumn(matrix, j);
        }
    }

    // nullifies the column of that row position
    void nullifyRow(int[][] matrix, int row){
        for (int j = 0; j < matrix[0].length; j++){
            matrix[row][j] = 0;
        }
    }

    // nullifies the row of that column position
    void nullifyColumn(int[][] matrix, int col){
        for (int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
    }
} 


