package leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GetWatchedVideosByYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int userId, int level) {
        var friendsOfUser = getFriends(friends, userId, level, userId);
        // System.out.println(friendsOfUser);
        return watchedVideoByFriends(watchedVideos, friendsOfUser);
    }

    private int[] getFriends(int[][] friends, int id, int level, int originId) {
        var friendsInLevel = new ArrayList<Integer>();

        Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[friends.length];

        que.offer(new int[]{id, 0});
        visited[id] = true;

        while(!que.isEmpty()) {
            var curr = que.poll();
            int currId = curr[0];
            int currLevel = curr[1];

            if (currLevel == level) {
                friendsInLevel.add(currId);
            }

            for (int friend: friends[currId]) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    que.offer(new int[] {friend, currLevel + 1});
                }
            }
        }

        return friendsInLevel.stream().mapToInt(i -> i).toArray();
    }


    private List<String> watchedVideoByFriends(List<List<String>> watchedVideos, int[] friends) {
        var videoToCount = new HashMap<String, Integer>();

        for (var friend: friends) {
            var watchedVideosByFriend = new HashSet<String>(watchedVideos.get(friend));

            watchedVideosByFriend.forEach(
                    video -> {
                        var preCount = videoToCount.getOrDefault(video, 0);
                        videoToCount.put(video, preCount + 1);
                    }
            );
        }

        return videoToCount.entrySet().stream()
                .sorted((l, r) -> {
                    if (l.getValue() - r.getValue() == 0) {
                        return l.getKey().compareTo(r.getKey());
                    }

                    return l.getValue() - r.getValue();
                })
                .map(Map.Entry::getKey)
                .toList();
    }
}
