package lab4;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取 k 和 n
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        // 读取数组
        node[] arr = new node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new node(scanner.nextInt(), i);
        }

        // 初始化 deque
        deque maxdeque = new deque(n); // 维护未来可能的最大值，降序
        deque mindeque = new deque(n); // 维护未来可能的最小值，升序

        // 初始化滑动窗口的指针
        int left = 0;
        int right = 0;

        // 初始化结果
        int ans = 0;

        // 开始滑动窗口
        while (right < n) {
            if (maxdeque.isEmpty() || mindeque.isEmpty()) { // 如果两个 deque 为空
                maxdeque.pushBack(arr[right]);
                mindeque.pushBack(arr[right]);

            }
            if (arr[right].value >= maxdeque.peekBack().value) {
                while (!maxdeque.isEmpty() && arr[right].value >= maxdeque.peekBack().value) {
                    maxdeque.popBack();
                }
                maxdeque.pushBack(arr[right]);
            } else {
                maxdeque.pushBack(arr[right]);
            }

            if (arr[right].value <= mindeque.peekBack().value) {
                while (!mindeque.isEmpty() && arr[right].value <= mindeque.peekBack().value) {
                    mindeque.popBack();
                }
                mindeque.pushBack(arr[right]);
            } else {
                mindeque.pushBack(arr[right]);
            }


            if (maxdeque.peekBack().value - mindeque.peekFront().value <= k) { // 如果满足条件，更新结果
                ans = Math.max(ans, right - left + 1);
                right++;
            } else {
                left++;
                // 检查栈顶元素是否在窗口内
                while (maxdeque.peekFront().index < left) {
                    maxdeque.popFront();
                }
                while (mindeque.peekFront().index < left) {
                    mindeque.popFront();
                }
                if (maxdeque.peekBack().value - mindeque.peekFront().value <= k) {
                    ans = Math.max(ans, right - left);
                }


            }
        }

        System.out.println(ans);
    }
}

class node {
    int value;
    int index;

    node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class deque {
    private node[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public deque(int capacity) {
        this.capacity = capacity;
        this.array = new node[capacity]; // 改为 node 类型
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void pushFront(node value) {
        if (isFull()) {
            return;
        }
        front = (front - 1 + capacity) % capacity; // front 指针前移 1 位
        array[front] = value;
        size++;
    }

    public void pushBack(node value) {
        if (isFull()) {
            return;
        }
        array[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
    }

    public node popFront() {
        if (isEmpty()) {
            return null;
        }
        node value = array[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public node popBack() {
        if (isEmpty()) {
            return null;
        }
        rear = (rear - 1 + capacity) % capacity;
        node value = array[rear];
        size--;
        return value;
    }

    public node peekFront() {
        if (isEmpty()) {
            return null;
        }
        return array[front];
    }

    public node peekBack() {
        if (isEmpty()) {
            return null;
        }
        return array[(rear - 1 + capacity) % capacity];
    }
}
