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
    System.out.println("Testing toString again: \n");
    System.out.println(q4.toString());
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

    QueenBoard q0 = new QueenBoard(0);
    QueenBoard q1 = new QueenBoard(1);
    QueenBoard q2 = new QueenBoard(2);
    QueenBoard q3 = new QueenBoard(3);

    QueenBoard q5 = new QueenBoard(5);
    QueenBoard q6 = new QueenBoard(6);
    QueenBoard q7 = new QueenBoard(7);
    QueenBoard q8 = new QueenBoard(8);
    QueenBoard q12 = new QueenBoard(12);
    QueenBoard q13 = new QueenBoard(13);
    QueenBoard q14 = new QueenBoard(14);

    System.out.println("\nTesting solve() on a 0x0: true --> \n");
    System.out.println(q0.solve());
    System.out.println("\nq0 should stll look the same, since there are no rows or cols.");
    System.out.println(q0.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 1x1: true --> \n");
    System.out.println(q1.solve());
    System.out.println("\nq1 should be a single Q.");
    System.out.println(q1.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 2x2: false --> \n");
    System.out.println(q2.solve());
    System.out.println("\nq2 should only be 0s, since it's impossible to have 2 queens, the board will not be changed");
    System.out.println(q2.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 3x3: false --> \n");
    System.out.println(q3.solve());
    System.out.println("\nq3 should only be 0s, since it's impossible to have 3 queens, the board will not be changed");
    System.out.println(q3.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 4x4: true --> \n");
    System.out.println(q4.solve());
    System.out.println("\nq4 should have 4 Qs: the board should be changed");
    System.out.println(q4.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 5x5: true --> \n");
    System.out.println(q5.solve());
    System.out.println("\nq5 should have 5 Qs: the board should be changed");
    System.out.println(q5.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 6x6: true --> \n");
    System.out.println(q6.solve());
    System.out.println("\nq6 should have 6 Qs: the board should be changed");
    System.out.println(q6.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 7x7: true --> \n");
    System.out.println(q7.solve());
    System.out.println("\nq7 should have 7 Qs: the board should be changed");
    System.out.println(q7.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 8x8: true --> \n");
    System.out.println(q8.solve());
    System.out.println("\nq4 should have 8 Qs: the board should be changed");
    System.out.println(q8.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 13x13: true --> \n");
    System.out.println(q13.solve());
    System.out.println("\nq13 should have 13 Qs: the board should be changed");
    System.out.println(q13.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting solve() on a 14x14: true --> \n");
    System.out.println(q14.solve());
    System.out.println("\nq13 should have 14 Qs: the board should be changed");
    System.out.println(q14.toString());
    System.out.println("-----------------------------------------------------\n");

    System.out.println("\nTesting countSolutions() on a 1x1 --> 1 \n");
    q1.revert();
    System.out.println(q1.countSolutions());

    System.out.println("\nTesting countSolutions() on a 2x2 --> 0 \n");
    q2.revert();
    System.out.println(q2.countSolutions());

    System.out.println("\nTesting countSolutions() on a 3x3 --> 0 \n");
    q3.revert();
    System.out.println(q3.countSolutions());

    System.out.println("\nTesting countSolutions() on a 4x4 --> 2 \n");
    q4.revert();
    System.out.println(q4.countSolutions());

    System.out.println("\nTesting countSolutions() on a 12x12 --> 14200 \n");
    q12.revert();
    System.out.println(q12.countSolutions());

    System.out.println("\nTesting countSolutions() on a 13x13 --> 73712 \n");
    q13.revert();
    System.out.println(q13.countSolutions());

    System.out.println("\nTesting countSolutions() on a 14x14 --> 365596 \n");
    q14.revert();
    System.out.println(q14.countSolutions());

    //System.out.println(Text.go(1,1));
    //System.out.println(this);Text.wait(50); //adjust this delay

  }
}
