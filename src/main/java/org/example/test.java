package org.example;

public class test{
public static void main(String[] args) {
    사람 a사람 = new 사람();
    a사람.나이 = 10;
    a사람.말하다( 30);
    }
}
class 사람{
    int 나이;
    void 말하다(int a){

        System.out.println("human says" + this.나이 + a);
    }
}
