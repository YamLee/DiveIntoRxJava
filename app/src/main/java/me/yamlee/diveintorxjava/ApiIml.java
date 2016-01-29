package me.yamlee.diveintorxjava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yamlee on 16/1/29.
 */
public class ApiIml implements Api {
    private ShopEntity shopEntity;

    public ApiIml() {
        shopEntity = new ShopEntity("http://image_url.com/shop.img", 10000);
    }

    @Override
    public void queryShop(String shopType, ShopQueryCallBack shopQueryCallBack) {
        try {
            Thread.sleep(2000);
            List<ShopEntity> shopEntityList = new ArrayList<>();
            shopEntityList.add(shopEntity);
            ShopEntity shopEntity2 = new ShopEntity("http://image_url.com/shop2.img", 20000);
            shopEntityList.add(shopEntity2);
            shopQueryCallBack.onSuccess(shopEntityList);
        } catch (InterruptedException e) {
            e.printStackTrace();
            shopQueryCallBack.onFail(e.getMessage());
        }

    }

    @Override
    public void store(ShopEntity shopEntity, ShopStoreCallBack shopStoreCallBack) {
        try {
            Thread.sleep(2000);
            shopStoreCallBack.onSuccess(shopEntity.getImage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            shopStoreCallBack.onFail(e.getMessage());
        }
    }
}
