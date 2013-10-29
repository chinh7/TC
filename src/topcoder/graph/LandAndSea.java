package topcoder.graph;

import java.util.Arrays;

public class LandAndSea {
    private int n,m;
    private int[][] map;
    private int islandCount=0;
    private int[] x = {-1,0,1,0}, y={0,1,0,-1};
    private boolean[] encountered;

    private boolean[][] graph;

    private boolean valid(int u, int v){
        return (u>=0&&u<n&&v>=0&&v<m);
    }
    private void numberIsland(int u, int v){
        map[u][v] = islandCount;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if(i!=0 || j!=0){
                    if(valid(u+i,v+j) && map[u+i][v+j]<0) numberIsland(u+i,v+j);
                }
            }
        }

    }
    private void find(int u, int v){
        map[u][v] = -1;
        for(int e=0; e<4; e++){
            int i = u+x[e], j=v+y[e];
            if(!valid(i,j)){
                encountered[0] = true;
            } else{
                if(map[i][j]>0){
                    encountered[map[i][j]] = true;
                } else
                if(map[i][j]==0){
                    find(i,j);
                }
            }
        }
    }
    private int longest(int i){
        int longest = 0;
        for(int j=0; j<islandCount; j++){
            if(graph[i][j]){
                int lc = longest(j);
                if(longest<lc+1) longest = lc+1;
            }
        }
        return longest;
    }
    public int[] howManyIslands(String[] seaMap){
        n = seaMap.length;
        m = seaMap[0].length();
        map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(seaMap[i].charAt(j)=='x') map[i][j] = -1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]<0){
                    islandCount++;
                    numberIsland(i,j);
                }
            }
        }
        encountered = new boolean[islandCount+1];
        graph = new boolean[islandCount][islandCount];
        int lastSeen = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    Arrays.fill(encountered, false);
                    find(i,j);
                    if(!encountered[0]){
                        for(int e=1; e<=islandCount; e++){
                            if(e!=lastSeen && encountered[e]){
                                graph[lastSeen-1][e-1] = true;
                            }
                        }
                    }
                } else
                if(map[i][j]>0){
                    lastSeen=map[i][j];
                }
            }
        }

        int[] levelCounts = new int[islandCount];
        int maxLevel = -1;
        for(int i=0; i<islandCount; i++){
            int level = longest(i);
            levelCounts[level]++;
            if(maxLevel<level) maxLevel=level;
        }
        int[] result = new int[maxLevel+1];
        for(int i=0; i<=maxLevel; i++) result[i] = levelCounts[i];
        return result;
    }
}
