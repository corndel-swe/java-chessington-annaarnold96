package com.corndel.chessington.model;

import com.corndel.chessington.model.pieces.*;

public class Board {

  public static final int BOARD_SIZE = 8;

  private Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

  private Board() {
  }

  public static Board forNewGame() {
    Board board = new Board();
    board.setBackRow(0, PlayerColour.BLACK);
    board.setBackRow(7, PlayerColour.WHITE);

    for (int col = 0; col < BOARD_SIZE; col++) {
      board.board[1][col] = new Pawn(PlayerColour.BLACK);
      board.board[6][col] = new Pawn(PlayerColour.WHITE);
    }

    return board;
  }

  public Piece[][] getBoard() {
    return board;
  }

  public static Board empty() {
    return new Board();
  }

  private void setBackRow(int rowIndex, PlayerColour colour) {
    board[rowIndex][0] = new Rook(colour);
    board[rowIndex][1] = new Knight(colour);
    board[rowIndex][2] = new Bishop(colour);
    board[rowIndex][3] = new Queen(colour);
    board[rowIndex][4] = new King(colour);
    board[rowIndex][5] = new Bishop(colour);
    board[rowIndex][6] = new Knight(colour);
    board[rowIndex][7] = new Rook(colour);
  }

  public Piece get(Coordinates coords) {
    return board[coords.getRow()][coords.getCol()];
  }

  public void move(Coordinates from, Coordinates to) {
    Piece piece = board[from.getRow()][from.getCol()];
    board[to.getRow()][to.getCol()] = piece;
    board[from.getRow()][from.getCol()] = null;
  }

  public void placePiece(Coordinates coords, Piece piece) {
    board[coords.getRow()][coords.getCol()] = piece;
  }


// ********************* ADDED BY ANNA *************************

  // Checks if piece can move
  public boolean isOnBoard(Coordinates from, Board board) {
    return (from.getRow() >= 0 && from.getRow() <= 7) && (from.getCol() >= 0 && from.getCol() <= 7);
  }
  // Checks if current piece would move off the top/bottom board
  public boolean wouldMoveOffBoardVertically(Coordinates from, Board board, PlayerColour colour){
  if ((colour.equals(PlayerColour.WHITE))){
    return (from.getRow() - 1 < 0);
  }
  else return (from.getRow() + 1 > 7);
}

  public boolean wouldMoveOffBoardHorizontally(Coordinates from, Board board, PlayerColour colour){
    return (from.getCol() - 1 < 0) || ((from.getCol() + 1 > 7));

  }

}