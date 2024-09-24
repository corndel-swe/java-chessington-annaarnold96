package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import kotlin.reflect.jvm.internal.impl.util.Checks;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece implements Piece {

  public Pawn(PlayerColour colour) {
    super(PieceType.PAWN, colour);
  }


  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    if ((getColour().equals(PlayerColour.WHITE))) {
      if (board.isOnBoard(from, board) && (!board.wouldMoveOffBoardVertically(from, board, colour)) && (board.get(from.plus(-1,0)) == null)) {
        allowedMoves.add(new Move(from, from.plus(-1, 0)));

        // Allow to move 2 if not moved
        if ((from.getRow() == 6) && (board.get(from.plus(-2,0)) == null)){
          allowedMoves.add(new Move(from, from.plus(-2, 0)));
        }
      }


      if (board.isOnBoard(from, board) && (!board.wouldMoveOffBoardVertically(from, board,colour)) && (!board.wouldMoveOffBoardHorizontally(from, board,colour)) && (board.get(from.plus(-1,-1))) != null && board.get(from.plus(-1,-1)).getColour().equals(PlayerColour.BLACK)) {
        allowedMoves.add(new Move(from, from.plus(-1, -1)));
      }
      if (board.isOnBoard(from, board) && (!board.wouldMoveOffBoardVertically(from, board,colour)) && (!board.wouldMoveOffBoardHorizontally(from, board,colour)) && (board.get(from.plus(-1,1))) != null && board.get(from.plus(-1,1)).getColour().equals(PlayerColour.BLACK)) {
        allowedMoves.add(new Move(from, from.plus(-1, 1)));
      }
    }

    else {
      if (board.isOnBoard(from, board) && (!board.wouldMoveOffBoardVertically(from, board, colour)) && (board.get(from.plus(1,0)) == null)) {
        allowedMoves.add(new Move(from, from.plus(1, 0)));

        // Allow to move 2 if not moved
        if ((from.getRow() == 1) && (board.get(from.plus(2,0)) == null)){
          allowedMoves.add(new Move(from, from.plus(2, 0)));
      }

      }
      if (board.isOnBoard(from, board) && (!board.wouldMoveOffBoardVertically(from, board,colour)) && (!board.wouldMoveOffBoardHorizontally(from, board,colour)) && (board.get(from.plus(1,-1))) != null && board.get(from.plus(1,-1)).getColour().equals(PlayerColour.WHITE)) {
        allowedMoves.add(new Move(from, from.plus(1, -1)));
      }
      if (board.isOnBoard(from, board) && (!board.wouldMoveOffBoardVertically(from, board, colour)) && (!board.wouldMoveOffBoardHorizontally(from, board,colour)) && (board.get(from.plus(1,1))) != null && board.get(from.plus(1,1)).getColour().equals(PlayerColour.WHITE)) {
        allowedMoves.add(new Move(from, from.plus(1, 1)));
      }
    }

    // TODO Implement this!
    return allowedMoves;
  }
}
