package be.pxl.ja.streamingservice.model;

import java.util.List;

public class Account {
    private String email;
    private String password;
    private PaymentInfo paymentinfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles;

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

    public void setPaymentinfo(PaymentInfo paymentinfo) {
        this.paymentinfo = paymentinfo;
    }

    public Profile getFirstProfile(){
        return profiles.get(0);
    }
}
