package Classes;

import android.graphics.Bitmap;

/**
 * Created by maciejgalos on 12.01.15.
 */
public final class DataBase {
    private Bitmap bitmap;
    private Bitmap lastPhoto;
    private static volatile DataBase instance =null;
    private DataBase(){
        bitmap=null;
        lastPhoto=null;
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


}
