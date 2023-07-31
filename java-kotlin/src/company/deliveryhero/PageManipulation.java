package company.deliveryhero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
    There are two more tasks other than `removeDuplicateLinks`
 */
public class PageManipulation {
  private record PageData(String url, String title, List<String> links) {}

  public static List<PageData> removeDuplicateLinks(List<PageData> pages) {
    return pages.stream().map(PageManipulation::removeDuplicateLinks).toList();
  }

  /*
    let N be links's length

    V time O(N) / space O(N)
    HashSet<String>
    if set contains the link, it's already appeared.

    time O(NlogN)/ space O(1)
    sorting
  */
  public static PageData removeDuplicateLinks(PageData page) {
    var set = new HashSet<>(page.links);
    return new PageData(page.url, page.title, set.stream().toList());
  }

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
  }
}
