package company.zalando;

public class ReverseDecimal {
  public void solution(int N) {
    int enable_print = 0;
    while (N > 0) {
      if (enable_print == 0 && N % 10 != 0) {
        enable_print = 1;
      }
      if (enable_print == 1) {
        System.out.print(N % 10);
      }
      N = N / 10;
    }
  }
}
