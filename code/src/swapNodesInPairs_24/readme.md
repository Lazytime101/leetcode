Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.

solution1:
一个自然的想法就是新建一个虚拟节点，虚拟节点的next指向当前位置的second(current.next.next)
虚拟节点的next.next 指向first阶段（current.next），这样来达到两两交换的目的