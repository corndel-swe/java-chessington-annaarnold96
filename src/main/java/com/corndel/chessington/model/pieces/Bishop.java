package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Bishop(PlayerColour colour) {
    super(PieceType.BISHOP, colour);
    this.type = PieceType.BISHOP;
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
    // Move Diagonally NW
    var allowedMoves = new ArrayList<Move>();
    int spacesCanMoveNW = -1;
    for (var cood = from.getRow() - 1; cood >= 0 ; cood--) {
      if ((from.plus(spacesCanMoveNW, spacesCanMoveNW).getCol() >= 0) && (board.get(from.plus(spacesCanMoveNW, spacesCanMoveNW)) == null)) {
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveNW, spacesCanMoveNW)));
        spacesCanMoveNW--;
      }
      else if ((from.plus(spacesCanMoveNW, spacesCanMoveNW).getCol() >= 0) && (board.get(from.plus(spacesCanMoveNW, spacesCanMoveNW)) != null) && (board.get(from.plus(spacesCanMoveNW, spacesCanMoveNW)).getColour() != getColour())){
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveNW, spacesCanMoveNW)));
        break;
      }
      else break;
    }

    // Move Diagonally SE

    int spacesCanMoveSE = 1;
    for (var cood = from.getRow() + 1; cood <= 7 ; cood++) {
      if ((from.plus(spacesCanMoveSE, spacesCanMoveSE).getCol() <= 7) && (board.get(from.plus(spacesCanMoveSE, spacesCanMoveSE)) == null)) {
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveSE, spacesCanMoveSE)));
        spacesCanMoveSE++;
      }
      else if ((from.plus(spacesCanMoveSE, spacesCanMoveSE).getCol() <= 7) && (board.get(from.plus(spacesCanMoveSE, spacesCanMoveSE)) != null) && (board.get(from.plus(spacesCanMoveSE, spacesCanMoveSE)).getColour() != getColour())){
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveSE, spacesCanMoveSE)));
        break;
      }
      else break;
    }

    // Move Diagonally SW

    int spacesCanMoveSW = 1;
    for (var cood = from.getRow() + 1; cood <= 7 ; cood++) {
      if ((from.plus(spacesCanMoveSE, -1 * spacesCanMoveSW).getCol() >= 0) && (board.get(from.plus(spacesCanMoveSW, -1 * spacesCanMoveSW)) == null)) {
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveSW, -1 * spacesCanMoveSW)));
        spacesCanMoveSW++;
      }
      else if ((from.plus(spacesCanMoveSW, -1 * spacesCanMoveSW).getCol() >= 0) && (board.get(from.plus(spacesCanMoveSW, -1 * spacesCanMoveSW)) != null) && (board.get(from.plus(spacesCanMoveSW, -1 * spacesCanMoveSW)).getColour() != getColour())){
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveSW, -1 * spacesCanMoveSW)));
        break;
      }
      else break;
    }

    // Move Diagonally NE

    int spacesCanMoveNE = 1;
    for (var cood = from.getRow() - 1; cood >= 0 ; cood++) {
      if ((from.plus(-1 * spacesCanMoveNE, spacesCanMoveNE).getCol() <= 7) && (board.get(from.plus(-1 * spacesCanMoveNE, spacesCanMoveNE)) == null)) {
        allowedMoves.add(new Move(from, from.plus(-1 * spacesCanMoveNE, spacesCanMoveNE)));
        spacesCanMoveNE++;
      }
      else if ((from.plus(-1 * spacesCanMoveNE, spacesCanMoveNE).getCol() <= 7) && (board.get(from.plus(-1 * spacesCanMoveNE, spacesCanMoveNE)) != null) && (board.get(from.plus(-1 * spacesCanMoveNE, spacesCanMoveNE)).getColour() != getColour())){
        allowedMoves.add(new Move(from, from.plus(-1 * spacesCanMoveNE, spacesCanMoveNE)));
        break;
      }
      else break;
    }

    return allowedMoves;
  }
}
