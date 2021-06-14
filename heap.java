package com.company;

public class heap {
    private int[] heap;
    private int size;

    public heap(int capacity){
        heap=new int[capacity];
    }

    public void insert(int value){
        if(isFull())
            throw  new IndexOutOfBoundsException("heap is full");
        heap[size]=value;
        fixHeapAbove(size);
        size++;

    }

    private boolean isFull(){
        return size==heap.length;
    }

    private boolean isEmpty(){
        return size==0;
    }

    private int getChild(int index,boolean left){
        return 2* index +(left?1:2);
    }

    private int getParent(int index){
        return (index-1)/2;
    }
    private void fixHeapAbove(int index){
        int value=heap[index];
        while(index>0&&heap[getParent(index)]<value){
            heap[index]=heap[getParent(index)];
            index=getParent(index);
        }
        heap[index]=value;
    }

    public int delete(int index){
        if(isEmpty())
            throw new IndexOutOfBoundsException("heap is empty");
        else
        {
            int deletedvalue=heap[index];
            heap[index]=heap[size-1];
            if(index==0||heap[index]<heap[getParent(index)])
                fixHeapBelow(index,size-1);
            else
                fixHeapAbove(index);
            size--;

            return deletedvalue;
        }


    }

    private void fixHeapBelow(int index,int lastheapindex) {
        int childToSwap;
        while (index <= lastheapindex) {
            int leftchild = getChild(index, true);
            int rightchild = getChild(index, false);
            if (leftchild <= lastheapindex) {
                if (rightchild > lastheapindex)
                    childToSwap = leftchild;
                else
                    childToSwap = (heap[leftchild] > heap[rightchild] ? leftchild : rightchild);
                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }
                else
                    break;
                index=childToSwap;
            }
            else
                break;

        }
    }
    public  void sort(){
        int lastheapindex=size-1;
        for(int i=0;i<lastheapindex;i++){
            int temp=heap[0];
            heap[0]=heap[lastheapindex-i];
            heap[lastheapindex-i]=temp;

            fixHeapBelow(0,lastheapindex-i-1);

        }

    }

    public void print(){
        for(int i=0;i<size;i++)
        {
            System.out.print(heap[i]+",");
        }
        System.out.println();
    }

}
