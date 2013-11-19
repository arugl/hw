// Scott Ma
// Period 8
// HW #27
// 2013-11-18

public class Rational {
    
    // instance variables of numerator and denominator

    int numerator, denominator;

    // default constructor; set rational to 0/1   

    public Rational () {
	numerator = 0;
	denominator = 1;
    }

    // default constructor; given values for numerator and denominator

    public Rational (int num, int denum) {

	// if the denumerator is 0 the number does not exist

	if (denum == 0) {
	    System.out.println("Invalid denominator.");
	}
	else {
	    numerator = num;
	    denominator = denum;
	}
    }

    // toString returns Rationals in String

    public String toString () {
	return numerator + "/" + denominator;
    }

    // floatValue returns a floating value of the rational number
    // as accurately as possible

    public double floatValue () {
	return (double) numerator / denominator;
    }

    // multiply(n) multiples current Rational with Rational n
    // divide(n) devides current Rational by Rational n

    public void multiply (Rational n) {
	numerator = (n.numerator * numerator);
	denominator = (n.denominator * denominator);
    }

    public void divide (Rational n) {
	numerator = (numerator * n.denominator);
	denominator = (denominator * n.numerator);
    }

    // add(n) adds current Rational with Rational n
    // subtract(n) substracts rational n from current rational
   
    public void add (Rational n) {
	int m = n.numerator;
	if (denominator != n.denominator) {
	    denominator *= n.denominator;
	    numerator *= n.denominator;
	    m *= denominator;
	}
	numerator += m;
    }

    public void subtract (Rational n) {
	int m = n.numerator;
	if (denominator != n.denominator) {
	    denominator *= n.denominator;
	    numerator *= n.denominator;
	    m *= denominator;
	}
	numerator -= m;
    }

    // gcd() returns integer gcd of numerator and denominator
    // uses Euclid's theorem

    public int gcd () {
	int a = numerator;
	int b = denominator;
	while (a != b) {
	    if ( a > b ) {
		a -= b;
	    }
	    else {
		b-= a;
	    }
	}
	return a;
    }

    // reduce() reduces the numerator and denominator to lowest integer form
    // uses gcd(a, b)

    public void reduce () {
	int a = gcd(numerator , denominator);
	numerator /= a;
	denominator /= a;
    }

    // gcd (a, b) calculates the gcd given two numbers
    // uses Euclid's theorem

    public static int gcd (int a, int b) {
	while (a != b) {
	    if ( a > b ) {
		a -= b;
	    }
	    else {
		b-= a;
	    }
	}
	return a;
    }

    // compareTo(n) compares current Rational to Rational n
    // return 0 if equal
    // return positive if current > n
    // return negative if current < n

    public int compareTo (Rational n) {
        if (( numerator * n.denominator ) == (denominator * n.numerator)) {
	    return 0;
	}
	else if (( numerator * n.denominator ) > (denominator * n.numerator)){
	    return 42;
	}
	else {
	    return -42;
	}
    }

    // main method for testing
    
    public static void main (String[] args) {

	// initialize Objects

	// test base constructor Rational()
	Rational nmb = new Rational();

	// test creation of working numbers

	Rational rnb = new Rational(3,4);
	Rational mnb = new Rational(15,4);

	// test creation of a nonexistant number divided by 0

	Rational no = new Rational(15,0);

	// tests toString() method
	System.out.println("Rational numbers:");
	System.out.println(nmb);
	System.out.println(rnb);
	System.out.println(mnb);

	// tests multiply(n) method

	System.out.println("Multiply 2 and 3");
        rnb.multiply(mnb);
	System.out.println(nmb);
	System.out.println(rnb);
	System.out.println(mnb);

	// tests divide(n) method
	System.out.println("Divide 2 by 3");
	rnb.divide(mnb);
	System.out.println(nmb);
	System.out.println(rnb);
	System.out.println(mnb);

	// tests reduce() method
	System.out.println("Reduce 2 and 3");
	mnb.reduce();
	rnb.reduce();
	System.out.println(nmb);
	System.out.println(rnb);
	System.out.println(mnb);

	// tests add(n) method
	System.out.println("Add 3 to 2");
	rnb.add(mnb);
	System.out.println(nmb);
	System.out.println(rnb);
	System.out.println(mnb);

	// tests subtract(n) method
	System.out.println("Subtract 2 from 3");
	mnb.subtract(rnb);
	System.out.println(nmb);
	System.out.println(rnb);
	System.out.println(mnb);

	// tests floatValue() method
	System.out.println("Print float value of 2");
	System.out.println(rnb.floatValue());

	// test compareTo(n) method
	System.out.println("Is the third one larger than the second one?");
	System.out.println(mnb.compareTo(rnb));

    } // end main method
	
} // end class Rational
