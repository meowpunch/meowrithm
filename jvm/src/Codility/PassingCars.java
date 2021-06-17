package Codility;

public class PassingCars {
    /**
     *  counting around the east traveling cars in order to avoid count duplicates.
     *
     *  Brute Force: O(N^2)/O(1)
     *  Memoizing, Time/Space: O(N)/O(1)
     *
     *  Memoize the number of east traveling cars on each moments and total passing cars.
     *
     *  for each [0 ... N-1]
     *      In case of east traveling car, count the number of east traveling cars.
     *      In case of west traveling car, add the count to the total passing cars.
     *  return the total passing cars
     *
     *  N - [1..100,000]
     *  50,000 * 50,000 = 2,500,000,000 (using int, overflow) int 2^32 -> 2*10^9
     */
    public int solution(int[] A) {
        int numOfEastTravelingCars = 0;
        int totalPassingCars = 0;

        for (int direction: A) {
            // east
            if (direction == 0) numOfEastTravelingCars += 1;
                // west
            else {
                totalPassingCars += numOfEastTravelingCars;
                if (totalPassingCars > 1000000000) {
                    totalPassingCars = -1;
                    break;
                }
            }
        }

        return totalPassingCars;
    }
}
