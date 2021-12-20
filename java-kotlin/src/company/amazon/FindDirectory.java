package company.amazon;

/* How would you implement the Linux find command as an API? For the API there are a lot of different use cases.
For this exercise we can focus on finding files by name and finding files by file size.
However, keep extensibility in mind.
*/

//public class FindDirectory {
//    /*
//       input: "abc"
//
//       Files : ["abcd", "dabcf", "abdc"]
//
//       output: ["abcd, "dabcf"]
//   */
//    public List<File> findingFiles(Predicate) {
//        //
//        Node rootDirectory = getRootDirectory();
//
//
//        // search DFS
//        Stack<Node> s = new Stack();
//        s.push(rootDirectory);
//
//        while (!s.empty()) {
//            Node cur = s.pop();
//
//            if (cur.children.size() == 0) {
//                // in case of leaf node(=file), compare string)
//
//                // get File
//                File file = cur.getFile();
//
//                file
//            } else {
//                // dive deeper
//                for (Node child : cur.children) {
//                    s.push(child);
//                }
//            }
//        }
//
//    }
//
//
//    public List<File> findingFiles(int size) {
//
//    }
//}
//
//
//class File {
//    String filename;
//
//}
//
//class Node {
//    File file;
//    List<Node> children;
//}
