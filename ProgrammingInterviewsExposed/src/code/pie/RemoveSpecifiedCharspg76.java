package code.pie;


public class RemoveSpecifiedCharspg76 {
	
	public static void main(String[] args) {
		
		String s = "Battle of the Vowels: Hawaii vs. Grozny";
		String r = "aeiou";
		System.out.println(removeSpecifiedChars(s, r));
		
	}

	private static String removeSpecifiedChars(String s, String r) {
		
		char[] sArray = s.toCharArray(); 
		boolean[] removeLookup = new boolean[128];
		for(int i=0; i<r.length(); i++) {
			removeLookup[r.charAt(i)] = true;
		}
		
		int src = 0;
		int dst = 0;
		
		while(src<sArray.length) {
			if(!removeLookup[sArray[src]]) {
				sArray[dst++] = sArray[src];
			}
			++src;
		}
		
		return new String(sArray, 0, dst);
				
	}

}
