package model;

/**
 * Product is an abstract class. It is used as the superclass of Movie and Serie.
 */
public abstract class Product {
    /**
     * name is the name of the product. It has to be unique in the system.
     */
    private String name;

    /**
     * directorName is the name of the director.
     */
    private String directorName;

    /**
     * synopsis is a brief summary about the product's argument.
     */
    private String synopsis;

    /**
     * Constructor of the class.
     * @param name String.
     * @param directorName String.
     * @param synopsis String.
     */
    public Product(String name, String directorName, String synopsis){
        this.name = name;
        this.directorName = directorName;
        this.synopsis = synopsis;
    }

// Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * toString method. It returns the properties in human readable format.
     */
    @Override
    public String toString(){
        String m = "";
        m += "Name: " + name;
        m+= "\nDirector: " + directorName;
        m+= "\nSynopsis: " + synopsis;
        
        return m;
    }
}
