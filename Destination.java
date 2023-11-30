/* Depht First Search
 * José Ángel Cardona García
 * 06/11/2023
 */
package depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AngelC-Linux
 */
public class Destination{
    
    private String name;
    private List<Destination> connections;

    public Destination(String name) {
        this.name = name;
        this.connections = new ArrayList<>();
    }

    public void addConnection(Destination destination) {
        connections.add(destination);
    }

    public List<Destination> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        return name;
    }
}

