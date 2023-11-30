/* Depht First Search
 * José Ángel Cardona García
 * 06/11/2023
 */
package depthFirstSearch;

/**
 *
 * @author AngelC-Linux
 */
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    private List<List<Destination>> routes;
    private Set<Destination> visited;
    
    public Graph() {
        routes = new ArrayList<>();
        visited = new HashSet<>();
    }
    
    public void findRoutes(Destination start, Destination end, int maxRoutes) {
        List<Destination> currentRoute = new ArrayList<>();
        findRoutesHelper(start, end, currentRoute, maxRoutes);
    }
    
    private void findRoutesHelper(Destination current, Destination end, List<Destination> currentRoute, int maxRoutes) {
        currentRoute.add(current);
        
        if (current == end && !hasDuplicateRoute(currentRoute)) {
            routes.add(new ArrayList<>(currentRoute));
            if (routes.size() >= maxRoutes) {
                return;
            }
        }
        
        for (Destination neighbor : current.getConnections()) {
            if (!visited.contains(neighbor) && !hasDuplicateRoute(currentRoute)) {
                visited.add(neighbor);
                findRoutesHelper(neighbor, end, currentRoute, maxRoutes);
                visited.remove(neighbor);
                currentRoute.remove(currentRoute.size() - 1);
            }
        }
    }
    
    private boolean hasDuplicateRoute(List<Destination> currentRoute) {
        for (List<Destination> route : routes) {
            if (currentRoute.size() == route.size() && currentRoute.containsAll(route)) {
                return true;
            }
        }
        return false;
    }
    
    public void printRoutes(Destination start, Destination end) {
        System.out.println("\nLista de rutas desde: " + start + " hasta " + end + ":\n");
        //for (int i = 0; i < routes.size(); i++){}
        for (int i = 0; i < 3; i++) {
            //System.out.println("Ruta " + (i + 1) + " desde " + start + " hasta " + end + ":");
            List<Destination> route = routes.get(i);
            System.out.print((i + 1) + ": ");
            for (Destination destination : route) {
                System.out.print(destination + " ");
            }
            System.out.println("\n");
        }
    }
}
