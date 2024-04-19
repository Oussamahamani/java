package edu.bhcc.fitnessTracker;

import jakarta.persistence.*;

@Entity
@Table(name = "Fitness")
public class Fitness {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String route;
    private String date;
    private double miles;

    /**
     * Protected Constructor, used by JPA..
     */
    protected Fitness(){

    }


    /**
     * Public Constructor, used to create new Objects.
     */
    public Fitness(String route, String date, double miles) {
        this.route = route;
        this.date = date;
        this.miles = miles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }


    @Override
    public String toString() {
        return String.format(
                "Todo[id=%d, text='%s', project='%s', completed=%b]",
                id, route, date, miles);
    }

}