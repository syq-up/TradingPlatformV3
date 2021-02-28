package com.shiyq.mapper;

import com.shiyq.pojo.Goods;
import com.shiyq.pojo.GoodsCollection;
import com.shiyq.pojo.GoodsGuestbook;
import com.shiyq.pojo.UserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GoodsMapper {

    /**
     * 查询所有商品
     * @param sort  分类查询
     * @return  商品列表
     */
    List<Goods> findAllGoodsBySort(String sort);

    /**
     * 查询商品
     * @param goodsId   商品id
     * @return  商品对象
     */
    Goods findSingleGoodsById(Integer goodsId);

    /**
     * 查询所有商品留言
     * @param goodsId   商品id
     * @return  留言集合
     */
    List<GoodsGuestbook> findAllMsgByGoodsId(Integer goodsId);

    /**
     * 保存商品
     * @param goods 商品对象
     */
    void saveGoods(Goods goods);

    /**
     * 查询用户发布的所有商品
     * @param userDetail    用户id
     * @return  返回所有商品集合
     */
    List<Goods> findAllMyGoodsByUserId(Integer userDetail);

    /**
     * 查询用户收藏的所有商品
     * @param userId    用户id
     * @return  返回所有商品集合
     */
    List<GoodsCollection> findAllMyCollectionByUserId(Integer userId);

    /**
     * 添加收藏
     * @param userId 当前用户id
     * @param goodsId 收藏的商品id
     */
    Integer saveCollectionByUserIdAndGoodsId(@Param("userId")Integer userId, @Param("goodsId")Integer goodsId);

    /**
     * 查询商品是否已收藏
     * @param userId 当前用户id
     * @param goodsId 收藏的商品id
     * @return 查询到的收藏数：0/1
     */
    Integer findCollectionByUserIdAndGoodsId(@Param("userId")Integer userId, @Param("goodsId")Integer goodsId);

    /**
     * 删除收藏
     * @param collectionId  收藏商品id
     */
    void deleteCollectionById(Integer collectionId);

    /**
     * 查询用户所有订单
     * @param userId    用户id
     * @return  返回订单集合
     */
    List<UserOrder> findAllMyOrderByUserId(Integer userId);

    /**
     * 完成交易，保存订单
     * @param userOrder 订单对象
     */
    void saveOrder(UserOrder userOrder);

    /**
     * 删除订单
     * @param orderId   订单id
     */
    void deleteOrderById(Integer orderId);

}
