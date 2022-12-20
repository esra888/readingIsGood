package com.example.readingisgood.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Month;

@Data
public class StatisticDetails
{
    private Month month;
    private int totalOrderCount;
    private int totalBookcount;
    private BigDecimal totalPurchasedAmount;

    public StatisticDetails()
    {
    }

    public StatisticDetails(Month month, int totalOrderCount, int totalBookcount, BigDecimal totalPurchasedAmount)
    {
        this.month = month;
        this.totalOrderCount = totalOrderCount;
        this.totalBookcount = totalBookcount;
        this.totalPurchasedAmount = totalPurchasedAmount;
    }
}
