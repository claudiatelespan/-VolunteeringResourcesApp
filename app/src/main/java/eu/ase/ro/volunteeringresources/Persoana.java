package eu.ase.ro.volunteeringresources;

public class Persoana {
    private final int id;
    private String name;
    private int age;
    private String college;

    public Persoana(int id, String name, int age, String college) {
        this.id = IdGenerator.generatorId();
        this.name = name;
        this.age = age;
        this.college = college;
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                '}';
    }



}
