package Graphs.BFS_DFS;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        SurroundedRegions sr = new SurroundedRegions();
        sr.solve(board);

        // Print the modified board
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++) {
            // first & last row
            if(i==0 || i==m-1) {
                for(int j=0;j<n;j++) {
                    if(board[i][j]=='O') dfs(board, i, j);
                }
            } else {
                //first col
                if(board[i][0]=='O') dfs(board, i, 0);
                //last col
                if(board[i][n-1]=='O') dfs(board, i, n-1);
            }
        }

        // now removing the cells with 'T' & replacing the 'O' with 'X'
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='T') board[i][j] = 'O';
                else if(board[i][j]=='O') board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(char[][] board, int r, int c) {
        board[r][c] = 'T';
        
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        
        for(int i=0;i<4;i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && board[nr][nc]=='O') dfs(board, nr, nc);
        }
    }
}
