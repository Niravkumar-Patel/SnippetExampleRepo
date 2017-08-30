package interviewque;

public class FindMinInsertions {

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static int findMinInsertions(String a, int start, int totalLength) {
		char[] str = a.toCharArray();

		if (start > totalLength)
			return Integer.MAX_VALUE;
		if (start == totalLength)
			return 0;
		if (start == totalLength - 1)
			return (str[start] == str[totalLength]) ? 0 : 1;

		return (str[start] == str[totalLength]) ? findMinInsertions(new String(str), start + 1, totalLength - 1)
				: (min(findMinInsertions(new String(str), start, totalLength - 1),
						findMinInsertions(new String(str), start + 1, totalLength)) + 1);
	}

	public static void main(String[] args) {
		String inputString = "abc";
		System.out.println(findMinInsertions(inputString, 0, inputString.length() - 1));
	}

}
