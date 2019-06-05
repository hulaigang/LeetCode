package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历链表，将链表的所有节点压入栈中，然后利用栈删除倒数第N个节点
 */
public class No_019_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode listNode = head;
		List<ListNode> list = new ArrayList<>();
		while (listNode!=null){
			list.add(listNode);
			listNode = listNode.next;
		}
		if(n==1 && n==list.size()){
			return null;
		}
		if (n==list.size()){
			head = list.get(1);
		}else {
			list.get(list.size()-n-1).next = list.get(list.size()-n).next;
		}
		return head;
	}
}
