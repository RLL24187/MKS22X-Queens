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
    System.out.println("Starting board 4x4: \n"+q.toString());
    System.out.println("Checking if all values are 0: true --> "+q.allZero());
    System.out.println("Testing toStringDebug: \n"+q.toStringDebug());
    System.out.println("Adding queen to (3,3): true --> "+q.addQueen(3, 3));
    System.out.println(q.toString());
    System.out.println("Attempting to add queen to (3,3) again: false --> "+q.addQueen(3, 3));
    System.out.println(q.toString());
    System.out.println("Checking if all values are 0: false --> "+q.allZero());
    /*Resulting board
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][-1]
    */
  }
}
