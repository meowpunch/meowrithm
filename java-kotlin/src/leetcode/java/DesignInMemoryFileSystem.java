package leetcode.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class FileSystem {


  record Node(
          String name,
          boolean isFile,
          Map<String, Node> children,
          StringBuilder content
  ) {}

  private final Node root;


  public FileSystem() {
    this.root = new Node("", false, new TreeMap<String, Node>(), new StringBuilder());
  }

  private Node find(String path) {
    Node currNode = this.root;

    for (String name: path.split("/")) {
      if(name.isEmpty()) continue;
      currNode = currNode.children.computeIfAbsent(
              name, k -> new Node(name, false, new TreeMap<>(), new StringBuilder())
      );
    }

    return currNode;
  }


  public List<String> ls(String path) {
    Node node = find(path);
    return node.isFile ? List.of(node.name): List.copyOf(node.children.keySet());
  }

  public void mkdir(String path) {
    find(path);
  }

  public void addContentToFile(String filePath, String content) {
    Node file = find(filePath);
    file.content.append(content);
  }

  public String readContentFromFile(String filePath) {
    Node file = find(filePath);
    return file.content.toString();
  }
}

public class DesignInMemoryFileSystem {
  public static void main(String[] args) {

    for (var a: "/".split("/")) {
      System.out.println("hi" + a);
    }
  }
}
