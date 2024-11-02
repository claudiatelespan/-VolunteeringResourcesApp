package eu.ase.ro.volunteeringresources;

public class Persoana {
    private final int id;
    private String name;
    private int varsta;
    private String facultate;

    public Persoana(int id, String name, int varsta, String facultate) {
        this.id = IdGenerator.generatorId();
        this.name = name;
        this.varsta = varsta;
        this.facultate = facultate;
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

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", varsta=" + varsta +
                ", facultate='" + facultate + '\'' +
                '}';
    }



}
