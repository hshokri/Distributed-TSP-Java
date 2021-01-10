package Main.Actors;

import Main.Graph.Draw;
import Main.Graph.Graph;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.Collections;

public class Actor extends AbstractActor {
    private Graph graph;
    private ArrayList<Integer> nodes;
    private Draw draw;
    private ArrayList<ActorRef> others;


    @Override
    public Receive createReceive() {
        return new ReceiveBuilder().match(Message.class, this::handel)
                .match(Data.class, this::init)
                .build();
    }

    private void init(Data data) {
        this.graph = data.graph;
        this.nodes = data.nodes;

        this.draw = data.draw;
        this.others = new ArrayList<>();
        Collections.addAll(this.others, data.others);

        this.nodes.remove(this.nodes.size() - 1);

        for(var i = 0; i < this.nodes.size() - 1; i++){
            this.draw.draw(
                    this.nodes.get(i),
                    this.nodes.get(i+1)
            );
        }
    }

    private void handel(Message message) {
        if(!this.graph.contains(message.end)) return;
        this.draw.draw(message.start, message.end);
    }
}
