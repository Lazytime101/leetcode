给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n保证是有效的。

首先将两个指标指向虚拟节点pre（pre.next=head)，将start 节点移动到第n位
然后start和end 同时移动，当start到队尾时，end 也就到了 l-n的位置
如果将end 指向 end.next.next 就删除了倒数第n个节点（即l-n+1)

复杂度分析

时间复杂度：O(L)O(L)，该算法对含有 LL 个结点的列表进行了一次遍历。因此时间复杂度为 O(L)O(L)。

空间复杂度：O(1)O(1)，我们只用了常量级的额外空间。
