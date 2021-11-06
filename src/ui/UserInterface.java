package ui;

/**
 * It Requires the class StreamingSystem from model package.
 */
import model.StreamingSystem;

/**
 * It requires the enumeration Type from model package.
 */
import model.Type;

/**
 * It requires the enumeration MovieCategory from model package.
 */
import model.MovieCategory;

/**
 * It requires the Scanner class for reading text input.
 */
import java.util.Scanner;

/**
 * UserInterface is the class that communicates with users. It works together with the class StreamingSystem.
 */
public class UserInterface{
    /**
     * exit is a boolean that determines when the program stops running.
     */
    private boolean exit;

    /**
     * currentMenu is an int that indicates the menu where the user is.
     */
    private int currentMenu;

    /**
     * sc is the Scanner object used for asking data.
     */
    private Scanner sc;

    /**
     * blackSnail is the connection with the class StreamingSystem.
     */
    private StreamingSystem blackSnail;

    /**
     * SUSCRIBER_LIMIT is an int that determines the maximum number of subscribers the program can have.
     */
    private final int SUSCRIBER_LIMIT = 50;

    /**
     * PRODUCT_LIMIT is an int that determines the maximum number of products the program can have.
     */
    private final int PRODUCT_LIMIT = 85;

    /**
     * SEASON_LIMIT is an int that determines the maximum number of sesons each serie can have.
     */
    private final int SEASON_LIMIT = 20;

    /**
     * MENU_MESSAGE is the String used as the default message in all menus.
     */
    private final String MENU_MESSAGE = "Select an option:";

    /**
     * MAIN_MENU_OPTIONS is a String array that contains the options to be displayed on the main menu.
     */

    private final String[] MAIN_MENU_OPTIONS = {"Manage subscribers", "Manage product catalog"};

    /**
     * SUSCRIBER_MENU_OPTIONS is a String array that contains the options to be displayed on the subscriber submenu.
     */
    private final String[] SUSCRIBER_MENU_OPTIONS = {"Register a subscriber", "Deactivate a subscriber", "Show subscriber list", "Show underage subscriber with the highest number of hours willing to consume"};
    
    /**
     * PRODUCT_MENU_OPTIONS is a String array that contains the options to be displayed on the product submenu.
     */
    private final String[] PRODUCT_MENU_OPTIONS = {"Add a product", "Show product information", "Add season to a serie", "Show list of movies by category", "Show list of series with its latest season"};

    
    /**
     * Constructor method. It does not need parameters.
     */
    public UserInterface(){
        sc = new Scanner(System.in);
        exit = false;
    }
    
    /** 
     * Main method of the project
     * @param args String[]
     */
    public static void main(String[] args){
        UserInterface admin = new UserInterface();
        admin.initializeSystem();
    }
    /**
     * Initializes the streamingSystem object necessary to meet the requirements. The values of its attributes are entered by the user.
     */
    public void initializeSystem(){
        System.out.println("initializing BlackSnail");
        System.out.println("Type the nit:");
        String nit = sc.nextLine();
        System.out.println("Type the address:");
        String address = sc.nextLine();
        System.out.println("Type the website url:");
        String website = sc.nextLine();

        blackSnail = new StreamingSystem(nit, address, website, SUSCRIBER_LIMIT, PRODUCT_LIMIT, SEASON_LIMIT);
        System.out.println("Initialized system:\n" + blackSnail.toString());

        enableFunctions();
    }

    /**
     * Verifies that the streamingSystem object exists and launches the main menu.
     */
    public void enableFunctions(){
        if (blackSnail != null){
            do{
                switch(currentMenu){
                    case 0:
                        mainMenu();
                        break;
                    case 1:
                        subscriberMenu();
                        break;
                    case 2:
                        productMenu();
                        break;
                }
            } while (!exit);
    
        } else{
            System.out.println("The BlackSnail system has not been created yet"); // This should never happen.
        }

        System.out.println("Program closed");
    }

    /**
     * Main menu of the program. It allows access to the subscriber management, product catalog and services submenus. It asks the user to choose one of the options.
     */
    public void mainMenu(){
        currentMenu = showOptionsMenu("Main Menu", MENU_MESSAGE, MAIN_MENU_OPTIONS);
        
        if (currentMenu == 0)
            exit = true;
    }

    /**
     * Submenu that groups the functionalities related to subscriber management. It asks the user to choose an option.
     */
    public void subscriberMenu(){
        int selectedOption = showOptionsMenu("Subscriber management", MENU_MESSAGE, SUSCRIBER_MENU_OPTIONS);
        switch(selectedOption){
            case 0:
                mainMenu();
                break;
            case 1:
                registerSubscriber();
                break;
            case 2:
                deactivateSubscriber();
                break;
            case 3:
                showSubscribersInfo();
                break;
            case 4:
                showBestMinorSubscriberName();
                break;
        }
    }

    /**
     * Submenu that groups the functionalities related to product management. It asks the user to choose an option.
     */
    public void productMenu(){
        int selectedOption = showOptionsMenu("Product management", MENU_MESSAGE, PRODUCT_MENU_OPTIONS);
        switch(selectedOption){
            case 0:
                mainMenu();
                break;
            case 1:
                registerProduct();
                break;
            case 2:
                showProductInfo();
                break;
            case 3:
                addNextSeason();
                break;
            case 4:
                showMoviesListByCategory();
                break;
            case 5:
                showSeriesList();
                break;
        }
    }

    /**
     * Prints a custom menu. It asks the user to select one of its options until it receive a valid option.
     * @param title String to be displayed as the title of the menu.
     * @param message String to be displayed as a message of the menu.
     * @param options String[] to be displayed as options of the menu. It includes the number of each option automatically.
     * @return option int corresponding to the option selected by the user.
     */
    public int showOptionsMenu(String title, String message, String[] options){
        int option = -1;
        System.out.println("------" + title + "------");
        System.out.println(message);
        while (option>options.length || option <0){
            for (int i=0; i<options.length; i++){
                System.out.println("(" + (i+1) + ") " + options[i]);
            }
            System.out.println("(0) Return / Exit");
            option = sc.nextInt();
            if (option>options.length || option <0){
                System.out.println("Invalid option, please type again:");
            }
        }
        sc.nextLine();
        return option;
    }

    
    /**
     * Works exactly as showOptionsMenu, the only difference is the look and that it does not have return / exit option.
     * @param message String to be displayed as a message of the menu.
     * @param options String[] to be displayed as options of the menu. It includes the number of each option automatically.
     * @return option int corresponding to the option selected by the user.
     */
    public int showOptions(String message, String[] options){
        int option = -1;
        System.out.println(message);
        while (option>options.length || option <0){
            for (int i=0; i<options.length; i++){
                System.out.println((i+1) + "- " + options[i]);
            }
            option = sc.nextInt();
            if (option>options.length || option <0){
                System.out.println("Invalid option, please type again:");
            }
        }
        sc.nextLine();
        return option;
    }

    /**
     * Performs the operations necessary to register a subscriber. It needs information from the user and calls other methods. It verifies that the entered document number is not repeated in the system.
     */
    public void registerSubscriber(){
        int newSubscriberIndex = blackSnail.searchAvailableSubscriberIndex();
        if (newSubscriberIndex != -1){
            System.out.println("Type the data of the new subscriber...");
            System.out.println("Dcoument number:");
            String documentNumber = sc.nextLine();
            if (blackSnail.verifySubscriberDocumentNumber(documentNumber)){
                System.out.println("Full name:");
                String fullName = sc.nextLine();
                System.out.println("Age:");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.println("Hours that he/she is willing to consume:");
                int hoursToConsume = sc.nextInt();
                sc.nextLine();
                Type type = askType();
                
                blackSnail.addSubscriber(documentNumber, fullName, age, hoursToConsume, type, newSubscriberIndex);
            } else{
                System.out.println("There is already a user created with this document number");
            }
        } else{
            System.out.println("The limit of registered users has been reached");
        }
    }

    /**
     * Performs the operations necessary to add a product. It needs information from the user and calls other methods. It verifies that the entered name is not repeated in the system.
     */
    public void registerProduct(){
        int newSubscriberIndex = blackSnail.searchAvailableProductIndex();
        if (newSubscriberIndex != -1){
            System.out.println("Type the data of the new product...");
            String[] productTypes = {"Serie", "Movie"};
            int selectedProductType = showOptions("Type:",productTypes);
            System.out.println("Name:");
            String name = sc.nextLine();
            if (blackSnail.verifyProductName(name)){
                System.out.println("Director name:");
                String directorName = sc.nextLine();
                System.out.println("Synopsis:");
                String synopsis = sc.nextLine();
                int dateDay;
                int dateMonth;
                int dateYear;
                switch(selectedProductType){
                    case 1:
                        System.out.println("Protagonists (one at a time):");
                        String[] protagonists = fillArrayWithInputs(15);
                        System.out.println("Date of release...");
                        System.out.println("Day:");
                        dateDay = sc.nextInt();
                        System.out.println("Month:");
                        dateMonth = sc.nextInt();
                        System.out.println("Year:");
                        dateYear = sc.nextInt();
                        System.out.println("Data from the first season...");
                        System.out.println("Number of scheduled episodes:");
                        int seasonNumScheduledEpisodes = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Number of published episodes:");
                        int seasonNumPublishedEpisodes = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Trailer source:");
                        String seasonTrailerSource = sc.nextLine();
                        blackSnail.addSerie(name, directorName, synopsis, protagonists, dateDay, dateMonth, dateYear, seasonNumScheduledEpisodes, seasonNumPublishedEpisodes, seasonTrailerSource, newSubscriberIndex);
                        break;
                    case 2:
                        System.out.println("Original title:");
                        String originalTitle = sc.nextLine();
                        System.out.println("Producer:");
                        String producer = sc.nextLine();
                        System.out.println("Minimum recommended age to watch:");
                        int minimumAge = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Category:");
                        MovieCategory category = askCategory();
                        System.out.println("World release date...");
                        System.out.println("Day:");
                        dateDay = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Month:");
                        dateMonth = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Year:");
                        dateYear = sc.nextInt();
                        sc.nextLine();
                        blackSnail.addMovie(name, directorName, synopsis, originalTitle, producer, minimumAge, category, dateDay, dateMonth, dateYear, newSubscriberIndex);
                        break;
                }
            } else{
                System.out.println("There is already a product created with this name");
            }

        } else{
            System.out.println("Registered product limit has been reached");
        }
    }

    /**
     * Returns an array filled with data provided by the user.
     * @param max The maximum amount of inputs to store.
     * @return finalArray String[] with the answers of the user. The array has as spaces as answers.
     */
    public String[] fillArrayWithInputs(int max){
        String[] array = new String[max];
        String[] finalArray = new String[max];
        int usedPositions = max;
        int respuesta = 0;
        int i = 1;
        String input = "";
        array[0] = sc.nextLine();
        do{
            if (i<=max){
                String[] options = {"Yes", "No"};
                respuesta = showOptions("Add another?", options);
                if (respuesta == 1){
                    System.out.println("Type the next:");
                    input = sc.nextLine();
                    if (!input.equals("")){
                        array[i] = input;
                    } else
                        System.out.println("Empty answer, it was not added");
                    i++;
                }
            } else{
                System.out.println("Maximum number of protagonists reached");
                respuesta = 2;
            }
        } while (respuesta != 2);
        
        for (int j=0; j<max; j++){
            if (array[j]==""){
                finalArray = new String[j-1];
                usedPositions = j-1;
            }
        }

        for (int j=0; j<usedPositions; j++){
            finalArray[j] = array[j];
        }
        return finalArray;
    }

    
    /**
     * Asks the user to choose a type of subscriber. It returns a constant from the Type enumeration.
     * @return type Type which represents the clasification of a subscriber.
     */
    public Type askType(){
        int selectedType = -1;
        Type type = Type.NORMAL;
        do{
            System.out.println("Type: \n(enter the corresponding number)");
            System.out.println(" 1- Normal \n 2- Platinum \n 3- Gold \n 4- Diamond");
            selectedType = sc.nextInt();
            sc.nextLine();
            switch(selectedType){
                case 2:
                    type = Type.PLATINUM;
                    break;
                case 3:
                    type = Type.GOLD;
                    break;
                case 4:
                    type = Type.DIAMOND;
                    break;
            }

            if (selectedType<1 || selectedType>4){
                System.out.println("Incorrect value, type again:");
            }
        } while (selectedType<1 || selectedType>4);
        return type;
    }

    /**
     * Asks the user to choose a type of movie. It returns a constant from the MovieCategory enumeration.
     * @return type MovieCategory which represents the clasification of a movie.
     */
     public MovieCategory askCategory(){
        int selectedType = -1;
        MovieCategory category = MovieCategory.ROMANTIC;
        do{
            System.out.println(" 1- Romantic \n 2- Action \n 3- Suspense \n 4- Horror \n 5- Comedy");
            selectedType = sc.nextInt();
            sc.nextLine();
            switch(selectedType){
                case 2:
                     category = MovieCategory.ACTION;
                    break;
                case 3:
                    category = MovieCategory.SUSPENSE;
                    break;
                case 4:
                    category = MovieCategory.HORROR;
                    break;
                case 5:
                    category = MovieCategory.COMEDY;
                    break;
            }

            if (selectedType<1 || selectedType>5){
                System.out.println("Incorrect value, type again:");
            }
        } while (selectedType<1 || selectedType>5);
        return category;
    }


    /**
     * Performs the operations neccesary to deactivate a subscriber. It needs information from the user and calls other methods. It Verifies that there is at least one active user in the system.
     */
    public void deactivateSubscriber(){
        if (blackSnail.hasActiveSubscribers()){
            System.out.println("Enter the document number of the subscriber that you are going to deactivate:");
            String documentNumber = sc.nextLine();
            blackSnail.deactivateSubscriber(documentNumber);
        } else{
            System.out.println("There are no active users to deactivate");
        }
    }

    /**
     * Performs the operations neccesary to show a list of the active subscribers registered in the system. It shows a total number, an a subtotal for each category.
     */
    public void showSubscribersInfo(){
        System.out.println(blackSnail.getSubscribersInfo());
    }

    /**
     * Performs the operations neccesary to show the information of a specific product registered in the system. The product is selected by its name.
     */
    public void showProductInfo(){
        if (blackSnail.hasProducts()){
            System.out.println("Enter the name of the product to consult:");
            String name = sc.nextLine();
            System.out.println(blackSnail.getProductInfo(name));
        } else
            System.out.println("There are no registered products");
    }

    /**
     * Performs the neccesary operations to show the name of the minor suscriber with thewith the longest available hours to consume watching BlackSnail. 
     */
    public void showBestMinorSubscriberName(){
        if (blackSnail.hasMinorActiveSubscribers()){
            String subscriberName = blackSnail.getBestMinorSubscriberName();
            System.out.println("The underage subscriber with the greatest willingness to consume the product is called " + subscriberName);
        } else{
            System.out.println("There are no registered and active underage users");
        }
    }

    /**
     * Adds a season to a pre-existing series. If the searched series does not exist, it displays an error message.
     */
    public void addNextSeason(){
        if (blackSnail.hasSeries()){
            System.out.println("Enter the name of the series:");
            String name = sc.nextLine();
            int searchIndex = blackSnail.searchSerieIndex(name);
            if (searchIndex != -1)
            {
                System.out.println("Type the data for the new season:");
                System.out.println("Number of scheduled episodes:");
                int numScheduledEpisodes = sc.nextInt();
                sc.nextLine();
                System.out.println("Number of published episodes:");
                int numPublishedEpisodes = sc.nextInt();
                sc.nextLine();
                System.out.println("Trailer source:");
                String trailerSource = sc.nextLine();
                System.out.println("Date of release...");
                System.out.println("Day:");
                int dateDay = sc.nextInt();
                sc.nextLine();
                System.out.println("Month:");
                int dateMonth = sc.nextInt();
                sc.nextLine();
                System.out.println("Year:");
                int dateYear = sc.nextInt();
                sc.nextLine();
                blackSnail.addSeasonToSerie(searchIndex, numScheduledEpisodes, numPublishedEpisodes, trailerSource, dateDay, dateMonth, dateYear);
            } else
                System.out.println("There is no registered serie with this name");
        } else
            System.out.println("There are no series added to the system");
    }

    /**
     * Asks the user to enter a movie category and prints a list with the movies that belong to it.
     */
    public void showMoviesListByCategory(){
        if (blackSnail.hasMovies()){
            System.out.println("Enter the movie category:");
            MovieCategory category = askCategory();
            System.out.println(blackSnail.getMovieListByCategory(category));
        } else
            System.out.println("There are no movies added to the system");        
    }

    /**
     * Prints a list with the registered series and their respective last seasons.
     */
    public void showSeriesList(){
        System.out.println(blackSnail.getSeriesList());
    }
}