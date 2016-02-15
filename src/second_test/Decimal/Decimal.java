package second_test.Decimal;

public class Decimal {
    private int numerator;
    private int denominator;

    public Decimal(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void multiplication (Decimal decimal) {
        setNumerator(this.numerator * decimal.getNumerator());
        setDenominator(this.denominator * decimal.getDenominator());
//        или лучше сделать вот так в одну строчку?
//        return new Decimal(this.numerator*decimal.getNumerator(), this.denominator*decimal.getDenominator());
    }

    public void division (Decimal decimal) {
        setNumerator(this.numerator * decimal.getDenominator());
        setDenominator(this.denominator * decimal.getNumerator());
//        или опять же луче решение - решение в одну строку?
//        return new Decimal(this.numerator*decimal.getDenominator(), this.denominator*decimal.getNumerator());
    }

    public void addition (Decimal decimal) {
        setNumerator(this.numerator + decimal.getNumerator());
        setDenominator(this.denominator + decimal.getDenominator());
//        return new Decimal(this.numerator+decimal.getNumerator(), this.denominator*decimal+getDenominator());
    }

    public void subtraction (Decimal decimal) {
        setNumerator(this.numerator - decimal.getNumerator());
        setDenominator(this.denominator - decimal.getDenominator());
//        return new Decimal(this.numerator-decimal.getNumerator(), this.denominator*decimal-getDenominator());
    }
}
