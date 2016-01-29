package me.yamlee.diveintorxjava;

import java.util.List;

/**
 * shop  net api
 * Created by yamlee on 16/1/28.
 */
public interface Api {
    interface ShopQueryCallBack {
        void onSuccess(List<ShopEntity> shopEntityList);

        void onFail(String cause);
    }

    interface ShopStoreCallBack {
        void onSuccess(String url);

        void onFail(String cause);
    }


    /**
     * query shop list by target shop type
     *
     * @param shopType
     * @return
     */
    void queryShop(String shopType, ShopQueryCallBack shopQueryCallBack);


    /**
     * add a new shop
     *
     * @param shopEntity
     * @return
     */
    void store(ShopEntity shopEntity, ShopStoreCallBack shopStoreCallBack);


}
