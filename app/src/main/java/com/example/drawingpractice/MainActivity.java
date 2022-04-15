package com.example.drawingpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    final static int line =1, square =2;
    static int shape = line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView my = new MyView(this);
        setContentView(my);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.itemline:
                shape = line;
                return true;
            case R.id.itemsquare:
                shape = square;
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyView extends View {

        public MyView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);

            Paint paint = new Paint();
            Path path = new Path();

            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLUE);

            path.moveTo(20, 20);
            switch(shape){
                case line:
                    path.lineTo(300,800);
                    invalidate();
                    break;
                case square:
                    path.lineTo(20,400);
                    path.lineTo(400,400);
                    path.lineTo(400,20);
                    path.lineTo(20,20);
                    invalidate();
                    break;
            }
            canvas.drawPath(path,paint);
        }
    }
}