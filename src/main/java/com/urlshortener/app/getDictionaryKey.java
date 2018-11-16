package com.urlshortener.app;

import java.util.ArrayList;
import java.util.List;

public class getDictionaryKey {
    public Long getDictionaryKeyFromUniqueID(String uniqueID) {
        List<Character> base62Number = new ArrayList<>();
        for (int i = 0; i < uniqueID.length(); ++i) {
            base62Number.add(uniqueID.charAt(i));
        }
        Long dictionaryKey = convertBase62ToBase10ID(base62Number);
        return dictionaryKey;
    }

    private Long convertBase62ToBase10ID(List<Character> ids) {
        long id = 0L;
        int exp = ids.size() - 1;
        for (int i = 0; i < ids.size(); ++i, --exp) {
            int base10 = IDConverter.getCharToIndexTable().get(ids.get(i));
            id += (base10 * Math.pow(62.0, exp));
        }
        return id;
    }
}
