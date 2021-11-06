package model;

/**
 * Enumeration with the categories of subscribers.
 */
public enum Type {
    /**
     * NORMAL is the standard category.
     */
    NORMAL,
    /**
     * PLATINUM is the category with the most benefits.
     */ 
    PLATINUM,
    /**
     * GOLD is better than DIAMOND, but worst than PLATINUM.
     */
    GOLD,
    /**
     * DIAMOND is the level 2 category. It is better than NORMAL.
     */
    DIAMOND;
}
