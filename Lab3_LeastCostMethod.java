public class Lab3_LeastCostMethod {
    public static void main(String[] args) {

        //program of trasportation problem using least cost method
        int[][] cost ={{12,10,12,13},{7,11,8,14},{6,16,11,7}};
        int[] supply = {500,300,200};
        int[] demand = {180,150,350,320};

        int[][] allocation = new int[supply.length][demand.length];
        boolean[] supplyUsed = new boolean[supply.length];
        boolean[] demandUsed = new boolean[demand.length];
        int totalCost = 0;
        int totalSupply = 0;
        int totalDemand = 0;
        for (int i = 0; i < supply.length; i++) {
            totalSupply += supply[i];
        }
        for (int i = 0; i < demand.length; i++) {
            totalDemand += demand[i];
        }
        if (totalSupply != totalDemand) {
            System.out.println("Supply and demand do not match.");
            return;
        }
        while (true) {
            int minCost = Integer.MAX_VALUE;
            int minRow = -1;
            int minCol = -1;

            // Find the minimum cost cell
            for (int i = 0; i < supply.length; i++) {
                if (supplyUsed[i]) continue;
                for (int j = 0; j < demand.length; j++) {
                    if (demandUsed[j]) continue;
                    if (cost[i][j] < minCost) {
                        minCost = cost[i][j];
                        minRow = i;
                        minCol = j;
                    }
                }
            }

            // If no valid cell found, break the loop
            if (minRow == -1 || minCol == -1) break;

            // Determine the allocation
            int allocationAmount = Math.min(supply[minRow], demand[minCol]);
            allocation[minRow][minCol] = allocationAmount;
            totalCost += allocationAmount * cost[minRow][minCol];

            // Update supply and demand
            supply[minRow] -= allocationAmount;
            demand[minCol] -= allocationAmount;

            // Mark supply or demand as used if exhausted
            if (supply[minRow] == 0) {
                supplyUsed[minRow] = true;
            }
            if (demand[minCol] == 0) {
                demandUsed[minCol] = true;
            }
        }

        // Print the allocation matrix
        System.out.println("Allocation Matrix:");   
        for (int i = 0; i < allocation.length; i++) {
            for (int j = 0; j < allocation[i].length; j++) {
                System.out.print(allocation[i][j] + "\t");
            }
            System.out.println();
        }

        // Print the total cost
        System.out.println("Total Cost: " + totalCost);

        
    }
}