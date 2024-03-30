package com.shiv.controller;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,6,7,8};
        int missingnumber;
        int n=8;
        int sum = n*(n+1)/2;
        int actualsum=0;
        for(int i=0;i< arr.length;i++){
           actualsum+=arr[i];
        }
        missingnumber=sum-actualsum;
        System.out.println("missing number is : "+missingnumber);


        int[] a1={1,2,3,4,5};
        int[] a2={6,7,11,9,10};
        int[] a3=new int[a1.length+ a2.length];
        int index=0;
        for(int i=0;i< a1.length;i++){
           a3[index]=a1[i];
           index++;
        }
        for(int i=0;i< a2.length;i++){
            a3[index]=a2[i];
            index++;
        }
        Arrays.sort(a3);
        for(int i=0;i< a3.length;i++) {
            System.out.print(a3[i] + ",");
        }
    }
}
