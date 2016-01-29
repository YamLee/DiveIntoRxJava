package me.yamlee.diveintorxjava;

import android.annotation.TargetApi;
import android.os.Build;

/**
 * Created by yamlee on 16/1/28.
 */
public class ShopEntity implements Comparable<ShopEntity> {
    private String image;
    private int earning;

    public ShopEntity(String image, int earning) {
        this.image = image;
        this.earning = earning;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEarning() {
        return earning;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public int compareTo(ShopEntity another) {
        return Integer.compare(earning, another.getEarning());
    }
}
