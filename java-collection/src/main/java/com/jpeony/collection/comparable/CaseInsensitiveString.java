package com.jpeony.collection.comparable;

/**
 * In the following description, the notation sgn(expression) designates the math- ematical signum function,
 * which is defined to return -1, 0, or 1, according to whether the value of expression is negative, zero, or positive.
 * 1）The implementor must ensure sgn(x.compareTo(y))==-sgn(y.compare- To(x)) for all x and y.
 * (This implies that x.compareTo(y) must throw an ex- ception if and only if y.compareTo(x) throws an exception.)
 * 2）The implementor must also ensure that the relation is transitive: (x.com- pareTo(y) > 0 && y.compareTo(z) > 0) implies x.compareTo(z) > 0.
 * 3）Finally,theimplementormustensurethatx.compareTo(y)==0impliesthat sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z.
 * 4）It is strongly recommended, but not strictly required, that (x.compareTo(y) == 0) == (x.equals(y)).
 * Generally speaking,any class that implements the Comparable interface and violates this condition should clearly indicate this fact.
 * The recommended language is “Note: This class has a natural ordering that is inconsistent with equals.”
 *
 * @author yihonglei
 */
public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
    private String s;

    @Override
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }
}
