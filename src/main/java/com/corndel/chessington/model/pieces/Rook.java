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
    if ((getColour().equals(PlayerColour.WHITE))) {
      for (int row = from.getRow()+1; row <= 7; row++) {
        int spacesCanMove = 0;
        if (board.get(from.plus(row,0)) == null){
          spacesCanMove++;
          allowedMoves.add(new Move(from, from.plus(spacesCanMove, 0)));
        }
        else break;
      }


    }
    else{
      for (int row = from.getRow()-1; row <= 0; row--) {
        int spacesCanMove = 0;
        if (board.get(from.plus(row,0)) == null){
          spacesCanMove--;
          allowedMoves.add(new Move(from, from.plus(spacesCanMove, 0)));
        }
        else break;
      }

    }

  return allowedMoves;

  }

}