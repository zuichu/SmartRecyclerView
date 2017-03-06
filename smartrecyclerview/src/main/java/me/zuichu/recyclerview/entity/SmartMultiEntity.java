package me.zuichu.recyclerview.entity;

import java.io.Serializable;

/**
 * Created by Tandong on 2017/3/2.
 */
public abstract class SmartMultiEntity implements Serializable {
    private int itemType;

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
