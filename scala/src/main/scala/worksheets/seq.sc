import java.util

/*
  immutable Stack is deprecated because it is same as List

  Vector vs List

        head	tail	apply	update	prepend	append	insert
  List	 C	   C	    L	    L       C      	L	      -
Vector  eC	  eC	   eC	   eC	     eC	     eC	      -

   Vector is implemented with tree that every node contains 32 elements of vectors or 32 other tree nodes.
 */

"abc".toList
"abc".toVector



val jal = new java.util.ArrayList[Int]()

jal.add