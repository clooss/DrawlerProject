package Classes;

/**
 * Created by maciejgalos on 14.01.15.
 */
public class ColorLabelItem {
    private String label;
    private int color;
    public ColorLabelItem(String label,int color){
        this.label=label;
        this.color=color;
    }
    public String getLabel(){
        return label;
    }
    public int getColor(){
        return color;
    }
}
