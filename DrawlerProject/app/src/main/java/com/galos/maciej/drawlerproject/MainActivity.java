package com.galos.maciej.drawlerproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import Classes.DataBase;


public class MainActivity extends ActionBarActivity {

    private DataBase dataBase = DataBase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void btTakePhotoClick(View v){
        Intent myIntent = new Intent(getApplicationContext(), TakePhotoActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);

    }
    public void btEditPhotoClick(View v){
        Intent myIntent = new Intent(getApplicationContext(), EditPhotoActivity.class);
        startActivity(myIntent);

    }
    public void btSendPictureClick(View v){

        String path = MediaStore.Images.Media.insertImage(getContentResolver(), dataBase.getBitmap(), "title", null);
        Uri screenshotUri = Uri.parse(path);

        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        emailIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
        emailIntent.setType("image/png");

        startActivity(Intent.createChooser(emailIntent, "Send email using"));

    }
}
