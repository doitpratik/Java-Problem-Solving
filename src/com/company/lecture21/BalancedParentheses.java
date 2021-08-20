package com.company.lecture21;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        String str = "{}()[]";
        System.out.println(balancedParenthesis(str));
    }

    private static boolean balancedParenthesis(String str) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                stk.push(ch);
            } else{
                char open = openBraces(ch);
                if(open != stk.pop()){
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    private static char openBraces(char ch) {
        if(ch == ')'){
            return '(';
        } else if(ch == '}'){
            return '{';
        } else{
            return '[';
        }
    }


}
