package calc;
// ТЗ Требования: П.2 Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
// ТЗ Требования: П.4 Калькулятор умеет работать только с целыми числами.
class Number {
    private int value;
    private NumberType type;
    public enum NumberType {
        ARABIC,
        ROMAN
    }

    Number(int value, NumberType type) {
        this.value = value;
        this.type = type;
    }

    int getValue() {
        return value;
    }

    NumberType getType() {
        return type;
    }
}