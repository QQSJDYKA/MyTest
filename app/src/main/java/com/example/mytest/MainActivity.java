package com.example.mytest;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Photo> photos = new ArrayList<>();
    private Cursor cursor;
    private int photoIndex;
    private int photoNameIndex;
    private int photoIDIndex;
    private int photoTitleIndex;
    private int photoSizeIndex;
    private String Message = null;
    private int totalNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String columns[] = new String[] { MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID, MediaStore.Images.Media.TITLE, MediaStore.Images.Media.DISPLAY_NAME, MediaStore.Images.Media.SIZE };
        // 得到一个游标
        cursor = this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null, null, null);
        // 获取指定列的索引
        photoIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        photoNameIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME);
        photoIDIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
        photoTitleIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE);
        photoSizeIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE);

        for (int i=0;i<cursor.getCount();i++){
            cursor.moveToNext();
            Log.i("qqq",cursor.getString(photoNameIndex));
        }



    }

    private Photo setImage()
    {
        Photo photo = new Photo();
        // 获取图片的Name
        photo.setName(cursor.getString(photoNameIndex));
        // 获取图片的ID
        photo.setNumber(cursor.getString(photoIDIndex));
        // 获取图片的Title
        photo.setTitle(cursor.getString(photoTitleIndex));
        // 获取图片的大小
        photo.setSize(cursor.getString(photoSizeIndex));
        // 获取图片存储路径
        photo.setPath(cursor.getString(photoIndex));
        return photo;

    }
}

