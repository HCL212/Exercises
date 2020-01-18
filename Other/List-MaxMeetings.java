import java.util.*; 
  
public class exercise { 
    
public static int countMeetings(List<Integer> arrival, List<Integer> departure) {
    if (arrival.isEmpty() || departure.isEmpty()){
        return 0;
    }

    int maxMeetings = 0;
    Set<Integer> booked = new HashSet<>();

    // books time slots according to first come first serve
    // need to optimize time slots for maximum meetings
    for (int i = 0; i < arrival.size(); i++){
        for (int j = departure.get(i); j >= arrival.get(i); j--){
            if (!booked.contains(j)){
                maxMeetings++;
                booked.add(j);
                break;
            }
        }
    }

    return maxMeetings;
}
  
    public static void main(String args[]) { 
        exercise test = new exercise();

        List<Integer> arrive = new ArrayList<Integer>(Arrays.asList(1, 3, 3, 4));
        List<Integer> leave = new ArrayList<Integer>(Arrays.asList(1, 9, 3, 5));
        
        System.out.println(test.countMeetings(arrive, leave));
    }
} 
