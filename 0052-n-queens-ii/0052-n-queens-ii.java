class Solution {
    public int totalNQueens(int n) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> primaryDiagonal = new HashSet<>();
        HashSet<Integer> secondaryDiagonal = new HashSet<>();
        return backtrack(n, 0, col, primaryDiagonal, secondaryDiagonal);
    }

    public int backtrack(int n, int r, HashSet<Integer> col, HashSet<Integer> primaryDiagonal, HashSet<Integer> secondaryDiagonal){
        if(r == n){ //As the r starts with 0 r == n will be right
            return 1;
        }
        int count = 0;
        for(int c=0;c<n;c++){
            if(col.contains(c)){
                continue;
            }
            if(primaryDiagonal.contains(r-c)){
                continue;
            }
            if(secondaryDiagonal.contains(r+c)){
                continue;
            }

            col.add(c);
            primaryDiagonal.add(r-c);
            secondaryDiagonal.add(r+c);
            count += backtrack(n, r+1, col, primaryDiagonal, secondaryDiagonal);
            col.remove(c);
            primaryDiagonal.remove(r-c);
            secondaryDiagonal.remove(r+c);
        }
        return count;
    }
}
//Time- O(n!)
//Space- O(n)