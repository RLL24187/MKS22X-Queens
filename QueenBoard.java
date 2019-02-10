public class QueenBoard{
//Instance Variables:
  private int[][]board;
  private int numQueens; //Keeps track of how many queens there are on the board

//Constructor:
  public QueenBoard(int size){
    board = new int[size][size];
    numQueens = 0;
  }

//Private methods (suggested):
  public boolean addQueen(int r, int c){
    //-1 means there is a queen
    /*Starting board
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][0]
    */
    //addQueen(3, 3)
    /*Resulting board
    [1][0][0][1]
    [0][1][0][1]
    [0][0][1][1]
    [1][1][1][-1]
    */
    //line eqn of top left - bot right Q diagonal is r = -1(c-ccor)+rcor
    //                                               r = ccor - c + rcor
    //line eqn of top right - bot left Q diagonal is r = 1(c-ccor)+rcor
    //                                               r = c - ccor + rcor
    //Must ensure that there is a 0 in the original spot
    //Also, r and c must both be less than the size and nonnegative
    if (board[r][c]==0 && r < board.length && c < board.length && r>=0 && c>=0){
      board[r][c] = -1;
      //loop through the row, col, and diagonals and add 1
      for (int y = 0; y < board.length; y++){ //rows
        for (int x = 0; x < board.length; x++){ //cols
          if (!(y==r && x==c)){
            if (y == r //rows equal
            ||  x == c //cols equal
            ||  y == x - c + r // on diagonal top left - bot right
            ||  y == c - x + r // on diagonal top right - bot left
            )
            board[y][x]++; //increase the number by 1
          }
        }
      }
      numQueens++;
      return true;
    }
    return false; //couldn't place a queen down
  }

  public boolean removeQueen(int r, int c){
    if (r < board.length && r>=0 && c>=0 && c < board.length && queenHere(r, c)){
      board[r][c] = 0;
      //loop through the row, col, and diagonals and subtract 1
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board.length; j++){
          if (!(i==r && j==c)){
            if (i == r //rows equal
            ||  j == c //cols equal
            ||  i == j - c + r // on diagonal top left - bot right
            ||  i == c - j + r // on diagonal top right - bot left
            )
            board[i][j]--; //decrease the number by 1
          }
        }
      }
      numQueens--;
      return true;
    }
    return false;
  }

  public void removeQueen(int r){ //gets rid of all queens in a row
    for (int i = 0; i < board.length;i++){
      removeQueen(r, i);
    }
  }

  //Returns whether or not a queen is in the block
  public boolean queenHere(int r, int c){
    return board[r][c]==-1;
  }
//Public Methods:
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String output = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if (queenHere(i,j)){
          output+= 'Q';
        }
        else{
          output+= '_';
        }
        if (j!= board.length - 1){
          output+=" ";
        }
      }
      output += "\n";
    }
    return output;
  }

  public String toStringDebug(){
    String output = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if (queenHere(i,j)){
          output+= 'Q';
        }
        else{
          output+= board[i][j];
        }
        if (j!= board.length - 1){
          output+=" ";
        }
      }
      output += "\n";
    }
    return output;
  }

  //Checks to see if all spaces are 0s
  public boolean allZero(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if (board[i][j]!=0){
          return false;
        }
      }
    }
    return true;
  }
  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */

  public boolean solve(){
    if (!allZero()){
      throw new IllegalStateException("solve() only works on blank boards!");
    }
    QueenBoard temp = new QueenBoard(board.length); //Copy of a QueenBoard
    return solveHelper(0, 0, 0, 0, temp, this);
  }

  public boolean solveHelper(int r, int c, int prevRow, int prevCol, QueenBoard q, QueenBoard original){
    q.removeQueen(r);
    if (prevRow >= q.board.length){
     //If you've gone through all the rows and cols and couldn't place all the queens down
      return false;
    }
    if (q.addQueen(r,c)){ //If you can add a queen, do solveHelper on the next row
      System.out.println(q.toStringDebug());
      return q.solveHelper(r+1, 0, prevRow, c, q, original);
    }
    if (numQueens == board.length){
      original = q; //set old to new solved version
      return true; //when the number of queens equals the board size, return true
    }
    if (c == board.length - 1 && !q.addQueen(r,c)){ //If you've gone through all the cols and couldn't place down
      q.removeQueen(r-1);
      if (r == 1) prevRow++; //if you need to backtrack to the 0 row, increase prevRow
      return q.solveHelper(r-1, prevRow, prevRow, prevCol, q, original);
    }
    //Otherwise try solveHelper on the next col
    return q.solveHelper(r, c+1, prevRow, prevCol, q, original);
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return 0;
  }

}
