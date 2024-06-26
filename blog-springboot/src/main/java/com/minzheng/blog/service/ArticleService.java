package com.minzheng.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.minzheng.blog.dto.*;
import com.minzheng.blog.entity.Article;
import com.minzheng.blog.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文章服务
 *
 * @author yezhiqiu
 * @date 2021/07/29
 */
public interface ArticleService extends IService<Article> {

    /**
     * 查询文章归档
     *
     * @return 文章归档
     */
    PageResult<ArchiveDTO> listArchives();

    /**
     * 查询后台文章
     *
     * @param condition 条件
     * @return 文章列表
     */
    PageResult<ArticleBackDTO> listArticleBacks(ConditionVO condition);

    /**
     * 查询首页文章
     *
     * @return 文章列表
     */
    List<ArticleHomeDTO> listArticles();

    /**
     * 根据条件查询文章列表
     *
     * @param condition 条件
     * @return 文章列表
     */
    ArticlePreviewListDTO listArticlesByCondition(ConditionVO condition);

    /**
     * 搜索文章
     *
     * @param condition 条件
     * @return 文章列表
     */
    List<ArticleSearchDTO> listArticlesBySearch(ConditionVO condition);

    /**
     * 根据id查看后台文章
     *
     * @param articleId 文章id
     * @return 文章列表
     */
    ArticleVO getArticleBackById(Integer articleId);

    /**
     * 根据id查看文章
     *
     * @param articleId 文章id
     * @return {@link ArticleDTO} 文章信息
     */
    ArticleDTO getArticleById(Integer articleId);

    /**
     * 点赞文章
     *
     * @param articleId 文章id
     */
    void saveArticleLike(Integer articleId, HttpServletRequest request);

    /**
     * 添加或修改文章
     *
     * @param articleVO 文章信息
     */
    void saveOrUpdateArticle(ArticleVO articleVO);

    /**
     * 修改文章置顶
     *
     * @param articleTopVO 文章置顶信息
     */
    void updateArticleTop(ArticleTopVO articleTopVO);

    /**
     * 删除或恢复文章
     *
     * @param deleteVO 逻辑删除对象
     */
    void updateArticleDelete(DeleteVO deleteVO);

    /**
     * 物理删除文章
     *
     * @param articleIdList 文章id集合
     */
    void deleteArticles(List<Integer> articleIdList);

    /**
     * 导出文章
     *
     * @param articleIdList 文章id列表
     * @return {@link List}<{@link String}> 文件地址
     */
    List<String> exportArticles(List<Integer> articleIdList);


    /**
     * 百度seo
     * @param ids 文章id集合
     * @return
     */
    void articleSeo(List<Integer> ids);

    /**
     * 爬取文章
     * @param url 文章地址
     * @return
     */
    Result reptile(String url);

    /**
     * 随机获取图片
     * @return
     */
    Result randomImg();

    /**
     * 随机获取一张系统图片
     * @param albumId
     * @return
     */
    String randomPhoto(Integer albumId);

}
