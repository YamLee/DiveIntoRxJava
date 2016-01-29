package me.yamlee.diveintorxjava;

import org.junit.Test;

/**
 * Created by yamlee on 16/1/29.
 */
public class StepOneTest {
    private String SHOP_TYPE = "food_type";
    Util util = new Util();


    @Test
    public void testV1() {
        util.saveEarningMostShopV1(SHOP_TYPE, new Util.SaveEarningMostCallBack() {
            @Override
            public void onSaveEarnMostSuccess(String url) {
                printSuccess(url);
            }

            @Override
            public void onSaveFail(String cause) {
                printlnFail(cause);
            }
        });
    }

    @Test
    public void testV2() {
        util.saveEarningMostShopV2(SHOP_TYPE, new ApiCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                printSuccess(s);
            }

            @Override
            public void onFail(String cause) {
                printlnFail(cause);
            }
        });
    }


    @Test
    public void testV3() {
        util.saveEarningMostShopV3(SHOP_TYPE).start(new ApiCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                printSuccess(s);
            }

            @Override
            public void onFail(String cause) {
                printlnFail(cause);
            }
        });
    }


    private void printSuccess(String s) {
        System.out.println("save success and url is --" + s);
    }


    private void printlnFail(String cause) {
        System.out.println("save fail and cause is----" + cause);
    }


}
