package Classes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.galos.maciej.drawlerproject.R;

import java.util.ArrayList;

/**
 * Created by maciejgalos on 14.01.15.
 */
public class RowAdapter extends ArrayAdapter<ColorLabelItem> {
    private Context context;
    private int layoutResourceID;
    private ArrayList<ColorLabelItem> data;

    public RowAdapter(Context context, int layoutResourceID, ArrayList<ColorLabelItem> data){
        super(context,layoutResourceID,data);
        this.context = context;
        this.layoutResourceID = layoutResourceID;
        this.data = data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RowHolder holder = null;

        if(row == null){
            LayoutInflater inFlater = ((Activity)context).getLayoutInflater();
            row = inFlater.inflate(layoutResourceID, parent, false);

            holder =new RowHolder();
            holder.textView1 = (TextView)row.findViewById(R.id.textView30);



            row.setTag(holder);
        }else {
            holder =(RowHolder) row.getTag();

        }

        ColorLabelItem item = data.get(position);
        holder.textView1.setText(item.getLabel());
        holder.textView1.setBackgroundColor(item.getColor());
        holder.textView1.setTextColor(Color.YELLOW);


        return row;

    }

    static class RowHolder{
        public TextView textView1;
    }


}
