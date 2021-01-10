package Main.GUI;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

class GUINode {
    private final StackPane container;
    private final int name;
    private final int x;
    private final int y;

    GUINode(int name, int x, int y){
        this.container = new StackPane();
        var c = new Circle(15);
        var t = new Text(""+name);


        this.name = name;
        this.container.getChildren().addAll(c,t);

        this.x = x;
        this.y = y;

        c.setFill(Color.RED);
        var tooltip = new Tooltip("Name : " + this.name);
        Tooltip.install(c, tooltip);
        this.container.setLayoutX(x);
        this.container.setLayoutY(y);
        t.setStyle("-fx-text-fill: white");
    }

    public StackPane getContainer() {
        return container;
    }

    public int getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "GUINode {" +
                "name = " + name +
                ", x = " + x +
                ", y = " + y +
                '}';
    }
}
