package lab3;

import java.util.Arrays;
import java.util.Scanner;

// 主类使用快读快写会更好
public class E3_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] answer = new int[n-1];

        // 创建链表的头节点
        DoublyLinkedListNode headnode = new DoublyLinkedListNode(Integer.MIN_VALUE);
        DoublyLinkedListNode current = headnode;
        DoublyLinkedListNode tailnode = new DoublyLinkedListNode(Integer.MAX_VALUE);

        // 创建节点数组
        DoublyLinkedListNode[] nodearray = new DoublyLinkedListNode[n];

        //把节点给到数组
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            DoublyLinkedListNode temp = new DoublyLinkedListNode(a[i]);
            nodearray[i] = temp;
        }
        DoublyLinkedListNode[] copiedArray = Arrays.copyOf(nodearray, nodearray.length);
        mergeSort(copiedArray, 0, copiedArray.length - 1);
        for (int i = 0; i < copiedArray.length; i++) {
            current.setNext(copiedArray[i]);
            copiedArray[i].setPrevious(current);
            current = copiedArray[i]; // 更新current指针

        }
        //设置尾节点
        current.setNext(tailnode);
        tailnode.setPrevious(current);
        for (int i = 0; i < nodearray.length-1; i++) {
            int min = Integer.MAX_VALUE;
            DoublyLinkedListNode currentnode = nodearray[i];
            if (currentnode.getPrevious().getData() != Integer.MIN_VALUE) {
                min = Math.min(min, Math.abs(currentnode.getData() - currentnode.getPrevious().getData()));
            }
            if (currentnode.getNext().getData() != Integer.MAX_VALUE) {
                min = Math.min(min, Math.abs(currentnode.getData() - currentnode.getNext().getData()));
            }
            answer[i] = min;
            //删除当前的节点
            DoublyLinkedListNode prevNode = currentnode.getPrevious();
            DoublyLinkedListNode nextNode = currentnode.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrevious(prevNode);


        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }






    }
    // 归并排序主函数
    public static void mergeSort(DoublyLinkedListNode[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // 递归对左右两部分排序
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // 合并两个有序部分
            merge(array, left, middle, right);
        }
    }

    // 合并两个有序部分
    public static void merge(DoublyLinkedListNode[] array, int left, int middle, int right) {
        // 计算左右两部分的长度
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // 创建临时数组
        DoublyLinkedListNode[] leftArray = new DoublyLinkedListNode[n1];
        DoublyLinkedListNode[] rightArray = new DoublyLinkedListNode[n2];

        // 将数据拷贝到临时数组
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[middle + 1 + i];
        }

        // 合并临时数组
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getData() <= rightArray[j].getData()) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 拷贝剩余的元素
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // 打印链表的函数
    public static void printList(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head.getNext(); // 跳过头节点
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

// 双向链表节点类
class DoublyLinkedListNode {
    // 节点的数据
    private int data;
    // 指向前一个节点的指针
    private DoublyLinkedListNode previous;
    // 指向下一个节点的指针
    private DoublyLinkedListNode next;

    // 构造函数
    public DoublyLinkedListNode(int data) {
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
    public DoublyLinkedListNode getPrevious() {
        return previous;
    }

    // 设置前一个节点
    public void setPrevious(DoublyLinkedListNode previous) {
        this.previous = previous;
    }

    // 获取下一个节点
    public DoublyLinkedListNode getNext() {
        return next;
    }

    // 设置下一个节点
    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }
}
