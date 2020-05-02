/*
 * Copyright (c) 2020 Colin McAllister to Present.
 */

import java.util.Scanner;

/**
 * Tests a strand of DNA to see if it has a protein.
 */
class DNA {

    private final String buildDNA;

    /**
     * Constructor for DNA
     *
     * @param DNAin String
     */
    public DNA(String DNAin) {
        buildDNA = DNAin;
    }

    //TODO count each strand A,C,G,T

    /**
     * Main method for DNA
     *
     * @param args
     */
    public static void main(String[] args) {
        DNA dna1 = new DNA("ATGCGATACGCTTGA");
        DNA dna2 = new DNA("ATGCGATACGTGA");
        DNA dna3 = new DNA("ATTAATATGTACTGA");

        //prints out the three DNA strands
        System.out.println(dna1.toString());
        System.out.println(dna2.toString());
        System.out.println(dna3.toString());

        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to test a different DNA strand?");
        String userIn = scan.nextLine();
        if (userIn.charAt(0) == ('y' | 'Y')) {// if user types yes
            System.out.println("Please enter your DNA strand: ");
            String newDNA = scan.nextLine();
            DNA n = new DNA(newDNA);
            if (n.isDNA(newDNA)) { // must contain only AGCT
                System.out.println(n.toString());
            } else {
                System.out.println("That strand contains characters other than A, G, C, T");
            }
        }
    }

    /**
     * Determines the length of the DNA strand.
     *
     * @return int for length
     */
    public int lengthOfDNA() {
        return buildDNA.length();
    }

    /**
     * Determines if the DNA strand is a protein by testing if the length
     * is divisible by 3, starts with ATG, and ends with TGA.
     *
     * @return boolean
     */
    public boolean isProtein() {
        boolean isP = false;
        int length = buildDNA.length();
        try {
            if (buildDNA.substring(0, 3).equalsIgnoreCase("ATG")
                    && buildDNA.substring(length - 3).equalsIgnoreCase("TGA") && buildDNA.length() % 3 == 0) {
                isP = true;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String must be at least 6 characters long.");
        }
        return isP;
    }

    /**
     * Takes a string and determines if each char is A, G, C, or T.
     *
     * @param s String input
     * @return boolean if it is a DNA strand
     */
    public boolean isDNA(String s) {
        boolean t = false;
        char[] a = s.toCharArray();
        for (char c : a) {
            t = ((c == 'a') || (c == 'A') || (c == 'g') || (c == 'G')
                    || (c == 'c') || (c == 'C') || (c == 't') || (c == 'T'));
        }
        return t;
    }

    /**
     * Puts the DNA info to a String.
     *
     * @return
     */
    public String toString() {
        String t = "The DNA strand \"" + buildDNA.toUpperCase();
        if (this.isProtein()) {
            t += "\" contains a protein.";
        } else {
            t += "\" does not contain a protein.";
        }
        return t;
    }
}
