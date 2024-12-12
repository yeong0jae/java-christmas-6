package christmas.domain;

public enum Badge {
    STAR(5_000, "별"),
    TREE(10_000, "트리"),
    SANTA(20_000, "산타"),
    NONE(0, "없음");

    private final int discount;
    private final String name;

    Badge(int discount, String name) {
        this.discount = discount;
        this.name = name;
    }

    public static Badge from(int totalDiscount) {
        if (totalDiscount >= valueOf("STAR").discount
                && totalDiscount < valueOf("TREE").discount) {
            return STAR;
        }
        if (totalDiscount >= valueOf("STAR").discount
                && totalDiscount < valueOf("TREE").discount) {
            return TREE;
        }
        if (totalDiscount >= valueOf("TREE").discount
                && totalDiscount < valueOf("SANTA").discount) {
            return SANTA;
        }
        return NONE;
    }

    public String getName() {
        return name;
    }
}
