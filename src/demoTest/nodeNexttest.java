package demoTest;

public class nodeNexttest {
    public static void main(String[] args) {
        node nodetest = new node(0 , 0);
        System.out.println(nodetest.next);
        System.out.println(nodetest);
        node temp=new node(1,1);
        nodetest.next=temp;
        System.out.println(nodetest);
        System.out.println(temp);
        System.out.println(nodetest.next);
        node temp1=new node(2,2);
        temp.next=temp1;
        System.out.println(temp1);
        System.out.println(temp.next);
      //  System.out.println(nodetest.next.next.coe);

    }
}
class node{
    private int coeffient;
    private int expotential;
    node next;//存储的地址值

    public node(int coeffient, int expotential) {
        this.coeffient = coeffient;
        this.expotential = expotential;
    }
}

