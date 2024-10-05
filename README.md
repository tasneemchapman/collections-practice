# Collections Practice

Just some review exercises for java collections.

Instead of writing a `main` and calling your methods, write unit
tests for them instead (with jUnit asserts).

> **a little extra challenge:** do 1-4 recursively + use method-level generics (for 2-4 only)

## 1) parentheses matching

Write a program that checks whether a sequence of brackets `(`, `]`, `)` 
are "balanced", meaning: each opening '(' has a corresponding closing ')'

For example, 
```
(( ))        // balanced
(() ) )      // not balanced
( () ( )     // not balanced
([)]         // not balanced
()[]         // balanced
```

## 2) recursive linear search

Write a method that performs, `lSearch` that performs a linear search of an 
ArrayList of integer. But do it recursively... some input/output examples:

```
lSearch([30, 20, 100, 3, 8, -3, 200], 3) // returns index 3
lSearch([], 4)                           // returns index -1
```
* **extra:** what's the largest list you can run this on before you run out of stack memory on your computer?

## 3) rm dups

Write a method, `rmDups`, that takes a list of integers and returns a new list without 
the duplicates.
* Note: should preserve the ordering of the original input list; don't modify the input list. 

```
rmDups([1, 2, 3, 2, 4, 1, 5]) // returns: [1, 2, 3, 4, 5]
rmDups([2, 9, 10])            // returns: [2, 9, 10]
rmDups([4, 4, 5])             // returns: [4, 5]
```

## 4) top k-frequent elements

Write a method, `kFreq` that takes an arraylist of integers and some int `k` 
and returns a list of the `k` most frequently occurring elements.
```
kFreq([1, 1, 1, 2, 2, 3], 2) should return [1, 2] 
```
since k=2 and 1 and 2 are the most frequently appearing