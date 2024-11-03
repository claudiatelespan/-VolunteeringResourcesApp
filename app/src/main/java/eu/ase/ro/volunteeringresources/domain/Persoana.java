package eu.ase.ro.volunteeringresources.domain;

import java.io.Serializable;

public class Persoana implements Serializable {
    private String cnp;
    private String name;
    private int age;
    private String college;
    private String eveniment;

    public Persoana(String cnp, String name, int age, String college, String eveniment) {
        this.cnp = cnp;
        this.name = name;
        this.age = age;
        this.college = college;
        this.eveniment = eveniment;
    }

    public String getEveniment() {
        return eveniment;
    }

    public void setEveniment(String eveniment) {
        this.eveniment = eveniment;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "cnp=" + cnp +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                '}';
    }



}
