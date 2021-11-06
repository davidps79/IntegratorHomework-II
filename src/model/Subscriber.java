package model;

/**
 * Subscriber represents the user who consumes the BlackSnail's content.
 */
public class Subscriber{
    /**
     * documentNumber is a String corresponding to the number of the legal identification of a subscriber.
     */
    private String documentNumber;
    /**
     * fullName is a String corresponding to the full name of a subscriber.
     */
    private String fullName;
    /**
     * age is an int corresponding to the age of a subscriber.
     */
    private int age;
    /**
     * hoursToConsume is an int corresponding to the number of hours a subscriber is willing to consume BlackSnail products.
     */
    private int hoursToConsume;
    /**
     * state is a State (enumeration of model package) which determines if a subscriber is active or not.
     */
    private State state;
    /**
     * type is a Type (enumeration of model package) which the determines the category of a subscriber.
     */
    private Type type;

    /**
     * Constructor method. It requires all the attributes of the class (described above), excepting state because all subscribers are registered as active.
     * 
     * @param documentNumber String
     * @param fullName String
     * @param age int
     * @param hoursToConsume int
     * @param type Type
     */
    public Subscriber(String documentNumber, String fullName, int age, int hoursToConsume, Type type){
        this.documentNumber = documentNumber;
        this.fullName = fullName;
        this.age = age;
        this.hoursToConsume = hoursToConsume;
        state = State.ACTIVE;
        this.type = type;
    }

// Getters

    /** 
     * @return documentNumber String 
     */
    public String getDocumentNumber(){
        return documentNumber;
    }

    
    /** 
     * @return fullName String
     */
    public String getFullName(){
        return fullName;
    }

    
    /** 
     * @return age int
     */
    public int getAge(){
        return age;
    }

    
    /** 
     * @return hoursToConsume int
     */
    public int getHoursToConsume(){
        return hoursToConsume;
    }

    
    /** 
     * @return state State
     */
    public State getState(){
        return state;
    }

    
    /** 
     * @return type Type
     */
    public Type getType(){
        return type;
    }


// Setters

    /** 
     * @param documentNumber String
     */
    public void setdocumentNumber(String documentNumber){
        this.documentNumber = documentNumber;
    }

    
    /** 
     * @param fullName String
     */
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    
    /** 
     * @param age int
     */
    public void setAge(int age){
        this.age = age;
    }

    
    /** 
     * @param hoursToConsume int
     */
    public void setHoursToConsume(int hoursToConsume){
        this.hoursToConsume = hoursToConsume;
    }

    
    /** 
     * @param state State
     */
    public void setState(State state){
        this.state = state;
    }

    
    /** 
     * @param type Type
     */
    public void setType(Type type){
        this.type = type;
    }
}