package me.yamlee.diveintorxjava;

import java.util.List;

/**
 * Created by yamlee on 16/1/29.
 */
public class ApiWrapperV2 {
    private Api api;

    public ApiWrapperV2(Api api) {
        this.api = api;
    }

    public AsyncJob<List<ShopEntity>> queryShop(final String shopType) {
        return new AsyncJob<List<ShopEntity>>() {
            @Override
            public void start(final ApiCallBack<List<ShopEntity>> callBack) {
                api.queryShop(shopType, new Api.ShopQueryCallBack() {
                    @Override
                    public void onSuccess(List<ShopEntity> shopEntityList) {
                        callBack.onSuccess(shopEntityList);
                    }

                    @Override
                    public void onFail(String cause) {
                        callBack.onFail(cause);
                    }
                });
            }
        };
    }

    public AsyncJob<String> store(final ShopEntity shopEntity) {
        return new AsyncJob<String>() {
            @Override
            public void start(final ApiCallBack<String> callBack) {
                api.store(shopEntity, new Api.ShopStoreCallBack() {
                    @Override
                    public void onSuccess(String url) {
                        callBack.onSuccess(url);
                    }

                    @Override
                    public void onFail(String cause) {
                        callBack.onFail(cause);
                    }
                });
            }
        };
    }
}
