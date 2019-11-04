/* Max Events: Given two lists, first is the time slots that companies arrive,
 * second is the duration of events, find the max # of events
 *
 * EXAMPLE:
 * [1, 3, 3, 5, 7] - arrival time
 * [2, 2, 1, 2, 1] - duration time
 * max = 4 events
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
class exercise { 
    
    int maxEvents (List<Integer> arrival, List<Integer> duration) {
        if (arrival.isEmpty() || duration.isEmpty())
            return 0;

        int maxEvents = 0;
        int nextTimeSlot = 0;
        int prevArrival = 0;

        for (int i = 0; i < arrival.size(); i++){
            if (arrival.get(i) == prevArrival){
                if (arrival.get(i) + duration.get(i) < nextTimeSlot){
                    nextTimeSlot = arrival.get(i) + duration.get(i);
                }
            }
            if (nextTimeSlot <= arrival.get(i)){
                maxEvents++;
            }
            nextTimeSlot = arrival.get(i) + duration.get(i);
            prevArrival = arrival.get(i);
        }
        
        return maxEvents;
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();

        List<Integer> arrivalList1 = Arrays.asList(1, 3, 3, 5, 7);
        List<Integer> durationList1 = Arrays.asList(2, 2, 1, 2, 1);

        System.out.println(test.maxEvents(arrivalList1, durationList1));
    }
} 



