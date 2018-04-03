package mx.pensare.institute.domain.constants;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/04/03
 */
public enum NumberEnum {

    ZERO(0, 0L, 0.0), ONE(1, 1L, 1.0), TWO(2, 2L, 2.0), THREE(3, 3L, 3.0), FOUR(4, 4L, 4.0), FIVE(5, 5L, 5.0), SIX(6, 6L, 6.0), SEVEN(7, 7L, 7.0), TEN(10, 10L, 10.0), ELEVEN(11, 11L, 11.0), TWELVE(12, 12L, 12.0), FIVETEEN(15, 15L, 15.0), TWENTY(20, 20L, 20.0), THIRTY(30, 30L, 30.0), ONE_HUNDRED(100, 100L, 100.0), ONE_THOUSAND(1000, 1000L, 1000.0);

    private Integer integer;

    /**
     * Name of the level
     */
    private Long bigint;

    /**
     * Name of the level
     */
    private Double decimal;

    NumberEnum(Integer integer, Long bigint, Double decimal) {
        this.integer = integer;
        this.bigint = bigint;
        this.decimal = decimal;
    }

    public Integer getInteger() {
        return integer;
    }

    public Long getBigint() {
        return bigint;
    }

    public Double getDecimal() {
        return decimal;
    }
}
