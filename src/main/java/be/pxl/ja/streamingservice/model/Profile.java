package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Profile {
    private String name;
    private LocalDate dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(){
        return dateOfBirth.compareTo(LocalDate.now());
    }

    public boolean allowedToWatch(Content content){
        return getAge() >= content.getMaturityRating().getMinimumAge();
    }


}
