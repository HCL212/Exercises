/* Route Between Nodes: Given a directed graph, design an algorithm
 * to find out whether there is a route between two nodes.
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
// use graph traversal such as DFS or BFS
// start with either node, during traversal, check if
// other node has been found
// mark nodes as visited to avoid repetition and cycles when checking
// we use BFS here
enum State { Unvisited, Visited, Visiting; }

boolean search (Graph g, Node start, Node end) {
    if (start == end) return true;
    
    // operates as queue
    LinkedList<Node> q = new LinkedList<Node>();

    // mark all nodes as unvisited
    for (Node u : g.getNodes()) {
        u.state = State.Unvisited;
    }

    // mark start node as visiting, and put into queue
    start.state = State.Visiting;
    q.add(start);
    Node u;
    while (!q.isEmpty()) {
        u = q.removeFirst(); // dequeue()
        if (u != null) {
            // go through each adjacent node to u
            for (Node v : u.getAdjacent()) {
                // only look at nodes that are unvisited
                if (v.state == State.Unvisited) {
                    if (v == end) {
                        return true;
                    } else {
                        // make v "visiting"
                        // and add to end of queue
                        v.state = State.Visiting;
                        q.add(v);
                    }
                }
            }
            // mark node as visited and continue with queue
            u.state = State.Visited
        }
    }
    return false;
} 


