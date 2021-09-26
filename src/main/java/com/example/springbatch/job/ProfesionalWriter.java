package com.example.springbatch.job;

import com.example.springbatch.entities.OutProfesional;
import com.example.springbatch.repositories.OutProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.item.ItemWriter;

import java.io.Serializable;
import java.util.List;

public class ProfesionalWriter implements ItemWriter<OutProfesional> {

    @Autowired
    private OutProfesionalRepository outProfesionalRepository;

    @Override
    public void write(List<? extends OutProfesional> list) throws Exception {
        outProfesionalRepository.saveAll(list);
    }
}
