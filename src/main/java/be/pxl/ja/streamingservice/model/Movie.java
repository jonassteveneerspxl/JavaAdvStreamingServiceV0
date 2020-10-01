package be.pxl.ja.streamingservice.model;
import java.time.LocalDate;

public class Movie extends Content implements Playable {
        private static final int LONG_PLAYING_TIME = 135;
        private String director;
        private LocalDate releaseDate;
        private int duration;
        private Genre genre;


        public Movie(String title , Rating maturityRating) {
            super(title , maturityRating);

        }

        public String getDirector () {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public LocalDate getReleaseDate () {
            return releaseDate;
        }

        public void setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
        }

        public int getDuration () {
            return duration;
        }

        @Override
        public void play() {
            System.out.println("Playing " + this);
        }

        @Override
        public void pause() {
            System.out.println("Pausing " + this);
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public boolean isLongPlayingTime(){
            return  duration > LONG_PLAYING_TIME;
        }

        public String getPlayingTime(){
            return "2 u 30 min";
        }

        public void setGenre(Genre genre) {
            this.genre = genre;
        }

        public Genre getGenre () {
            return genre;
        }

        @Override
    public String toString() {
            StringBuilder builder = new StringBuilder(super.toString());
            if(releaseDate != null) {
                builder.append(" (").append(releaseDate.getYear()).append(")");
            }
            return builder.toString();
        }

}

