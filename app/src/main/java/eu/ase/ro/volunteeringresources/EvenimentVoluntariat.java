package eu.ase.ro.volunteeringresources;

import java.util.Date;

public class EvenimentVoluntariat {
    private Integer id;
    private String numeEveniment;
    private String numeAsociatie;
    private Date dataEveniment;
    private String locatie;
    private String descriere;

    public String getNumeEveniment() {
        return numeEveniment;
    }

    public void setNumeEveniment(String numeEveniment) {
        this.numeEveniment = numeEveniment;
    }

    public String getNumeAsociatie() {
        return numeAsociatie;
    }

    public void setNumeAsociatie(String numeAsociatie) {
        this.numeAsociatie = numeAsociatie;
    }

    public Date getDataEveniment() {
        return dataEveniment;
    }

    public void setDataEveniment(Date dataEveniment) {
        this.dataEveniment = dataEveniment;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public EvenimentVoluntariat(String locatie, String descriere, Date dataEveniment, String numeAsociatie, String numeEveniment, Integer id) {
        this.locatie = locatie;
        this.descriere = descriere;
        this.dataEveniment = dataEveniment;
        this.numeAsociatie = numeAsociatie;
        this.numeEveniment = numeEveniment;
        this.id = id;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Eveniment: " + numeEveniment + "\n" +
                "Organizat de: " + numeAsociatie + "\n" +
                "Data: " + DateConverter.fromDate(dataEveniment) + "\n" +
                "Locatie: " + locatie + "\n" +
                "Descriere: " + descriere;
    }
}
