/* Excel Notation: Given a integer, print out the row and column.
 * Columns go from A -> ZZ (total of 702 columns)
 * Rows go from 1 -> 10^9
 *
 * EXAMPLE:
 * Input: 27
 * Output: 1AA
 *
 * Input: 703
 * Output: 2AA
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
class exercise { 
    
    String excelNotation (long n) {
        int input = (int) n; 
        int row = input/703 + 1;
        String r = Integer.toString(row);

        StringBuilder column = new StringBuilder();

        while (input > 0) {
            input -= 1;
            if (column.length() < 2){
                column.append((char) ('A' + input % 26));
            }
            input /= 26;
        }

        column.reverse();
        String c = column.toString();
        r += c;

        return r;
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();

        System.out.println(test.excelNotation(3)); // 1C
        System.out.println(test.excelNotation(27)); // 1AA
        System.out.println(test.excelNotation(702)); // 1ZZ
        System.out.println(test.excelNotation(703)); // 2AA
        System.out.println(test.excelNotation(905602)); // 1289PV (don't know if correct)
    }
} 



