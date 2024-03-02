package company.zalando;

public class LongestStringWithAABBABWithoutAAABBB {

    public static String solution(int AA, int AB, int BB) {
        StringBuilder sb = new StringBuilder();

        if (AA == BB) {
            sb.append("AABB".repeat(AA));
            sb.append("AB".repeat(AB));
        } else if (AA > BB) {
            sb.append("AB".repeat(AB));
            sb.append("AABB".repeat(BB));
            sb.append("AA");
        } else {
            sb.append("BBAA".repeat(AA));
            sb.append("BB");
            sb.append("AB".repeat(AB));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 0, 2)); // Expected: AABBAABBA or similar, respecting constraints
        System.out.println(solution(1, 2, 1)); // Expected: ABAABAB or similar, respecting constraints
        System.out.println(solution(0, 2, 0)); // Expected: ABAB, as given in example
        System.out.println(solution(0, 0, 10)); // Expected to handle edge cases gracefully
    }
}
