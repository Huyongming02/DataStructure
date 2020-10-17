package com.hym.datastructure.datastructure.stack;


import org.junit.Test;

public class ExpressionCalculateTest {

    @Test
    public void testSinle() {
        //a+b;a-b;
        //a*b;a/b;
        String expression1 = "10+20";
        System.out.println(expression1 + ":" + ExpressionCalculate.calculate(expression1));
        String expression2 = "10-20";
        System.out.println(expression2 + ":" + ExpressionCalculate.calculate(expression2));
        String expression3 = "10*20";
        System.out.println(expression3 + ":" + ExpressionCalculate.calculate(expression3));
        String expression4 = "100/20";
        System.out.println(expression4 + ":" + ExpressionCalculate.calculate(expression4));
    }

    @Test
    public void testSinle2() {
        //a+b+c;a+b-c;a-b-c;a-b+c
        String expression1 = "100+200+300";
        System.out.println(expression1 + ":" + ExpressionCalculate.calculate(expression1));
        String expression2 = "100+200-300";
        System.out.println(expression2 + ":" + ExpressionCalculate.calculate(expression2));
        String expression3 = "100-200+300";
        System.out.println(expression3 + ":" + ExpressionCalculate.calculate(expression3));
        String expression4 = "100-200-300";
        System.out.println(expression4 + ":" + ExpressionCalculate.calculate(expression4) + "\n");
        //a*b*c;a*b/c;a/b*c;a/b/c
        String expression5 = "100*200*300";
        System.out.println(expression5 + ":" + ExpressionCalculate.calculate(expression5));
        String expression6 = "100*200/300";
        System.out.println(expression6 + ":" + ExpressionCalculate.calculate(expression6));
        String expression7 = "1000/200*300";
        System.out.println(expression7 + ":" + ExpressionCalculate.calculate(expression7));
        String expression8 = "1000000/200/300";
        System.out.println(expression8 + ":" + ExpressionCalculate.calculate(expression8));
    }

    @Test
    public void testComplex() {
        //a+b*c;a+b/c;a-b*c;a-b/c;
        String expression1 = "100+200*300";
        System.out.println(expression1 + ":" + ExpressionCalculate.calculate(expression1));
        String expression2 = "100+2000/300";
        System.out.println(expression2 + ":" + ExpressionCalculate.calculate(expression2));
        String expression3 = "100-200*300";
        System.out.println(expression3 + ":" + ExpressionCalculate.calculate(expression3));
        String expression4 = "100-2000/300";
        System.out.println(expression4 + ":" + ExpressionCalculate.calculate(expression4) + "\n");
        //a*b+c;a*b-c;a/b+c;a/b-c;
        String expression5 = "100*200+300";
        System.out.println(expression5 + ":" + ExpressionCalculate.calculate(expression5));
        String expression6 = "100*200-300";
        System.out.println(expression6 + ":" + ExpressionCalculate.calculate(expression6));
        String expression7 = "1000/200+300";
        System.out.println(expression7 + ":" + ExpressionCalculate.calculate(expression7));
        String expression8 = "1000/200-300";
        System.out.println(expression8 + ":" + ExpressionCalculate.calculate(expression8));
    }

    @Test
    public void testParenthesis() {
        //a+(b+c);a+(b-c);a+(b*c);a+(b/c)
        String expression1 = "100+(200+300)";
        System.out.println(expression1 + ":" + ExpressionCalculate.calculate(expression1));
        String expression2 = "100+(200-300)";
        System.out.println(expression2 + ":" + ExpressionCalculate.calculate(expression2));
        String expression3 = "100+(200*300)";
        System.out.println(expression3 + ":" + ExpressionCalculate.calculate(expression3));
        String expression4 = "100+(2000/300)";
        System.out.println(expression4 + ":" + ExpressionCalculate.calculate(expression4));
    }

    @Test
    public void testParenthesisNest() {
        //a+(b+c+(e+f));a+(b+c-(e+f));a+(b+c*(e+f));a+(b+c*(e+f))
        String expression1 = "10+(20+30+(10+20))";
        System.out.println(expression1 + ":" + ExpressionCalculate.calculate(expression1));
        String expression2 = "10+(20+30-(10+20))";
        System.out.println(expression2 + ":" + ExpressionCalculate.calculate(expression2));
        String expression3 = "10+(20+30*(10+20))";
        System.out.println(expression3 + ":" + ExpressionCalculate.calculate(expression3));
        String expression4 = "10+(20+30/(1+2))";
        System.out.println(expression4 + ":" + ExpressionCalculate.calculate(expression4));
    }
}
