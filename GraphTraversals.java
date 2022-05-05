import java.util.*;

class BFS {
	// BFS is used to find shortest path in unweighted graphs
	public static void startBFS(int numOfNodes, int numOfEdges, List<int[]> edges) {
		System.out.println(" *** BFS *** ");
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for (int i = 0; i < numOfNodes; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < numOfEdges; i++) {
			int a = edges.get(i)[0];
			int b = edges.get(i)[1];
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}
		
		Queue<Integer> traversing = new LinkedList<>();
		// root is always zero, if there are nodes in random numbers
		// then will have to use a hashmap for adjList
		traversing.add(0);
		
		boolean[] visited = new boolean[numOfNodes];
		visited[0] = true;
		
		while (!traversing.isEmpty()) {
			int currentNode = traversing.poll();
			System.out.print(currentNode+" ");
			
			List<Integer> neighbours = adjList.get(currentNode);
			for ( int node : neighbours ) {
				if ( !visited[node] ) {
					traversing.add(node);
					visited[node] = true;
				}
			}
			
		}
		
		System.out.println();
	}
}

class DFS {
	public static void startDFS(int numOfNodes, int numOfEdges, List<int[]> edges) {
		System.out.println(" === DFS === ");
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for (int i = 0; i < numOfNodes; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < numOfEdges; i++) {
			int a = edges.get(i)[0];
			int b = edges.get(i)[1];
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}
		
		boolean[] visited = new boolean[numOfNodes];
		dfs(0, visited, adjList);
		System.out.println();
	}
	
	static void dfs(int srcNode, boolean[] visited, List<List<Integer>> adjList) {
		visited[srcNode] = true;
		System.out.print(srcNode+" ");
		List<Integer> neighbours = adjList.get(srcNode);
		
		for (int node : neighbours) {
			if ( !visited[node] ) {
				dfs(node, visited, adjList);
				visited[node] = true;
			}
		}
	}
}

/*

Input:

5 7
0 1
0 4
1 4
4 3
3 1
3 2
1 2

*/

class GraphTraversals {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int numOfNodes = sc.nextInt();
		int numOfEdges = sc.nextInt();
		List<int[]> edges = new ArrayList<>();
		for ( int i = 0; i < numOfEdges; i++ ) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			edges.add(new int[] {a,b});
		}
		
		
		// Undirected Graph Traversal
		DFS.startDFS(numOfNodes, numOfEdges, edges);
		BFS.startBFS(numOfNodes, numOfEdges, edges);
	}
}