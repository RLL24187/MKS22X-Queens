public class QueenBoard{
//Instance Variables:
  private int[][]board;

//Constructor:
  public QueenBoard(int size){
    board = new int[size][size];
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
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][-1]
    */
    //Must ensure that there is a 0 in the original spot
    //Also, r and c must both me less than the size and nonnegative
    if (board[r][c]==0 && r < board.length && c < board.length && r>=0 && c>=0){
      board[r][c] = -1;
      return true;
    }
    return false; //couldn't place a queen down
  }

  public boolean removeQueen(int r, int c){
    if (r < board.length && r>=0 && c>=0 && c < board.length && queenHere){
      board[r][c] = 0;
      return true;
    }
    return false;
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
          output+= board[j][i];
        }
        if (j!= board.length - 1){
          output+=" ";
        }
      }
      output += "\n";
    }
    return output;
  }
  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    return true;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return 0;
  }

}
