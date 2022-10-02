package model;

public enum Actions {
    LOGIN(1),
    CREATE(2),
    UPDATE(3),
    DELETE(4),
    REGISTER(5);

    public final int id;

    /**
     * @param id
     */
    Actions (int id){
        this.id = id;
    }
}
