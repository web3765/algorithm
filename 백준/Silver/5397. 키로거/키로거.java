import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	static List<Character> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			list = new LinkedList<>();
			ListIterator<Character> iter = list.listIterator();

			for(char c : s.toCharArray()) 
				check(c, iter);
			
			for(char c : list) 
				sb.append(c);
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void check(char c, ListIterator<Character> iter) {
		
		switch(c) {
			case '<' : 
				if(iter.hasPrevious())
					iter.previous();
				break;
			case '>' : 
				if(iter.hasNext())
					iter.next();
				break;
			case '-' : 
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			default : 
				iter.add(c);
				break;
		}

	}

}