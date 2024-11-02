package eu.ase.ro.volunteeringresources.domain;

import java.io.Serializable;

public class Feedback implements Serializable {
    //private int idPersoana;
    //private int idEveniment;
    private String name;
    private String event;
    private String sugestii;
    private String comentarii;
    private float rating;

    private ParticipareViitoareEvenimente participareViitoareEvenimente;

    public Feedback(String name, String event, String sugestii, String comentarii, float rating, ParticipareViitoareEvenimente participareViitoareEvenimente) {

        this.name = name;
        this.event = event;
        this.sugestii = sugestii;
        this.comentarii = comentarii;
        this.rating = rating;
        this.participareViitoareEvenimente = participareViitoareEvenimente;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getSugestii() {
        return sugestii;
    }

    public void setSugestii(String sugestii) {
        this.sugestii = sugestii;
    }

    public String getComentarii() {
        return comentarii;
    }

    public void setComentarii(String comentarii) {
        this.comentarii = comentarii;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ParticipareViitoareEvenimente getParticipareViitoareEvenimente() {
        return participareViitoareEvenimente;
    }

    public void setParticipareViitoareEvenimente(ParticipareViitoareEvenimente participareViitoareEvenimente) {
        this.participareViitoareEvenimente = participareViitoareEvenimente;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                " name='" + name + '\'' +
                ", event='" + event + '\'' +
                ", sugestii='" + sugestii + '\'' +
                ", comentarii='" + comentarii + '\'' +
                ", rating=" + rating +
                ", participareViitoareEvenimente=" + participareViitoareEvenimente +
                '}';
    }
}
