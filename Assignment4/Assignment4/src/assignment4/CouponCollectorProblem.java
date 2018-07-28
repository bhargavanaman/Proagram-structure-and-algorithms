/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.Random;


public class CouponCollectorProblem<Key, Value> {
     
    public int n; 
    private int m;
    private static int CAP;
                                   
    private SequentialSearchST<Key, Value>[] sequentialSearchSt; 

    public CouponCollectorProblem() {
        this(CAP);
    } 
    public CouponCollectorProblem(int m) {
        this.m = m;
        sequentialSearchSt = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            sequentialSearchSt[i] = new SequentialSearchST<Key, Value>();
    } 

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }  

    public int size() {
        return n;
    } 

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("Exception caught");
        return get(key) != null;
    } 
    
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Exception caught");
        int i = hash(key);
        return sequentialSearchSt[i].get(key);
    } 
    public static boolean flag=true;
    public static int count=0;
    public static int c=0;
     
    public void put(Key key, Value val,String initial){

        int i = hash(key);
        if (!sequentialSearchSt[i].getCollision(key)){ 
            c++;
      
        }
        if(c==CAP){
            count+=n;
            flag=false;
       
        }

         put(key, val);
    }
    public void put(Key key, Value val) {
         if (key == null) throw new IllegalArgumentException("Exception caught");
         int i = hash(key);
         n++;
         sequentialSearchSt[i].put(key, val);
    } 

       public static void main(String[] args) {
        for(int m=10;m<=100;m+=10){  
            count=0;
           CAP=m; 
        for(int j=0;j<=100;j++)
        {
        CouponCollectorProblem<String, Integer> st = new CouponCollectorProblem<String, Integer>(CAP);
         c=0;
        int i=0;
        while(flag==true || c<=CAP) {
          
            Random r=new Random();
            String key= String.valueOf(r.nextInt());
            if(flag)
            st.put(key, i,"put");
            else 
            {
                flag=true;
                break;
            }
           i++;

        }
        }
           System.out.println("Average for :"+m+" is: "+count/100);
     }
   }
}
