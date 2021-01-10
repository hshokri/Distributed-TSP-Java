package Main.Actors;

import Main.Graph.Draw;
import Main.Graph.Graph;
import akka.actor.ActorRef;

import java.util.ArrayList;

public class Data {
    public final Graph graph;
    public final ArrayList<Integer> nodes;
    public final Draw draw;
    public final ActorRef[] others;

    public Data(Graph graph, ArrayList<Integer> nodes, Draw draw, ActorRef... others){

        this.graph = graph;
        this.nodes = nodes;
        this.draw = draw;
        this.others = others;
    }

    public Graph getGraph() {
        return graph;
    }

    public ArrayList<Integer> getNodes() {
        return nodes;
    }

    public Draw getDraw() {
        return draw;
    }

    public ActorRef[] getOthers() {
        return others;
    }
}
