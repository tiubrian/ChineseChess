package com.example.brian.chinesechess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.brian.chinesechess.model.ChineseChessModel;
import com.example.brian.chinesechess.views.SquareAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boardview);
        ChineseChessModel model = new ChineseChessModel(this);
        Log.d("tag", model.toString());


        GridView gridview = (GridView) findViewById(R.id.boardview);

        SquareAdapter squareAdapter = new SquareAdapter(this, model,gridview);
        gridview.setAdapter(squareAdapter);
        model.setSquareAdapter(squareAdapter);

        model.play();


    }
}
