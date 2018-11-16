package com.urlshortener.app;

import java.util.LinkedList;
import java.util.List;


public class CreateUniqueID {
    public String createUniqueID(Long id) {
        List<Integer> base62ID = convertBase10ToBase62ID(id);
        StringBuilder uniqueURLID = new StringBuilder();
        for (int digit: base62ID) {
            uniqueURLID.append(IDConverter.getIndexToCharTable().get(digit));
        }
        return uniqueURLID.toString();
    }
    private List<Integer> convertBase10ToBase62ID(Long id) {
        List<Integer> digits = new LinkedList<>();
        while(id > 0) {
            int remainder = (int)(id % 62);
            ((LinkedList<Integer>) digits).addFirst(remainder);
            id /= 62;
        }
        return digits;
    }
}
