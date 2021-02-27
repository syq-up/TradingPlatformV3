package com.shiyq.service;

import com.shiyq.mapper.GoodsMapper;
import com.shiyq.pojo.Goods;
import com.shiyq.pojo.GoodsCollection;
import com.shiyq.pojo.GoodsGuestbook;
import com.shiyq.pojo.UserOrder;
import com.shiyq.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsService {

    private GoodsMapper goodsMapper;

    @Autowired
    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    /**
     * 查询所有商品
     * @param sort  分类查询
     * @return  商品列表
     */
    public List<Goods> findAllGoodsBySort(String sort) {
        if ("recent".equals(sort))
            sort = null;
        return goodsMapper.findAllGoodsBySort(sort);
    }

    /**
     * 查询商品
     * @param goodsId   商品id
     * @return  商品对象
     */
    public Goods findSingleGoodsById(Integer goodsId) {
        return goodsMapper.findSingleGoodsById(goodsId);
    }

    /**
     * 查询所有商品留言
     * @param goodsId   商品id
     * @return  留言集合
     */
    public List<GoodsGuestbook> findAllMsgByGoodsId(Integer goodsId) {
        return goodsMapper.findAllMsgByGoodsId(goodsId);
    }

    /**
     * 保存商品
     * @param goods 商品对象
     */
    public void saveGoods(Goods goods, MultipartFile[] files) {
        goods.setGoodsImg(UploadFile.uploadFiles(files));
        goodsMapper.saveGoods(goods);
    }

    /**
     * 查询用户发布的所有商品
     * @param userDetail    用户id
     * @return  返回所有商品集合
     */
    public List<Goods> findAllMyGoodsByUserId(Integer userDetail) {
        return goodsMapper.findAllMyGoodsByUserId(userDetail);
    }

    /**
     * 查询用户收藏的所有商品
     * @param userId    用户id
     * @return  返回所有商品集合
     */
    public List<GoodsCollection> findAllMyCollectionByUserId(Integer userId) {
        return goodsMapper.findAllMyCollectionByUserId(userId);
    }

    /**
     * 添加收藏
     * @param hashMap 收藏
     */
    public Integer saveCollectionByUserIdAndGoodsId(HashMap<String, Integer> hashMap) {
        return goodsMapper.saveCollectionByUserIdAndGoodsId(hashMap);
    }

    /**
     * 删除收藏
     * @param collectionId  收藏商品id
     */
    public void deleteCollectionById(Integer collectionId) {
        goodsMapper.deleteCollectionById(collectionId);
    }

    /**
     * 查询用户所有订单
     * @param userId    用户id
     * @return  返回订单集合
     */
    public List<UserOrder> findAllMyOrderByUserId(Integer userId) {
        return goodsMapper.findAllMyOrderByUserId(userId);
    }

    /**
     * 完成交易，保存订单
     * @param userOrder 订单对象
     */
    public void saveOrder(UserOrder userOrder) {
        goodsMapper.saveOrder(userOrder);
    }

    /**
     * 删除订单
     * @param orderId   订单id
     */
    public void deleteOrderById(Integer orderId) {
        goodsMapper.deleteOrderById(orderId);
    }

    /**
     * 批量上传图片
     * @param files 文件数组
     * @param request   请求
     */
    private String uploadGoodsImg(MultipartFile[] files, HttpServletRequest request) {

        //上传路径保存设置，为文件再创建一级目录防止重名
        String uuidPath = UUID.randomUUID().toString();
        String path = "\\upload\\goodsImg" + "\\" + uuidPath;
//        String path = request.getServletContext().getRealPath("/upload/goodsImg") + "\\" + uuidPath;

        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdirs();
        }

        // 重命名图片名。从1开始
        int i = 1;
        for (MultipartFile file : files){
            //获取文件名 : file.getOriginalFilename(); 获取文件后缀：FilenameUtils.getExtension()
            //String uploadFileName = i++ + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            String uploadFileName = i++ + ".jpg";

            try{
                //通过CommonsMultipartFile的方法直接写文件
                file.transferTo(new File(path + "\\" + uploadFileName));
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return uuidPath;
    }

}
