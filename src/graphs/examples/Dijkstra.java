package graphs.examples;

import java.util.*;

class Dijkstra {

	
		
		public  int V=7;
		public  PriorityQueue<Node> queue;
		public  HashSet<Integer> visitedSet;
		public  int[] dist;
		
		public Dijkstra(Integer V){
			this.V=V;
			this.queue = new PriorityQueue<Node>(V, new Node());
			this.visitedSet = new HashSet<Integer>();
			this.dist = new int[V];
		}
		
		public void performDijkstra(List<List<Node> > graph, Integer source) {
			
			queue.add(new Node(source,0));
			for(int i=0; i<V; i++)
				dist[i]=Integer.MAX_VALUE;
			
			dist[source]=0;
			
			while(visitedSet.size()!=V) {
				int u = queue.remove().node;
				visitedSet.add(u);
				visitNeighbour(graph,u);
				
			}
			
			
		}
		
		public  void visitNeighbour(List<List<Node> > graph, Integer start) {
			//int currDistance=-1;
			int newDistance =-1;
			List<Node> nodes = graph.get(start);
			for(Node elem: nodes) {
				if(visitedSet.contains(elem.node)) {
					continue;
				}
				//currDistance = elem.cost;
				newDistance = dist[start]+ elem.cost;
				
				if(newDistance<dist[elem.node]){
					dist[elem.node]=newDistance;					
				}
				queue.add(new Node(elem.node,dist[elem.node]));
			}
			
		}
		
		public static void main(String arg[]) 
	    { 
	        int V = 5; 
	        int source = 0; 
	  
	        // Adjacency list representation of the  
	        // connected edges 
	        List<List<Node> > adj = new ArrayList<List<Node> >(); 
	  
	        // Initialize list for every node 
	        for (int i = 0; i < V; i++) { 
	            List<Node> item = new ArrayList<Node>(); 
	            adj.add(item); 
	        } 
	  
	        // Inputs for the DPQ graph 
	        adj.get(0).add(new Node(1, 9)); 
	        adj.get(0).add(new Node(2, 6)); 
	        adj.get(0).add(new Node(3, 5)); 
	        adj.get(0).add(new Node(4, 3)); 
	  
	        adj.get(2).add(new Node(1, 2)); 
	        adj.get(2).add(new Node(3, 4)); 
	  
	        // Calculate the single source shortest path 
	        Dijkstra dpq = new Dijkstra(V); 
	        dpq.performDijkstra(adj, source); 
	  
	        // Print the shortest path to all the nodes 
	        // from the source node 
	        System.out.println("The shorted path from node :"); 
	        for (int i = 0; i < dpq.dist.length; i++) 
	            System.out.println(source + " to " + i + " is "
	                               + dpq.dist[i]); 
	    } 
	} 
	  
	// Class to represent a node in the graph 
	class Node implements Comparator<Node> { 
	    public int node; 
	    public int cost; 
	  
	    public Node() 
	    { 
	    } 
	  
	    public Node(int node, int cost) 
	    { 
	        this.node = node; 
	        this.cost = cost; 
	    } 
	  
	    @Override
	    public int compare(Node node1, Node node2) 
	    { 
	        if (node1.cost < node2.cost) 
	            return -1; 
	        if (node1.cost > node2.cost) 
	            return 1; 
	        return 0; 
	    } 
	} 

