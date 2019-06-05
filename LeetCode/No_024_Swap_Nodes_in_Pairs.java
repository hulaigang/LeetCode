package LeetCode;

/**
 * 翻转两个结点 需要这两个结点之前的一个结点。
 * 遍历链表，不断记录三个连续结点，并翻转后两个结点
 */
public class No_024_Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
		if(head == null){
			return null;
		}
		ListNode headNode;
		if(head.next==null){
			headNode = head;
		}else{
			headNode = head.next;
		}
		int i = 0;
		ListNode tmpNode_1 = null; //前一个节点;
		ListNode tmpNode_2 = null;//前两个节点
		while (head!=null){
			if (i%2==0){
				i++;
				tmpNode_1 = head;
				head = head.next;
			}else {
				tmpNode_1.next = head.next;
				head.next = tmpNode_1;
				if (tmpNode_2!=null){
					tmpNode_2.next = head;
				}
				tmpNode_2 = tmpNode_1;
				head = tmpNode_1.next;
				i++;
			}
		}
		return headNode;
	}
}
