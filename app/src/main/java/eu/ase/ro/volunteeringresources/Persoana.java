package eu.ase.ro.volunteeringresources;

public class Persoana {
    private int cnp;
    private String name;
    private int age;
    private String college;

    public Persoana(int cnp, String name, int age, String college) {
        this.cnp = cnp;
        this.name = name;
        this.age = age;
        this.college = college;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
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
