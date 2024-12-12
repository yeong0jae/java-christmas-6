package christmas.domain;

public enum Bedge {
    STAR(5_000),
    TREE(10_000),
    SANTA(20_000);

    private final int discount;

    Bedge(int discount) {
        this.discount = discount;
    }
}
