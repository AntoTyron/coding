package linkedlist.examples;


class MergeKList{
	public static class ListNode {
 		int time;
 		int val;
 		ListNode next;
 		ListNode() {}
 		ListNode(int time, int val) { this.time = time; this.val=val; }
 		ListNode(int time,int val,ListNode next) { this.time = time; this.val=val; this.next = next; }
	}
	public static ListNode merge(ListNode[] list ) {
		if(list.length<0) return null;
		if(list.length==0) return list[0];
		ListNode L1= list[0];
		ListNode dummyHead = new ListNode(0,0,null);
		int comp = 0;
		ListNode curr = dummyHead;
		for(int i=1; i<list.length; i++) {		
			ListNode L2 = list[i];
			int preVal=0;
			while(L1!=null && L2!=null) {
				int currVal=0;
				if(L1.time< L2.time) {
					curr.next = L1;
					preVal = L1.val;
					currVal = L1.val;
					L1=L1.next;					
					
					
				} else if(L1.time == L2.time) {
					curr.next = L1;
					currVal = L1.val+L2.val;
					preVal = currVal;
					L1=L1.next;
					L2=L2.next;
					
				}else{
					curr.next = L2;
					currVal = preVal+L2.val;
					preVal = L2.val;
					L2=L2.next;
										
				}
				curr=curr.next;				
				curr.val = currVal;
				comp++;
				
			}
			curr.next = L1!=null? L1: L2;
			L1= dummyHead.next;
			curr = dummyHead;
			printElem(dummyHead.next);
			comp++;
		}
		System.out.println("Complexity:"+comp);
		return dummyHead.next;
	}
	public static void  printElem(ListNode nextElem) {
		while(nextElem!=null){
			System.out.print(nextElem.time+":"+nextElem.val+"->");
			nextElem = nextElem.next;
			
		}
		System.out.println();
		
	}
	public static void main(String args[]) {
		
		ListNode l1= new ListNode(1,2);
		l1.next = new ListNode(5,3);
		l1.next.next = new ListNode(10,4);
		l1.next.next.next = new ListNode(11,1);
		//printElem(l1);
		
		ListNode l2= new ListNode(1,3);
		l2.next = new ListNode(2,1);
		l2.next.next = new ListNode(3,1);
		l2.next.next.next = new ListNode(11,1);
		//printElem(l2);
		ListNode l3= new ListNode(4,2);
		l3.next = new ListNode(5,7);
		l3.next.next = new ListNode(9,2);
		l3.next.next.next = new ListNode(10,2);
		//printElem(l3);
		ListNode[] l = {l1,l2,l3};
		ListNode newNode = merge(l);
		ListNode nextElem= newNode;
		printElem(nextElem);
		
		
	}
}
	


