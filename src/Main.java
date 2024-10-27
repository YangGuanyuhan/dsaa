

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // 测试用例数
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();  // 队伍成员数
            int M = scanner.nextInt();  // 操作数
            // 构建数组存储每个队员的地址
            DoublyNode[] array = new DoublyNode[N];
            for (int i = 0; i < N; i++) {
                DoublyNode node = new DoublyNode(i);
                array[i] = node;
            }
            // 构建双向链表的头节点和尾节点
            DoublyNode head = new DoublyNode(-1);
            DoublyNode current = head;
            DoublyNode tail = new DoublyNode(-2);
            // 根据题目的要求构建双向链表
            for (int i = 0; i < N; i++) {
                int index = scanner.nextInt();
                current.setNext(array[index]);
                array[index].setPrevious(current);
                current = current.getNext();
            }
            current.setNext(tail);
            tail.setPrevious(current);
            // 进行M次交换x1 x2 y1 y2操作
            for (int i = 0; i < M; i++) {
                int x1 = scanner.nextInt();
                int y1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();
                // 找到x1和x2的位置
                DoublyNode x1Node = array[x1];
                DoublyNode x2Node = array[x2];
                // 找到y1和y2的位置
                DoublyNode y1Node = array[y1];
                DoublyNode y2Node = array[y2];

                DoublyNode x1Previous = x1Node.getPrevious();
                DoublyNode x1Next = x1Node.getNext();
                DoublyNode x2previous = x2Node.getPrevious();
                DoublyNode x2Next = x2Node.getNext();
                DoublyNode y1Previous = y1Node.getPrevious();
                DoublyNode y1Next = y1Node.getNext();
                DoublyNode y2Previous = y2Node.getPrevious();
                DoublyNode y2Next = y2Node.getNext();


                if (y1Next != x2Node) {
                    x1Previous.setNext(x2Node);
                    x2Node.setPrevious(x1Previous);

                    y2Node.setNext(y1Next);
                    y1Next.setPrevious(y2Node);

                    x2previous.setNext(x1Node);
                    x1Node.setPrevious(x2previous);

                    y1Node.setNext(y2Next);
                    y2Next.setPrevious(y1Node);
                }else {
                    x1Previous.setNext(x2Node);
                    x2Node.setPrevious(x1Previous);

                    y2Node.setNext(x1Node);
                    x1Node.setPrevious(y2Node);



                    y1Node.setNext(y2Next);
                    y2Next.setPrevious(y1Node);
                }


            }

            printList(head.getNext());
        }
    }

    public static void printList(DoublyNode head) {
        DoublyNode current = head;
        while (current != null&&current.getData()!=-2) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void printListReverse(DoublyNode tail) {
        DoublyNode current = tail;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrevious();
        }
        System.out.println();
    }
}

class DoublyNode {
    // 节点的数据
    private int data;
    // 指向前一个节点的指针
    private DoublyNode previous;
    // 指向下一个节点的指针
    private DoublyNode next;

    // 构造函数
    public DoublyNode(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    // 获取数据
    public int getData() {
        return data;
    }

    // 设置数据
    public void setData(int data) {
        this.data = data;
    }

    // 获取前一个节点
    public DoublyNode getPrevious() {
        return previous;
    }

    // 设置前一个节点
    public void setPrevious(DoublyNode previous) {
        this.previous = previous;
    }

    // 获取下一个节点
    public DoublyNode getNext() {
        return next;
    }

    // 设置下一个节点
    public void setNext(DoublyNode next) {
        this.next = next;
    }
}
