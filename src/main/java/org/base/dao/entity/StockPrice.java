package org.base.dao.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "stock_price")
public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 股票编号
     */
    @Column(name = "stock_code")
    private String stockCode;

    /**
     * 开票价格
     */
    @Column(name = "open_price")
    private Float openPrice;

    /**
     * 收盘价
     */
    @Column(name = "close_price")
    private Float closePrice;

    /**
     * 交易日
     */
    @Column(name = "trade_day")
    private Date tradeDay;

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
     * 获取开票价格
     *
     * @return open_price - 开票价格
     */
    public Float getOpenPrice() {
        return openPrice;
    }

    /**
     * 设置开票价格
     *
     * @param openPrice 开票价格
     */
    public void setOpenPrice(Float openPrice) {
        this.openPrice = openPrice;
    }

    /**
     * 获取收盘价
     *
     * @return close_price - 收盘价
     */
    public Float getClosePrice() {
        return closePrice;
    }

    /**
     * 设置收盘价
     *
     * @param closePrice 收盘价
     */
    public void setClosePrice(Float closePrice) {
        this.closePrice = closePrice;
    }

    /**
     * 获取交易日
     *
     * @return trade_day - 交易日
     */
    public Date getTradeDay() {
        return tradeDay;
    }

    /**
     * 设置交易日
     *
     * @param tradeDay 交易日
     */
    public void setTradeDay(Date tradeDay) {
        this.tradeDay = tradeDay;
    }
}