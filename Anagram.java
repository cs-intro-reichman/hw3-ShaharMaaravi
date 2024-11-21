/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String ph1 = preProcess(str1); 
		String ph2  = preProcess(str2); 
		int l1 = str1.length(); 
		int l2 = str2.length(); 
		if(l1 != l2){
			return false;
		}
		for(int i = 0; i < l1; i++){ 
			char indexA = ph1.charAt(i); 
			boolean exs = false; 
			for(int k = 0; k < l2; k++){ 
				char indexB = ph2.charAt(k);
				if(indexA == indexB){ 
					exs = true; 
					ph2 = ph2.substring(0, k) + "#" + ph2.substring(k + 1); 
				}
			}
			if (exs == false){ 
				return false; 
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerCaseText = str.toLowerCase(); 
		return lowerCaseText.replaceAll("[^a-z ]", "");
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int l1 = str.length(); 
		String results = ""; 
		String tempStr = str;
		for (int i = 0; i < l1; i++) { 
			int indexR = (int) (Math.random() * tempStr.length());
			results = results + tempStr.charAt(indexR); 
			tempStr = tempStr.substring(0, indexR) + tempStr.substring(indexR + 1);
		}
		return results;
	}
}
