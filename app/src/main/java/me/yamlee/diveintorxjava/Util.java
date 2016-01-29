package me.yamlee.diveintorxjava;

import java.util.Collections;
import java.util.List;

/**
 * Created by yamlee on 16/1/29.
 */
public class Util {
    private Api api;
    private ApiWrapper apiWrapper;
    private ApiWrapperV2 apiWrapperV2;

    public Util() {
        api = new ApiIml();
        apiWrapper = new ApiWrapper(api);
        apiWrapperV2 = new ApiWrapperV2(api);
    }

    public interface SaveEarningMostCallBack {
        void onSaveEarnMostSuccess(String url);

        void onSaveFail(String cause);
    }

    public void saveEarningMostShopV1(String type, final SaveEarningMostCallBack callBack) {
        api.queryShop(type, new Api.ShopQueryCallBack() {
            @Override
            public void onSuccess(List<ShopEntity> shopEntityList) {
                ShopEntity maxShopEntity = findMostEarningShop(shopEntityList);
                api.store(maxShopEntity, new Api.ShopStoreCallBack() {
                    @Override
                    public void onSuccess(String url) {
                        callBack.onSaveEarnMostSuccess(url);
                    }

                    @Override
                    public void onFail(String cause) {
                        callBack.onSaveEarnMostSuccess(cause);
                    }
                });
            }

            @Override
            public void onFail(String cause) {
                callBack.onSaveFail(cause);

            }
        });
    }

    public void saveEarningMostShopV2(String type, final ApiCallBack<String> storeEarnMostCallBack) {
        apiWrapper.queryShop(type, new ApiCallBack<List<ShopEntity>>() {
            @Override
            public void onSuccess(List<ShopEntity> shopEntities) {
                ShopEntity shopEntity = findMostEarningShop(shopEntities);
                apiWrapper.store(shopEntity, storeEarnMostCallBack);
            }

            @Override
            public void onFail(String cause) {
                storeEarnMostCallBack.onFail(cause);
            }
        });
    }

    public AsyncJob<String> saveEarningMostShopV3(final String type) {
        return new AsyncJob<String>() {
            @Override
            public void start(final ApiCallBack<String> callBack) {
                apiWrapperV2.queryShop(type).start(new ApiCallBack<List<ShopEntity>>() {
                    @Override
                    public void onSuccess(List<ShopEntity> shopEntities) {
                        apiWrapperV2.store(findMostEarningShop(shopEntities))
                                .start(new ApiCallBack<String>() {
                                    @Override
                                    public void onSuccess(String s) {
                                        callBack.onSuccess(s);
                                    }

                                    @Override
                                    public void onFail(String cause) {
                                        callBack.onFail(cause);
                                    }
                                });
                    }

                    @Override
                    public void onFail(String cause) {
                        callBack.onFail(cause);
                    }
                });
            }
        };
    }


    private ShopEntity findMostEarningShop(List<ShopEntity> shopEntityList) {
        return Collections.max(shopEntityList);
    }

}
