package Codility;

public class PassingCars {
    /**
     * counting around the east traveling cars in order to avoid count duplicates.
     * <p>
     * Brute Force: O(N^2)/O(1)
     * Memoizing, Time/Space: O(N)/O(1)
     * <p>
     * Memoize the number of east traveling cars on each mements and totol passing cars.
     * <p>
     * for each [0 ... N-1]
     * In case of east traveling car, count the number of east traveling cars.
     * In case of west traveling car, add the count to the total passing cars.
     * return the total passing cars
     */
    public int solution(int[] A) {
        int numOfEastTravelingCars = 0;
        int totalPassingCars = 0;

        for (int direction : A) {
            // east
            if (direction == 0) numOfEastTravelingCars += 1;
                // west
            else totalPassingCars += numOfEastTravelingCars;
        }
        return totalPassingCars;
    }
}
