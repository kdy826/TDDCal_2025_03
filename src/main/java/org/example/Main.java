package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        String exp = "5 + -(9 + 1) * -(8 + 2) + 5";
//
//        int startPos = 4;
//        int endPos = 11;
//
//        String head = exp.substring(0, startPos);
//        String body = "(" + exp.substring(startPos + 1, endPos + 1) + " * -1)";
//        String tail = exp.substring(endPos + 1);
//
//        System.out.println("head: " + head);
//        System.out.println("body: " + body);
//        System.out.println("tail: " + tail);
//
//        System.out.println("exp: " + exp);
//        System.out.printf("exp : ");
//        System.out.printf(head);
//        System.out.printf(body);
//        System.out.printf(tail);


        String exp = "3 * 1 + (1 - (4 * 1 - ( 1 - 1))) ;";

        int startPos = 9;
        int endPos = 30;

        String head = exp.substring(0, startPos);
        String body = "(" + exp.substring(startPos + 1, endPos + 1) + " * -1)";
        String tail = exp.substring(endPos + 1);

        System.out.println("head: " + head);
        System.out.println("body: " + body);
        System.out.println("tail: " + tail);

        System.out.println("exp: " + exp);
        System.out.printf("exp : ");
        System.out.printf(head);
        System.out.printf(body);
        System.out.printf(tail);


    }
}