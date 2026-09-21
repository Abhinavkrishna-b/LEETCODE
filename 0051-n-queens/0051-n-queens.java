// The most difficult part is about how to find if there is queen in primary or secondary diagonal
//So there is the trick in primary diagonal for a full diagonal the r-c is same for each element
//And for the secondary diagonal the r+c is same for each element in the diagonal
class Solution {
    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> primaryDiagonal = new HashSet<>();
        HashSet<Integer> secondaryDiagonal = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        backtrack(n, 0, col, primaryDiagonal, secondaryDiagonal, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int n, int r, HashSet<Integer> col, HashSet<Integer> primaryDiagonal, HashSet<Integer> secondaryDiagonal, List<String> temp, List<List<String>> result){
        if(temp.size() == n){
            result.add(new ArrayList<>(temp));
            return;
        }
        
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
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[c] = 'Q';

            col.add(c);
            primaryDiagonal.add(r-c);
            secondaryDiagonal.add(r+c);
            temp.add(new String(row));

            backtrack(n, r+1, col, primaryDiagonal, secondaryDiagonal, temp, result);

            col.remove(c);
            primaryDiagonal.remove(r-c);
            secondaryDiagonal.remove(r+c);
            temp.remove(temp.size()-1);     
        }
    }
}
//Time- O(n . n!)
//Space- O(n^2)