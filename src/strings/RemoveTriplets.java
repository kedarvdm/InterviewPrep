package strings;

public class RemoveTriplets {

	public static void main(String args[]) {
		
		System.out.println(removeTriplets("aabbbacdddcccdcccdcc"));
		
		int a = 1;
		int b = 0;
		
		System.out.println(Integer.compare(a, b));

	}

	public static String removeTriplets(String s) {

		if (s.length() < 3) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(s);

		int start = 0;
		while (start < sb.length() - 2) {
			char c = sb.charAt(start); // initial char
			if (sb.charAt(start + 1) == c && sb.charAt(start + 2) == c) {
				sb.delete(start, start + 3);
				//reset the start
				start = 0;
			} else {
				start++;
			}
		}
		return sb.toString();
	}
}
