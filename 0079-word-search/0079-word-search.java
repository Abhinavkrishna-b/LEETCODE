class Solution {
    public boolean exist(char[][] board, String word) {
        int visited[][]=new int[board.length][board[0].length];
        int index = 0;//To track the index of the word
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(board[r][c] == word.charAt(index)){
                    if(search(board,word,visited,r,c,index)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(char board[][], String word, int visited[][], int r, int c, int i){
        
        //Here we need to check for i > last index because if we check for last index we don't know if last character of matrix is equal to last character of word
        if(i == word.length()){
            return true;
        }
        if(r >= board.length || c >= board[0].length || r<0 || c<0){
            return false;
        }
        if(visited[r][c] == 1){
            return false;
        }
        if(word.charAt(i) != board[r][c]){
            return false;
        }
        visited[r][c] = 1;
        if(search(board,word,visited,r-1,c,i+1) || search(board,word,visited,r+1,c,i+1) || search(board,word,visited,r,c-1,i+1) || search(board,word,visited,r,c+1,i+1)){
            return true;
        }

        //We need to again reset the visited to 0 hence we are gona take a new path
        visited[r][c] = 0;
        return false;
    }
}
//Time- O(rc 4^l)
//4^l is max no of recursive call for tot 4 directions
//Space- O(l)
//Where l is lenght of word