# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return None
        sp = head
        fp = head
        while fp != None and fp.next != None:
            sp = sp.next
            fp = fp.next.next
            if sp == fp:
                break
        if fp == None or fp.next == None:
            return None
        fp = head
        while sp != fp:
            sp = sp.next
            fp = fp.next
        return sp
    
