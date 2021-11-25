package amazon;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CustomerReview {

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Query and repository should be compared in case-insensitive
        final String refinedQuery = customerQuery.toLowerCase(Locale.ROOT);
        final List<String> refinedRepository = repository.stream()
                .map(item -> item.toLowerCase(Locale.ROOT))
                .sorted()
                .collect(Collectors.toList());

        return IntStream.range(1, refinedQuery.length())
                .mapToObj(i -> refinedQuery.substring(0, i + 1))
                .map(
                        subQuery -> refinedRepository.stream()
                                .filter(item -> item.startsWith(subQuery))
                                .limit(3)
                                .collect(Collectors.toList())
                ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(
                searchSuggestions(
                        Stream.of("mobile", "mouse", "moneypot", "monitor", "mousepad" ).collect(Collectors.toList()), "mouse"
                ));
    }
}
