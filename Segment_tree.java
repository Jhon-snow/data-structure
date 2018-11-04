package com.company;
import java.util.*;
public class Segment_tree {
    int[]stree;
    Segment_tree(int arr[], int n)
    {
      //  int size=(int)(Math.ceil(Math.log(n)/Math.log(2)));

        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));//if n==5 then log 2^5 is 3 and 2^3 is 8

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;//so max size is 2*8-1=15


        stree=new int[max_size];
        Arrays.fill(stree, Integer.MAX_VALUE);
        constructtree(arr,stree,0,arr.length-1,0);

    }
       void constructtree(int arr[],int stree[],int low, int high,int pos){
        if(low==high){
            stree[pos]=arr[low];
                    return;
        }
        int mid=(low+(high-low)/2);
        constructtree(arr,stree,low,mid,(2*pos)+1);
        constructtree(arr,stree,mid+1,high,(2*pos)+2);
        stree[pos]=Math.min(stree[(2*pos)+1],stree[(2*pos)+2]);
       }
       int query(int left , int right, int size)
       {
           return query(left, right, 0, size-1, 0);
       }

       int query(int l,int r,int low,int high,int pos){
        if(r<low||l>high)
            return Integer.MAX_VALUE;
        if(l>=low && high<=r)
            return stree[pos];
        int mid=(low+(high-low)/2);
        return (Math.min(query(l,r,low,mid,2*pos+1),query(l,r,mid+1,high,2*pos+2)));
       }

       public static void main(String[]args){
        int []arr=new int[]{-1,2,4,0};
           Segment_tree s=new Segment_tree(arr,4);
         //  for(int i:s.stree)
           //    System.out.print(i);
         int y=  s.query(1,3,4);
           System.out.print(y);
       }
}
