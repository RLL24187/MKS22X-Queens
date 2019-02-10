public class Driver{
  public static void main(String[] args){
    QueenBoard q4 = new QueenBoard(4); //Make an empty board size 4x4
    //-1 means there is a queen
    /*Starting board
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][0]
    [0][0][0][0]
    */
    System.out.println("Starting board 4x4 and testing toString: \n"+q4.toString());
    System.out.println("Checking if all values are 0: true --> "+q4.allZero());
    System.out.println("Testing toStringDebug: \n"+q4.toStringDebug());
    System.out.println("Adding queen to (2,1): true --> "+q4.addQueen(2, 1));
    System.out.println(q4.toStringDebug());
    System.out.println("Attempting to add queen to (2,1) again: false --> "+q4.addQueen(2, 1));
    System.out.println(q4.toStringDebug());
    System.out.println("Attempting to add queen to (2,0) same row: false --> "+q4.addQueen(2, 0));
    System.out.println(q4.toStringDebug());
    System.out.println("Attempting to add queen to (3,1) same col: false --> "+q4.addQueen(3, 1));
    System.out.println(q4.toStringDebug());
    System.out.println("Attempting to add queen to (1,0) on top-left to bottom-right diagonal: false --> "+q4.addQueen(1, 0));
    System.out.println(q4.toStringDebug());
    System.out.println("Attempting to add queen to (3,2) on top-right to bottom-left diagonal: false --> "+q4.addQueen(3, 2));
    System.out.println(q4.toStringDebug());
    /*Resulting board
       0  1  2  3
    0 [0][1][0][1]
    1 [1][1][1][0]
    2 [1][Q][1][1]
    3 [1][1][1][0]
    */
    System.out.println("Attempting to add queen to (0, 2) (not threatened): true --> "+q4.addQueen(0, 2));
    System.out.println(q4.toStringDebug());
    System.out.println("Checking if all values are 0: false --> "+q4.allZero());
    /*Resulting board
       0  1  2  3
    0 [1][2][Q][2]
    1 [1][2][2][1]
    2 [2][Q][2][1]
    3 [1][1][2][0]
    */
    System.out.println("Attempting to remove queen from (2,1): true --> "+q4.removeQueen(2, 1));
    System.out.println(q4.toStringDebug());
    System.out.println("Attempting to remove queen from (2,1) again: false --> "+q4.removeQueen(2, 1));
    System.out.println(q4.toStringDebug());
    System.out.println("Attempting to remove queen from (0,2): true --> "+q4.removeQueen(0, 2));
    System.out.println(q4.toStringDebug());
    System.out.println("Attempting to remove queen from (0,2) again: false --> "+q4.removeQueen(0, 2));
    System.out.println(q4.toStringDebug());
    /*Resulting board
       0  1  2  3
    0 [0][0][0][0]
    1 [0][0][0][0]
    2 [0][0][0][0]
    3 [0][0][0][0]
    */


    System.out.println("Testing removeQueen(int r)");
    System.out.println("First adding queen to (0, 3): true --> "+q4.addQueen(0,3));
    System.out.println("Now removeQueen(0) should remove all queens from row 0: \n");
    q4.removeQueen(0);
    System.out.println(q4.toStringDebug());
    System.out.println("All values should now be be 0 --> allZero(): true --> "+q4.allZero());

    QueenBoard q1 = new QueenBoard(1);
    QueenBoard q2 = new QueenBoard(2);
    QueenBoard q3 = new QueenBoard(3);
    System.out.println("\nTesting solve() on a 4x4");
    q4.solve();
  }
}
