import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main1325{
    
    static int N,M;
    static ArrayList<Integer> com[];
    static boolean check[];
    static int cnt[] = new int[10001];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        com = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            com[i] = new ArrayList();
        }
        
        for(int i = 0 ; i < M ; i++){
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            com[x].add(y);
        }
        
        for(int i =1; i<= N ;i++){
            check = new boolean[N+1];
            dfs(i);
        }
        
        int max = 0;
        for(int i =1 ; i <= N ; i++){
            if(max <cnt[i]){
                max = cnt[i];
            }
        }
        for(int i = 1 ; i <= N ; i++){
            if(cnt[i]==max){
                System.out.print(i+" ");
            }
        }
    }
    
    public static void dfs(int here){
        check[here]=true;
        for(int there : com[here]){
            if(!check[there]){
                dfs(there);
                cnt[there]++;
            }
        }
    }
}
