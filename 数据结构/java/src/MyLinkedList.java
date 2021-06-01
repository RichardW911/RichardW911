import java.util.*;
class Node {
    public int data;
    public Node next;
    public Node() {

    }
    public Node(int data) {
        this.data = data;
    }

}


public class MyLinkedList {
    public  Node head;//表示当前链表的头 默认是null

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public Node findLastNode() {
        if (this.head == null) {
            System.out.println("null");
            return null;
        }
        if (this.head.next == null) {
            System.out.println("only one node!");
            return this.head;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public Node findLastTwoNode() {
        if (this.head == null) {
            System.out.println("null");
            return null;
        }
        if (this.head.next == null) {
            System.out.println("only one node!");
        }
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public Node findN(int n) {
        if (this.head == null) {
            System.out.println("单链表为空！");
            return null;
        }
        if (n <= 0) {
            System.out.println("n小了");
            return null;
        }
        if (n > size()) {
            System.out.println("n大了");
            return null;
        }
        int count = 1;
        Node cur = this.head;
        while (count != n) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    //头插法
    public void addFirst(int data) {
        //0、首先你得有个节点
        Node node = new Node(data);
        //1、判断链表是不是空的
        if (this.head == null) {
            this.head = node;
        } else {
            //2、插入
            node.next = this.head;
            this.head = node;
        }
        //0、首先你得有个节点
       /* Node node = new Node(data);
        //1、判断链表是不是空的
        node.next = this.head;
        this.head = node;*/
    }


    //尾插法
    public void addLast(int data) {
        //0、new
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            //1、cur 找尾巴
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            //2、插入
            cur.next = node;
        }
    }

    /**
     * 该函数是找到index-1位置的节点的引用
     *
     * @param index
     * @return
     */
    public Node moveIndex(int index) {
        Node cur = this.head;
        int count = 0;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            System.out.println("index不合法");
            return;
        }
        //头插法
        if (index == 0) {
            addFirst(data);
            return;
        }
        //尾插法
        if (index == size()) {
            addLast(data);
            return;
        }
        Node cur = moveIndex(index);
        //cur保存的是 index-1位置的节点的引用
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 找到关键key的前驱，如果有返回前驱节点的引用
     * 如果没有返回null
     *
     * @param key
     * @return
     */
    public Node searchPrev(int key) {
        Node cur = this.head;

        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if (prev == null) {
            System.out.println("没有这个key的前驱");
        } else {
            Node del = prev.next;
            prev.next = del.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node prev = this.head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }


    public void clear() {
        this.head = null;
    }

/*

*
* */
    public Node reverseList() {
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public Node middleNode1() {
        int len = size() / 2;
        Node cur = this.head;
        int count = 0;
        while (count != len) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node findKthToTail(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (k - 1 != 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                return null; //代表k值过大
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                tmp.next = headA;
                headA = headA.next;
            } else {
                tmp.next = headB;
                headB = headB.next;
            }
            tmp = tmp.next;
        }
        //代码走到这里肯定是一个为空 一个不为空
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

    public Node deleteDuplicates(Node head) {
        if(head == null) return null;
        Node cur = head;
        while(cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                Node curNext = cur.next;
                while(cur.data == curNext.data && curNext.next != null) {
                    curNext = curNext.next;
                }
                cur.next = curNext;
            }
            cur = cur.next;
        }
        return head;

    }








}






