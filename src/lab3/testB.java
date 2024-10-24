package lab3;

import org.w3c.dom.Node;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Scanner;

public class testB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            node nodhead = new node(0, -1);
            node current = nodhead;
            for (int j = 0; j < n; j++) {
                node temp = new node(in.nextInt(), in.nextInt());
                current.next = temp;
                current = current.next;
            }
            node tail = new node(0, Integer.MAX_VALUE);
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
                    node temp = new node(coe, exp);
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

class node {
    int coeffient;
    int expotential;
    node next;//存储的地址值

    public node(int coeffient, int expotential) {
        this.coeffient = coeffient;
        this.expotential = expotential;
    }
}
