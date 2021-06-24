package Others;

import Others.structure.ListNode;

public class Test {
    public void func1(Integer a) {
        a = 2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        ReversedLinkedList solution = new ReversedLinkedList();
        ListNode reversed = solution.reverseList(head);

        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }

        Integer a = 0;
        new Test().func1(a);
        System.out.println(a);

        Integer x = new Integer(0);
        Integer y = x;
        Integer z = y;
        x = 3;

        System.out.printf("%s %s %s\n", x, y, z);
        System.out.printf("%s %s %s\n\n", x.hashCode(), y.hashCode(), z.hashCode());

        A obj1 = new A();
        A obj2 = obj1;
        obj1 = new A();
        obj1.a = 3;

        System.out.printf("%s %s\n", obj1.a, obj2.a);
        System.out.printf("%s %s\n", obj1.hashCode(), obj2.hashCode());

    }
}

final class A {
    public int a = 1;
}
