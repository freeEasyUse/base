package org.base.dao.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "stock_details")
public class StockDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 股票编号
     */
    @Column(name = "stock_code")
    private String stockCode;

    /**
     * 成交时间
     */
    @Column(name = "trade_time")
    private Date tradeTime;

    /**
     * 成交价格
     */
    @Column(name = "trade_price")
    private Float tradePrice;

    /**
     * 交易数量
     */
    @Column(name = "trade_count")
    private Integer tradeCount;

    /**
     * 交易方向 买入 卖出
     */
    @Column(name = "trade_nature")
    private String tradeNature;

    /**
     * 价格浮动
     */
    @Column(name = "price_float")
    private Float priceFloat;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取股票编号
     *
     * @return stock_code - 股票编号
     */
    public String getStockCode() {
        return stockCode;
    }

    /**
     * 设置股票编号
     *
     * @param stockCode 股票编号
     */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * 获取成交时间
     *
     * @return trade_time - 成交时间
     */
    public Date getTradeTime() {
        return tradeTime;
    }

    /**
     * 设置成交时间
     *
     * @param tradeTime 成交时间
     */
    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    /**
     * 获取成交价格
     *
     * @return trade_price - 成交价格
     */
    public Float getTradePrice() {
        return tradePrice;
    }

    /**
     * 设置成交价格
     *
     * @param tradePrice 成交价格
     */
    public void setTradePrice(Float tradePrice) {
        this.tradePrice = tradePrice;
    }

    /**
     * 获取交易数量
     *
     * @return trade_count - 交易数量
     */
    public Integer getTradeCount() {
        return tradeCount;
    }

    /**
     * 设置交易数量
     *
     * @param tradeCount 交易数量
     */
    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    /**
     * 获取交易方向 买入 卖出
     *
     * @return trade_nature - 交易方向 买入 卖出
     */
    public String getTradeNature() {
        return tradeNature;
    }

    /**
     * 设置交易方向 买入 卖出
     *
     * @param tradeNature 交易方向 买入 卖出
     */
    public void setTradeNature(String tradeNature) {
        this.tradeNature = tradeNature;
    }

    /**
     * 获取价格浮动
     *
     * @return price_float - 价格浮动
     */
    public Float getPriceFloat() {
        return priceFloat;
    }

    /**
     * 设置价格浮动
     *
     * @param priceFloat 价格浮动
     */
    public void setPriceFloat(Float priceFloat) {
        this.priceFloat = priceFloat;
    }
}