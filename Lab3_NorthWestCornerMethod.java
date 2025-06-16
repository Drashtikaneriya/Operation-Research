public class Lab3_NorthWestCornerMethod {
    public static void main(String[] args) {
        int[] supply = {500,300,200};
        int[] demand = {180,150,350,320};
        int[][] cost ={{12,10,12,13},{7,11,8,14},{6,16,11,7}};
        int [][] allocation = new int[3][4];
        int total=0;
        for(int i =0;i<supply.length;i++){
            for(int j=0;j<demand.length;j++){
                int min=Math.min(supply[i],demand[j]);
                allocation[i][j]=min;
                supply[i]-=min; 
                demand[j]-=min;
                if(supply[i]==0){
                  break;
                }

            }
        }
        for(int row=0;row<3;row++){
            for(int col=0;col<4;col++){
            total+=allocation[row][col]*cost[row][col];
                System.out.print(allocation[row][col]+ "   ");
            }
            System.out.println();

        }
        System.out.println("total cost : "+total);
    }
}

