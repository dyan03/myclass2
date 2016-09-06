/* 
Name: An DaeYeong
Student ID:2012136009
*/
import java.util.Arrays;

public class HW0{

    static int i=0;
    static int j=0;

    private static void push(String[] box, String s){

        box[i]=s;
        ++i;
    }



    private  static void swap(StringBuffer str, int p1, int p2){

       
        char c = str.charAt(p1);
        str.setCharAt(p1, str.charAt(p2));
        str.setCharAt(p2, c);
        
    } 


    public static int factorial(int n){

        int res=1;

        if(n==1) return res;

        res= n*factorial(n-1);

        return res;

    }
 public static void delete(String[] res, int index, int size){

    res[index]="x";

 }

    public static String[] unique(String[] res,int size){

        int count=0;

        for(int i=0;i<size-1;i++){

            for(int j=i+1;j<size;j++){

                if (res[i].equals(res[j])==true){
                    delete(res,j,size);
                    
                }
            }
        }

        for(int k=0;k<size;k++){

            if(res[k].equals("x"))count++;

        }

        String[] newRes=new String[size-count];
        i=0;
        for(int k=0;k<size;k++){
        if(res[k].equals("x")==false){
            push(newRes,res[k]);
            
        }
        }
        int n= size-count;
        System.out.println("number of permutation="+n );
        System.out.println(count);
        return newRes;
    }



    private static void permutation(StringBuffer str, int index, String[] s){

      if(index <= 0)
         push(s,str.toString());         

     else { 
         permutation(str, index-1,s);
         int cp = str.length()-index;
         for (int i = cp+1; i < str.length(); i++) {
            
             swap(str,cp,i);
             permutation(str, index-1,s);
             swap(str,i, cp);
         
         }
     }
 }




 public static String[] printPermutations(String s)
 {
   int n=s.length();
   int c= factorial(n);

   StringBuffer sBuf=new StringBuffer(s);
   String[] res = new String[c];

   permutation(sBuf,n, res);
   Arrays.sort(res);

   return unique(res,c);

  


}




public static void main(String[] args)  {

    String[] permutations = printPermutations("vsffsb");
    
    for(String p : permutations)
        {
            System.out.println(p);
        }
         
    }


}