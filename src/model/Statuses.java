package model;

public enum Statuses {
    RESOLVED(1),
    ACTIVE(2),
    URGENT(3),
    CRITICAL(4),
    EXTERNAL(5),
    REVIEW(6),
    CANCELLED(7);

    public final int id;

    /**
     * @param id
     */
    Statuses(int id) {
        this.id = id;
    }
}
