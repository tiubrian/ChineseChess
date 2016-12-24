package com.example.brian.chinesechess.model.pieces;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.Position;

import java.util.ArrayList;

/**
 * Created by Brian on 16/12/1.
 */
public class King extends Piece {
    public King(ChineseChessModel model, char color, Position position) {
        super(model, color, position);
        if(color == 'r') {
            type = 'K';
        } else {
            type = 'k';
        }
    }

    @Override
    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> validMoves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

        if(whatColor(position) == 'b') {
            // up
            Position p = new Position(row-1, col);
            if(inUpperCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }

            // down
            p = new Position(row+1, col);
            if(inUpperCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }

            // left
            p = new Position(row, col-1);
            if(inUpperCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }

            // right
            p = new Position(row, col+1);
            if(inUpperCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }
        } else if(whatColor(position) == 'r') {
            // up
            Position p = new Position(row-1, col);
            if(inLowerCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }

            // down
            p = new Position(row+1, col);
            if(inLowerCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }

            // left
            p = new Position(row, col-1);
            if(inLowerCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }

            // right
            p = new Position(row, col+1);
            if(inLowerCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }
        }
        return filterMoves(validMoves);
   }

    @Override
    public ArrayList<Position> noFilterGetPossibleMoves() {
        if(color == 'r') {
            if(type != 'K') {
                return new ArrayList<>();
            }
        } else {
            if(type != 'k') {
                return new ArrayList<>();
            }
        }
        ArrayList<Position> validMoves = new ArrayList<>();

        if(color == 'b') {
            int col = position.getCol();
            for (int i = position.getRow()+1; i < 10; i++) {
                if(model.getBoard()[i][col].getType() != 'K' && model.getBoard()[i][col].getType() != '-') {
                    break;
                }
                validMoves.add(new Position(i, col));
            }
        } else {
            int col = position.getCol();
            for (int i = position.getRow()-2; i >= 0; i--) {
                if(model.getBoard()[i][col].getType() != 'k' && model.getBoard()[i][col].getType() != '-') {
                    break;
                }
                validMoves.add(new Position(i, col));
            }
        }

        return validMoves;
    }


    private boolean inUpperCastle(Position p) {
        int row = p.getRow();
        int col = p.getCol();
        if(0 <= row && row <= 2 &&
                3 <= col && col <= 5) {
            return true;
        }

        return false;
    }

    private boolean inLowerCastle(Position p) {
        int row = p.getRow();
        int col = p.getCol();
        if(7 <= row && row <= 9 &&
                3 <= col && col <= 5) {
            return true;
        }

        return false;
    }

    @Override
    public char getType() {
        return type;
    }
}
