package com.learn.example.sampleQuestions;

public class CardTypeCache {

 /*   public static CardTypeCache buildCache(List<BinRange> binRanges) {
        Map<Predicate<String>, String> types = new HashMap<>();
        for (BinRange binRange : binRanges) {
            Predicate<String> predicate = (cardNumber) -> {
                int cdInt = Integer.parseInt(cardNumber);
                int start = Integer.parseInt(binRange.start);
                int end = Integer.parseInt(binRange.end);
                return start <= cdInt && cdInt<= end;
            };
            types.put(predicate, binRange.cardType);
        }
        return (cardNumber) -> {
            for (Map.Entry<Predicate<String>, String> entry : types.entrySet()) {
                if (entry.getKey().test(cardNumber)) {
                    return entry.getValue();
                }
            }
            return null;
        };
    }

    class BinRange {

        private String start;
        private String end;
        private String cardType;

    }*/

}




