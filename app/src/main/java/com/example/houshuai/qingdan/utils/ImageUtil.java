package com.example.houshuai.qingdan.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.LruCache;

import java.io.File;
import java.net.HttpURLConnection;

/**
 * Created by xiajie on 2016/7/6.
 */

public class ImageUtil {

    long maxMemory =Runtime.getRuntime().maxMemory();
    long cacheMemory=maxMemory/8;
    private LruCache<String, Bitmap> cache=new LruCache<String,Bitmap>((int) cacheMemory){

        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getByteCount();
        }
    };

    /**
     * 加载图片
     * @param imgUrl 图片的url
     * @return BitMap
     */
    private Bitmap getBitMap(Context context,String imgUrl)
    {
      String key=imgUrl.substring(imgUrl.lastIndexOf("/")+1);
        Bitmap bitmap=cache.get(key);
        if(bitmap!=null)
        {//在缓存找到了
            return bitmap;
        }else{
            File file=getImageFromPhone(context,key);
            if (file!=null&&file.exists()&&file.getTotalSpace()>0)
            {//在手机中找到了
                bitmap= BitmapFactory.decodeFile(file.getAbsolutePath());
                cache.put(key,bitmap);
                return bitmap;
            }else {
                //没有找到。开启子线程下载
                new Thread()
                {
                    @Override
                    public void run() {

                    }
                }.start();
            }
        }
        return null;
    }

    /**
     * 从手机上获取图片
     * @param imgName
     * @return
     */
    public File getImageFromPhone(Context context, String imgName)
    {
        File file=new File(context.getCacheDir(),imgName);
        if(file!=null&&file.getTotalSpace()>0)
        {
            return file;
        }else if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
        {
             file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),imgName);
            return file;
        }
        return null;
    }

}
