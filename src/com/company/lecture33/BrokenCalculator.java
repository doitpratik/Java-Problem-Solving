package com.company.lecture33;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BrokenCalculator {
    class Node{
        boolean possible;
        int steps;
        ArrayList<Integer> list = new ArrayList<>();
    }

   //public static final int LONG = 1000000009;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(), m = sc.nextInt(), o = sc.nextInt();
            ArrayList<Integer> workingNumber = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int num = sc.nextInt();
                workingNumber.add(num);
            }

            int signs[] = new int[4];
            for(int i = 0; i < m; i++){
                int num = sc.nextInt();
                signs[num-1] = 1;
            }

            int target = sc.nextInt();

            getMinSteps(target, new HashMap<Integer, Integer>(), 1, workingNumber, o, signs);
            System.out.println(answer);
        }
        sc.close();
    }

    private static void getMinSteps(int target, HashMap<Integer, Integer> output, int curr_lev, ArrayList<Integer> workingNumber, int o, int[] signs) {
        if(workingNumber.size() == 0){
            return ;
        }
        for (int i = 0; i < workingNumber.size(); i++) {
            int curr_ele = workingNumber.get(i);
            workingNumber.remove(i);
            HashMap<Integer, Integer> new_output = new HashMap<>();
            new_output.put(curr_ele, 1);
            for (Map.Entry<Integer, Integer> entry : output.entrySet()) {
                int val = entry.getKey();
                int touch = entry.getValue();

                if (signs[0] == 1) {
                    int newAdd = curr_ele + val;
                    int newFreq = touch + 3;
                    if (!new_output.containsKey(newAdd)) {
                        new_output.put(newAdd, newFreq);
                    } else if (new_output.get(newAdd) > newFreq) {
                        new_output.put(newAdd, newFreq);
                    }
                    if (newAdd == target && newFreq <= o) {
                        answer = Math.min(answer, newFreq);
                    }
                }
                //subtract
                if (signs[1] == 1) {
                    int newAdd = curr_ele - val;
                    int newFreq = touch + 3;
                    if (!new_output.containsKey(newAdd)) {
                        new_output.put(newAdd, newFreq);
                    } else if (new_output.get(newAdd) > newFreq) {
                        new_output.put(newAdd, newFreq);
                    }
                    if (newAdd == target && newFreq <= o) {
                        answer = Math.min(answer, newFreq);
                    }
                }
                //Multiply
                if (signs[2] == 1) {
                    int newAdd = curr_ele * val;
                    int newFreq = touch + 3;
                    if (!new_output.containsKey(newAdd)) {
                        new_output.put(newAdd, newFreq);
                    } else if (new_output.get(newAdd) > newFreq) {
                        new_output.put(newAdd, newFreq);
                    }
                    if (newAdd == target && newFreq <= o) {
                        answer = Math.min(answer, newFreq);
                    }
                }
                //divide
                if (signs[3] == 1) {
                    if (val != 0 && curr_ele >= val) {
                        if (curr_ele % val == 0) {
                            int newAdd = curr_ele / val;
                            int newFreq = touch + 3;
                            if (!new_output.containsKey(newAdd)) {
                                new_output.put(newAdd, newFreq);
                            } else if (new_output.get(newAdd) > newFreq) {
                                new_output.put(newAdd, newFreq);
                            }
                            if (newAdd == target && newFreq <= o) {
                                answer = Math.min(answer, newFreq);
                            }
                        }
                    } else {
                        if (curr_ele != 0 && val % curr_ele == 0) {
                            int newAdd = val / curr_ele;
                            int newFreq = touch + 3;
                            if (!new_output.containsKey(newAdd)) {
                                new_output.put(newAdd, newFreq);
                            } else if (new_output.get(newAdd) > newFreq) {
                                new_output.put(newAdd, newFreq);
                            }
                            if (newAdd == target && newFreq <= o) {
                                answer = Math.min(answer, newFreq);
                            }
                        }
                    }
                }
                String one = Integer.toString(curr_ele);
                String two = Integer.toString(Math.abs(val));

                //System.out.println("Concat" + curr_ele + " + " + val);
                int newAdd = Integer.parseInt(one.concat(two));
                int newFreq = touch + 1;
                //System.out.println("Concat" + curr_ele + " + " + val + " freq :" + newFreq);
                if (!new_output.containsKey(newAdd)) {
                    new_output.put(newAdd, newFreq);
                } else if (new_output.get(newAdd) > newFreq) {
                    new_output.put(newAdd, newFreq);
                }
                if (newAdd == target && newFreq <= o) {
                    answer = Math.min(answer, newFreq);
                }


                newAdd = Integer.parseInt(two.concat(one));
                if (!new_output.containsKey(newAdd)) {
                    new_output.put(newAdd, newFreq);
                } else if (new_output.get(newAdd) > newFreq) {
                    new_output.put(newAdd, newFreq);
                }
                if (newAdd == target && newFreq <= o) {
                    answer = Math.min(answer, newFreq);
                }
            }

            for (Map.Entry<Integer, Integer> entry : output.entrySet()) {
                int val = entry.getKey();
                int level = entry.getValue();
                if (!new_output.containsKey(val)) {
                    new_output.put(val, level);
                } else {
                    if (new_output.get(val) > level) {
                        new_output.put(val, level);
                    }
                }
            }

            getMinSteps(target, new_output, curr_lev + 1, workingNumber, o, signs);
            workingNumber.add(i, curr_ele);
        }
    }
}
