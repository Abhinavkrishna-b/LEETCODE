//No shortest path, no specify path - we just need to find any valid path and there need to be only one valid path
//So just you can go full right and full down that's all you reach the target - make this path '.' and other with '#'
class Solution {
    public String[] createGrid(int m, int n) {
        String grid[] = new String[m]; //A array of strings representing the rows
        StringBuilder row1 = new StringBuilder();
        for(int i=0;i<n;i++){
            row1.append('.');
        }
        grid[0] = row1.toString();

        for(int i=1;i<m;i++){//Here we start from i=1 (row = 2)
            StringBuilder currentRow = new StringBuilder();
            for(int j=0;j<n;j++){
                if(j == n-1){
                    currentRow.append('.');
                    continue;
                }
                currentRow.append('#');
            }
            grid[i] = currentRow.toString();
        }
        return grid;
    }
}
//Time- O(mn)
//Space- O(n) - without including the output grid array. O(n) space is for the currentRow and row1