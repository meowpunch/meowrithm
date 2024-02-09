package company.amazon;

import java.util.HashMap;
import java.util.Map;

/*
   Return leftmost unique character so far

   addChar(a)  return a
   addChar(b)  return a
   addChar(a)  return b
   addChar(c)  return b

*/

public class LeftMostUniqueCharacter {

  class Node {
    Character value;
    Node prevNode;
    Node nextNode;

    Node(Character value, Node prev, Node next) {
      this.value = value;
      this.prevNode = prev;
      this.nextNode = next;
    }
  }

  private Map<Character, Node> occuredCharacterToNode = new HashMap<>();
  private Node head;
  private Node tail;

  public Character addChar(char character) {
    if (head == null) {
      head = new Node(character, null, null);
      tail = head;
      occuredCharacterToNode.put(character, head);
      return character;
    }

    if (occuredCharacterToNode.containsKey(character)) {
      // remove node
      // a
      Node node = occuredCharacterToNode.get(character);
      // null
      Node prevNode = node.prevNode;
      // b
      Node nextNode = node.nextNode;

      if (node.equals(tail)) tail = prevNode;
      // head = b
      if (node.equals(head)) head = nextNode;

      // b.prevNode = null
      if (nextNode != null) nextNode.prevNode = prevNode;
      if (prevNode != null) prevNode.nextNode = nextNode;

      return head != null ? head.value : null;
    }

    // Add node
    Node node = new Node(character, tail, null);
    tail.nextNode = node;
    tail = node;
    occuredCharacterToNode.put(character, node);
    return head.value;
  }

  private static void printList(Node curr) {
    StringBuilder sb = new StringBuilder();
    sb.append("LinkedList: ");
    sb.append(curr.value);
    curr = curr.nextNode;
    while (curr != null) {
      sb.append(" -> ");
      sb.append(curr.value);
      curr = curr.nextNode;
    }
    System.out.println(sb);
  }

  public static void main(String[] args) {

    var lmuc = new LeftMostUniqueCharacter();
    System.out.println(lmuc.addChar('a'));
    printList(lmuc.head);
    //    System.out.println(lmuc.head.value);
    //    System.out.println(lmuc.tail.value);
    //    System.out.println(lmuc.occuredCharacterToNode);

    System.out.println(lmuc.addChar('b'));
    printList(lmuc.head);
    //    System.out.println(lmuc.head.value);
    //    System.out.println(lmuc.tail.value);
    //    System.out.println(lmuc.occuredCharacterToNode);

    System.out.println(lmuc.addChar('a'));
    printList(lmuc.head);
    //    System.out.println(lmuc.head.value);
    //    System.out.println(lmuc.tail.value);
    //    System.out.println(lmuc.occuredCharacterToNode);

    System.out.println(lmuc.addChar('c'));
    printList(lmuc.head);
    //    System.out.println(lmuc.head.value);
    //    System.out.println(lmuc.tail.value);
    //    System.out.println(lmuc.occuredCharacterToNode);
  }
}
