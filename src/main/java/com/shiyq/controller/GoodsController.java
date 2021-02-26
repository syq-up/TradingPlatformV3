package com.shiyq.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiyq.pojo.*;
import com.shiyq.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author shiyq
 * @create 2021-02-09 15:31
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private static final int PAGE_SIZE = 6;
    private GoodsService goodsService;

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    /**
     * 进入首页
     */
    @RequestMapping
    public String toJsp(){
        return "redirect:/goods/all/recent/1";
    }

    /**
     * 进入首页
     */
    @RequestMapping("/all/{sort}")
    public String toGoodsJsp(@PathVariable String sort, Model model){
        return showAllGoodsBySortAndPageNum(sort, 1, model);
    }

    /**
     * 查询展示商品列表，通过分类和页数
     * @param sort      商品分类
     * @param pageNum   分页
     * @param model     写入商品集合
     * @return  返回页面
     */
    @RequestMapping("/all/{sort}/{pageNum}")
    public String showAllGoodsBySortAndPageNum(@PathVariable String sort,
                                               @PathVariable int pageNum,
                                               Model model){
        Page<Goods> page = PageHelper.startPage(pageNum, PAGE_SIZE);
        List<Goods> goodsList = goodsService.findAllGoodsBySort(sort);

        model.addAttribute("pageNum",pageNum);  // 当前页数
        model.addAttribute("totalPages",page.getPages());// 总页数
        model.addAttribute("goodsList", goodsList); // 此页商品集合
        model.addAttribute("sort", sort);   // 当前商品类别
        return "show-all-goods";
    }

    @RequestMapping("/single/{goodsId}")
    public String toShowSingleGoods(@PathVariable int goodsId){
        return "redirect:/goods/single/"+goodsId+"/0";
    }

    /**
     * 查询展示单个商品
     * @param goodsId   商品id
     * @param msg       购买/收藏操作执行信息
     * @param model     返回商品对象
     * @return  返回页面
     */
    @RequestMapping("/single/{goodsId}/{msg}")
    public String showSingleGoods(@PathVariable int goodsId,
                                  @Nullable @PathVariable String msg,
                                  Model model){
        Goods goods = goodsService.findSingleGoodsById(goodsId);
        model.addAttribute("goods", goods);
        List<GoodsGuestbook> msgList = goodsService.findAllMsgByGoodsId(goodsId);
        model.addAttribute("msgList", msgList);
        if ("0".equals(msg))
            model.addAttribute("msg", null);
        else if ("success".equals(msg))
            model.addAttribute("msg", "收藏成功");
        else if ("error".equals(msg))
            model.addAttribute("msg","收藏失败，请重试！");
        return "show-single-goods";
    }

    /**
     * 添加商品
     * @param goods 页面传来的商品对象
     * @param model 写入商品对象返回页面
     * @return  返回此添加商品页面
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/save")
    public String saveGoods(@ModelAttribute Goods goods,
                            @RequestParam("files") CommonsMultipartFile[] files,
                            HttpServletRequest request,
                            Model model)
            throws IOException {
        goods.setLastEditTime(new java.sql.Timestamp(new Date().getTime()));
        goodsService.saveGoods(goods, files, request);
        model.addAttribute("goods", goods);
        return "show-single-goods";
    }

    /**
     * 转到添加商品页面
     * @return 返回页面
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/add")
    public String toAddJsp(){
        return "add-goods";
    }

    /**
     * 查询用户所有商品
     * @param pageNum   页数
     * @param session   获取用户id
     * @param model     写入商品集合
     * @return  返回
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/me-goods/{pageNum}")
    public String showMyGoods(@PathVariable int pageNum,
                              HttpSession session,
                              Model model){
        User user = (User)session.getAttribute("user");
        Page<Goods> page = PageHelper.startPage(pageNum,3);
        List<Goods> goodsList = goodsService.findAllMyGoodsByUserId(user.getUserId());
        model.addAttribute("pageNum",pageNum);  // 当前页数
        model.addAttribute("totalPages",page.getPages());// 总页数
        model.addAttribute("goodsList", goodsList); // 商品集合
        return "me-goods";
    }

    /**
     * 添加收藏
     * @param userId    用户id
     * @param goodsId   商品id
     * @return  返回商品页面，显示收藏操作执行信息
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/me-collection/save")
    public String saveCollection(@RequestParam("userId")int userId,
                                 @RequestParam("goodsId")int goodsId){
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("userId", userId);
        hashMap.put("goodsId", goodsId);
        int i = goodsService.saveCollectionByUserIdAndGoodsId(hashMap);
        if (i==1)
            return "redirect:/goods/single/" + goodsId + "/success";
        else
            return "redirect:/goods/single/" + goodsId + "/error";
    }

    /**
     * 删除用户收藏
     * @param collectionId  收藏id
     * @param pageNum   页数
     * @return  返回
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/me-collection/delete/{collectionId}/{pageNum}")
    public String deleteCollection(@PathVariable int collectionId,
                                   @PathVariable int pageNum){
        goodsService.deleteCollectionById(collectionId);
        return "redirect:/goods/me-collection/"+pageNum;
    }

    /**
     * 查询用户所有收藏
     * @param pageNum   页数
     * @param session   获取用户id
     * @param model     写入收藏集合
     * @return  返回
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/me-collection/{pageNum}")
    public String showMyCollection(@PathVariable int pageNum,
                                   HttpSession session,
                                   Model model){
        User user = (User)session.getAttribute("user");
        Page<GoodsCollection> page = PageHelper.startPage(pageNum,3);
        List<GoodsCollection> goodsCollectionList = goodsService.findAllMyCollectionByUserId(user.getUserId());
        model.addAttribute("pageNum",pageNum);  // 当前页数
        model.addAttribute("totalPages",page.getPages());// 总页数
        model.addAttribute("goodsCollectionList", goodsCollectionList); // 商品集合
        return "me-collection";
    }

//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/me-order/buy")
    public String saveOrder(@ModelAttribute UserOrder userOrder){
        goodsService.saveOrder(userOrder);
        return "";
    }

//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/me-order/delete/{orderId}/{pageNum}")
    public String deleteOrder(@PathVariable int orderId,
                              @PathVariable int pageNum){
        goodsService.deleteOrderById(orderId);
        return "redirect:/goods/me-order/"+pageNum;
    }

    /**
     * 查询用户所有订单
     * @param pageNum   页数
     * @param session   获取用户id
     * @param model     写入订单集合
     * @return  返回
     */
//    @PreAuthorize("hasRole('user')")
    @RequestMapping("/me-order/{pageNum}")
    public String showMyOrder(@PathVariable int pageNum,
                              HttpSession session,
                              Model model){
        User user = (User)session.getAttribute("user");
        Page<UserOrder> page = PageHelper.startPage(pageNum,3);
        List<UserOrder> userOrderList = goodsService.findAllMyOrderByUserId(user.getUserId());
        model.addAttribute("pageNum",pageNum);  // 当前页数
        model.addAttribute("totalPages",page.getPages());// 总页数
        model.addAttribute("userOrderList", userOrderList); // 商品集合
        return "me-orders";
    }

}
