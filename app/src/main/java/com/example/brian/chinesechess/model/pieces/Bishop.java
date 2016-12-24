package com.example.brian.chinesechess.model.pieces;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.Position;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Brian on 16/12/1.
 */
public class Bishop  extends Piece  {
    public Bishop(ChineseChessModel model, char color, Position position) {
        super(model, color, position);
        if(color == 'r') {
            type = 'B';
        } else {
            type = 'b';
        }
    }

    @Override
    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> validMoves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

        if(color == 'b') {
            // up left
            Position p = new Position(row-1, col-1);
            if(insideUpCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }

            // up right
            p = new Position(row-1, col+1);
            if(insideUpCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }

            // down left
            p = new Position(row+1, col-1);
            if(insideUpCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }

            // down right
            p = new Position(row+1, col+1);
            if(insideUpCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }
        } else if(whatColor(position) == 'r') {
            // up left
            Position p = new Position(row-1, col-1);
            if(insideDownCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }

            // up right
            p = new Position(row-1, col+1);
            if(insideDownCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }

            // down left
            p = new Position(row+1, col-1);
            if(insideDownCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }

            // down right
            p = new Position(row+1, col+1);
            if(insideDownCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }
        }

        return filterMoves(validMoves);

    }

    @Override
    public ArrayList<Position> noFilterGetPossibleMoves() {
        if(color == 'r') {
            if(type != 'B') {
                return new ArrayList<>();
            }
        } else {
            if(type != 'b') {
                return new ArrayList<>();
            }
        }
        ArrayList<Position> validMoves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

        if(color == 'b') {
            // up left
            Position p = new Position(row-1, col-1);
            if(insideUpCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }

            // up right
            p = new Position(row-1, col+1);
            if(insideUpCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }

            // down left
            p = new Position(row+1, col-1);
            if(insideUpCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }

            // down right
            p = new Position(row+1, col+1);
            if(insideUpCastle(p) && whatColor(p) != 'b') {
                validMoves.add(p);
            }
        } else if(whatColor(position) == 'r') {
            // up left
            Position p = new Position(row-1, col-1);
            if(insideDownCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }

            // up right
            p = new Position(row-1, col+1);
            if(insideDownCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }

            // down left
            p = new Position(row+1, col-1);
            if(insideDownCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }

            // down right
            p = new Position(row+1, col+1);
            if(insideDownCastle(p) && whatColor(p) != 'r') {
                validMoves.add(p);
            }
        }

        return validMoves;
    }


    private boolean insideUpCastle(Position p) {
        int row = p.getRow();
        int col = p.getCol();

        if(row == 0 && col == 3 ||
                row == 0 && col == 5 ||
                row == 1 && col == 4 ||
                row == 2 && col == 3 ||
                row == 2 && col == 5) {
            return true;
        }

        return false;
    }


    private boolean insideDownCastle(Position p) {
        int row = p.getRow();
        int col = p.getCol();

        if(row == 9 && col == 3 ||
                row == 9 && col == 5 ||
                row == 8 && col == 4 ||
                row == 7 && col == 3 ||
                row == 7 && col == 5) {
            return true;
        }

        return false;
    }


    @Override
    public char getType() {
        return type;
    }
}
