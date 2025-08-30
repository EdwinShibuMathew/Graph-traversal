// If your editor flags this package line, set 'src' as your source root in VS Code or your IDE.
package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class graph_implement {

    private final LinkedList<Integer>[] adjacency;

    @SuppressWarnings("unchecked") // removes the offputting squiggles as it runs unchecked lol
    public graph_implement(int vertices){
        adjacency = new LinkedList[vertices]; // Unchecked warning suppressed above
        for(int i = 0; i < vertices; i++){
            adjacency[i] = new LinkedList<>();
        }
    }

    public void insertEdge(int source, int destination){
        adjacency[source].add(destination);
        adjacency[destination].add(source);
        //System.out.println("Source : " + adjacency[destination] + " Destination : " + adjacency[source]);
    }

    public void bfs(int startSource){
        boolean visited_nodes[] =new boolean [adjacency.length];
        int parent_nodes[] = new int [adjacency.length];
        Queue <Integer> q = new LinkedList<>();

        q.add(startSource);
        visited_nodes[startSource] = true;
        parent_nodes[startSource] = -1;

        while(!q.isEmpty()){
            int p = q.poll();
            System.out.print(p);
            for(int i : adjacency[p]){
                if(visited_nodes[i] != true){
                    visited_nodes[i] = true;
                    q.add(i);
                    parent_nodes[i] = p;
                }
            }
        }
        System.out.println();

    }
    public void dfs(int startSource){
        boolean visited_nodes[] = new boolean[adjacency.length];
        int parent_nodes[] = new int[adjacency.length];
        Stack <Integer> q = new Stack<>();

        q.add(startSource);
        visited_nodes[startSource] = true;
        parent_nodes[startSource] = -1;

        while(!q.isEmpty()){
            int p = q.pop();
            System.out.print(p);
            for(int i : adjacency[p]){
                if(visited_nodes[i] != true){
                    visited_nodes[i] = true;
                    q.add(i);
                    parent_nodes[i] = p;
                }
            }
        }
    }


    public static void main(String[] args){
        System.out.println("Enter number of vertices and edges: ");
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        graph_implement g = new graph_implement(vertices);

        System.out.println("Enter the source and destination vertices of each edge in order: ");
        for(int i = 0; i < edges; i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            g.insertEdge(source, destination);
        }

        System.out.println("Enter the source for the BFS + DFS(same start point) traversal: ");
        int startSource = sc.nextInt();
        sc.close();
        g.bfs(startSource);
        g.dfs(startSource);
        
    }
}
