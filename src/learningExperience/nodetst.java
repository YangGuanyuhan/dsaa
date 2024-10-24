package learningExperience;

public class nodetst {
    public static void main(String[] args) {
        // 创建节点并构建链表
        node head = new node(2);
        node second = new node(3);
        node third = new node(4);

        // 链接节点
        head.setNext(second);
        second.setNext(third);

        node inserter = new node(9);
        node temp =second.getNext();
        second.setNext(inserter);
        inserter.setNext(temp);




        // 打印链表
        printLinkedList(head);  // 输出: 2 -> 3 -> 4 -> null
    }

    // 修改为使用自己的节点类
    public static void printLinkedList(node head) {
        node current = head;  // 从头节点开始
        while (current != null) {  // 当当前节点不为 null 时
            System.out.print(current.getValue() + " -> ");  // 打印当前节点的值
            current = current.getNext();  // 移动到下一个节点
        }
        System.out.println("null");  // 最后打印 null，表示链表结束
    }
}

class node {
    private int value;  // 节点的值
    private node next;  // 指向下一个节点的指针

    // 构造函数
    public node(int value) {
        this.value = value;
        this.next = null;  // 默认 next 为 null
    }

    // 获取节点的值
    public int getValue() {
        return value;
    }

    // 获取下一个节点
    public node getNext() {
        return next;
    }

    // 设置下一个节点
    public void setNext(node next) {
        this.next = next;
    }
}
