package org.example;

public class Calc {

    public static int run(String exp) {


        boolean needToPlus = exp.contains("+");
        boolean needToMinus = exp.contains("-");


        System.out.println("exp1 : " + exp);


        exp = exp.replace("- ", "+ -");


        String[] bits = exp.split(" \\+ ");

        System.out.println("exp2 : " + exp);


        int sum = 0;

        for(int i = 0; i < bits.length; i++) {
            sum+= Integer.parseInt(bits[i]);
        }return sum;
    }
}


// =====더하기
//String[] bits = exp.split(" \\+ ");
//
//int a = Integer.parseInt(bits[0]);
//int b = Integer.parseInt(bits[1]);
//
//        return a + b;


//======더하기 빼기 추가

//boolean needToPlus = exp.contains("+");
//boolean needToMinus = exp.contains("-");
//
//String[] bits = null;
//
//        if (needToPlus) {
//bits = exp.split(" \\+ ");
//        } else if (needToMinus) {
//bits = exp.split(" - ");
//        }
//
//int a = Integer.parseInt(bits[0]);
//int b = Integer.parseInt(bits[1]);
//
//        if (needToPlus) {
//        return a + b;
//        } else if (needToMinus) {
//        return a - b;
//        }
//
//                throw new RuntimeException("해석 불가 : 올바른 계산식이 아닙니다");

//======3개 더하기

//boolean needToPlus = exp.contains("+");
//boolean needToMinus = exp.contains("-");
//
//String[] bits = null;
//
//        if (needToPlus) {
//bits = exp.split(" \\+ ");
//        } else if (needToMinus) {
//bits = exp.split(" - ");
//        }
//
//int a = Integer.parseInt(bits[0]);
//int b = Integer.parseInt(bits[1]);
//int c = 0;
// if(bits.length >2){
//        int c = Integer.parseInt(bits[2]);}
//        if (needToPlus) {
//        return a + b + c;
//        } else if (needToMinus) {
//        return a - b;
//        }
//
//                throw new RuntimeException("해석 불가 : 올바른 계산식이 아닙니다");

// ======= 더하기 빼기 연산

//boolean needToPlus = exp.contains("+");
//boolean needToMinus = exp.contains("-");
//        System.out.println("exp1 : " + exp);
//
//String[] bits = null;
//exp = exp.replace("- ", "+ -");
//        if (needToPlus) {
//bits = exp.split(" \\+ ");
//        } else if (needToMinus) {
//bits = exp.split(" - ");
//        }
//
//                System.out.println("exp2 : " + exp);
//
//
//int a = Integer.parseInt(bits[0]);
//int b = Integer.parseInt(bits[1]);
//int c = 0;
// if(bits.length >2){
//c = Integer.parseInt(bits[2]);}
//        if (needToPlus) {
//        return a + b + c;
//        } else if (needToMinus) {
//        return a - b;
//        } return a + b + c;

//   throw new RuntimeException("해석 불가 : 올바른 계산식이 아닙니다");


//=======임시 방편
//boolean needToPlus = exp.contains("+");
//boolean needToMinus = exp.contains("-");
//
//
//        System.out.println("exp1 : " + exp);
//
//
//exp = exp.replace("- ", "+ -");
//
//
//String[] bits = exp.split(" \\+ ");
//
//        System.out.println("exp2 : " + exp);
//
//
//int a = Integer.parseInt(bits[0]);
//int b = Integer.parseInt(bits[1]);
//int c = 0;
//        if (bits.length > 2) {
//c = Integer.parseInt(bits[2]);
//        }
//                if (needToPlus) {
//        return a + b + c;
//        } else if (needToMinus) {
//        return a + b;
//        }return 0;


// === 덧셈 뻴셈 최적화

//boolean needToPlus = exp.contains("+");
//boolean needToMinus = exp.contains("-");
//
//
//        System.out.println("exp1 : " + exp);
//
//
//exp = exp.replace("- ", "+ -");
//
//
//String[] bits = exp.split(" \\+ ");
//
//        System.out.println("exp2 : " + exp);
//
//
//int sum = 0;
//
//        for(int i = 0; i < bits.length; i++) {
//sum+= Integer.parseInt(bits[i]);
//        }return sum;
//    }
//            }
