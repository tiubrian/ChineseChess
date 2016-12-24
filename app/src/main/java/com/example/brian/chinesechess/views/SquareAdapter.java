package com.example.brian.chinesechess.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.brian.chinesechess.R;
import com.example.brian.chinesechess.controllers.SquareListener;
import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.model.pieces.Piece;
import com.example.brian.chinesechess.model.pieces.Rook;

/**
 * Created by Brian on 16/12/2.
 */
public class SquareAdapter extends BaseAdapter {
    private Context mContext;
    private ChineseChessModel model;
    private Piece[][] board;
    private LayoutInflater inflater;
    private View[][] imageViews;
    private GridView gridView;


    public SquareAdapter(Context mContext, ChineseChessModel model, GridView gridView) {
        this.mContext = mContext;
        this.model = model;
        this.board = model.getBoard();
        this.gridView = gridView;
        this.imageViews = new View[model.getROW()][model.getCOL()];
        model.setImageViewGrid(imageViews);

        this.inflater = LayoutInflater.from(mContext.getApplicationContext());

    }

    @Override
    public int getCount() {
        return 9*10;
    }

    // Don't need to change
    @Override
    public Object getItem(int position) {
        return null;
    }

    // Don't need to change
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View imageView = convertView;
        final int row = position/model.getCOL();
        final int col = position%model.getCOL();

        if (imageView == null) {
            imageView = inflater.inflate(R.layout.square, null);

        }
        final ImageView oImageView = (ImageView)imageView.findViewById(R.id.innersquare);

        if(board[row][col] != null) {
            switch(board[row][col].getType()) {

                case 'r':
                    oImageView.setImageResource(R.drawable.br);
                    break;
                case 'h':
                    oImageView.setImageResource(R.drawable.bn);
                    break;
                case 'e':
                    oImageView.setImageResource(R.drawable.be);
                    break;
                case 'b':
                    oImageView.setImageResource(R.drawable.bb);
                    break;
                case 'k':
                    oImageView.setImageResource(R.drawable.bk);
                    break;
                case 'c':
                    oImageView.setImageResource(R.drawable.bc);
                    break;
                case 'p':
                    oImageView.setImageResource(R.drawable.bp);
                    break;


                case 'R':
                    oImageView.setImageResource(R.drawable.rr);
                    break;
                case 'H':
                    oImageView.setImageResource(R.drawable.rn);
                    break;
                case 'E':
                    oImageView.setImageResource(R.drawable.re);
                    break;
                case 'B':
                    oImageView.setImageResource(R.drawable.rb);
                    break;
                case 'K':
                    oImageView.setImageResource(R.drawable.rk);
                    break;
                case 'C':
                    oImageView.setImageResource(R.drawable.rc);
                    break;
                case 'P':
                    oImageView.setImageResource(R.drawable.rp);
                    break;
                case '-': oImageView.setImageResource(R.color.colorClear);
                    break;






            }

        } else {
            oImageView.setImageResource(R.color.colorClear);

        }


        imageView.setTag(imageView);
        imageView.setOnClickListener(new SquareListener(model, row, col, imageView, gridView, this));

        imageViews[row][col] = oImageView;
        return imageView;
    }

    public void repaint() {
        this.notifyDataSetChanged();
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public ChineseChessModel getModel() {
        return model;
    }

    public void setModel(ChineseChessModel model) {
        this.model = model;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public View[][] getImageViews() {
        return imageViews;
    }

    public void setImageViews(View[][] imageViews) {
        this.imageViews = imageViews;
    }

    public GridView getGridView() {
        return gridView;
    }

    public void setGridView(GridView gridView) {
        this.gridView = gridView;
    }
}
