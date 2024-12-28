package com.practice;


import java.util.HashMap;
import java.util.Map;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycleUsingMap(ListNode head) {

        if(head == null || head.next == null) {
            return false;
        }
        Map<Object, Object> loopMap = new HashMap<>();
        ListNode current = head;
        while (current!= null && current.next!= null) {
            if(loopMap.containsKey(current)) {
                System.out.println(loopMap.size());
                return true;
            } else {
                loopMap.put(current, current.val);
                current = current.next;
            }
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode fast = null, slow = null;
        fast = head;
        slow = head;
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        LinkedListCycle listCycle = new LinkedListCycle();
        int[] inputArray = new int[]{-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        int pos = -1;
        int length = 0;
        ListNode head =null, current = null;
        for(int i=0; i<inputArray.length; i++) {
            if(current == null) {
                current = new ListNode(inputArray[i]);
                head = current;
                current.next = null;

            } else {
                current.next = new ListNode(inputArray[i]);
                current = current.next;
                current.next = null;

            }
            length++;
            if(length == inputArray.length) {
                ListNode traverse = head;
                for (int j=0; j<pos; j++) {
                    traverse = traverse.next;
                }
                current.next = traverse.next;
            }
        }
        System.out.println("Linked List is :: ");
        ListNode traverse = head;
        for (int i=0; i<length; i++) {
            System.out.println(traverse.val);
            traverse = traverse.next;
        }
        System.out.println("List has loop :: " + listCycle.hasCycle(head));
    }
}
