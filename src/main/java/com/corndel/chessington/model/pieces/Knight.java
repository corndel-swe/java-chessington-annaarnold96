package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.List;

public class Knight extends AbstractPiece implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Knight(PlayerColour colour) {
    super(PieceType.KNIGHT, colour);
    this.type = PieceType.KNIGHT;
    this.colour = colour;
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
    return List.of();
  }
}
