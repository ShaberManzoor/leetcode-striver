package Graphs.BFS_DFS;

public class FloodFill {
    private int originalColor;
    private int x[] = {0, 1, 0, -1};
    private int y[] = {1, 0, -1, 0};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        originalColor = image[sr][sc];
        
        if(originalColor==color) return image;
        
        dfs(image, sr, sc, color);
        
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int color) {
        image[sr][sc] = color;
        
        for(int i=0;i<4;i++) {
            int nr = sr + x[i];
            int nc = sc + y[i];
            
            if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && image[nr][nc]==originalColor) {
                dfs(image, nr, nc, color);
            }
        }
    }
}
