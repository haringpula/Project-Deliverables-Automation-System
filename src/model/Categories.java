package model;

public enum Categories {
    DOCUMENTATION(1),
    MODEL(2),
    VIEW(3),
    CONTROLLER(4),
    IMPLEMENTATION(5),
    LIBRARIES(6),
    RESOURCES(7),
    TESTING(8),
    ENHANCEMENT(9);

    public final int id;

    /**
     * @param id
     */
    Categories(int id) {
        this.id = id;
    }
}
