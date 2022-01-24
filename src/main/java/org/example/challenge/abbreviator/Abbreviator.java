package org.example.challenge.abbreviator;

public class Abbreviator {

    public String abbreviate(String string) {
        return string.length() <= 3 ?
                string :
                string.substring(0, 1) + (string.length() - 2) + string.substring(string.length() - 1);
    }

}
