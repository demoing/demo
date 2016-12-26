package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import bean.Shopping;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/15.
 */

public class Dao {

    private final DatabaseHelper helper;
    public Dao(Context context) {
        helper = new DatabaseHelper(context);
    }
    //添加
    public void  insert(Shopping shopping){
        SQLiteDatabase db=helper.getWritableDatabase();
        db.execSQL("insert  into shopping (name,number,price,url) values(?,?,?,?)",new Object[]{shopping.name,
                shopping.number,shopping.price,shopping.url});
        db.close();
    }
    //查询
    List<Shopping> list=new ArrayList<>();
    public List<Shopping> query(){
        list.clear();
       // List<Shopping> list=new ArrayList<>();
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from shopping",null);
        while(cursor.moveToNext()){
            list.add(new Shopping(
                    cursor.getDouble(cursor.getColumnIndex("price")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getInt(cursor.getColumnIndex("number")),
                    cursor.getString(cursor.getColumnIndex("url"))));
        }
        return  list;
    }

}
