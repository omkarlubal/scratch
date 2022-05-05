import java.util.*;

/*

a b c d e f g h
1 2 3 4 5 6 7 8

Input:
6 9
1 2 4
1 3 2
2 3 1
2 4 5
3 4 8
3 5 10
4 5 2
4 6 6
5 6 5
1
1 6


*/

class Djikstra {
	
	public static int getShortestPath(int source, int destination, int numOfNodes, List<int[]> edges) {
		int adjMatrix[][] = new int[numOfNodes+1][numOfNodes+1];
		
		for (int i = 0; i < edges.size(); i++) {
			int a = edges.get(i)[0];
			int b = edges.get(i)[1];
			int c = edges.get(i)[2];
			
			adjMatrix[a][b] = c;
			adjMatrix[b][a] = c;
		}
		
		int dist[] = new int[numOfNodes+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// minHeap, storing elements in order of min distance at top
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(
			(a,b) -> a[1] - b[1]
		);
		
		minHeap.add(new int[]{source, 0});
		
		while (!minHeap.isEmpty()) {
			int node[] = minHeap.poll();
			int start = node[0];
			int currentDistance = node[1];
			
			for (int i = 1; i <= numOfNodes; i++ ) {
				int distToNeighbour = adjMatrix[start][i];
				if ( distToNeighbour > 0 && currentDistance + distToNeighbour < dist[i]) {
					dist[i] = currentDistance + distToNeighbour;
					minHeap.add(new int[]{i, dist[i]});
				}
			}
		}
		
		return dist[destination];
		
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int numOfNodes = sc.nextInt();
		int numOfEdges = sc.nextInt();
		List<int[]> edges = new ArrayList<>();
		for ( int i = 0; i < numOfEdges; i++ ) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int d = sc.nextInt();
			edges.add(new int[] {a,b,d});
		}
		
		// find distances for given number of queries
		int t = sc.nextInt();
		
		while (t-- > 0) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			
			int distance = getShortestPath(src, dest, numOfNodes, edges);
			System.out.println("Shortest Distance between "+src+" and "+dest+" is "+distance);
		}
	}
}