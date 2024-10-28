package lab3;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();  // 测试用例数
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();  // 当前输入的字符总数
            String input = in.next();  // 读取整个输入字符串
            linkedlist text = new linkedlist();
            text.tohead();
            boolean replace = false;
            for (char ch : input.toCharArray()) {
                switch (ch) {
                    case 'I':
                        text.tohead();  // 光标移到行首
                        break;
                    case 'H':
                        text.previous();  // 左移光标
                        break;
                    case 'L':
                        text.next();  // 右移光标
                        break;
                    case 'r':
                        replace = true;  // 启用替换模式
                        break;
                    case 'x':
                        text.remove();  // 删除当前字符
                        break;
                    default:
                        if (Character.isDigit(ch)) {  // 数字输入处理
                            if (replace) {
                                text.remove();
                                text.add(ch);  // 替换当前字符
                                text.previous();
                                replace = false;
                            } else {
                                text.add(ch);  // 插入字符
                            }
                        }
                }
            }

            // 输出结果，忽略尾部EOL
            text.print();
        }

    }
}
class doublenode {
    char data;
    doublenode next;
    doublenode pre;
    doublenode(char data){
        this.data = data;
    }
}
class linkedlist{
    doublenode head;
    doublenode endOfLine;
    doublenode current;
    linkedlist(){
        head = new doublenode('f');
        endOfLine = new doublenode('e');
        head.next = endOfLine;
        endOfLine.pre = head;
        current = head;
    }
    void add(char data){
        doublenode temp = new doublenode(data);
        temp.next = current.next;
        temp.pre = current;
        current.next.pre = temp;
        current.next = temp;
        current = temp;
    }
    void remove(){
        if(current.next != endOfLine){
            current.next.next.pre = current.next.pre;
            current.next.pre.next = current.next.next;
        }
    }
    void previous(){
        if(current != head){
            current = current.pre;
        }
    }
    void next(){
        if(current.next != endOfLine){
            current = current.next;
        }
    }
    void set(char data){
        if (current != head && current != endOfLine) current.data = data;
        else add(data);
    }
    void tohead(){
        current = head;
    }
    void print(){
        doublenode temp = head.next;
        while(temp != endOfLine){
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}