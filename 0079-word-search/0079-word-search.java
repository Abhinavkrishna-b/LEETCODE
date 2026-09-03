class Solution {
    public boolean exist(char[][] board, String word) {
        int visited[][] = new int[board.length][board[0].length];
        int index = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(index)){
                    if(search(board, word, visited, i, j, index)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(char board[][], String word, int visited[][], int r, int c, int i){
        if(i >= word.length()){
            return true;
        }

        if(r>=board.length || r<0 || c>= board[0].length || c<0 || board[r][c] != word.charAt(i)){
            return false;
        }

        if(visited[r][c] == 1){
            return false;
        }
        visited[r][c] = 1;
        boolean result = search(board, word, visited, r, c+1, i+1) || search(board, word, visited, r, c-1, i+1) || search(board, word, visited, r+1, c, i+1) || search(board, word,visited, r-1, c, i+1);

        if(!result){
            visited[r][c] = 0;
        }
        return result;
    }
}
//Time- O(rc . 4^l)
//Space- O(l)
//l is length of word