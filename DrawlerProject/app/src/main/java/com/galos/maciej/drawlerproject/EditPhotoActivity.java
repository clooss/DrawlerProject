package com.galos.maciej.drawlerproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import Classes.DataBase;
import Classes.DrawingView;


public class EditPhotoActivity extends ActionBarActivity {
    private DrawingView drawingView;
    private DataBase dataBase = DataBase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);
        setUp();
    }

    private void setUp(){
        drawingView = (DrawingView)findViewById(R.id.DrawingView);
        if(dataBase.getBitmap()!=null)
        setBackgroundV16Minus(drawingView,dataBase.getBitmap());


    }

    @SuppressWarnings("deprecation")
    private void setBackgroundV16Minus(View view, Bitmap bitmap) {
        view.setBackgroundDrawable(new BitmapDrawable(bitmap));
    }

    public Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap( v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        dataBase.setBitmap(b);
        return b;
    }

    public void btSettingsClick(View v){
        Intent myIntent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(myIntent);
    }

    @Override
    protected void onPause() {
        loadBitmapFromView(drawingView);
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_photo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        drawingView.setPaintStrokeWidth(dataBase.getStrokeWidth());
        super.onResume();
    }
}
