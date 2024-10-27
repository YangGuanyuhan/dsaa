package lab3;

import java.util.Scanner;

public class testB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            polynominalnode nodhead = new polynominalnode(0, -1);
            polynominalnode current = nodhead;
            for (int j = 0; j < n; j++) {
                polynominalnode temp = new polynominalnode(in.nextInt(), in.nextInt());
                current.next = temp;
                current = current.next;
            }
            polynominalnode tail = new polynominalnode(0, Integer.MAX_VALUE);
            current.next = tail;
            current = nodhead;
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                int coe = in.nextInt();
                int exp = in.nextInt();
                while (current.next.expotential <= exp) {
                    current = current.next;
                }
                if (current.expotential == exp) {
                    current.coeffient += coe;
                } else {
                    polynominalnode temp = new polynominalnode(coe, exp);
                    temp.next = current.next;
                    current.next = temp;
                }}
                int szdihjfbgv = in.nextInt();
                current = nodhead.next;
                for (int k = 0; k < szdihjfbgv; k++) {
                    int x = in.nextInt();
                    while (current.next.expotential <= x) {
                        current = current.next;
                    }
                    if (current.expotential == x) {
                        System.out.print(current.coeffient + " ");
                    } else {
                        System.out.print("0 ");
                    }
                }


        }

    }
}

class polynominalnode {
    int coeffient;
    int expotential;
    polynominalnode next;//存储的地址值

    public polynominalnode(int coeffient, int expotential) {
        this.coeffient = coeffient;
        this.expotential = expotential;
    }
}
