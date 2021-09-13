package com.string;

import java.util.*;

public class Valid_Parentheses {

	public static void main(String[] args) {

		String s = "([}}])";
		System.out.println(isValid4(s));

	}

	public static boolean isValid3(String s) {
		char[] stack = new char[s.length()];
		int head = 0;

		for (char c : s.toCharArray()) {
			switch (c) {
				case '(':
					stack[head++] = ')';
					break;
				case '{':
					stack[head++] = '}';
					break;
				case '[':
					stack[head++] = ']';
					break;
				default:
					if (head == 0 || stack[--head] != c)
						return false;
					break;
			}
		}
		return head == 0;
	}

	public static boolean isValid4(String s) {
		if (s.length() % 2 != 0)
			return false;

		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			}else{
				return false;
			}
		}
		return stack.isEmpty();

	}

	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();

	}

	public static boolean isValid2(String s) {

		Map<Character, Character> mappings = new HashMap<Character, Character>();
		mappings.put(')', '(');
		mappings.put('}', '{');
		mappings.put(']', '[');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			if (mappings.containsKey(c)) {
				char topElement = stack.empty() ? '#' : stack.pop();
				if (topElement != mappings.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}

}
