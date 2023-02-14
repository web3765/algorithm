import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	 
    public static void main(String[] args) throws IOException {
//      1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=10; tc++) {
            int N = Integer.parseInt(br.readLine());
//      2. check
            int answer = 1;            
            boolean flag = false;
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                if(flag) continue;
                char tmp = st.nextToken().charAt(0);
                if(!st.hasMoreTokens()) {
                	if(!Character.isDigit(tmp)) {
                		flag = true;
                		answer = 0;
                	}
                }
            }
      
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
//      3. output
      System.out.println(sb.toString());
         
    }

}