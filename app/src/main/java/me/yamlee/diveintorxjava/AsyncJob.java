package me.yamlee.diveintorxjava;

/**
 * Created by yamlee on 16/1/29.
 */
public interface AsyncJob<T> {
    void start(ApiCallBack<T> callBack);
}
