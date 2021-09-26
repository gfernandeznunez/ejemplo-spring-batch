package com.example.springbatch.job;

import com.example.springbatch.entities.InProfesional;
import com.example.springbatch.repositories.InProfesionalRepository;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.item.ItemReader;

import java.io.Serializable;
import java.util.Iterator;

public class ProfesionalReader implements ItemReader <InProfesional>{

    @Autowired
    private InProfesionalRepository inProfesionalRepository;

    private Iterator<InProfesional> profesionalIterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        profesionalIterator = inProfesionalRepository.findAll().iterator();
    }

    @Override
    public InProfesional read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if(profesionalIterator != null && profesionalIterator.hasNext()){
            return profesionalIterator.next();
        } else{
            return null;
        }
    }
}
