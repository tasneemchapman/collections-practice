package edu.psu.ist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public final class SomeTests {

    @Test public void testBracketsSimpleConfigs() {
        Assertions.assertTrue(CollPractice.balanced("()"));
        Assertions.assertFalse(CollPractice.balanced("(]"));
        Assertions.assertFalse(CollPractice.balanced("[)"));
        Assertions.assertTrue(CollPractice.balanced("[]"));
    }


    @Test public void testBracksMedium() {
        Assertions.assertTrue(CollPractice.balanced("()[]"));
        Assertions.assertFalse(CollPractice.balanced("([)]"));
        Assertions.assertTrue(CollPractice.balanced("[][][](())"));
        Assertions.assertFalse(CollPractice.balanced("[][][(())"));
        Assertions.assertFalse(CollPractice.balanced("[]][](())"));
    }

    @Test public void testTrickyTricky() {
        // after first [] the bracket stack will be empty (trying to trigger
        // a peek of an empty stack)
        Assertions.assertFalse(CollPractice.balanced("[]]]]]"));
        Assertions.assertFalse(CollPractice.balanced("[]())"));
    }

    @Test public void testBracketsBadInput() {
        Assertions.assertFalse(CollPractice.balanced("()[x]"));

        Assertions.assertFalse(CollPractice.balanced("$()[x]|"));
        Assertions.assertFalse(CollPractice.balanced("sdoa"));
        Assertions.assertFalse(CollPractice.balanced("[ ]"));
    }

    // q2 tests:
    // note1: this one likely will crash (out of stack memory) when run searching
    // for a key in a list of length 5000+ - assuming the search doesn't find it early on in the list

    // note2: List.of(..) produces a *read-only* list (attempts to mutate it will throw an exception)
    @Test public void testLinearSearchNotFound() {
        Assertions.assertEquals(-1, CollPractice.linearSearchRec(List.of(10, 20, 0, 3), 4));
        Assertions.assertEquals(-1, CollPractice.linearSearchRec(List.of(), 4));
        Assertions.assertEquals(-1, CollPractice.linearSearchRec(List.of("cat"), "dog"));
    }

    @Test public void testLinearSearchFoundAtEnd() {
        Assertions.assertEquals(3, CollPractice.linearSearchRec(List.of(10, 20, 0, 3), 3));
        Assertions.assertEquals(2, CollPractice.linearSearchRec(List.of(3, 5, 4), 4));
        Assertions.assertEquals(0, CollPractice.linearSearchRec(List.of("cat"), "cat"));
    }

    @Test public void testFoundAtBeginning() {
        Assertions.assertEquals(0, CollPractice.linearSearchRec(List.of(4, 4, 4), 4));
    }

    @Test public void testRmDups01() {
        Assertions.assertEquals(List.of(1), CollPractice.rmDups(List.of(1, 1, 1)));
        Assertions.assertEquals(List.of(1), CollPractice.rmDups(List.of(1)));
        Assertions.assertEquals(List.of(1, 2, 3), CollPractice.rmDups(List.of(1, 2, 3)));
    }

    @Test public void testRmDups02() {
        Assertions.assertEquals(List.of(1, 2, 3), CollPractice.rmDups( List.of(1, 2, 1, 3)));
        Assertions.assertEquals(List.of("x", "s"), CollPractice.rmDups(List.of("x", "x", "x", "s", "s", "x")));
        Assertions.assertEquals(List.of("x", "s"), CollPractice.rmDups(List.of("x", "x", "x", "s", "s")));
        Assertions.assertEquals(List.of(), CollPractice.rmDups(List.of()));
    }

    @Test public void testKMostFreq01() {
        Assertions.assertEquals(List.of(1, 2), CollPractice.kFreqNoGenerics(List.of(1, 1, 1, 2, 2, 3), 2));
    }

    // what happens if k > size of the list?

    @Test public void testKMostFreq02() {
        Assertions.assertEquals(List.of(1, 2, 3), CollPractice.kFreqNoGenerics(List.of(1, 1, 1, 2, 2, 3), 30));
    }
}
