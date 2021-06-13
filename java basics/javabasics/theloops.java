/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasics;

/**
 *
 * @author black
 */
class theloops {
    //first
    void printnum(int a){
        for(int i=1;i<=a;i++){
            System.out.println(i);
        }
    }
    //second
    void oddprint(int a){
        for(int i=1;i<=a;i++){
            if(i%2 != 0){
                System.out.println(i);
            }
        }
    }
    //third
    void printsum(int a){
        int sum = 0;
        for(int i=0;i<=a;i++){
            sum+=i;
            System.out.println("new number is : "+ i + " Sum : " +sum);
        }
    }
    //fourth
    void arrprint(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    //fifth
    Integer maxarr(int[] a){
        int max = a[0];
        for(int i=0;i<a.length;i++){
            if (max<a[i]){
                max=a[i];
            }
        }
        return max;
    }
    //sixth
    Integer avgarr(int[] a){
        int sum=0,avg=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        avg=(sum/a.length);
            
        return avg;
    }
    //seventh
    int[] oddarr(int a){
    int[] y = new int[a];
        int z=0;
        for(int i=0;i<=a;i++){
            if(i%2 !=0){
                y[z]=i;
                z++;
            }
        }
        return y;
    }
    //eigth
    void greaterthany(int[] a,int y){
        int z=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>y){
            z++;
        }
        }
        System.out.println(z);
    }
    //ninth
    int[] arrsquare(int[] a){
        int[] newarr = new int[a.length];
        for(int i=0;i<a.length;i++){
            newarr[i] =(int) Math.pow(a[i], 2);
        }
        
        return newarr;
    }
    //tenth
    int[] absarr(int[] a){
        int b= a.length;
        int newarr[]= new int[b];
        for(int i=0;i<a.length;i++){
            if(a[i]>0){
                newarr[i]=a[i];
            }else{
            newarr[i]=0;
        }}
        return newarr;
    }
    //eleventh
    int[] maxminavg(int[] a){
        int max=a[0];
        int min=a[0];
        int sum=0;
        int avg=0;
        int[] newarr=new int[3];
        for(int i=0;i<a.length;i++){
            if (a[i]>max){
                max=a[i];
            }
            if(min>a[i]){
                min=a[i];
            }
            
            sum+=a[i];
            
        }
        newarr[0]=max;
        newarr[1]=min;
        newarr[2]=sum/a.length;
        return newarr;
    }
    
    
    
    
    
}
