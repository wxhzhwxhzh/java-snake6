package com.zetcode.MyUtil;

public class Location {
    public int x;
    public int y;
    public boolean showDraw=false;
    public Location(int x,int  y){
        this.x=x;
        this.y=y;
    }
    public  String toString(){
        return "("+this.x+","+this.y+")";
    }
}
