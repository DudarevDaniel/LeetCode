package company.upwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstTask {

    public static void main(String[] args) {
        FirstTask main = new FirstTask();
        String solution = main.solution("Sat", 500);
        System.out.println(solution);
    }

    public String solution(String S, int K) {
        Map<String, Integer> dayOfWeekNumbers = new HashMap<>();
        dayOfWeekNumbers.put("Mon", 0);
        dayOfWeekNumbers.put("Tue", 1);
        dayOfWeekNumbers.put("Wed", 2);
        dayOfWeekNumbers.put("Thu", 3);
        dayOfWeekNumbers.put("Fri", 4);
        dayOfWeekNumbers.put("Sat", 5);
        dayOfWeekNumbers.put("Sun", 6);

        Map<Integer, String> dayOfWeeks = new HashMap<>();
        dayOfWeeks.put(0, "Mon");
        dayOfWeeks.put(1, "Tue");
        dayOfWeeks.put(2, "Wed");
        dayOfWeeks.put(3, "Thu");
        dayOfWeeks.put(4, "Fri");
        dayOfWeeks.put(5, "Sat");
        dayOfWeeks.put(6, "Sun");


        Integer currentDayIndex = dayOfWeekNumbers.get(S);
        if (currentDayIndex == null) {
            return S;
        }
        int dayIndex = (K + currentDayIndex) % 7;
        return dayOfWeeks.get(dayIndex);
    }

}
