package com.example.springbatch.listener;

import com.example.springbatch.entities.OutProfesional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class ProfesionalWriterListener implements ItemWriteListener<OutProfesional> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfesionalWriterListener.class);

    @Override
    public void beforeWrite(List<? extends OutProfesional> list) {
        LOGGER.info("beforeWrite");
    }

    @Override
    public void afterWrite(List<? extends OutProfesional> list) {
        for (OutProfesional profesional : list) {
            LOGGER.info("afterWrite :" + profesional.toString());
        }
    }

    @Override
    public void onWriteError(Exception e, List<? extends OutProfesional> list) {
        LOGGER.info("onWriteError");
    }
}
