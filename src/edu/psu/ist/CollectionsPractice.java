package edu.psu.ist;

import java.util.Stack;

public final class CollectionsPractice {

    // note: this class should have no instance data/fields
    //       just do 1-4 using static methods (then test said
    //       methods from the 'test' directory using jUnit)
    public static boolean balanced(String bracketStack ) {
        Stack<Character> stackOfParenthesis = new Stack<>();
        for (int i = 0; i < bracketStack.length(); i++) {
            char ch = bracketStack.charAt(i);
            if (ch== '(' || ch=='[') {
                stackOfParenthesis.push(ch);
            }
            else if (ch==']') {
                if (stackOfParenthesis.peek() == '[') {
                    stackOfParenthesis.pop();
                } else {
                    return false;
                }
            }
                else if (ch==')') {
                    if (stackOfParenthesis.peek() == '(') {
                        stackOfParenthesis.pop();
                    }
                    else {
                        return false;
                    }
            }
        }

    }

}
