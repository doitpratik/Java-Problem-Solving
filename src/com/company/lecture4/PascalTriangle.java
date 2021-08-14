/*
This Problem is of pascals Triangle
Representation of Pascal's Triangle:
                1
               1 1
              1 2 1
             1 3 3 1
            1 4 6 4 1
So as we can see in this problem first index
& last index is having 1 as their value
this problem can be thinked in many way to solve,
Solving Methods:
1). By using relation in the rows:-
        As we can see in the row 3 the 2 is the addition
        of previous row's index, same as in row no 4, where
        the 1st index value i.e 3 which is an outcome of
        previous row's index 0 and index 1's value addition
        i.e 1+2
        same for index 2 value 3 which is processed by index 1
        & index 3
        i.e 2+1
    So the Timecomplexty for this problem becomes O(n^2) and
    space complextity goes upto O(N)
2). By using this method we can calculate this values without using
    extra Space. That means space complexity will be O(1):-
        This algorithm uses Combination formula in some modified way
        Formula (Org):
            nCr --> line C row = line! / ((line-row)! * row!);
        Formula (Mod):
            nCr --> line C row = line C (row-1) * (line - row) /row;

*/
package com.company.lecture4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(usingList(n));


        usingFormula(n);

    }

    private static void usingFormula(int n) {
        for (int Line = 1; Line <= n ; Line++) {
            int C = 1;
            for (int row = 1; row <= Line ; row++) {
                System.out.print(C+" ");
                C = C * (Line - row) / row;
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> usingList(int n) {
        List<List<Integer>> allRows = new ArrayList<List<Integer>>();
        List<Integer> rowing = new ArrayList<Integer>();
        for(int Line = 0; Line < n; Line++) {
            for(int row = rowing.size() - 1; row >= 1 ; row--) {
                rowing.set(row, rowing.get(row) + rowing.get(row - 1));
            }
            rowing.add(1);
            allRows.add(new ArrayList(rowing));
        }
        return allRows;
    }
}
