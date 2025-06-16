public class Lab2_ServerMinTime {
    public static void main(String[] args) {

        int[] tasks = {10, 20, 30};

        int minMaxTime = Integer.MAX_VALUE;

        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    int server1 = 0;
                    int server2 = 0;

                    if (a == 0) 
                        server1 += tasks[0]; 
                    else
                        server2 += tasks[0];
                    if (b == 0)
                        server1 += tasks[1]; 
                    else 
                        server2 += tasks[1];
                    if (c == 0) 
                        server1 += tasks[2]; 
                    else 
                        server2 += tasks[2];

                    int maxTime = Math.max(server1, server2);

                    if (maxTime < minMaxTime)
                        minMaxTime = maxTime;
                }
            }
        }

        System.out.println("Minimum max time on any server: " + minMaxTime);

        
    }
}
