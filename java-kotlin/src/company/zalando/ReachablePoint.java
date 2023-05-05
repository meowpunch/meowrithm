package company.zalando;

public class ReachablePoint {

  public static void main(String[] args) {
    System.out.println(isReachableFromStartingPointToEndingPoint(new Point(1, 5), new Point(6, 11)));
    System.out.println(isReachableFromStartingPointToEndingPoint(new Point(1, 0), new Point(6, 11)));
    System.out.println(isReachableFromStartingPointToEndingPoint(new Point(0, 5), new Point(6, 11)));
  }
  /*
    sp - (1, 5) ep - (6, 11)

    (1, 5) -> (6, 5) -> (6, 11) is reachable

    DFS

    2^N <- 2 * 2 * 2 * 2 exponential
   */
  public static boolean isReachableFromStartingPointToEndingPoint(Point startingPoint, Point endingPoint) {
    if (startingPoint.x == endingPoint.x && startingPoint.y == endingPoint.y) return true;

    if (startingPoint.x > endingPoint.x || startingPoint.y > endingPoint.y) return false;

    return (startingPoint.y > 0 && isReachableFromStartingPointToEndingPoint(new Point(startingPoint.x + startingPoint.y, startingPoint.y), endingPoint))
         || (startingPoint.x > 0 && isReachableFromStartingPointToEndingPoint(new Point(startingPoint.x, startingPoint.x + startingPoint.y), endingPoint));
  }


  private record Point(int x, int y) {}
}
