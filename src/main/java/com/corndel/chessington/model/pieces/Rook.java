package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece implements Piece {

//  private final Piece.PieceType type;
//  protected final PlayerColour colour;

  public Rook(PlayerColour colour) {
    super(PieceType.ROOK, colour);
//    this.type = PieceType.ROOK;
//    this.colour = colour;
  }

//  @Override
//  public Piece.PieceType getType() {
//    return type;
//  }
//
//  @Override
//  public PlayerColour getColour() {
//    return colour;
//  }
//
//  @Override
//  public String toString() {
//    return colour.toString() + " " + type.toString();
//  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    // TODO Implement this!
    var allowedMoves = new ArrayList<Move>();
    // For every row, check if there is anything. If null, add move. If false, break.

    // Move down
      int spacesCanMoveDown = 1;
    if (board.wouldMoveOffBoardVertically(from, board)) {
      for (int row = from.getRow() + 1; row <= 7; row++) {
        if (board.isOnBoard(from.plus(1, 0), board) && board.get(from.plus(row, 0)) == null) {
          allowedMoves.add(new Move(from, from.plus(spacesCanMoveDown, 0)));
          spacesCanMoveDown++;
        } else break;
      }
      // Move up
      int spacesCanMoveUp = -1;
      for (int row = from.getRow() - 1; row >= 0; row--) {
        if (board.get(from.plus(row, 0)) == null) {
          allowedMoves.add(new Move(from, from.plus(spacesCanMoveUp, 0)));
          spacesCanMoveUp++;
        } else break;
      }
    }



    return allowedMoves;

  }

}