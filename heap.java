package com.company;

public class heap {

        public int[] array;
        public int count;           //no of current elements in heap
        public int capacity;        //maximum no elements in heap
        // public int heap_type;
        public heap(int capacity){
            this.capacity=capacity;
            // this.heap_type=heap_type;
            this.count=0;
            this.array=new int[capacity];
        }

        public int parent(int i)
        {
            if(i<=0||i>=this.count)
                return -1;
            return (i-1)/2;
        }
        public int leftchild(int i){
            int left=2*i;
            if(left>=this.count)
                return -1;
            else return left;
        }
        public int rightchild(int i){
            int right=2*i+1;
            if(right>=this.count)
                return -1;
            else return right;
        }

        public void swap(int a,int b){
            int temp;
            temp=this.array[a];
            this.array[a]=this.array[b];
            this.array[b]=temp;
        }


        public void maxheapify(int i){                                        //maxheapify
            int l,r,max,temp;
            l=leftchild(i);
            r=rightchild(i);
            if(l!=-1 && this.array[l]>this.array[i])//check if left element exist and is greater than parent
                max=l;
            else
                max=i;
            if(r!=-1 && this.array[r]>this.array[max])
                max=r;
            if(max!=i){
                temp=this.array[i];
                this.array[i]=this.array[max];
                this.array[max]=temp;
                maxheapify(max);
            }
        }
    public void minheapify(int i){                                        //minheapify
        int l,r,min,temp;
        l=leftchild(i);
        r=rightchild(i);
        if(l!=-1 && this.array[l]<this.array[i])//check if left element exist and is greater than parent
            min=l;
        else
            min=i;
        if(r!=-1 && this.array[r]<this.array[min])
            min=r;
        if(min!=i){
            temp=this.array[i];
            this.array[i]=this.array[min];
            this.array[min]=temp;
            minheapify(min);
        }
    }

        public void insert(int key){                                        //insert an element
            this.count++;
            int i=this.count-1;
            this.array[i]=key;
//            while (i>0 && this.array[parent(i)]<this.array[i]){         //this is performed cause new element inserted may be largest
//                swap(parent(i),i);
//                i=parent(i);
//            }
            while (i>0 && this.array[parent(i)]>this.array[i]){         //minheapify function
                swap(parent(i),i);
                i=parent(i);
            }
           // System.out.print(this.array[i]);
        }
        public int deletemax(){                                          //delete maximum element
            if(this.count==0)           //no element to delete
                return -1;
            int data=this.array[0];
            this.array[0]=this.array[count-1];
            this.count--;
            maxheapify(0);
            return data;
        }
    public int deletemin(){                                          //delete mainimum element
        if(this.count==0)           //no element to delete
            return -1;
        int data=this.array[0];
        this.array[0]=this.array[count-1];
        this.count--;
        minheapify(0);
        return data;
    }
public int changekey(int i,int key){
            int value =this.array[i];                       //replace a element with another
            this.array[i]=key;
    while (i>0 && this.array[parent(i)]<this.array[i]){
        swap(parent(i),i);
        i=parent(i);
    }
    return value;
}

//build heap function

public void buildheap(int arr[]){
            this.array=arr;

}
public int delete(int i){
            int value =this.array[i];
            this.array[i]=this.array[this.count-1];
    this.count=this.count-1;
            maxheapify(i);
            return value;
}
public int k_smallest(int i){
            for(int j=0;j<i-1;j++){
                this.deletemin();
            }
            return this.deletemin();
}
        public  static void main(String []args){
            heap h=new heap(11);
            //Heap(11);
            // Heap(11);
            h.insert(31);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(1);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(21);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(9);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(10);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(12);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(18);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(3);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(2);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(8);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            h.insert(7);
            for(int i:h.array)
                System.out.print(i+" ");
            System.out.println(" ");

            int arr[]=new int[]{0,5,9,6,3,2,15,10,14};
            h.buildheap(arr);

//
//           h.changekey(10,32);
//            for(int i:h.array)
//                System.out.print(i+" ");

// h.delete(9);
//            for(int i:h.array)
//               System.out.print(i+" ");
//            System.out.println(h.count+" ");
           int small= h.k_smallest(3);
            System.out.print(small+" ");


    }



}
