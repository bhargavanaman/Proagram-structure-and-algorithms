/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.Random;

public class BirthdayProblem<Key, Value> {
    
    public int n;                                
    private int m; 
    private static int CAP;
                                 
    private SequentialSearchST<Key, Value>[] seqSearchSt;  

    public BirthdayProblem() {
        this(CAP);
    } 

    public BirthdayProblem(int m) {
        this.m = m;
        seqSearchSt = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            seqSearchSt[i] = new SequentialSearchST<Key, Value>();
    } 
 
    private int hash(Key key) {
        char[] k=String.valueOf(key).toCharArray();
        int hash=0;
           for (int i = 0; i < k.length; i++)
            hash = ((hash * 31) + k[i])%m;

        return hash;
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
        return seqSearchSt[i].get(key);
    } 
    
    public static boolean flag=true;
    public static int count=0;
    public void put(Key key, Value val,String initial){
        int i = hash(key);
           if(seqSearchSt[i].getCollision(key)){
               count+=n;
               flag=false;
           }

         put(key, val);
    }
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("Exception caught");

        int i = hash(key);
            n++;
        seqSearchSt[i].put(key, val);
    } 

   
       public static void main(String[] args) {
        for(int m=10;m<=100;m+=10){  
           count=0;
           CAP=m; 
        for(int j=0;j<=100;j++)
        {
        BirthdayProblem<String, Integer> st = new BirthdayProblem<String, Integer>(CAP);
  
        Random r=new Random();
        int[] array=new int[CAP];
        for (int i = 0; i<array.length; i++) 
          {
           array[i] = r.nextInt(CAP); // TODO populate the array with real random data
          }

        for (int i = 0; i<array.length; i++) {
          //Scanner in = new Scanner(System.in);
            //String key = in.next();
            String key= String.valueOf(array[i]);
            if(flag)
            st.put(key, i,"put");
            else 
            {
                flag=true;
                break;
            }
          }
        }
           System.out.println("Average for m:"+m+" is : "+count/100);
    }
   }
}
