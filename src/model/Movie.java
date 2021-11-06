package model;

/**
 * Movie is a type of product.
 */
public class Movie extends Product{

    /**
     * originalTitle is the title in the original languaje.
     */
    private String originalTitle;

    /**
     * producer is the in charge of producing the movie.
     */
    private String producer;

    /**
     * minimumAge is the minimum recommended age for watching the movie.
     */
    private int minimumAge;

    /**
     * category is the cinematographic classification. It is linked to the MovieCategory enumeration.
     */
    private MovieCategory category;
    private Date worldReleaseDate;

    /**
     * Constructor of the class.
     * @param name String.
     * @param directorName String.
     * @param synopsis String.
     * @param originalTitle String.
     * @param producer String.
     * @param minimumAge int.
     * @param category MovieCategory.
     * @param worldReleaseDate Date.
     */
    public Movie(String name, String directorName, String synopsis, String originalTitle, String producer, int minimumAge, MovieCategory category, Date worldReleaseDate){
        super(name, directorName, synopsis);
        this.originalTitle = originalTitle;
        this.producer = producer;
        this.minimumAge = minimumAge;
        this.worldReleaseDate = worldReleaseDate;
        this.category = category;
    }

// Getters and setters

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Date getWorldReleaseDate(){
        return worldReleaseDate;
    }

    public void setWorldReleaseDate(Date worldReleaseDate){
        this.worldReleaseDate = worldReleaseDate;
    }

    public MovieCategory getCategory(){
        return category;
    }

    public void setCategory(MovieCategory category){
        this.category = category;
    }

    /**
     * toString method. It returns the properties in human readable format.
     */
    @Override
    public String toString(){
        String m = super.toString();
        m+= "\nType: Movie";
        m+= "\nOriginal title: " + originalTitle;
        m+= "\nProducer: " + producer;
        m+= "\nMinimum age: " + minimumAge;
        m+= "\nCategory: " + category.name();
        m+= "\nWorldReleaseDate: " + worldReleaseDate.toString();
        return m;
    }
}
