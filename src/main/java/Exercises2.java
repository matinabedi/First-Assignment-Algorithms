import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        int numssize= nums.length;
        int [] khorogi =new int [2];
        for (int i=0 ; i<numssize;i++){
            for(int j=i+1 ; j<numssize; j++){
                if(nums[i]+nums[j]==target) {
                    khorogi[0] = i;
                    khorogi[1] = j;
                }
            }
        }
        return khorogi;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int romanToInt(String s) {
        int stringsize =s.length();
        int sum=0;
        for(int i=0 ; i<stringsize; i++){

            switch (s.charAt(i)) {
                case 'I':
                        if (i!=stringsize-1 && s.charAt(i + 1) == 'V') {
                            sum = sum + 4;
                            i++;
                        } else if (i!=stringsize-1 && s.charAt(i + 1) == 'X') {
                            sum = sum + 9;
                            i++;
                        } else sum=sum+1;
                    break;
                case 'V':
                    sum=sum+5;
                    break;
                case 'X':
                    if(i!=stringsize-1) {
                        if (i!=stringsize-1 && s.charAt(i + 1) == 'L') {
                            sum = sum + 40;
                            i++;
                        } else if (i!=stringsize-1 && s.charAt(i + 1) == 'C') {
                            sum = sum + 90;
                            i++;
                        }
                    }
                   else sum=sum+10;
                    break;
                case 'L':
                    sum=sum+50;
                    break;
                case 'C':
                    if(i!=stringsize-1 && i!=stringsize-1) {
                        if (s.charAt(i + 1) == 'D') {
                            sum = sum + 400;
                            i++;
                        } else if (i!=stringsize-1 && s.charAt(i + 1) == 'M') {
                            sum = sum + 900;
                            i++;
                        }
                    }
                   else  sum=sum+100;
                    break;
                case 'D':
                    sum=sum+500;
                    break;
                case 'M':
                    sum=sum+1000;
                    break;
            }
        }
        return sum;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        jaygasht(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private void jaygasht(int[] nums, List<Integer> currPermutation, List<List<Integer>> permutations) {
        if (currPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currPermutation));
            return;
        }
        for (int num : nums) {
            if (!currPermutation.contains(num)) {
                currPermutation.add(num);
                jaygasht(nums, currPermutation, permutations);
                currPermutation.remove(currPermutation.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        // test your code here!
    }
}