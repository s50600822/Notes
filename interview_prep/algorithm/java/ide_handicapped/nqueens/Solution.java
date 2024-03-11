import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        return new AbstractList<List<String>>(){
            @Override
            public int size(){
                init();
                return result.size();
            }

            @Override
            public List<String> get(int index){
                init();
                return result.get(index);
            }

            private void init(){
                if(result != null) return;
                int[][] grid = newEmptyBoard(n);
                getQueenCombinations(grid, n, 0, 0);
            }
        };
    }
    private void getQueenCombinations(
        int[][] grid,
        int n,
        int row,
        int col
    ){
        if(row >= n){
            result.add(build(grid, n));
            return;
        }

        for(int i = 0; i < n; i++){
            if(isValidCombination(grid, n, row, i)){
                grid[row][i] = 1;
                getQueenCombinations(grid, n, row + 1, col);
                grid[row][i] = 0;
            }
        }
    }

    private boolean isValidCombination(
        int[][] grid,
        int n,
        int row,
        int col
    ){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && (row + col == i + j || row + j == col + i || j == col)){
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> build(int[][] grid, int n){
        final List<String> solution = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    sb.append('.');
                }
                else{
                    sb.append('Q');
                }
            }
            solution.add(sb.toString());
        }
        return solution;
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/n-queens/
        int boardSize = 15;
        final Solution solution = new Solution();
        final List<List<String>> solutions = solution.solveNQueens(boardSize);

        // for (List<String> solutionBoard : solutions) {
        //     for (String row : solutionBoard) {
        //         System.out.println(row);
        //     }
        //     System.out.println();
        // }
    }

    private int[][] newEmptyBoard(int size){
        int[][] grid = new int[size][size];
        result = new ArrayList<>();
        for(int[] row : grid){
            Arrays.fill(row, 0);
        }
        return grid;
    }

}