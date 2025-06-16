import java.util.Scanner;

public class DynamicArrayExampl{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number: ");
            arr[i]= sc.nextInt();
           
        }
        for (int i = 0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]==-1 || arr[j]==-1){
                    continue;
                }
                if(arr[i]==arr[j]){
                    arr[j]=-1;
                }
            }
        }
        for(int i =0;i<n;i++){
        System.out.println(arr[i]);
        }
    }
}
