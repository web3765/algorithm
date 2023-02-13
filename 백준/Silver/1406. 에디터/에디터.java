import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	static int cursor;
	static List<Character> list;
    
	public static void main(String[] args) throws IOException {
// 		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String original = br.readLine();
		list = new LinkedList<>();
		for(char c : original.toCharArray())
			list.add(c);
		cursor = list.size();		
		int N = Integer.parseInt(br.readLine());
// 		2. check
		ListIterator<Character> iter = list.listIterator();
		
		while(iter.hasNext())
			iter.next();
		
		for(int i=0; i<N; i++) {
			String toDo = br.readLine();
			check(toDo, iter);
		}
// 		3. output
		StringBuilder sb = new StringBuilder();
		for(char c : list)
			bw.write(c);
		
		bw.flush();
		bw.close();
	}

	private static void check(String toDo, ListIterator iter) {
		char tmp = toDo.charAt(0);
		switch(tmp) {
			case 'L' :
//				if(cursor > 0)
//				cursor -= 1;
				if(iter.hasPrevious())
					iter.previous();
				break;
			case 'D' :
//				if(cursor < list.size())
//					cursor += 1;
				if(iter.hasNext())
					iter.next();
				break;
			case 'B' :
//				if(cursor > 0) {
//					list.remove(cursor - 1);
//					cursor -= 1;
//				}
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P' :
//				if(cursor <= list.size()) {
//					list.add(cursor, toDo.charAt(2));
//					cursor += 1;
//				}
				iter.add(toDo.charAt(2));
				break;
			default : break;
		}	
	
	}

}