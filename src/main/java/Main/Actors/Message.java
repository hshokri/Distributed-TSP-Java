package Main.Actors;

public class Message {
    public final int start;
    public final int end;

    public Message(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Message {" +
                "end = " + this.end +
                "end = " + this.start +
                '}';
    }
}
