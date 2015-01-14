package com.galos.maciej.drawlerproject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import Classes.ColorLabelItem;
import Classes.DataBase;
import Classes.DrawingView;
import Classes.RowAdapter;


public class SettingsActivity extends ActionBarActivity {
    private DataBase dataBase = DataBase.getInstance();
    private DrawingView drawingView;
    private ListView listView;
    private boolean isLoaded=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        if(!isLoaded)
            SetUp();
        isLoaded=true;


    }

    private void SetUp(){
        ArrayList<ColorLabelItem> list = dataBase.getColorsList();
        listView = (ListView)findViewById(R.id.listView);
        RowAdapter adapter = new RowAdapter(this,R.layout.item1,list);
        listView.setAdapter(adapter);
        listView.invalidate();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dataBase.setColor(dataBase.getColorsList().get(i).getColor());
                finish();
            }
        });




        final SeekBar mySeekBar = ((SeekBar) findViewById(R.id.seekBar));
        drawingView = (DrawingView)findViewById(R.id.DrawingView);
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
                                                 public void onProgressChanged(    SeekBar seekBar,    int progress,    boolean fromUser){


                                                     dataBase.setStrokeWidth((float) mySeekBar.getProgress());


                                                 }
                                                 public void onStartTrackingTouch(    SeekBar seekBar){
                                                 }
                                                 public void onStopTrackingTouch(    SeekBar seekBar){

                                                 }
                                             }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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


}
