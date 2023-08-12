import java.util.Arrays;

class MCP_DP{
    public static int minimumCostPath(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] costs = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[0][0] = grid[0][0];

        int[][] ds = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < ds.length; k++) {
                    int newX = i + ds[k][0];
                    int newY = j + ds[k][1];

                    if (isSafe(newX, newY, rows, cols)) {
                        int newCost = costs[i][j] + grid[newX][newY];
                        costs[newX][newY] = Math.min(costs[newX][newY], newCost);
                    }
                }
            }
        }

        return costs[rows - 1][cols - 1];
    }

    public static boolean isSafe(int row, int col, int N, int M) {
        return row >= 0 && col >= 0 && row < N && col < M;
    }

    public static void main(String[] args) {
        int grid[][] = {{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}};
        System.out.println(minimumCostPath(grid));
    }
}