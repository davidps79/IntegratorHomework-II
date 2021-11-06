package model;

/**
 * Season is part of a Serie.
 */
public class Season {
    /**
     * number is the chronological position that the season occupies.
     */
    private String number;

    /**
     * numScheduledEpisodes is the amount of scheduled episodes.
     */
    private int numScheduledEpisodes;

    /**
     * numPublishedEpisodes is the amount of episodes that are already published.
     */
    private int numPublishedEpisodes;

    /**
     * trailerSource is the link of the trailer.
     */
    private String trailerSource;

    /**
     * releaseDate is an object of type Date.
     */
    private Date releaseDate;

    /**
     * Constructor of the class
     * @param number String.
     * @param numScheduledEpisodes int.
     * @param numPublishedEpisodes int.
     * @param trailerSource String.
     * @param releaseDate Date.
     */
    public Season(String number, int numScheduledEpisodes, int numPublishedEpisodes, String trailerSource, Date releaseDate){
        this.number = number;
        this.numScheduledEpisodes = numScheduledEpisodes;
        this.numPublishedEpisodes = numPublishedEpisodes;
        this.trailerSource = trailerSource;
        this.releaseDate = releaseDate;
    }

// Getters and setters

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumScheduledEpisodes() {
        return numScheduledEpisodes;
    }

    public void setNumScheduledEpisodes(int numScheduledEpisodes) {
        this.numScheduledEpisodes = numScheduledEpisodes;
    }

    public int getNumPublishedEpisodes() {
        return numPublishedEpisodes;
    }

    public void setNumPublishedEpisodes(int numPublishedEpisodes) {
        this.numPublishedEpisodes = numPublishedEpisodes;
    }

    public String getTrailerSource() {
        return trailerSource;
    }

    public void setTrailerSource(String trailerSource) {
        this.trailerSource = trailerSource;
    }

    public Date getReleaseDate(){
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
    }

    /**
     * toString method. It returns the properties in human readable format.
     */
    @Override
    public String toString(){
        String m = "";
        m+= "   - Number: " + number;
        m+= "\n   - Trailer source: " + trailerSource;
        m+= "\n   - Release date: " + releaseDate.toString();
        return m;
    }
}
