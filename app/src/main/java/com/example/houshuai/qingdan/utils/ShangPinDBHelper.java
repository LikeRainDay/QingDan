package com.example.houshuai.qingdan.utils;

import android.content.Context;

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.dao.DaoSession;
import com.example.houshuai.qingdan.dao.ShangPin;
import com.example.houshuai.qingdan.dao.ShangPinDao;

import java.util.List;

import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.QueryBuilder;

/**
 *
 * Created by HouShuai on 2016/7/11.
 */

public class ShangPinDBHelper {
    private static Context mContext;
    private static ShangPinDBHelper instance;

    private ShangPinDao cityInfoDao;

    private ShangPinDBHelper() {
    }

    public static ShangPinDBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new ShangPinDBHelper();
            if (mContext == null) {
                mContext = context;
            }

            // 数据库对象
            DaoSession daoSession = App.getDaoSession(mContext);
            instance.cityInfoDao = daoSession.getShangPinDAo();
        }
        return instance;
    }

    /**
     * 添加数据
     */
    public void addToMessageInfoTable(ShangPin item) {
        cityInfoDao.insert(item);
    }

    /**
     * 查询
     */
    public List<ShangPin> getMessageInfoList() {
        QueryBuilder<ShangPin> qb = cityInfoDao.queryBuilder();
        return qb.list();
    }

    /**
     * 查询
     */
    public List<ShangPin> getMessageInfo() {
        return cityInfoDao.loadAll();
    }


    /**
     * 指定ID删除
     */
    public void deleteMessageInfoList(int Id) {
        QueryBuilder<ShangPin> qb = cityInfoDao.queryBuilder();
        DeleteQuery<ShangPin> bd = qb.where(ShangPinDao.Properties.Id.eq(Id)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();
    }

    /**
     * 指定URL删除
     */

    public void deleteMessageInfoListBy(String url) {
        QueryBuilder<ShangPin> qb = cityInfoDao.queryBuilder();
        DeleteQuery<ShangPin> bd = qb.where(ShangPinDao.Properties.Url.eq(url)).buildDelete();
        bd.executeDeleteWithoutDetachingEntities();
    }

    /**
     * 删除所有
     */
    public void clearMessageInfo() {
        cityInfoDao.deleteAll();
    }

}