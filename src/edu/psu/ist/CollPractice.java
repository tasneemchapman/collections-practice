package edu.psu.ist;

import java.util.*;

public final class CollPractice {

    /**
     * A small type to represent the various left and right bracket types
     * we might see.
     */
    private enum BracketType {LBrack, RBrack, LParen, RParen}

    /**
     * Returns true only if {@code brackets} is a balanced
     * string where each opening bracket {@code (} and {@code [} has a
     * corresponding closing one; false otherwise.
     */
    public static boolean balanced(String brackets) {

        var asBrackets = new ArrayList<BracketType>();

        for (int i = 0; i < brackets.length(); i++) {
            var tpeOpt = switch (brackets.charAt(i)) {
                case '(' -> Optional.of(BracketType.LParen);
                case ')' -> Optional.of(BracketType.RParen);
                case '[' -> Optional.of(BracketType.LBrack);
                case ']' -> Optional.of(BracketType.RBrack);
                default -> Optional.<BracketType>empty();
            };
            if (tpeOpt.isEmpty()) { // we found a bracket type we don't recognize
                return false;
            }
            asBrackets.add(tpeOpt.get());
        }

        Stack<BracketType> stk = new Stack<>();

        for (BracketType b : asBrackets) {
            switch (b) {
                // case 1: any time we see an opening bracket type,
                //         push it on the bracket stk
                case LBrack, LParen -> stk.push(b);
                // cases 2-4: ok, so we didn't just push an opening bracket type...
                //  (2) if we ever see here that the bracket stack is empty, return false
                //  (3) if we see a ')', then the bracket stack better have '(' at the top
                //  (4) if we see a ']', then the bracket stack better have '[' at the top
                case BracketType _ when stk.isEmpty() -> { return false; }
                case BracketType t when t == BracketType.RParen && stk.peek() == BracketType.LParen -> stk.pop();
                case BracketType t when t == BracketType.RBrack && stk.peek() == BracketType.LBrack -> stk.pop();
                default -> { return false; }
            }
        }
        return stk.empty();
    }

    /**
     * Returns the first index where {@code key} occurs in {@code input};
     * -1 if not found.
     */
    public static <T> int linearSearchRec(List<T> input, T key) {
        // this is a "kick off" method.. kicks off the (private) recursive helper
        return linearSearchRec(input, key, 0);
    }

    private static <T> int linearSearchRec(List<T> input, T key, int currIdx) {
        if (currIdx >= input.size()) {
            return -1; // we're at the end and didn't find key
        }
        T item = input.get(currIdx);
        if (key.equals(item)) {
            return currIdx;
        }
        return linearSearchRec(input, key, currIdx + 1);
    }

    public static <A> List<A> rmDups(List<A> items) {
        // first toss everything from items list into a hashset
        var seenAreadySet = new HashSet<A>();
        var result = new ArrayList<A>();
        // iterate over items
        for (A item : items) {
            if (!seenAreadySet.contains(item)) {
               result.add(item);
            }
            seenAreadySet.add(item);
        }
        return result;
    }

    // takes advantage of linked hashsets (which work the same as normal hashsets)
    // but they preserve the order of insertion
    public static <A> List<A> rmDups2(List<A> input) {
       var filtered = new LinkedHashSet<>(input);
       return new ArrayList<>(filtered); //<--- using arraylist (collection) copy constructor
    }

    // NOT well tested... (to do a generic version would need to say
    // <A extends Comparable<A>> for the generic type slot)
    public static List<Integer> kFreqNoGenerics(List<Integer> input, int k) {
        // helpful to use a TreeMap here so we can maintain the (k,v) pairs
        // in the map in order (sorted by keys k). More efficient sols exist
        // (use a normal hashmap)
        var m = new TreeMap<Integer, Integer>();

        // create a histogram
        for (Integer x : input) {
            /* // alternate version that doesn't use get or default:
            if (!m.containsKey(x)) {
                m.put(x, 1); // first time we're seeing x, so map it to 1
            } else {
                // else we've seen x some number of times before
                int count = m.get(x);
                m.put(x, count + 1); // <- we're seeing x again now (hence the +1)
            }*/
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        // last, return the last k keys of (key-sorted) histogram
        var kMostFrequent = new ArrayList<Integer>();
        int i = 0;
        while (!m.isEmpty() && i < k) {
            var kv = m.pollFirstEntry();
            kMostFrequent.add(kv.getKey());
            i++;
        }
        return kMostFrequent;
    }

}
