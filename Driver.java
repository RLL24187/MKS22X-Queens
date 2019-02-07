public class Driver{
  public static void main(String[] args){
    QueenBoard q = new QueenBoard(4); //Make an empty board size 4x4
    //-1 means there is a queen
    /*Starting board
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][0]
    */
    q.addQueen(3, 3);
    System.out.println(q.toString());
    /*Resulting board
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][-1]
    */
  }
}
