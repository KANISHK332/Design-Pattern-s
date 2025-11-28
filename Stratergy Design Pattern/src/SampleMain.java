import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SampleMain {
    void printNameNtimes(int i,int N){
        if(i>=N) return;
        i++;
        System.out.println("Kanishk");
        printNameNtimes(i,N);
    }

    void printNumber1ToN(int i,int N){
        if(i>N) return ;
        System.out.println(i);
        printNumber1ToN(i+1,N);
    }

    void printNumberNTo1(int i){
        if(i<=0) return;
        System.out.println(i);
        printNumberNTo1(i-1);
    }


    int sumOfFirstN(int i,int N,int sm){
        if(i>N) return sm;
        return sumOfFirstN(i+1,N,sm+i);
    }

    long factorial(int i,int N,long ans){
        if(i>N) return ans;
        return factorial(i+1,N,ans*i);
    }

    void reverseArray(int[] arr, int lt, int rt){
          if(rt>lt) {
              int tmp = arr[rt];
              arr[rt] = arr[lt];
              arr[lt] = tmp;
              reverseArray(arr, lt + 1, rt - 1);
          }
    }

    boolean palindromeCheck(String s, int lt, int rt){
         if(lt>=rt) return true;
         if(s.charAt(lt)!=s.charAt(rt)) return false;
         return palindromeCheck(s,lt+1,rt-1);
    }

    List<Integer> fibonacciNumber(int i,int N,List<Integer> ans) {
        if (i > N) return ans;
        Integer res = 0;
        if (i == 0) res = 0;
        if (i == 1) res = 1;
        if (i >= 2) {
            res = ans.get(i - 1) + ans.get(i - 2);
        }
        ans.add(res);
        return fibonacciNumber(i + 1, N, ans);
    }
       void  merge(int arr[],int low,int high){
           if(low>=high) return;
           int md= (low+high)/2;
           merge(arr,low,md);
           merge(arr,md+1,high);
           mergeSort(arr,low,md,high);
        }

    private void mergeSort(int[] arr, int low, int md, int high) {
          int lt= low;
          int rt= md+1;
          List<Integer> tmp= new ArrayList<>();
          while(lt<=md && rt<=high){
              if(arr[lt]<=arr[rt]){
                  tmp.add(arr[lt]);
                  lt++;
              }
              else{
                  tmp.add(arr[rt]);
                  rt++;
              }
          }

          while(lt<=md){
              tmp.add(arr[lt]);
              lt++;
          }
          while(rt<=high){
              tmp.add(arr[rt]);
              rt++;
          }

          for(int i=low;i<=high;i++){
              arr[i]= tmp.get(i-low);
          }
    }

    void quickSort(int arr[],int low ,int high){
        if(low<high){
            int pivotIdx= partitionIdx(arr,low,high);
            quickSort(arr,low,pivotIdx-1);
            quickSort(arr,pivotIdx+1,high);
        }
    }

    private int partitionIdx(int[] arr, int low, int high) {
          int pivot= arr[low];
          int i=low;
          int j=high;
          while(i<j){
              while(pivot>=arr[i] && i<=high-1){
                  i++;
              }
              while(pivot<arr[j] && j>=low+1){
                  j--;
              }
              if(i<j){
                  int tmp= arr[i];
                  arr[i]=arr[j];
                  arr[j]= tmp;
              }
          }
          int tmp= arr[low];
          arr[low]=arr[j];
          arr[j]=tmp;
          return  j;
    }

    Integer largestElem(int[] arr){
        int maxmElem= Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxmElem= Math.max(maxmElem,arr[i]);
        }
        return maxmElem;
    }

    Integer secondLargestElem(int []arr){
         int n=arr.length;
         int maxmElem= arr[0];
         int maxmElem2=Integer.MIN_VALUE;
         for(int i=1;i<n;i++){
             if(arr[i]>=maxmElem){
                 maxmElem2=maxmElem;
                 maxmElem=arr[i];
             }
             else{
                 if(arr[i]>maxmElem2){
                     maxmElem2=arr[i];
                 }
             }

         }
        return maxmElem2;
    }

    public static void main(String[] args) {
        SampleMain sampleMain= new SampleMain();
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        sampleMain.printNameNtimes(0,N);
        sampleMain.printNumber1ToN(1,N);
        sampleMain.printNumberNTo1(N);
        System.out.println(sampleMain.sumOfFirstN(1,N,0));
        System.out.println(sampleMain.factorial(1,N,1));
        int[] arr ={1,2,3,4,5};
        sampleMain.reverseArray(arr,0,N-1);
        for(int i=0;i<N;i++)
        System.out.print(arr[i]+" ");
        System.out.println();
        String s= "bcccb";
        System.out.println(sampleMain.palindromeCheck(s,0,s.length()-1));
        List<Integer> ans= new ArrayList<>();
        System.out.println(sampleMain.fibonacciNumber(0,N,ans));
        int[] arr1= {2,9,7,5,4};
        sampleMain.merge(arr1,0,N-1);
        for(int x:arr1){
            System.out.print(x+" ");
        }
        System.out.println();
        int arr2[]= {5,3,4,9,95,2};
        System.out.println(sampleMain.largestElem(arr2));
        System.out.println(sampleMain.secondLargestElem(arr2));
        sampleMain.quickSort(arr2,0,N-1);
        for(int x2:arr2){
            System.out.print(x2+" ");
        }

    }
}
