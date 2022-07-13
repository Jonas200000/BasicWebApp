package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
        query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "Jonas";
        } else if (query.contains("plus")) {
            String[] params = query.split(" ");
            int sum = 0;
            for (String s : params) {
                try {
                    int n = Integer.parseInt(s);
                    sum += n;
                } catch (NumberFormatException e) {

                }
            }
            return String.valueOf(sum);
        } else if (query.contains("largest")) {
            String[] params = query.split(" ");
            int largest = Integer.MIN_VALUE;
            for (String s : params) {
                try {
                    int current = Integer.parseInt(s);
                    if (current > largest) {
                        largest = Integer.parseInt(s);
                    }
                } catch (NumberFormatException e) {

                }
            }
            return String.valueOf(largest);
        } else { // TODO extend the programm here
            return "";
        }
    }

    public static void main(String[] args) {
        QueryProcessor queryProcessor = new QueryProcessor();

        String plus = "what is 2 plus 5";
        System.out.println(queryProcessor.process(plus));
        String largest = "what is the largest of 2 5 99 3 2";
        System.out.println(queryProcessor.process(largest));
    }
}
