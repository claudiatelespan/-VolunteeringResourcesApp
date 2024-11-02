package eu.ase.ro.volunteeringresources;

public class IdGenerator {

    private static int idCounter =1;


    public static int generatorId()
    {
        return idCounter++;
    }


}
