package practical8;
import java.util.*;
/**
 * Implementation of the GraphADT interface using an adjacency list with LinkedLists.
 */
class Graph implements GraphADT {
    private int nNodes; // Number of nodes
    private int nEdges; // Number of edges
    private List<LinkedList<Integer>> adjacencyList; // Adjacency list representation

    public Graph(int nodes) {
        this.nNodes = nodes;
        this.nEdges = 0;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    @Override
    public int nNodes() {
        return nNodes;
    }

    @Override
    public int nEdges() {
        return nEdges;
    }

    @Override
    public boolean addEdge(int node1, int node2) {
        if (node1 < 0 || node1 >= nNodes || node2 < 0 || node2 >= nNodes) {
            throw new IllegalArgumentException("Invalid node indices");
        }
        if (adjacencyList.get(node1).contains(node2)) {
            return false; // Edge already exists
        }
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1); // Because the graph is undirected
        nEdges++;
        return true;
    }

    @Override
    public boolean isEdge(int node1, int node2) {
        if (node1 < 0 || node1 >= nNodes || node2 < 0 || node2 >= nNodes) {
            // Invalid node number -> cannot make edge between them:
            throw new IllegalArgumentException("Invalid node indices");
        }

        return adjacencyList.get(node1).contains(node2);
    }

    @Override
    public ArrayList<Integer> neighbours(int node) {
        if (node < 0 || node >= nNodes) {
            throw new IllegalArgumentException("Invalid node index");
        }
        return new ArrayList<>(adjacencyList.get(node));
    }

    @Override
    public List<Integer> dfs(int startNode) {
        if (startNode < 0 || startNode >= nNodes) {
            throw new IllegalArgumentException("Invalid start node");
        }// Valid:
        List<Integer> visitedOrder= new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean [nNodes]; // Auto false:
        stack.push(startNode); // Push start node to begin
        visited[startNode] = true;
        while(!stack.isEmpty()) {
            int currentNode = stack.pop(); // Pop the node we are looking at off
            visitedOrder.add(currentNode); // Mark it as visited
            visited[currentNode] = true;
            System.out.println(currentNode+" ");
            for(int neighbour : adjacencyList.get(currentNode)) {
                // Getting all neighbours for our currentNode to consider for our search:
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                }
            }
        }
        return visitedOrder;

        /*
        List<Integer> visitedOrder = new ArrayList<>();
        boolean [] visited = new boolean [nNodes]; // Auto false:
        //System.out.println(startNode + "");
        visited[startNode] = true; // Mark it off:
        for(int i = 0; i<neighbours(startNode).size(); i++) {
            if (!visited[neighbours(startNode).get(i)]) {
                dfs(neighbours(startNode).get(i));
                visitedOrder.add(neighbours(startNode).get(i));
            }
        }
         */
    }

    @Override
    public List<Integer> bfs(int startNode) {
        if (startNode < 0 || startNode >= nNodes) {
            throw new IllegalArgumentException("Invalid start node");
        }

        // Creating Shit:
        boolean[] visited = new boolean [nNodes];
        List<Integer> visitedOrder= new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Push start node into the queue and mark it as visited:
        queue.add(startNode);
        visited[startNode] = true;

        // Explore queue:
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            visitedOrder.add(currentNode);
            System.out.println(currentNode+" ");
            for(int neighbour : adjacencyList.get(currentNode)) {
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return visitedOrder;
    }
}

/**
 * Test class for the Graph implementation.
 */
class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5); // A graph with 5 nodes
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        

        System.out.println("Number of nodes: " + graph.nNodes());
        System.out.println("Number of edges: " + graph.nEdges());

        System.out.println("DFS starting from node 0: " + graph.dfs(0));
        System.out.println("BFS starting from node 0: " + graph.bfs(0));
    }
}
