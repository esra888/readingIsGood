package com.example.readingisgood.service.impl;

import com.example.readingisgood.model.Statistic;
import com.example.readingisgood.repository.StatisticRepository;
import com.example.readingisgood.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService
{
    @Autowired
    StatisticRepository statisticRepository;

    @Override
    public Statistic createStatistic(Statistic statistic)
    {
        return statisticRepository.save(statistic);
    }
}
