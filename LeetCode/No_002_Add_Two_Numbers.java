package LeetCode;

/**
 * 时间复杂度O（N）
 */
public class No_002_Add_Two_Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1==null || l2==null) return null;
		return addTowNumbers(l1,l2,0);
	}

	private ListNode addTowNumbers(ListNode l1,ListNode l2,int i){
		if (l1==null&&l2==null){
			if (i!=0){
				return new ListNode(i);
			}else {
				return null;
			}
		}
		int a = (l1==null?0:l1.val);
		int b = (l2==null?0:l2.val);
		int c= a+b+i;
		ListNode node = new ListNode(c%10);
		node.next = addTowNumbers((l1==null?null:l1.next),(l2==null?null:l2.next),c/10);
		return node;
	}
}

class ListNode {
	 int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
