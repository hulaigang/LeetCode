package LeetCode;

/**
 * 双指针，遍历的同时建立新的链表，时间复杂度O（N）
 */
public class No_021_Merge_Two_Sorted_Lists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1==null && l2==null) return null;
		if (l1==null) return l2;
		if (l2 == null) return l1;
		ListNode head;
		ListNode node_1=l1,node_2=l2;
		if (l1.val<=l2.val) {
			head = l1;
			node_1 = node_1.next;
		}else {
			head = l2;
			node_2 = node_2.next;
		}
		ListNode node = head;
		while (node_1!=null || node_2!=null){
			if (node_1==null) {
				node.next=node_2;
				node_2 = node_2.next;
			}else if (node_2==null){
				node.next=node_1;
				node_1 = node_1.next;
			}else {
				if (node_1.val<=node_2.val){
					node.next=node_1;
					node_1 = node_1.next;
				}else {
					node.next=node_2;
					node_2 = node_2.next;
				}
			}
			 node=node.next;
		}
		return head;
	}
}
