package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece implements Piece {


  public Rook(PlayerColour colour) {
    super(PieceType.ROOK, colour);
  }



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




    return allowedMoves;

  }

}