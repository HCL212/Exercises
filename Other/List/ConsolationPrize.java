/* Consolation Prize: Determine how many prizes will be given out if
 * int k determines the last place to get a prize
 *
 * EXAMPLE:
 * [100, 90, 90, 80, 60, 20] = Rank 1, 2, 2, 4, 5, 6
 * if k = 2 then 3 prizes would be given out
 * if k = 3 then 3 prizes would be given out
 * if k = 4 then 4 prizes would be given out
 * if k = 5 then 5 prizes would be given out
 *
 * [100, 80, 80, 60, 60, 30] = Rank 1, 2, 2, 4, 4, 6
 * if k = 2 then 3 prizes would be given out
 * if k = 3 then 3 prizes would be given out
 * if k = 4 then 5 prizes would be given out
 * if k = 5 then 5 prizes would be given out
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
class exercise { 
    
    int consolationPrizes (int k, List<Integer> marks) {
        if (marks.isEmpty()){
            System.out.println(0);
            return 0;
        }
        
        Collections.sort(marks);
        Collections.reverse(marks);
        
        int prizes = 0;
        int currRank = 0;
        int prevMark = marks.get(0);

        for (int i = 0; i < marks.size(); i++){
            currRank++;
            if (currRank <= k || marks.get(i) == prevMark)
                prizes++;
            // need to break the loop otherwise it goes to the end and
            // additional prizes will be added if there are dupes after
            else
                break;
            prevMark = marks.get(i);
        }

        System.out.println(marks);
        System.out.println("int k = " + k);
        System.out.println(prizes);               
        return prizes; 
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();

        List<Integer> list1 = Arrays.asList(100, 90, 90, 60, 80, 20);
        List<Integer> list2 = Arrays.asList(80, 60, 100, 80, 30, 60);
        List<Integer> list3 = Arrays.asList(80, 40, 100, 40, 80, 80, 20, 100, 40, 100);
        List<Integer> list4 = Arrays.asList();

        System.out.println("List1");
        test.consolationPrizes(2, list1); // output 3
        test.consolationPrizes(3, list1); // output 3
        test.consolationPrizes(4, list1); // output 4
        test.consolationPrizes(5, list1); // output 5

        System.out.println("List2");
        test.consolationPrizes(2, list2); // output 3
        test.consolationPrizes(3, list2); // output 3
        test.consolationPrizes(4, list2); // output 5
        test.consolationPrizes(5, list2); // output 5

        System.out.println("List3");
        test.consolationPrizes(2, list3); // output 3
        test.consolationPrizes(3, list3); // output 3
        test.consolationPrizes(4, list3); // output 6
        test.consolationPrizes(5, list3); // output 6
        test.consolationPrizes(7, list3); // output 9

        System.out.println("Empty List");
        test.consolationPrizes(2, list4); // output 0;
     }
}  



