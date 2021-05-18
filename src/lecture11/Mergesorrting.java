package lecture11;

import java.util.Arrays;

public class Mergesorrting {
    public static void main(String[] args) {
/*        int[] first = {0,7,8,10,16};
        int[] second= {2,3,6,9,11};
        int[] third = merge(first,second);
        System.out.println(Arrays.toString(third));*/
        int[] nums = {9,3,8,1,0,5,2,8};
        //mergeSort(nums,0,nums.length-1);
        nums= mergeSort1(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] mergeSort1(int[] nums) {
        if(nums.length < 2){
            return nums;
        }
        int mid = nums.length/2;

        int[] first = Arrays.copyOfRange(nums, 0, mid);
        int[] second = Arrays.copyOfRange(nums, mid, nums.length);

        first = mergeSort1(first);
        second = mergeSort1(second);
        return  merge(first, second);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        int mid = start + (end-start)/2 ;

    }

    private static int[] merge(int[] first, int[] second) {
        int i=0, j=0,k=0;
        int[] third = new int[first.length + second.length];
        while(i< first.length && j< second.length){
            if(first[i] < second[j]){
                third[k++] = first[i++];
            }else{
                third[k++] = second[j++];
            }
        }
        while(i< first.length){
            third[k++] = first[i++];
        }
        while (j<second.length){
            third[k++] =  second[j++];
        }
        return third;
    }
}
