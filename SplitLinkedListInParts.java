/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] list = new ListNode[k];
        if(root != null){
            int length = 0, // length of input ll
                s = 0, // length of each part
                rem = 0; // reminder of (length / k)
            ListNode temp = root;
            while(temp != null){
                length ++;
                temp = temp.next;
            }
            s = length / k;
            rem = length % k;
            
            temp = root;
            for( int i = 0; i < list.length && temp!=null; i++){
                ListNode toAdd = temp;
                
                int t = rem-- > 0 ? s + 1 : s;
                while(--t > 0 && temp != null){
                    temp = temp.next;
                }
                
                if(temp != null ){ // unlesh the part
                    ListNode prev = temp;
                    temp = temp.next;
                    prev.next = null;
                }
                list[i] = toAdd;
            }
        }
        return list;
    }
}
