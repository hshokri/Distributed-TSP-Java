package Main.GUI;

import akka.actor.*;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

import java.util.*;

public class MainViewController {
    @FXML
    private TextField nodeCount;
    @FXML
    private TextField maxEdgeCount;
    @FXML
    private TextField serverCount;
    @FXML
    private AnchorPane graphPanel;

    private ArrayList<Props> actors;
    private ActorSystem system;

    public MainViewController() {
        this.actors = new ArrayList<>();
        this.system = ActorSystem.create("Solver");
    }

    public void generateGraph(){
        this.graphPanel.getChildren().clear();
        this.actors.clear();

        var nc = 0;
        var me = 0.0;
        var actorCount = 1;

        try {

            nc = Integer.parseInt(nodeCount.getText());
            me = Double.parseDouble(maxEdgeCount.getText());
            actorCount = (int)Double.parseDouble(this.serverCount.getText());

        }catch (NumberFormatException exception) {
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Bad input number");
            alert.showAndWait();
        }

        var location = new GUINode[nc];
        var e = new int[nc][nc];
        var random = new Random();

        // creating GUI nodes
        for(var i = 0; i < nc; i++){
            var x = (int)Math.abs(800 - 800 *  Math.cos((i * Math.PI * 2 )/nc));
            var y = (int)Math.abs(650 - 800 *  Math.sin((i * Math.PI * 2 )/nc));
            location[i] = new GUINode(i, x, y);
        }

        // creating graph nodes
        for (var i = 0; i < nc; i++) {
            for (var j = 0; j < i; j++) {
                double r = random.nextDouble() % Double.MAX_VALUE;
                if(r < me && e[i][j] == 0){
                    e[i][j] = Math.abs(random.nextInt() % 5);
                    e[j][i] = e[i][j];
                }
            }
        }

        // adding graph to the panel
        for(var i = 0; i < nc; i++){
            this.graphPanel.getChildren().add(location[i].getContainer());
            for(var j = 0; j < i; j++){
                if(e[i][j] != 0) {
                    var line = new Line(location[i].getX()+10, location[i].getY()+15, location[j].getX()+15, location[j].getY()+10);
                    var tooltip = new Tooltip("(start: " + i + "\tend: " + j + ")\tConst : "+e[i][j]);

                    Tooltip.install(line, tooltip);
                    line.setStrokeWidth(5);

                    this.graphPanel.getChildren().add(line);
                }
            }
        }

    }
}
