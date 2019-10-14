/* Rotate Matrix: Given an image represented by an NxN matrix, where each
 * pixel in the image is 4 bytes, write a method to rotate the image by 90
 * degrees (clockwisie).  Can you do this in place?
 *
 * Current solution time complexity = O(n^2), any algorithm must touch all
 */

import java.util.*; 
  
class exercise { 
   
    // perform a swap on each layer, starting from 
    // the outermost and working inwards.
    boolean rotate(int[][] matrix){
        // check for invalid matrix
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return false;

        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++){
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // saved top -> right

                /*  ________________________
                 * |                       | 
                 * | 0,0 | 0,1 | 0,2 | 0,3 |
                 * | 1,0 | 1,1 | 1,2 | 1,3 |
                 * | 2,0 | 2,1 | 2,2 | 2,3 |
                 * | 3,0 | 3,1 | 3,2 | 3,3 |
                 * |_______________________|
                 * 
                 * first layer
                 * save 0,0
                 * 0,0 gets 3,0
                 * 3,0 gets 3,3
                 * 3,3 gets 0,3
                 * 0, 3 gets saved 0,0
                 *
                 * save 0,1
                 * 0,1 gets 2,0
                 * 2,0 gets 3,2
                 * 3,2 gets 1,3
                 * 1,3 gets saved 0,1
                 *
                 * etc...
                 */
            }
        }

        return true;
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
    }
} 


