package com.example.brian.chinesechess.model.pieces;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.Position;

import java.util.ArrayList;

/**
 * Created by Brian on 16/12/1.
 */
public class Cannon extends Piece  {
    public Cannon(ChineseChessModel model, char color, Position position) {
        super(model, color, position);
        if(color == 'r') {
            type = 'C';
        } else {
            type = 'c';
        }
    }

    @Override
    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> validMoves = new ArrayList<>();
        int setRow = position.getRow();
        int setCol = position.getCol();
        boolean eatingPhase = false;

        // Up
        int row = setRow;
        row--;
        eatingPhase = false;
        while(row >= 0) {
            Position p = new Position(row, setCol);
            char tempColor = whatColor(p);
            if(!eatingPhase) {
                if (tempColor == 'e') {
                    validMoves.add(p);
                } else {
                    eatingPhase = true;
                }
            } else {
                if(tempColor != 'e') {
                    if(tempColor == color) {
                        break;
                    } else {
                        validMoves.add(p);
                        break;
                    }
                }
            }
            row--;
        }

        // Down
        row = setRow;
        row++;
        eatingPhase = false;
        while(row < 10) {
            Position p = new Position(row, setCol);
            char tempColor = whatColor(p);
            if(!eatingPhase) {
                if (tempColor == 'e') {
                    validMoves.add(p);
                } else {
                    eatingPhase = true;
                }
            } else {
                if(tempColor != 'e') {
                    if(tempColor == color) {
                        break;
                    } else {
                        validMoves.add(p);
                        break;
                    }
                }
            }
            row++;
        }

        // Left
        int col = setCol;
        col--;
        eatingPhase = false;
        while(col >= 0) {
            Position p = new Position(setRow, col);
            char tempColor = whatColor(p);
            if(!eatingPhase) {
                if (tempColor == 'e') {
                    validMoves.add(p);
                } else {
                    eatingPhase = true;
                }
            } else {
                if(tempColor != 'e') {
                    if(tempColor == color) {
                        break;
                    } else {
                        validMoves.add(p);
                        break;
                    }
                }
            }
            col--;
        }

        // Right
        col = setCol;
        col++;
        eatingPhase = false;
        while(col < 9) {
            Position p = new Position(setRow, col);
            char tempColor = whatColor(p);
            if(!eatingPhase) {
                if (tempColor == 'e') {
                    validMoves.add(p);
                } else {
                    eatingPhase = true;
                }
            } else {
                if(tempColor != 'e') {
                    if(tempColor == color) {
                        break;
                    } else {
                        validMoves.add(p);
                        break;
                    }
                }
            }
            col++;
        }
        return filterMoves(validMoves);
    }

    @Override
    public ArrayList<Position> noFilterGetPossibleMoves() {
        if(color == 'r') {
            if(type != 'C') {
                return new ArrayList<>();
            }
        } else {
            if(type != 'c') {
                return new ArrayList<>();
            }
        }
        ArrayList<Position> validMoves = new ArrayList<>();
        int setRow = position.getRow();
        int setCol = position.getCol();
        boolean eatingPhase = false;

        // Up
        int row = setRow;
        row--;
        eatingPhase = false;
        while(row >= 0) {
            Position p = new Position(row, setCol);
            char tempColor = whatColor(p);
            if(!eatingPhase) {
                if (tempColor == 'e') {
                    validMoves.add(p);
                } else {
                    eatingPhase = true;
                }
            } else {
                if(tempColor != 'e') {
                    if(tempColor == color) {
                        break;
                    } else {
                        validMoves.add(p);
                        break;
                    }
                }
            }
            row--;
        }

        // Down
        row = setRow;
        row++;
        eatingPhase = false;
        while(row < 10) {
            Position p = new Position(row, setCol);
            char tempColor = whatColor(p);
            if(!eatingPhase) {
                if (tempColor == 'e') {
                    validMoves.add(p);
                } else {
                    eatingPhase = true;
                }
            } else {
                if(tempColor != 'e') {
                    if(tempColor == color) {
                        break;
                    } else {
                        validMoves.add(p);
                        break;
                    }
                }
            }
            row++;
        }

        // Left
        int col = setCol;
        col--;
        eatingPhase = false;
        while(col >= 0) {
            Position p = new Position(setRow, col);
            char tempColor = whatColor(p);
            if(!eatingPhase) {
                if (tempColor == 'e') {
                    validMoves.add(p);
                } else {
                    eatingPhase = true;
                }
            } else {
                if(tempColor != 'e') {
                    if(tempColor == color) {
                        break;
                    } else {
                        validMoves.add(p);
                        break;
                    }
                }
            }
            col--;
        }

        // Right
        col = setCol;
        col++;
        eatingPhase = false;
        while(col < 9) {
            Position p = new Position(setRow, col);
            char tempColor = whatColor(p);
            if(!eatingPhase) {
                if (tempColor == 'e') {
                    validMoves.add(p);
                } else {
                    eatingPhase = true;
                }
            } else {
                if(tempColor != 'e') {
                    if(tempColor == color) {
                        break;
                    } else {
                        validMoves.add(p);
                        break;
                    }
                }
            }
            col++;
        }
        return validMoves;
    }

    @Override
    public char getType() {
        return type;
    }
}
