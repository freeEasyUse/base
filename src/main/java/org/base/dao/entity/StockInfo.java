package org.base.dao.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "stock_info")
public class StockInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名字
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司编码
     */
    @Column(name = "company_code")
    private String companyCode;

    /**
     * 股票编码
     */
    @Column(name = "stock_code")
    private String stockCode;

    /**
     * 股票简称
     */
    @Column(name = "stock_short")
    private String stockShort;

    /**
     * 上市时间
     */
    @Column(name = "liste_time")
    private Date listeTime;

    /**
     * 经营行业
     */
    @Column(name = "business_type")
    private String businessType;

    /**
     * 上市地点
     */
    @Column(name = "liste_address")
    private String listeAddress;

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
     * 获取公司名字
     *
     * @return company_name - 公司名字
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名字
     *
     * @param companyName 公司名字
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取公司编码
     *
     * @return company_code - 公司编码
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 设置公司编码
     *
     * @param companyCode 公司编码
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 获取股票编码
     *
     * @return stock_code - 股票编码
     */
    public String getStockCode() {
        return stockCode;
    }

    /**
     * 设置股票编码
     *
     * @param stockCode 股票编码
     */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * 获取股票简称
     *
     * @return stock_short - 股票简称
     */
    public String getStockShort() {
        return stockShort;
    }

    /**
     * 设置股票简称
     *
     * @param stockShort 股票简称
     */
    public void setStockShort(String stockShort) {
        this.stockShort = stockShort;
    }

    /**
     * 获取上市时间
     *
     * @return liste_time - 上市时间
     */
    public Date getListeTime() {
        return listeTime;
    }

    /**
     * 设置上市时间
     *
     * @param listeTime 上市时间
     */
    public void setListeTime(Date listeTime) {
        this.listeTime = listeTime;
    }

    /**
     * 获取经营行业
     *
     * @return business_type - 经营行业
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置经营行业
     *
     * @param businessType 经营行业
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取上市地点
     *
     * @return liste_address - 上市地点
     */
    public String getListeAddress() {
        return listeAddress;
    }

    /**
     * 设置上市地点
     *
     * @param listeAddress 上市地点
     */
    public void setListeAddress(String listeAddress) {
        this.listeAddress = listeAddress;
    }
}