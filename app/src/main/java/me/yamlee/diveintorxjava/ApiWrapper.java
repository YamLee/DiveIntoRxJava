package me.yamlee.diveintorxjava;

import java.util.List;

/**
 * Created by yamlee on 16/1/29.
 */
public class ApiWrapper {
    private Api api;

    public ApiWrapper(Api api) {
        this.api = api;
    }

    public void queryShop(String shopType, final ApiCallBack<List<ShopEntity>> shopListApiCallBack) {
        api.queryShop(shopType, new Api.ShopQueryCallBack() {
            @Override
            public void onSuccess(List<ShopEntity> shopEntityList) {
                shopListApiCallBack.onSuccess(shopEntityList);
            }

            @Override
            public void onFail(String cause) {
                shopListApiCallBack.onFail(cause);
            }
        });
    }

    public void store(ShopEntity shopEntity, final ApiCallBack<String> shopStoreCallBack) {
        api.store(shopEntity, new Api.ShopStoreCallBack() {
            @Override
            public void onSuccess(String url) {
                shopStoreCallBack.onSuccess(url);
            }

            @Override
            public void onFail(String cause) {
                shopStoreCallBack.onFail(cause);
            }
        });
    }
}
