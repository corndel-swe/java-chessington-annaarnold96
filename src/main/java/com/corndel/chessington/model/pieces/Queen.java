package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Queen(PlayerColour colour) {
    super(PieceType.QUEEN, colour);
    this.type = PieceType.QUEEN;
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
    var allowedMoves = new ArrayList<Move>();
    // For every row, check if there is anything. If null, add move. If false, break.

    // Move down
    int spacesCanMoveDown = 1;
    for (int row = from.getRow() + 1; row <= 7; row++) {
      if (board.get(from.plus(spacesCanMoveDown, 0)) == null) {
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveDown, 0)));
        spacesCanMoveDown++;
      }
      else if ((board.get(from.plus(spacesCanMoveDown, 0)) != null) && (board.get(from.plus(spacesCanMoveDown, 0)).getColour() != getColour())){
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveDown, 0)));
        break;
      }
      else break;
    }


    // Move up

    int spacesCanMoveUp = -1;
    for (int row = from.getRow() - 1; row >= 0; row--) {
      if (board.get(from.plus(spacesCanMoveUp, 0)) == null) {
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveUp, 0)));
        spacesCanMoveUp--;
      }
      else if ((board.get(from.plus(spacesCanMoveUp, 0)) != null) && (board.get(from.plus(spacesCanMoveUp, 0)).getColour() != getColour())){
        allowedMoves.add(new Move(from, from.plus(spacesCanMoveUp, 0)));
        break;
      }
      else break;
    }

    // Move Right
    int spacesCanMoveRight = 1;
    for (int col = from.getCol() + 1; col <= 7; col++) {
      if (board.get(from.plus(0, spacesCanMoveRight)) == null) {
        allowedMoves.add(new Move(from, from.plus(0, spacesCanMoveRight)));
        spacesCanMoveRight++;
      } else if ((board.get(from.plus(0, spacesCanMoveRight)) != null) && (board.get(from.plus(0, spacesCanMoveRight)).getColour() != getColour())){
        allowedMoves.add(new Move(from, from.plus(0, spacesCanMoveRight)));
        break;
      }

      else break;
    }


    // Move Left

    int spacesCanMoveLeft = -1;
    for (int col = from.getCol() - 1; col >= 0; col--) {
      if (board.get(from.plus(0, spacesCanMoveLeft)) == null) {
        allowedMoves.add(new Move(from, from.plus(0, spacesCanMoveLeft)));
        spacesCanMoveLeft--;
      }
      else if ((board.get(from.plus(0, spacesCanMoveLeft)) != null) && (board.get(from.plus(0, spacesCanMoveLeft)).getColour() != getColour())){
        allowedMoves.add(new Move(from, from.plus(0, spacesCanMoveLeft)));
        break;
      }
      else break;
    }

    // Move Diagonally NW

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
