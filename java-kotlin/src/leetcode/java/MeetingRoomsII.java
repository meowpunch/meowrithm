package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {

  /*

     ----
        ----------
              ----------
  */
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(m -> m[0]));

    var pq = new PriorityQueue<Integer>();

    int numOfMeetingRooms = 0;
    for (int[] interval: intervals) {
      int str = interval[0];
      var end = interval[1];

      if (pq.isEmpty()) {
        pq.offer(end);
        continue;
      }

      if (pq.peek() <= str) {
        pq.poll();
        pq.offer(end);
      }
    }


    return pq.size();
  }
}
