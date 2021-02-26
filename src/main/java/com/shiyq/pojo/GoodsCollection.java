package com.shiyq.pojo;

public class GoodsCollection {
    private Integer collectionId;
    private Integer userId;
    private Goods goods;

    public GoodsCollection() {
    }

    public GoodsCollection(Integer collectionId, Integer userId, Goods goods) {
        this.collectionId = collectionId;
        this.userId = userId;
        this.goods = goods;
    }

    public Integer getCollectId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
