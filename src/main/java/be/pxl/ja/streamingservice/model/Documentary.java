package be.pxl.ja.streamingservice.model;

public class Documentary extends Movie {

    private String topic;

    public Documentary(String title, Rating maturityRating) {
        super(title, maturityRating);
        setGenre(Genre.DOCUMENTARY);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void play() {
        System.out.println("Playing " + topic);
    }

    public void pause() {
        System.out.println("Pausing " + topic);
    }
}
