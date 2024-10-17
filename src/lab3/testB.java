package lab3;

import org.w3c.dom.Node;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Scanner;

public class testB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            node nodhead = new node(0,-1);
            node current = nodhead;
            for (int j = 0; j < in.nextInt(); j++) {
                node temp = new node(in.nextInt(),in.nextInt());
                temp =temp.next;





            }




        }
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
