package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {

    public static boolean debug = true;
    public static int runCallCount = 0;

    public static int run(String exp) {
        runCallCount++;

        exp = exp.trim(); // 양 옆의 쓸데없는 공백 제거
        // 괄호 제거
        exp = stripOuterBrackets(exp);

        // 만약에 -( 패턴이라면, 내가 갖고있는 코드는 해석할 수 없으므로 해석할 수 있는 형태로 수정
        int[] pos = null;
        while ((pos = findCaseMinusBracket(exp)) != null) {
            exp = changeMinusBracket(exp, pos[0], pos[1]);
        }

        exp = stripOuterBrackets(exp);

        if (debug) {
            System.out.printf("exp(%d) : %s\n", runCallCount, exp);
        }

        // 단일항이 들어오면 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains(" * ");
        boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");
        boolean needToSplit = exp.contains("(") || exp.contains(")");
        boolean needToCompound = needToMulti && needToPlus;

        if (needToSplit) {
            exp = exp.replaceAll("- ", "+ -");
            int splitPointIndex = findSplitPointIndex(exp);

            String firstExp = exp.substring(0, splitPointIndex);
            String secondExp = exp.substring(splitPointIndex + 1);

            char operator = exp.charAt(splitPointIndex);

            exp = Calc.run(firstExp) + " " + operator + " " + Calc.run(secondExp);

            return Calc.run(exp);

        } else if (needToCompound) {
            String[] bits = exp.split(" \\+ ");

            String newExp = Arrays.stream(bits).mapToInt(Calc::run).mapToObj(e -> e + "").collect(Collectors.joining(" + "));




            return run(newExp);
        }

        if (needToPlus) {
            exp = exp.replaceAll("- ", "+ -");

            String[] bits = exp.split(" \\+ ");

            int sum = 0;

            for (int i = 0; i < bits.length; i++) {
                sum += Integer.parseInt(bits[i]);
            }

            return sum;
        } else if (needToMulti) {
            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }

        throw new RuntimeException("해석 불가 : 올바른 계산식이 아니야");
    }

    private static String changeMinusBracket(String exp, int startPos, int endPos) {
        String head = exp.substring(0, startPos);
        String body = "(" + exp.substring(startPos + 1, endPos + 1) + " * -1)";
        String tail = exp.substring(endPos + 1);

        exp = head + body + tail;


        return exp;
    }

    private static int[] findCaseMinusBracket(String exp) {
        for (int i = 0; i < exp.length() - 1; i++) {
            if (exp.charAt(i) == '-' && exp.charAt(i + 1) == '(') {
                // 발견

                int bracketsCount = 1;

                for (int j = i + 2; j < exp.length(); j++) {
                    char c = exp.charAt(j);

                    if (c == '(') {
                        bracketsCount++;
                    } else if (c == ')') {
                        bracketsCount--;
                    }

                    if (bracketsCount == 0) {
                        return new int[]{i, j};
                    }
                }
            }
        }

        return null;
    }

    private static int findSplitPointIndex(String exp) {
        int index = findSplitPointIndexBy(exp, '+');

        if (index >= 0) return index;

        return findSplitPointIndexBy(exp, '*');
    }

    private static int findSplitPointIndexBy(String exp, char findChar) {
        int bracketsCount = 0;

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '(') {
                bracketsCount++;
            } else if (c == ')') {
                bracketsCount--;
            } else if (c == findChar) {
                if (bracketsCount == 0) return i;
            }
        }
        return -1;
    }

    private static String stripOuterBrackets(String exp) {
        if (exp.charAt(0) == '(' && exp.charAt(exp.length() - 1) == ')') {
            int bracketsCount = 0;

            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '(') {
                    bracketsCount++;
                } else if (exp.charAt(i) == ')') {
                    bracketsCount--;
                }

                if (bracketsCount == 0) {
                    if (exp.length() == i + 1) {
                        return stripOuterBrackets(exp.substring(1, exp.length() - 1));
                    }

                    return exp;
                }
            }
        }

        return exp;


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
/// / 단일항이 들어오면 바로 리턴
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