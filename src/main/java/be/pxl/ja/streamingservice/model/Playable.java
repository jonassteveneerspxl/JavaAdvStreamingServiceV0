package be.pxl.ja.streamingservice.model;

public interface Playable {
    int getDuration ();
    void play();
    void pause();
}
