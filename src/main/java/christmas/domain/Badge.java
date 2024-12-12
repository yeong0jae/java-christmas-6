package christmas.domain;

public enum Badge {
    STAR(5_000),
    TREE(10_000),
    SANTA(20_000),
    NONE(0);

    private final int discount;

    Badge(int discount) {
        this.discount = discount;
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
}
