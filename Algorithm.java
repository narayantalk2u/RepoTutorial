package com.narayan.sort;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Algorithms {
	/*
	 * 	Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 *	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 */
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i+1};
            }
            map.put(nums[i],i+1);
        }
        return new int[]{0,0};
    }
	/*
	 * Given a large array of integers and a window of size 'w', 
	 * find the current maximum in the window as the window slides through the entire array.
	 */
	public static int findMaxInSlidingWindow(int []arr,int w){
		if(w > arr.length){
			return 0;
		}
		/*
		 * First find max in first window
		 */
		ArrayDeque<Integer> window = new ArrayDeque<Integer>();
		for(int i=0;i<w;i++){
			while(!window.isEmpty()&& arr[i] >= arr[window.peekLast()]){
				window.removeLast();
			}
			window.addLast(i);
		}
		for(int i=w;i<arr.length;i++){
			while(!window.isEmpty() && arr[i] >= arr[window.peekLast()]){
				window.removeLast();
			}
			if(!window.isEmpty() && window.peekFirst()<= i-w){
				window.removeLast();
			}
			window.addLast(i);
		}
		return arr[window.getFirst()];
	}

	public static void main(String[] args) {
		System.out.println(findMaxInSlidingWindow(new int[]{-4,2,-5,1,-1,6,3,6,8,9,10,12,4,2,1},3));

	}

}

    


