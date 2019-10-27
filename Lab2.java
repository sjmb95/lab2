/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;
import java.lang.Math;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author Dizz
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
public static int [] generator(int array[]){

for(int i = 0;i < array.length;i++){

        array[i]= (int)Math.round((Math.random()*((9 - 0)+ 1)) + 0);
}

return array;

}    
    
 public static void main(String[] args) {
        
        
        int [] frames1 = new int[3];
        int [] frames2 = new int[4];
        int pos1 = 0;
        int pos2=0;
        int [] ref ={7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        int fault = 0;
        int c1=3,c2=2,c3=1;
        int highest = 0;
        int p = 0;
        int c4=0;
        
        
        ref = generator(ref);
        System.out.println("ref is : ");
        
        for(int i = 0;i<ref.length;i++){
          System.out.print(ref[i]+", ");
        }
        System.out.println();
        
        // FIFO
        
         frames1[0] = ref[0];
        frames1[1] = ref[1];
        frames1[2] = ref[2];
        
        frames2[0] = ref[0];
        frames2[1] = ref[1];
        frames2[2] = ref[2];
        frames2[3] = ref[3];
        
        
           System.out.println("\n\n  ----------------FIFO--------------- ");
            System.out.println("\n             3 FRAMES \n");
        
        System.out.print(frames1[0]+" - "+frames1[0]+" "+frames1[1]+" - "+frames1[0]+" "+frames1[1]+" "+frames1[2]);
        fault = 3;
        for(int i=3;i<ref.length;i++){
             
            if(ref[i]!=frames1[0] && ref[i]!=frames1[1] && ref[i]!=frames1[2]){
             fault++;
             if(ref[i]!= frames1[0]){
              c1++;
             
             }
             if(ref[i] != frames1[1]){
              c2++;
            }
              if(ref[i] != frames1[2]){
                 c3++;
             }
              
             highest = c1;
             
         if(highest<=c1){
             p= 0;
         highest= c1;
             
         }
             
        if(highest < c2){
         p= 1;
         highest= c2;
         
       }
       if(c3 > highest){
         p=2;
         highest= c3;
         
       }
       
      
       if(highest == c1){
        c1=0;
       }else if(highest==c2){
        c2=0;
       }else if(highest==c3){
       c3=0;
       }
             
          
            
        frames1[p]= ref[i];
            
        System.out.print(" - "+frames1[0]+" "+frames1[1]+" "+frames1[2]);
        
            }       
            
        
        }
         System.out.println("\nNumber of page faults is : "+fault);
        
        System.out.println("\n             4 FRAMES \n");
        c1=4;c2=3;c3=2;c4=1;
        
           System.out.print(frames2[0]+" - "+frames2[0]+" "+frames2[1]+" - "+frames2[0]+" "+frames2[1]+" "+frames2[2]+" - "+frames2[0]+" "+frames2[1]+" "+frames2[2]+" "+frames2[3]);
        fault = 4;
        
           for(int i=4;i<ref.length;i++){
             
            if(ref[i]!=frames2[0] && ref[i]!=frames2[1] && ref[i]!=frames2[2]){
             fault++;
             if(ref[i]!= frames2[0]){
              c1++;
             
             }else if(ref[i] != frames2[1]){
              c2++;
             }else if(ref[i] != frames2[2]){
                 c3++;
             }else if(ref[i] != frames2[3]){
                c4++;
             }
             }
              
             highest = c1;
             
         if(highest<=c1){
          p= 0;
         highest= c1;
             
         }
             
        if(highest < c2){
         p= 1;
         highest= c2;
        
       }
       if(c3 > highest){
         p=2;
         highest= c3;
      
       }
       if(c4 > highest){
         p=3;
         highest= c4;
        
       }
      
             
          
            
        frames2[p]= ref[i];
        
        if(highest == c1){
        c1=0;
       }else if(highest==c2){
        c2=0;
       }else if(highest==c3){
       c3=0;
       }else if(highest==c4){
        c4=0;
       }
            
        System.out.print(" - "+frames2[0]+" "+frames2[1]+" "+frames2[2]+" "+frames2[3]);
        
            }    
       
        System.out.println("\n number of page faults = "+fault);
        
        
        
        frames1[0] = ref[0];
        frames1[1] = ref[1];
        frames1[2] = ref[2];
        
        frames2[0] = ref[0];
        frames2[1] = ref[1];
        frames2[2] = ref[2];
        frames2[3] = ref[3];
        
        
           System.out.println("\n\n  ----------------LRU--------------- ");
            System.out.println("\n             3 FRAMES \n");
        
        System.out.print(frames1[0]+" - "+frames1[0]+" "+frames1[1]+" - "+frames1[0]+" "+frames1[1]+" "+frames1[2]);
        fault = 3;
        for(int i=3;i<ref.length;i++){
             
            if(ref[i]!=frames1[0] && ref[i]!=frames1[1] && ref[i]!=frames1[2]){
             fault++;
             frames1 = getLRU(frames1,ref,i);
          
            
            }
            
            
        System.out.print(" - "+frames1[0]+" "+frames1[1]+" "+frames1[2]);
        
        
            
        
        }
         System.out.println("\nNumber of page faults is : "+fault);
        
        System.out.println("\n             4 FRAMES \n");
        
           System.out.print(frames2[0]+" - "+frames2[0]+" "+frames2[1]+" - "+frames2[0]+" "+frames2[1]+" "+frames2[2]+" - "+frames2[0]+" "+frames2[1]+" "+frames2[2]+" "+frames2[3]);
        fault = 4;
        for(int i=4;i<ref.length;i++){
             
            if(ref[i]!=frames2[0] && ref[i]!=frames2[1] && ref[i]!=frames2[2] &&ref[i]!=frames2[3]){
             fault++;
             frames2 = getLRU(frames2,ref,i);
          
            
            }
        System.out.print(" - "+frames2[0]+" "+frames2[1]+" "+frames2[2]+" "+frames2[3]);
            
        
        }
        
        
        
        System.out.println();
        System.out.println("Number of page faults is : "+fault);
        
        
        
        // belady 
        System.out.println("\n -----------belady------------");
        
        frames1[0] = ref[0];
        frames1[1] = ref[1];
        frames1[2] = ref[2];
        
        frames2[0] = ref[0];
        frames2[1] = ref[1];
        frames2[2] = ref[2];
        frames2[3] = ref[3];
        
            System.out.println("\n             3 FRAMES \n");
        
        System.out.print(frames1[0]+" - "+frames1[0]+" "+frames1[1]+" - "+frames1[0]+" "+frames1[1]+" "+frames1[2]);
        fault = 3;
        for(int i=3;i<ref.length;i++){
             
            if(ref[i]!=frames1[0] && ref[i]!=frames1[1] && ref[i]!=frames1[2]){
             fault++;
             frames1 = getOpt(frames1,ref,i);
          
            
            }
        System.out.print(" - "+frames1[0]+" "+frames1[1]+" "+frames1[2]);
        
        
            
        
        }
         System.out.println("\nNumber of page faults is : "+fault);
        
        System.out.println("\n             4 FRAMES \n");
        
           System.out.print(frames2[0]+" - "+frames2[0]+" "+frames2[1]+" - "+frames2[0]+" "+frames2[1]+" "+frames2[2]+" - "+frames2[0]+" "+frames2[1]+" "+frames2[2]+" "+frames2[3]);
        fault = 4;
        for(int i=4;i<ref.length;i++){
             
            if(ref[i]!=frames2[0] && ref[i]!=frames2[1] && ref[i]!=frames2[2] &&ref[i]!=frames2[3]){
             fault++;
             frames2 = getOpt(frames2,ref,i);
          
            
            }
        System.out.print(" - "+frames2[0]+" "+frames2[1]+" "+frames2[2]+" "+frames2[3]);
            
        
        }
        
        
        
        System.out.println();
        System.out.println("Number of page faults is : "+fault);
        
        
        
        
        // TODO code application logic here
    }
    
    public static int [] getLRU(int frames[],int ref [],int pos){
        
       int c1, c2, c3,c4;
       c1=0;
       c2=0;
       c3=0;
       c4=0;
       int i = pos;
       int found = 0;
       int p = 0;
       int lowCount = 0;
       
       while(i>=0){
           
          
         
           if(frames[0]== ref[i] ){
             if(c1==0){  
               c1 = i;
               found++;
             }
           }else if(frames[1] == ref[i]){
              if(c2==0){
                c2 = i;
                found++;
              }
           }else if(frames[2]==ref[i]){
             if(c3==0){ 
               c3 =i;
              found++;
             }
           }else if(frames.length == 4){
             if(frames[3]==ref[i]){
              if(c4==0){
                c4 = i;
                found++;
              }
             }
           
           }else{}
           
              
           
           
           i--;
       }
       
    
       
      
     lowCount= c1;
       
       if(lowCount >= c1){
         p= 0;
         lowCount = c1;
       }
       
       if(lowCount > c2){
         p= 1;
         lowCount = c2;
       }
       if(c3 <lowCount){
         p=2;
         lowCount= c3;
       }
       if(frames.length==4){
         if(c4< lowCount){
           p=3;
           lowCount = c4;
         }
       }
     
      
       
      
        
        
        frames[p] = ref[pos];
        
      
       return frames;
    
    }
    
  public static int [] getOpt(int frames[],int ref [],int pos){
        
       int c1, c2, c3,c4;
       c1=100;
       c2=100;
       c3=100;
       c4=100;
       int i = pos;
       int found = 0;
       int p = 0;
       int highCount = 0;
       
       while(i< ref.length){
           
          
         
           if(frames[0]== ref[i] ){
             if(c1==100){  
               c1 = i;
               found++;
             }
           }else if(frames[1] == ref[i]){
              if(c2==100){
                c2 = i;
                found++;
              }
           }else if(frames[2]==ref[i]){
             if(c3==100){ 
               c3 =i;
              found++;
             }
           }else if(frames.length == 4){
             if(frames[3]==ref[i]){
              if(c4==100){
                c4 = i;
                found++;
              }
             }
           
           }else{}
           
              
           
           
           i++;
       }
       
    
       
      
     highCount= c1;
       
       if(highCount <= c1){
         p= 0;
         highCount = c1;
       }
       
       if(highCount < c2){
         p= 1;
         highCount = c2;
       }
       if(c3> highCount){
         p=2;
         highCount= c3;
       }
       if(frames.length==4){
         if(c4> highCount){
           p=3;
           highCount = c4;
         }
       }
     
      
       
      
        
        
        frames[p] = ref[pos];
        
      
       return frames;
    
    }   
  
 
    
}
