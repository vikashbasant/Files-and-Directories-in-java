package in.co.decimal.file;

import java.util.Stack;

public class IsValidString {
	public static void main(String[] args) {
		final String string = "*())";
		final boolean isValid = checkValidString(string);
		System.out.println(isValid);
	}

	public static boolean checkValidString(String s) {
		final Stack<Integer> open = new Stack<>();
		final Stack<Integer> star = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				open.push(i);
			} else if (s.charAt(i) == '*') {
				star.push(i);
			} else if (s.charAt(i) == ')') {
				if (!open.isEmpty()) {
					open.pop();
				} else if (!star.isEmpty()) {
					star.pop();
				} else {
					return false;
				}
			}
		}
		if (!open.isEmpty() && star.isEmpty()) {
			return false;
		}
		while (!open.isEmpty()) {
			if (!star.isEmpty()) {
				if (open.peek() > star.peek()) {
					return false;
				}
				star.pop();
				open.pop();
			}
		}
		return true;
	}
}
