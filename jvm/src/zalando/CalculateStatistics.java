package zalando;

// you can also use imports, for example:
import java.util.*;


class Statistic {
    Double average;
    Integer totalNumber;

    Statistic(Double average, Integer totalNumber) {
        // TODO :average -> totalExecutionTIme more better
        this.average = average;
        this.totalNumber = totalNumber;
    }

    Double getAverage() {
        return this.average;
    }

    Integer getTotalNumber() {
        return this.totalNumber;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "average=" + average +
                ", totalNumber=" + totalNumber +
                '}';
    }
}

public class CalculateStatistics {
    /**
     *
     * HashMap
     *      Key - Method name e.g. "Method_A"
     *      Value - Statistic {
     average: 1.5, -> totalExecutionTime
     totalNumber: 2,
     }

     Stack<String>
     e.g. "{timestamp};{methodName}" - "0;Method_A"

     */
    private static void solution(String[] input) {
        // init
        final Map<String, Statistic> mem = new HashMap<>();
        final Stack<String> stk = new Stack<>();

        // iterate
        for (String line : input) {
            // manipulate string
            final String[] s = line.split(";");
            // Enter or Exit
            final String t = s[0];
            final String o = s[1];

            // determine whether Enter or Exit
            if (o.equals("Enter")) {
                // case of Enter
                final String n = s[2];
                // "{timestamp};{methodName}"
                final String sd = String.format("%s;%s", t, n);
                stk.add(sd);
            } else {
                // case of Exit
                final String[] sd = stk.pop().split(";");
                // TODO: need to parseDouble
                final Double executionTime = Double.parseDouble(t) - Double.parseDouble(sd[0]);
                final String methodName = sd[1];

                final Statistic st = mem.getOrDefault(methodName, null);
                if (st == null) {
                    mem.put(methodName, new Statistic(executionTime, 1));
                } else {


                    // calculate average
                    final Integer newNum = st.getTotalNumber() + 1;
                    final Double newAvg = ((st.getAverage() * st.getTotalNumber()) + executionTime) / newNum.doubleValue();

                    mem.put(methodName, new Statistic(newAvg, newNum));
                    //  (prevAvg * prevNum + executiontime) / (prevNum + 1)
                }
            }



        }


        // output
        System.out.println(mem);
    }



    public static void main(String [] args) {
        String[] input = {
                "0;Enter;Method_A",
                "10;Enter;Method_B",
                "15;Exit",
                "17;Exit",
                "18;Enter;Method_C",
                "22;Exit",
                "23;Enter;Method_B",
                "25;Enter;Method_A",
                "31;Exit",
                "33;Exit"
        };
        solution(input);

    }
}