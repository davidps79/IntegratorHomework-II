package model;

/**
 * StreamingSystem has most of the intern logic of the program. But it does not communicate with the user directly, its methods are called by the UserInterface class.
 */
public class StreamingSystem{
    /**
     * nit is a String corresponding to the legal business identification of the channel.
     */
    private String nit;

    /**
     * address is a String corresponding to the pysical address of the channel studio or headquarter.
     */
    private String address;

    /**
     * website is a String corresponding to the url of the website of the channel.
     */
    private String website;

    /**
     * suscriberAmount is an int that limits the amount of registered users in the system.
     */
    private int subscriberAmount;

    /**
     * productAmount is an int that limits the amount of registered products in the system.
     */
    private int productAmount;

    /**
     * seasonAmount is an int that limits the amount of registered seaons per serie.
     */
    private int seasonAmount;

    /**
     * subscribers is an array of Suscriber objects.
     */
    private Subscriber[] subscribers;

    /**
     * products is an array of Product objects.
     */
    private Product[] products;

    /**
     * Constructor of the class.
     * @param nit String.
     * @param address String.
     * @param website String.
     * @param subscriberAmount int.
     * @param productAmount int.
     * @param seasonAmount int.
     */
    public StreamingSystem(String nit, String address, String website, int subscriberAmount, int productAmount, int seasonAmount){
        this.nit = nit;
        this.address = address;
        this.website = website;
        this.subscriberAmount = subscriberAmount;
        this.productAmount = productAmount;
        this.seasonAmount = seasonAmount;
        subscribers = new Subscriber[subscriberAmount];
        products = new Product[productAmount];
    }

    
    /** 
     * Returns the index of the first available (empty) index of the suscriptors array. If there is no available space it returns -1.
     * @return index int corresponding to the available position of the array.
     */
    public int searchAvailableSubscriberIndex(){
        int index = -1;
        boolean flag = false;
        for (int i=0; i<subscriberAmount && !(flag); i++){
            if (getSubscriber(i)==null){
                index = i;
                flag = true;
            }
        }
        return index;
    }

    /** 
     * Returns the index of the first available (empty) index of the products array. If there is no available space it returns -1.
     * @return index int corresponding to the available position of the array.
     */
    public int searchAvailableProductIndex(){
        int index = -1;
        boolean flag = false;
        for (int i=0; i<productAmount && !(flag); i++){
            if (getProduct(i)==null){
                index = i;
                flag = true;
            }
        }
        return index;
    }

    
    /** 
     * Verifies if a subscriber's document number is unique in the system. Returns false if there are repeated identifications.
     * @param document String corresponding to the document number to be validated.
     * @return validation true only if the entered document number can be registered.
     */
    public boolean verifySubscriberDocumentNumber(String document){
        boolean validation = true;
        for (int i=0; i<subscriberAmount; i++){
            if (getSubscriber(i) != null && subscribers[i].getDocumentNumber().equals(document)){
                validation = false;
            }
        }
        return validation;
    }

    /** 
     * Verifies if a product's name is unique in the system. Returns false if there are repeated names.
     * @param name String corresponding to the document number to be validated.
     * @return validation true only if the entered document number can be registered.
     */
    public boolean verifyProductName(String name){
        boolean validation = true;
        for (int i=0; i<subscriberAmount; i++){
            if (getProduct(i) != null && products[i].getName().equals(name)){
                validation = false;
            }
        }
        return validation;
    }
    
    /**
     * Adds a subscriber object to the subscribers array. It needs all the attributes of the constructor of the class and it also needs an index or position of the array where store the object.
     * @param documentNumber String corresponding to the number of the legal identification of a subscriber.
     * @param fullName String corresponding to the full name of a subscriber.
     * @param age int corresponding to the age of a subscriber.
     * @param hoursToConsume int corresponding to the number of hours a subscriber is willing to consume BlackSnail products.
     * @param type Type (enumeration of model package) which the determines the category of a subscriber.
     * @param index int corresponding to an available index of the suscriptor array.
     */
    public void addSubscriber(String documentNumber, String fullName, int age, int hoursToConsume, Type type, int index){
        subscribers[index] = new Subscriber(documentNumber, fullName, age, hoursToConsume, type);
        System.out.println("The new subscriber has been successfully registered");
    }

    /**
     * Adds a movie to the array. It needs the attributes of the classes it contains.
     * @param name String.
     * @param directorName String.
     * @param synopsis String.
     * @param originalTitle String.
     * @param producer String.
     * @param minimumAge int.
     * @param category MovieCategory.
     * @param dateDay int. It is an attribute of the neccesary Date object.
     * @param dateMonth int.It is an attribute of the neccesary Date object.
     * @param dateYear int. It is an attribute of the neccesary Date object.
     * @param index int. It is automatically determined by the UserInteface class.
     */
    public void addMovie(String name, String directorName, String synopsis, String originalTitle, String producer,
    int minimumAge, MovieCategory category, int dateDay, int dateMonth, int dateYear, int index){

        Date worldReleaseDate = new Date(dateDay, dateMonth, dateYear);
        Product product = new Movie(name, directorName, synopsis, originalTitle, producer, minimumAge, category, worldReleaseDate);
        products[index] = product;
        System.out.println("The new movie has been successfully registered");
    }

    /**
     * Adds a serie to the array. It needs the attributes of the classes it contains.
     * @param name String.
     * @param directorName String.
     * @param synopsis String.
     * @param protagonists String[].
     * @param dateDay int. It is an attribute of the neccesary Date object.
     * @param dateMonth int. It is an attribute of the neccesary Date object.
     * @param dateYear int. It is an attribute of the neccesary Date object.
     * @param seasonNumScheduledEpisodes int. It is an attribute of the neccesary Season object.
     * @param seasonNumPublishedEpisodes int. It is an attribute of the neccesary Season object.
     * @param seasonTrailerSource String. It is an attribute of the neccesary Season object.
     * @param index int. It is automatically determined by the UserInteface class.
     */
    public void addSerie(String name, String directorName, String synopsis, String[] protagonists, int dateDay,
    int dateMonth, int dateYear, int seasonNumScheduledEpisodes, int seasonNumPublishedEpisodes, String seasonTrailerSource, int index){
        
        Date firstEmissionDate = new Date(dateDay, dateMonth, dateYear);
        Season firstSeason = new Season("1", seasonNumScheduledEpisodes, seasonNumPublishedEpisodes, seasonTrailerSource, firstEmissionDate);
        Product product = new Serie(name, directorName, synopsis, protagonists, firstEmissionDate, firstSeason, seasonAmount);
        products[index] = product;
        System.out.println("The new serie has been successfully registered");
    }


    /** 
     * Returns the subscriber object stored on an specific index of the subscriber array.
     * @param index int corresponding to the position where the neccessary object is stored.
     * @return Subscriber stored in the selected index. 
     */
    public Subscriber getSubscriber(int index){
        return subscribers[index];
    }

    /** 
     * Returns the product object stored on an specific index of the subscriber array.
     * @param index int corresponding to the position where the neccessary object is stored.
     * @return Product stored in the selected index. 
     */
    public Product getProduct(int index){
        return products[index];
    }

    
    /** 
     * Verififies if there exists at least one active subscriptor in the system. 
     * @return validation boolean, true only if the condition is satisfied. 
     */
    public boolean hasActiveSubscribers(){
        boolean validation = false;
        for (int i=0; i<subscriberAmount && !(validation); i++){
            Subscriber temp = getSubscriber(i);
            if (temp != null && temp.getState().equals(State.ACTIVE)){
                validation = true;
            }
        }
        return validation;
    }

    /** 
     * Verififies if there exists at least one product registered in the system. 
     * @return validation boolean, true only if the condition is satisfied. 
     */
    public boolean hasProducts(){
        boolean validation = false;
        for (int i=0; i<productAmount && !(validation); i++){
            Product temp = getProduct(i);
            if (temp != null){
                validation = true;
            }
        }
        return validation;
    }

    /** 
     * Verififies if there exists at least one serie registered in the system. 
     * @return validation boolean, true only if the condition is satisfied. 
     */
    public boolean hasSeries(){
        boolean validation = false;
        for (int i=0; i<productAmount && !(validation); i++){
            Product temp = getProduct(i);
            if (temp != null && (temp instanceof Serie)){
                validation = true;
            }
        }
        return validation;
    }

    /** 
     * Verififies if there exists at least one movie registered in the system. 
     * @return validation boolean, true only if the condition is satisfied. 
     */
    public boolean hasMovies(){
        boolean validation = false;
        for (int i=0; i<productAmount && !(validation); i++){
            Product temp = getProduct(i);
            if (temp != null && (temp instanceof Movie)){
                validation = true;
            }
        }
        return validation;
    }
    
    /** 
     * Deactivates a subscriber. It will set the state to inactive and reset the type to normal.
     * @param documentNumber document number of the subscriber to be deactivated.
     */
    public void deactivateSubscriber(String documentNumber){
        Subscriber subscriberToDeactivate = searchSubscriber(documentNumber);
        if (subscriberToDeactivate != null){
            subscriberToDeactivate.setType(Type.NORMAL);
            subscriberToDeactivate.setState(State.INACTIVE);
            System.out.println("The subscriber has been successfully deactivated");
        } else{
            System.out.println("There is no registered user with that document number");
        }
    }

    
    /** 
     * Searches a specific subscriber object on the array based on his document number.
     * @param documentNumber String corresponding to the identification of the subscriber to be located.
     * @return foundSubscriber Subscriber with the entered document number.
     */
    public Subscriber searchSubscriber(String documentNumber){
        Subscriber foundSubscriber = null;
        boolean flag = false;
        for (int i=0; i<subscriberAmount && !(flag); i++){
            Subscriber temp = getSubscriber(i);
            if (temp !=null && temp.getDocumentNumber().equals(documentNumber)){
                foundSubscriber = getSubscriber(i);
                flag = true;
            }
        }
        return foundSubscriber;
    }

    /** 
     * Searches a specific product object on the array based on his name. It is not case sensitive.
     * @param name String corresponding to the name of the product to be located.
     * @return foundProduct Product with the entered name.
     */
    public Product searchProduct(String name){
        Product foundProduct = null;
        boolean flag = false;
        for (int i=0; i<subscriberAmount && !(flag); i++){
            Product temp = getProduct(i);
            if (temp !=null && temp.getName().equalsIgnoreCase(name)){
                foundProduct = getProduct(i);
                flag = true;
            }
        }
        return foundProduct;
    }

    /**
     * Similar to the searchProduct method, but it returns the index of the found product and it only searches series. 
     * @param name String corresponding to the name of the serie to be located.
     * @return index position (int) where the object is located inside the array.
     */
    public int searchSerieIndex(String name){
        int index = -1;
        boolean flag = false;
        for (int i=0; i<subscriberAmount && !(flag); i++){
            Product temp = getProduct(i);
            if ((temp !=null && temp instanceof Serie) && temp.getName().equalsIgnoreCase(name)){
                index = i;
                flag = true;
            }
        }
        return index;
    }
    
    /**
     * Returns the amount of subscribers of each type and a total.
     * @return String message with the subscribers statistics.
     */
    public String getSubscribersInfo(){
        int[] stats = countSubscribers();
        String message = "The number of active subscribers is:" +
        stats[4] + ". These are distributed as follows:"
        + "\n a. Normal: " + stats[0]
        + "\n b. Platinum: " + stats[1]
        + "\n c. Gold: " + stats[2]
        + "\n d. Diamond: " + stats[3];
        return message;
    }

    /**
     * Returns a message with the state of an specific product.
     * @param name name of the product.
     * @return info String message with the product information. It returns an error message if the object does not exist. 
     */
    public String getProductInfo(String name){
        Product search = searchProduct(name);
        String info = "There is no product registered with that name";
        if (search != null){
            info = "\nProduct information...\n";
            info += search.toString();
        }

        return info;
    }

    
    /** 
     * Counts the amount of subscribers of each type and a total.
     * @return count int[] with the subscribers statistics.
     */
    public int[] countSubscribers(){
        int count[] = new int[5];
        for (int i=0; i<subscriberAmount; i++){
            Subscriber temp = getSubscriber(i);
            if (temp != null && temp.getState().equals(State.ACTIVE)){
                switch (temp.getType().name()){
                    case "NORMAL":
                        count[0]++;
                        break;
                    case "PLATINUM":
                        count[1]++;
                        break;
                    case "GOLD":
                        count[2]++;
                        break;
                    case "DIAMOND":
                        count[3]++;
                        break;
                }
            }
        }
        
        for (int i=0; i<(count.length-1); i++){
            count[4] += count[i];
        }
        return count;
    }

    
    /** 
     * Similar to hasActiveSubscribers but only for minors. It verifies if there is at least one active minor subscriptor in the system.
     * @return boolean
     */
    public boolean hasMinorActiveSubscribers(){
        boolean validation = false;
        for (int i=0; i<subscriberAmount && !(validation); i++){
            Subscriber temp = getSubscriber(i);
            if (temp != null && temp.getState().equals(State.ACTIVE) &&
                temp.getAge()<18){

                validation = true;
            }
        }
        return validation;
    }

    
    /** 
     * Returns the name of the minor subscriber with the longest amount of time willing to consume on BlackSnail.
     * @return nameCarry String corresponding to the name of the found minor.
     */
    public String getBestMinorSubscriberName(){
        int hoursCarry = -1;
        String nameCarry = "default";

        for (int i=0; i<subscriberAmount; i++){
            Subscriber temp = getSubscriber(i);
            if (temp != null && temp.getState().equals(State.ACTIVE)
                && temp.getAge()<18 && temp.getHoursToConsume() > hoursCarry){
                hoursCarry = temp.getHoursToConsume();
                nameCarry = temp.getFullName();
            }
        }
        return nameCarry;
    }

    /**
     * Adds a season to a serie. It perform all the necessary operations such as creating the Date and Season objects.
     * @param searchIndex int. It is automatically determined by the UserInteface class.
     * @param numScheduledEpisodes int.
     * @param numPublishedEpisodes int.
     * @param trailerSource String.
     * @param dateDay int. It is an attribute of the neccesary Season object.
     * @param dateMonth int. It is an attribute of the neccesary Season object.
     * @param dateYear int. It is an attribute of the neccesary Season object.
     */
    public void addSeasonToSerie(int searchIndex, int numScheduledEpisodes, int numPublishedEpisodes, String trailerSource, int dateDay, int dateMonth, int dateYear){
        Date releaseDate = new Date(dateDay, dateMonth, dateYear);
        String number = "";
        Season season = new Season(number, numScheduledEpisodes, numPublishedEpisodes, trailerSource, releaseDate);
        ((Serie) getProduct(searchIndex)).addSeason(season);
        System.out.println("The new season has been successfully added to the serie");
    }

    /**
     * Returns a string in the form of a list with the movies that belong to the indicated category.
     * @param category MovieCategory. It is the filter of the list.
     * @return list String with the list.
     */
    public String getMovieListByCategory(MovieCategory category){
        String list = "\nMovies belonging to the " + category.name().toLowerCase() + " category:";
        boolean flag = false;
        for (int i=0; i<productAmount; i++){
            Product temp = getProduct(i);
            if (getProduct(i) != null && (temp instanceof Movie) &&  ((Movie) temp).getCategory() == category){
                flag = true;
                list += "\n- " + temp.getName();
            }
        }

        if (!flag){
            list = "There are no movies registered in this category";
        }
        return list;
    }

    /**
     * Returns a string in the form of a list with the registered series and the information of the last season of each one of them.
     * @return list String with the list.
     */
    public String getSeriesList(){
        String list = "\nSeries added to the system:";
        boolean flag = false;
        for (int i=0; i<productAmount; i++){
            Product temp = getProduct(i);
            if (getProduct(i) != null && (temp instanceof Serie)){
                flag = true;
                list += "\n- " + temp.getName();
                list += "\n  Last season information:\n" + ((Serie) temp).getLastSeason().toString();
                list += "\n";
            }
        }

        if (!flag){
            list = "There are no series added to the system";
        }
        return list;
    }

    /**
     * toString method. It returns the properties in human readable format.
     */
    @Override
    public String toString(){
        String m= "";
        m+= "NIT: " + nit;
        m+= "\nAddress: " + address;
        m+= "\nWebsite link: " + website;
        return m;
    }
}