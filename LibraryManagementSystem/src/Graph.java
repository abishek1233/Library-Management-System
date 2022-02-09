
/*
* Graph.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* Graph object with all the methods of the data-structure.
* 
*
*/

public class Graph {
	public static class Node implements Comparable {
		private Comparable info;
		private Vector edges;
		private Boolean visited;

		public Node(Comparable label) {
			this.info = label;
			this.edges = new Vector(50);
			visited = false;
		}

		public void addEdge(Edge e) {
			edges.addLast(e);
		}

		public int compareTo(Object o) {
			Node n = (Node) o;
			return n.info.compareTo(info);
		}

		public Comparable getLabel() {
			return info;
		}

		public Vector getEdges() {
			return this.edges;
		}

	}

	public static class Edge implements Comparable {
		private Node toNode;
		private double distance;

		public Edge(Node to, double distance) {
			this.toNode = to;
			this.setDistance(distance);
		}

		public int compareTo(Object o) {
			Edge n = (Edge) o;
			return n.toNode.compareTo(toNode);
		}

		public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}

		public Comparable toNodeLabel() {
			return this.toNode.getLabel();
		}
	}

	private Vector nodes;

	public Graph() {
		nodes = new Vector(50);
	}

	public void addNode(Node label) {
		nodes.addLast(label);
	}

	public Node findNode(Comparable nodeLabel) {
		Node res = null;
		for (int i = 0; i < nodes.size(); i++) {
			Node n = (Node) nodes.get(i);
			if (n.getLabel() == nodeLabel) {
				res = n;
				break;
			}
		}
		return res;
	}

	public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2, double distance) {
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2);
		n1.addEdge(new Edge(n2, distance));
	}

	public Vector findPath(Comparable nodeLabel1, Comparable nodeLabel2) {
		// the commented out parts are a less efficient implementation of fixing the
		// problem of cycles
		// Nodes to false variable instead of vector so the vector does not need to be
		// traversed each time to check if you have visited a node
		this.nodesToFalse();
		Vector path = new Vector(20);
		// Vector visitedNodes = new Vector(20);
		Node startState = findNode(nodeLabel1);
		Node endState = findNode(nodeLabel2);
		Stack toDoList = new Stack(20);
		toDoList.push(startState);
		while (!toDoList.empty()) {
			// pop a node and add it to the path
			Node current = (Node) toDoList.pop();
			path.addLast(current);
			// If this node is the endstate: return path
			if (current.compareTo(endState) == 0) {
				return path;
			}
			// if not, push its children on to the ToDo stack
			else if (current.visited == false) {
				for (int i = 0; i < current.edges.size(); i++) {
					Edge e = (Edge) current.edges.get(i);
					toDoList.push(e.toNode);
					// if the endState gets pushed onto the stack, we know it is a direct child of
					// our current node and we don't have to loop through the other nodes,
					// we just add the endstate to the path and return the path
					// this reduces the length of the path taken, without regarding edge weight
					if (e.toNode.compareTo(endState) == 0) {
						path.addLast(endState);
						return path;

					}
					// after you push a node's children on the to do list you have visited it
					current.visited = true;
				}
			}
		}
		return path;
	}

	private void nodesToFalse() {
		for (int i = 0; i < this.nodes.size(); i++) {
			((Node) nodes.get(i)).visited = false;
		}
	}

}