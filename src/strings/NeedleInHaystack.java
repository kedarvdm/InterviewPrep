package strings;

public class NeedleInHaystack {

	public static void main(String args[]) {

		String haystack = "abcdefghibcdajklmndcba";
		String needle = "bcda";

		int count = searchAnagramSubstring(haystack, needle);
		System.out.println(count);
	}

	public static int searchAnagramSubstring(String haystack, String needle) {
		int count = 0;
		int haystacklength = haystack.length();
		int needlelength = needle.length();

		if (haystacklength < needlelength | haystacklength == 0 | needlelength == 0) {
			return 0;
		}

		int haystackHist[] = new int[256];
		int needleHist[] = new int[256];

		int i = 0;
		for (i = 0; i < needlelength; i++) {
			needleHist[haystack.charAt(i)]++;
			haystackHist[haystack.charAt(i)]++;
		}

		while (i < haystacklength) {
			if (isAnagram(haystackHist, needleHist)) {
				System.out.println("anagram found : " + haystack.substring(i - needlelength, i));
				count++;
			}

			haystackHist[haystack.charAt(i)]++;
			haystackHist[haystack.charAt(i - needlelength)]--;
			i++;
		}

		return count;
	}

	private static boolean isAnagram(int[] haystack, int[] needle) {
		for (int i = 0; i < haystack.length; i++) {
			if (haystack[i] != needle[i]) {
				return false;
			}
		}

		return true;
	}
}
