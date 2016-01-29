package me.yamlee.diveintorxjava;

import org.junit.Test;

/**
 * Created by yamlee on 16/1/29.
 */
public class StepOneTest {
    @Test
    public void testStepOne() {
        Api api = new ApiIml();
        Util util = new Util(api);
        util.storeEarningMost("food_shop");
    }

}
