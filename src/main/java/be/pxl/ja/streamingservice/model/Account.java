package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.util.List;

public class Account {
    private String email;
    private String password;
    private PaymentInfo paymentinfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        Profile profile1 = new Profile();
        profile1.setName("jef");
        profile1.setDateOfBirth(LocalDate.now());
        addProfile(profile1);
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void addProfile(Profile profile){
        profiles.add(profile);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean verifyPassword(String password) {
        return true;
    }

    public void setPaymentInfo(PaymentInfo paymentinfo) {
        this.paymentinfo = paymentinfo;
    }

    public Profile getFirstProfile(){
        return profiles.get(0);
    }
}
