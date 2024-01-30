package company.amazon;

/*
- Problem -
How would you implement the Linux find command as an API? For the API there are a lot of different use cases.
For this exercise we can focus on finding files by name and finding files by file size.
However, keep extensibility in mind.

https://leetcode.com/discuss/interview-question/369272/Amazon-or-Onsite-or-Linux-Find-Command
*/

/*
- Design -

Action: find
Object: File

 */

import java.util.ArrayList;
import java.util.List;

// How does the object (that we want to find) look like?
// Do you have any range of size?
record File(String name, int size, int type, List<File> children) {}

// How does API look like?
// What is the best way for user to use the feature?

/*


- first -
List<File> findFiles(File baseFile, String name, int size, ...)
-> Not extensible
-> Clients might use the interface as binary code
Whenever adding the new criteria, clients need to update the version of API and adjust their code

- extensible for filter -
List<File> findFiles(File baseFile, List<Filter> filters);

findFiles("basePath", List.of(new NameFilter("xxx.txt"), new SizeFilter("34"));

findFiles("basePath", List.of(new NameFilter("xxx.txt"), new SizeFilter("34"), new Extension("txt"));


- extensible for filter and reusable -
var findCommandWithXXXAndYYY = new FindCommand()
    .withFilter(new XXXFilter())
    .withFilter(new YYYFilter())
    .build();

FindCommand.execute(Files.get("basePath"));

findCommandWithXXXAndYYY.builder().withFilter(new ZZZFilter());


- extensible for filter and operator and reusable -

new FindCommand(
    new XFilter().and(new YFilter())
);
*/

class NameFilter implements Specification<File> {

  private final String name;

  NameFilter(String name) {
    this.name = name;
  }

  @Override
  public boolean test(File file) {
    return name.equals(file.name());
  }
}

class SizeFilter implements Specification<File> {
  private final int size;

  SizeFilter(int size) {
    this.size = size;
  }

  @Override
  public boolean test(File item) {
    return size == item.size();
  }
}

class AndSpecification<T> implements Specification<T> {

  private final Specification<T> first, second;

  AndSpecification(Specification<T> first, Specification<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean test(T item) {
    return first.test(item) && second.test(item);
  }
}

class OrSpecification<T> implements Specification<T> {

  private final Specification<T> first, second;

  OrSpecification(Specification<T> first, Specification<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean test(T item) {
    return first.test(item) || second.test(item);
  }
}

interface Specification<T> {
  boolean test(T item);

  default Specification<T> and(Specification<T> other) {
    return new AndSpecification<>(this, other);
  }

  default Specification<T> or(Specification<T> other) {
    return new OrSpecification<>(this, other);
  }
}

public class FindCommand {

  private final Specification<File> specification;

  public FindCommand(Specification<File> specification) {
    this.specification = specification;
  }

  public List<File> execute(File baseFile) {

    var result = new ArrayList<File>();

    if (baseFile == null) {
      return result;
    }

    if (specification.test(baseFile)) {
      result.add(baseFile);
    }

    baseFile.children().stream().map(this::execute).forEach(result::addAll);

    return result;
  }

  public static void main(String[] args) {
    var baseFile =
        new File(
            "base",
            10,
            0,
            List.of(new File("child", 11, 1, List.of()), new File("child", 10, 1, List.of())));

    var findCommandWithTenSizeAndChildName =
        new FindCommand(new AndSpecification<>(new SizeFilter(10), new NameFilter("child")));
    findCommandWithTenSizeAndChildName.execute(baseFile).forEach(System.out::println);

    findCommandWithTenSizeAndChildName =
            new FindCommand(new SizeFilter(10).and(new NameFilter("child")));
    findCommandWithTenSizeAndChildName.execute(baseFile).forEach(System.out::println);


    var findCommandWithTenSizeOrChildName =
            new FindCommand(new OrSpecification<>(new SizeFilter(10), new NameFilter("child")));
    findCommandWithTenSizeOrChildName.execute(baseFile).forEach(System.out::println);


  }
}

/*
2021's result

public class FindDirectory {
    *//*
          input: "abc"

          Files : ["abcd", "dabcf", "abdc"]

          output: ["abcd, "dabcf"]
      *//*
                  public List<File> findingFiles(Predicate) {
                      //
                      Node rootDirectory = getRootDirectory();


                      // search DFS
                      Stack<Node> s = new Stack();
                      s.push(rootDirectory);

                      while (!s.empty()) {
                          Node cur = s.pop();

                          if (cur.children.size() == 0) {
                              // in case of leaf node(=file), compare string)

                              // get File
                              File file = cur.getFile();

                              file
                          } else {
                              // dive deeper
                              for (Node child : cur.children) {
                                  s.push(child);
                              }
                          }
                      }

                  }


                  public List<File> findingFiles(int size) {

                  }
              }


              class File {
                  String filename;

              }

              class Node {
                  File file;
                  List<Node> children;
              }
              */
