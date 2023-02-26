import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
//		중복단어 제거 + 오름차순 
		Set<String> voca = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return s1.length() != s2.length() ? s1.length() - s2.length() : s1.compareTo(s2); 
			}
			
		});

		for(int i = 0; i < N; i++) {
			voca.add(br.readLine());
		}
	
		Iterator<String> it = voca.iterator();
		while(it.hasNext())
			sb.append(it.next()).append("\n");
		
		System.out.println(sb.toString());
	}

}