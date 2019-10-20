import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//This is implementation for https://www.hackerrank.com/challenges/torque-and-development/submissions/code/60158401
//Define graph ALL edges first. Grouping connected nodes by using edges.
//Markers for visited node help to search node in one group.
public class Dfs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            long libCost = in.nextLong();
            long roadCost = in.nextLong();
            Graph graph = new Graph(n,false);             
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                graph.addEdge(city_1,city_2);
            }
            
            System.out.println(getCost(graph,libCost,roadCost));
        }
    }
    
    private static long getCost(Graph graph,long libCost,long roadCost){
        long cost = 0;
        if(libCost < roadCost){
            cost += graph.nodeNum*libCost;
        }else{            
            boolean[] visited = new boolean[graph.nodeNum +1];
            //Search each groups.
            for(int i=1;i<graph.nodeNum + 1;i++){
                if(!visited[i]){
                    cost += (getGroupDFS(graph,visited,i) - 1) * roadCost;
                    cost += libCost;   
                }
                //Loops after visiting all nodes in one group.
            }            
        }
        return cost;
    }
    
    //Count nodes in a group recursively.
    private static int getGroupDFS(Graph graph,boolean[] visited,int current){
        int result = 1;
        visited[current] = true;
        ArrayList<Integer> fromThis = graph.edges[current];
        for(int i:fromThis){
            if(!visited[i]){
                result += getGroupDFS(graph,visited,i); 
            }
        }        
        return result;
    }
}

class Graph{
    int nodeNum;
    private final boolean directed;
    ArrayList<Integer>[] edges;    
    
    Graph(int nodeNum,boolean directed){
        this.nodeNum = nodeNum;
        this.directed = directed;
        this.edges = new ArrayList[nodeNum + 1];
        for(int i = 0;i<nodeNum + 1;i++){
            edges[i] = new ArrayList<Integer>();
        }
    }
    
    public void addEdge(int node1,int node2){
        edges[node1].add(node2);
        if(!this.directed){
            edges[node2].add(node1);
        }
    }
}