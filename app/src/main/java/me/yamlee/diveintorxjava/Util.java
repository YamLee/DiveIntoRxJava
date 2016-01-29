package me.yamlee.diveintorxjava;

import java.util.Collections;
import java.util.List;

/**
 * Created by yamlee on 16/1/29.
 * help for analysis
 */
public class Util {
    private Api api;

    public Util(Api api) {
        this.api = api;
    }

    public void storeEarningMost(String type) {
        api.queryShop(type, new Api.ShopQueryCallBack() {
            @Override
            public void onSuccess(List<ShopEntity> shopEntityList) {
                ShopEntity maxShopEntity = Collections.max(shopEntityList);
                api.store(maxShopEntity, new Api.ShopStoreCallBack() {
                    @Override
                    public void onSuccess(String url) {
                        System.out.print("success save max earning shop url is:" + url);
                    }

                    @Override
                    public void onFail(String cause) {
                        System.out.print("save max earning shop error ,reason is" + cause);
                    }
                });
            }

            @Override
            public void onFail(String cause) {
                System.out.print("query shop error ,reason is" + cause);

            }
        });
    }
}
