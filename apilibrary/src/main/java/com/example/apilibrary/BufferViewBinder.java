package com.example.apilibrary;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Alex
 * @version : V 2.0.0
 * @date : 2018/09/17
 */
public class BufferViewBinder {

    private static final ActivityViewFinder FINDER = new ActivityViewFinder();
    private static final Map<String, ViewBinder> BINDER_MAP = new HashMap<>();

    public static void bind(Activity activity) {
        bind(activity, activity, FINDER);
    }

    private static void bind(Object host, Object o, ViewFinder finder) {
        String className = host.getClass().getName();
        ViewBinder viewBinder = BINDER_MAP.get(className);
        if (viewBinder == null) {
            try {
                Class<?> aClass = Class.forName(className + "$$ViewBinder");
                try {
                    viewBinder = (ViewBinder) aClass.newInstance();
                    BINDER_MAP.put(className, viewBinder);
                    if (viewBinder != null) {
                        viewBinder.bindView(host, o, finder);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unBind(Object host) {
        String classname = host.getClass().getName();
        ViewBinder viewBinder = BINDER_MAP.get(classname);
        if (viewBinder != null) {
            viewBinder.unBindView(host);
        }
    }


}
