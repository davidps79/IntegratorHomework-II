package model;

/**
 * It is a type of Product. It needs almost one Season to be created.
 */
public class Serie extends Product{
    /**
     * protagonists is a String array with the names of the protagonists.
     */
    private String[] protagonists;

    /**
     * censored indicates if the serie is censored. It is initialized as false by default. 
     */
    private boolean censored;

    /**
     * censoredReason indicates the reason of the censorhip.
     */
    private String censoredReason;

    /**
     * firstEmissionDate is the Date of the first emission. It has the same value as the releaseDate of its firstSeason.
     */
    private Date firstEmissionDate;

    /**
     * seasons is an array of Season objects. The first position starsthe first position is always initialized with a value since at least one season is required for each serie.
     */
    private Season[] seasons;

    /**
     * Constructor of the class.
     * @param name String.
     * @param directorName String.
     * @param synopsis String.
     * @param protagonists String[].
     * @param firstEmissionDate Date.
     * @param firstSeason Season.
     * @param maximumSeasonAmount int. This value determines the maximum amount of seasons that can be registered. 
     */
    public Serie(String name, String directorName, String synopsis, String[] protagonists, Date firstEmissionDate, Season firstSeason, int maximumSeasonAmount){
        super(name, directorName, synopsis);
        this.protagonists = protagonists;
        this.censored = false;
        this.censoredReason = "This product is not censored";
        this.firstEmissionDate = firstEmissionDate;
        seasons = new Season[maximumSeasonAmount];
        seasons[0] = firstSeason;
    }

// Getters and setters

    public String[] getProtagonists() {
        return protagonists;
    }

    public void setProtagonists(String[] protagonists) {
        this.protagonists = protagonists;
    }

    public boolean getCensored() {
        return censored;
    }

    public void setCensored(boolean censored) {
        this.censored = censored;
    }

    public String getCensoredReason() {
        return censoredReason;
    }

    public void setCensoredReason(String censoredReason) {
        this.censoredReason = censoredReason;
    }

    public Date getFirstEmissionDate(){
        return firstEmissionDate;
    }

    public void setFirstEmissionDate(Date firstEmissionDate){
        this.firstEmissionDate = firstEmissionDate;
    }

    public Season getSeason(int index){
        return seasons[index];
    }

    /**
     * Returns specifically the last season.
     * @return Season 
     */
    public Season getLastSeason(){
        boolean flag = false;
        int index = 0;
        for (int i=1; i<seasons.length && !flag; i++){
            if (getSeason(i) == null){
                index = i-1;
                flag = true;
            }
        }
        return seasons[index];
    }

    public void setSeason(int index, Season season){
        seasons[index] = season;
    }

    /**
     * Returns the index of the first available position of the array of Season.
     * @return index int
     */
    public int searchAvailableSeasonIndex(){
        int index = -1;
        boolean flag = false;
        for (int i=0; i<seasons.length && !flag; i++){
            if (getSeason(i) == null){
                index = i;
                flag = true;
            }
        }
        return index;
    }

    /**
     * Adds a Season to the serie.
     * @param season the Season to be added.
     */
    public void addSeason(Season season){
        int index = searchAvailableSeasonIndex();
        seasons[index] = season;
        seasons[index].setNumber((index + 1) + "");;
    }
    
    /**
     * toString method. It returns the properties in human readable format.
     */
    @Override
    public String toString(){
        String m = super.toString();
        m+= "\nType: Serie";
        m+= "\nProtagonists: ";
        for (int i=0; i<protagonists.length; i++){
            if (protagonists[i]!=null)
                m+= protagonists[i];
            else
                break;

            if (i<protagonists.length-1)
                m+= ", ";
        }
        m+= "\nCensored: " + censored;
        m+= "\nCensored reason: " + censoredReason;
        m+= "\nFirst emission date: " + firstEmissionDate.toString();
        m+= "\nSeason: ";
        for (int i=0; i<seasons.length; i++){
            if (getSeason(i) != null){
                m+= "\n" + seasons[i].toString() + "\n";
            }
        }
        return m;
    }
}
