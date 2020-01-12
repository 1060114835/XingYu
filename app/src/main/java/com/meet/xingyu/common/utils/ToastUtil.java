package com.meet.xingyu.common.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * 全局Toast统一管理
 * 用于处理多个toast弹出混乱
 */
public class ToastUtil {
    private Context mContext;
    private static ToastUtil instance;
    //最短时间间隔
    private static final long MIN_TIME = 2000;
    private long lastTime;
    private static final int TOAST_SIGN = 0;
    //消息队列
    private List<String> mList = new CopyOnWriteArrayList<>();
    private Executor mExecutor = Executors.newSingleThreadExecutor();


    private ToastUtil() {
    }

    public static ToastUtil getInstance() {
        if (instance == null) {
            synchronized (ToastUtil.class) {
                if (instance == null) {
                    instance = new ToastUtil();
                }
            }
        }
        return instance;
    }


    /**
     * 在application中初始化
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        Handler handler = new Handler(msg -> {
            if (msg.what == TOAST_SIGN) {
                handleToast((String) msg.obj);
            }
            return false;
        });
        mExecutor.execute(() -> {
            while (true) {
                if (!mList.isEmpty())
                    if (System.currentTimeMillis() - lastTime > MIN_TIME) {
                        lastTime = System.currentTimeMillis();
                        Message message = Message.obtain();
                        message.what = TOAST_SIGN;
                        message.obj = mList.remove(0);
                        handler.sendMessage(message);
                    }
            }
        });
    }

    public void toast(String msg) {
        mList.add(msg);
    }

    private void handleToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
