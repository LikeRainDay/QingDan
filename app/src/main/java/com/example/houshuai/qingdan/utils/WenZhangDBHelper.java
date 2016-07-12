package com.example.houshuai.qingdan.utils;

import android.content.Context;

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.dao.DaoSession;
import com.example.houshuai.qingdan.dao.WenZhang;
import com.example.houshuai.qingdan.dao.WenZhangDao;

import java.util.List;

import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by HouShuai on 2016/7/11.
 */

public class WenZhangDBHelper {
    private static Context mContext;
    private static WenZhangDBHelper instance;

    private WenZhangDao cityInfoDao;

    private WenZhangDBHelper() {
    }

    public static WenZhangDBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new WenZhangDBHelper();
            if (mContext == null) {
                mContext = context;
            }

            // 数据库对象
            DaoSession daoSession = App.getDaoSession(mContext);
            instance.cityInfoDao = daoSession.getShouchangDao();
        }
        return instance;
    }

    /**
     * 添加数据
     */
    public void addToMessageInfoTable(WenZhang item) {
        cityInfoDao.insert(item);
    }

    /**
     * 查询
     */
    public List<WenZhang> getMessageInfoList() {
        QueryBuilder<WenZhang> qb = cityInfoDao.queryBuilder();
        return qb.list();
    }

    /**
     * 查询
     */
    public List<WenZhang> getMessageInfo() {
        return cityInfoDao.loadAll();
    }


    /**
     * 指定ID删除
     */
    public void deleteMessageInfoList(long Id) {
        QueryBuilder<WenZhang> qb = cityInfoDao.queryBuilder();
        DeleteQuery<WenZhang> bd = qb.where(WenZhangDao.Properties.Id.eq(Id)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();
    }

    /**
     * 指定URL删除
     */

    public void deleteMessageInfoListBy(String url) {
        QueryBuilder<WenZhang> qb = cityInfoDao.queryBuilder();
        DeleteQuery<WenZhang> bd = qb.where(WenZhangDao.Properties.Url.eq(url)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();
    }

    /**
     * 删除所有
     */
    public void clearMessageInfo() {
        cityInfoDao.deleteAll();
    }

}