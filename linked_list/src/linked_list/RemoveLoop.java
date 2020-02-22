package linked_list;


import java.util.*;
import java.io.*;
import java.lang.*;
class Node
{
    int data;
    Node next;
    
}
class Geeks
{
     public static Node newNode(int data)
        {
            Node temp = new Node();
            temp.data = data;
            temp.next = null;
            return temp;
        }
        
        public static Node insert(Node head, int data)
        {
            if (head == null)
                head = newNode(data);
            else
                head.next = insert(head.next, data);
            return head;
        }
        
        public static void makeLoop(Node head, int x)
        {
            if (x == 0)
                return;
            Node curr = head;
            Node last = head;
            int counter = 0;
            while (counter < x)
            {
                curr = curr.next;
                counter++;
            }
            while (last.next != null)
                last = last.next;
            last.next = curr;
        }
        
         public static int detectloop(Node head)
        {
            Node hare = head.next;
            Node tortoise = head;
            while (hare != tortoise && hare != null && tortoise != null)
            {
                hare = hare.next;
                tortoise = tortoise.next;
                if (hare != null && hare.next != null)
                    hare = hare.next;
                if (hare == tortoise)
                    return 1;
            }
            if (hare == tortoise)
                return 1;
            return 0;
        }
        public static int length(Node head, boolean hasloop)
        {
            int len = 0;
            if (hasloop == false)
            {
                Node temp = head;
                while (temp != null)
                {
                    len++;
                    temp = temp.next;
                }
                return len;
            }
            else
            {
                Node hare = head.next;
                Node tortoise = head;
                while (hare != tortoise)
                {
                    hare = hare.next;
                    tortoise = tortoise.next;
                    hare = hare.next;
                    if (hare == tortoise)
                        break;
                }
               
                int looplen = 0;
                while (hare.next!=tortoise)
                {
                    hare = hare.next;
                    looplen++;
                }
                
                looplen++;
                Node begin = head;
                int startlen = 0;
                tortoise = tortoise.next;
                while (begin != tortoise)
                {
                    
                    begin = begin.next;
                    tortoise = tortoise.next;
                    startlen++;
                }
                return looplen + startlen;
                
            }
        }
}
public class RemoveLoop
{
    public static void main (String[] args) {
        /* code */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int sizeOfArray = sc.nextInt();
            int arr[] = new int[sizeOfArray];
            
            for(int i = 0; i < sizeOfArray; i++)
              arr[i] = sc.nextInt();
              
           Node head = null;
            
              for (int i = 0; i < sizeOfArray; i++)
                {
                    head = new Geeks().insert(head, arr[i]);
                }
                int x = sc.nextInt();
                new Geeks().makeLoop(head, x);
                
                int length = 0;
                if (new Geeks().detectloop(head) == 1)
                {
                     length=new Geeks().length(head, true);
                }
                else
                {
                     length = new Geeks().length(head, false);
                }
                new Loop().removeTheLoop(head);
                if (new Geeks().detectloop(head) == 0 && length == new Geeks().length(head, false))
                    System.out.println("1");
                else
                   System.out.println("0");
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*Complete The function
Node is as follows:
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/
class Loop{
    
    // This function will remove the loop from the linked list
    public static void removeTheLoop(Node head)
    {
        Node d_head=head;
        int head_temp=Integer.MAX_VALUE;
        while(head!=null){
            Node node = d_head.next;
            if(node!=null) d_head = node.next;
            if(head!=null && d_head!=null && d_head==head){
                //System.out.println("Hello"+node.data);
            	if(head_temp==node.data) {
            		head_temp=head.data;
            		head=head.next;
            		continue;
            	}
                node.next=null;
                break;
            }
            head_temp=head.data;
            head=head.next;
        }
    }
}
/*
Input:
2
3
1 3 4
2
4
1 8 3 4
0

Output:
1
1

Explanation:
Testcase 1: In the first test case N = 3.
The linked list with nodes N = 3 is given. Here, x = 2 which means last node is connected with xth node of linked list. Therefore, there exists a loop. 

Testcase 2: N = 4 and x = 0, which means lastNode->next = NULL, thus the Linked list does not contains any loop.
*/
