package Classes;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by maciejgalos on 12.01.15.
 */
public final class DataBase {

    private ArrayList<ColorLabelItem> colorsList= new ArrayList<ColorLabelItem>();

    private float strokeWidth;
    private Bitmap bitmap;
    private Bitmap lastPhoto;
    private int color;
    private static volatile DataBase instance =null;
    private DataBase(){
        strokeWidth=5f;
        bitmap=null;
        lastPhoto=null;
        color = Color.BLACK;
        this.addNewColor(new ColorLabelItem("Red", Color.RED));
        this.addNewColor(new ColorLabelItem("Blue", Color.BLUE));
        this.addNewColor(new ColorLabelItem("Green", Color.GREEN));
        this.addNewColor(new ColorLabelItem("Black", Color.BLACK));
        this.addNewColor(new ColorLabelItem("White", Color.WHITE));

    }
    public static DataBase getInstance(){
        if(instance == null){
            synchronized (DataBase.class){
                instance = new DataBase();
            }
        }
        return  instance;
    }
    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }
    public Bitmap getBitmap(){
        return bitmap;
    }
    public void setLastPhoto(Bitmap b){
        lastPhoto = b;
    }
    public Bitmap getLastPhoto(){
        return lastPhoto;
    }
    public void setColor(int c){
        color = c;
    }
    public int getColor(){
        return color;
    }

    public void addNewColor(ColorLabelItem i){
        colorsList.add(i);
    }
    public ArrayList<ColorLabelItem> getColorsList(){
        return colorsList;
    }
    public float getStrokeWidth(){
        return strokeWidth;
    }
    public void setStrokeWidth(float s){
        strokeWidth=s;
    }


}
