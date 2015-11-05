import java.util.ArrayList;
import java.util.List;


public class Test {
	public static void main(String[] args) {
		
		
		List<String> state_list = new ArrayList<String>();
		state_list.add("____");
		state_list.add("___");
		state_list.add("_____");
		state_list.add("__");
		
		int count = 0;
		int min = 100;
		String wordToBeProcessed = null;
		for(String s: state_list) {
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '_') count ++;
			}
			
			if(count<min) {
				min = count;
				wordToBeProcessed = s;
			}
			
			count = 0 ;
		}
		
		System.out.println(wordToBeProcessed);
		
	}
}
