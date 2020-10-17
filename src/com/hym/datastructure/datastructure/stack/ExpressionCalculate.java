package com.hym.datastructure.datastructure.stack;

import java.util.Stack;

/**
 * 表达式计算
 */
public class ExpressionCalculate {

    public static int calculate(String expression) {
        Stack<Integer> stackValue = new Stack<>();
        Stack<Character> stackOperator = new Stack<>();
        if (expression == null || expression.trim().length() == 0) {
            return Integer.MIN_VALUE;
        }

        char[] array = expression.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (ch >= '0' && ch <= '9') {
                int value = ch - '0';
                while (i + 1 < array.length && array[i + 1] >= '0' && array[i + 1] <= '9') {//获取操作数
                    value = value * 10 + array[i + 1] - '0';
                    i++;
                }
                stackValue.add(value);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int level = getLevel(ch);
                while (!stackOperator.isEmpty() && level <= getLevel(stackOperator.peek())) {//当前操作符比操作符栈顶的操作符级别低或者相等
                    calculate(stackValue, stackOperator);//执行计算：操作符栈顶元素出栈，从操作数
                }
                stackOperator.push(ch);//操作符入栈
            } else if (ch == '(') {//将左括号入栈
                stackOperator.push(ch);
            } else if (ch == ')') {//右括号，将括号内的表达式计算完毕
                while (!stackOperator.isEmpty() && stackOperator.peek() != '(') {
                    calculate(stackValue, stackOperator);
                }
                stackOperator.pop();//括号计算完之后，左括号出栈
            }
        }
        while (!stackOperator.isEmpty()) {//表达式已结束，将栈中所有数据计算完毕
            calculate(stackValue, stackOperator);
        }
        return stackValue.pop();
    }

    private static void calculate(Stack<Integer> stackValue, Stack<Character> stackOperator) {
        int num2 = stackValue.pop();
        char operator = stackOperator.pop();
        int num1 = stackValue.pop();
        switch (operator) {
            case '+':
                num2 = num1 + num2;
                break;
            case '-':
                num2 = num1 - num2;
                break;
            case '*':
                num2 = num1 * num2;
                break;
            case '/':
                num2 = num1 / num2;
                break;
        }
        stackValue.push(num2);
    }

    private static int getLevel(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 10;
            case '*':
            case '/':
                return 20;
            case '(':
            case '）':
                return 0;
        }
        return -1;
    }

}
