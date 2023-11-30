/* Depht First Search
 * José Ángel Cardona García
 * 06/11/2023
 */
package depthFirstSearch;

/**
 *
 * @author AngelC-Linux
 */

public class MainDFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Destination NY = new Destination("NY");
        Destination Chi = new Destination("Chi");
        Destination Tor = new Destination("Tor");
        Destination Cal = new Destination("Cal");
        Destination Den = new Destination("Den");
        Destination Hou = new Destination("Hou");
        Destination Urb = new Destination("Urb");
        Destination LA = new Destination("LA");

        NY.addConnection(Chi);
        NY.addConnection(Tor);
        NY.addConnection(Den);
        Chi.addConnection(Den);
        Tor.addConnection(Cal);
        Tor.addConnection(LA);
        Den.addConnection(Hou);
        Den.addConnection(LA);
        Den.addConnection(Urb);
        Urb.addConnection(LA);
        Hou.addConnection(LA);

        Graph graph = new Graph();
        //graph.findRoute(NY, LA);
        //graph.printRoute(NY, LA);
        graph.findRoutes(NY, LA, 3);
        graph.printRoutes(NY, LA);
    }
}

