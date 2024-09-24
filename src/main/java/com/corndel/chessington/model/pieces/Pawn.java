package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Pawn(PlayerColour colour) {
    this.type = PieceType.PAWN;
    this.colour = colour;
  }

  @Override
  public Piece.PieceType getType() {
    return type;
  }

  @Override
  public PlayerColour getColour() {
    return colour;
  }

  @Override
  public String toString() {
    return colour.toString() + " " + type.toString();
  }

  // Checks if piece can move
  boolean isOnBoard(Coordinates from, Board board){
    return (from.getRow() > 0 && from.getRow() < 7) && (from.getCol() > 0 && from.getCol() < 7);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    if ((getColour().equals(PlayerColour.WHITE))) {
      if (isOnBoard(from, board) && (board.get(from.plus(-1,0)) == null)) {
        allowedMoves.add(new Move(from, from.plus(-1, 0)));
      }
      // Allow to move 2 if not moved
      if ((from.getRow() == 6) && (board.get(from.plus(-2,0)) == null)){
        allowedMoves.add(new Move(from, from.plus(-2, 0)));
      }
      if (isOnBoard(from, board) && (board.get(from.plus(-1,-1))) != null && board.get(from.plus(-1,-1)).getColour().equals(PlayerColour.BLACK)) {
        allowedMoves.add(new Move(from, from.plus(-1, -1)));
      }
      if (isOnBoard(from, board) && (board.get(from.plus(-1,1))) != null && board.get(from.plus(-1,1)).getColour().equals(PlayerColour.BLACK)) {
        allowedMoves.add(new Move(from, from.plus(-1, 1)));
      }
    }

    else {
      if (isOnBoard(from, board) && (board.get(from.plus(1,0)) == null)) {
        allowedMoves.add(new Move(from, from.plus(1, 0)));
      }
      // Allow to move 2 if not moved
      if ((from.getRow() == 1) && (board.get(from.plus(2,0)) == null)){
        allowedMoves.add(new Move(from, from.plus(2, 0)));
      }
      if (isOnBoard(from, board) && (board.get(from.plus(1,-1))) != null && board.get(from.plus(1,-1)).getColour().equals(PlayerColour.WHITE)) {
        allowedMoves.add(new Move(from, from.plus(1, -1)));
      }
      if (isOnBoard(from, board) && (board.get(from.plus(1,1))) != null && board.get(from.plus(1,1)).getColour().equals(PlayerColour.WHITE)) {
        allowedMoves.add(new Move(from, from.plus(1, 1)));
      }
    }

    // TODO Implement this!
    return allowedMoves;
  }
}
