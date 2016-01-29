package me.yamlee.diveintorxjava;

/**
 * Created by yamlee on 16/1/29.
 */
public interface ApiCallBack<T> {
    void onSuccess(T t);

    void onFail(String cause);
}
