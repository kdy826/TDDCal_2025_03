package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;
public class Calc {

    public static int run(String exp) {

        // 괄호 제거
        exp = stripOuterBrackets(exp);

        // 단일항이 들어오면 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains(" * ");
        boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");

        boolean needToCompound = needToPlus && needToMulti;

        if (needToCompound) {
            exp = stripOuterBrackets(exp);
            String[] bits = exp.split(" \\+ ");

            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj(e -> e + "")
                    .collect(Collectors.joining(" + "));

            return run(newExp);
        }

        if (needToPlus) {

            System.out.println("exp1 : " + exp);


            exp = exp.replace("- ", "+ -");




            String[] bits = exp.split(" \\+ ");

            int sum = 0;

            for (int i = 0; i < bits.length; i++) {
                sum += Integer.parseInt(bits[i]);
            }    return sum;
        } else if (needToMulti) {
            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }

        throw new RuntimeException("해석 불가 : 올바른 계산식이 아닙니다");

    }

    private static String stripOuterBrackets(String exp) {


        int outerBracketsCount = 0;

        while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length() - 1 - outerBracketsCount) == ')') {
            outerBracketsCount++;
        }

        if (outerBracketsCount == 0) return exp;

        return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
    }

}

// ======================= 더하기 곱하기 연산
//        boolean needToMulti = exp.contains("*");
//        boolean needToPlus = exp.contains("+");
//
//        boolean needToCompound = needToPlus && needToMulti;


//
//        if (needToCompound) {
//            String[] bits = exp.split(" \\+ ");
//
//
//            String newExp = "";
//                        for (int i = 0; i < bits.length; i++) {
//                            int result = Calc.run(bits[i]);
//                            newExp += result;
//                            if (i < bits.length - 1) {
//                                newExp += " + ";
//                            }
//                        }
//
//
//                         return run(newExp);


//====================replace를 이용한 괄호제거

//      if (!exp.contains(" ")) { //단일항이 들어오면 바로 리턴
//        return Integer.parseInt(exp);
//        }
//
//boolean needToMulti = exp.contains("*");
//boolean needToPlus = exp.contains("+"); // -음수 추가 || exp.contains("-");
//
//boolean needToCompound = needToPlus && needToMulti;
//boolean needToMinus =! (needToPlus || needToMulti);// 내가한거.
//
//        if (needToMinus) {
//String[] bits = exp.split( " - ");
//            return Integer.parseInt(bits[0]) - Integer.parseInt(bits[1]);
//    }
//            if (needToCompound) {
//exp = exp.replace("(" , "");
//exp = exp.replace(")" , "");
//String[] bits = exp.split(" \\+ ");
//
//
//
//            if (bits.length == 2) {
//        return Integer.parseInt(bits[0]) + run(bits[1]);
//            }
//                    if (bits.length == 3) {
//        return run(bits[0]) + Integer.parseInt(bits[1]) + run(bits[2]);
//            }
//
//
//                    return Integer.parseInt(bits[0]) + run(bits[1]);

//        }


// 강사님이 알려준 괄호제거
// 괄호 제거
//exp = stripOuterBrackets(exp);
//
//// 단일항이 들어오면 바로 리턴
//        if (!exp.contains(" ")) {
//        return Integer.parseInt(exp);
//        }
//
//boolean needToMulti = exp.contains(" * ");
//boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");
//
//boolean needToCompound = needToPlus && needToMulti;
//
//        if (needToCompound) {
//exp = stripOuterBrackets(exp);
//String[] bits = exp.split(" \\+ ");
//
//String newExp = Arrays.stream(bits)
//        .mapToInt(Calc::run)
//        .mapToObj(e -> e + "")
//        .collect(Collectors.joining(" + "));
//
//            return run(newExp);
//        }
//

// 아래는 맨밑에 더하기 곱하기 밑에
//private static String stripOuterBrackets(String exp) {
//
//    if (exp.charAt(0) == '(' && exp.charAt(exp.length() - 1) == ')') {
//        exp = exp.substring(1, exp.length() - 1);
//    }
//
//    return exp;