package com.example.springbatch.listener;

import com.example.springbatch.entities.InProfesional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

public class ProfesionalReaderListener implements ItemReadListener<InProfesional> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfesionalReaderListener.class);

    @Override
    public void beforeRead() {
        LOGGER.info("beforeRead");
    }

    @Override
    public void afterRead(InProfesional inProfesional) {
        LOGGER.info("afterRead: " + inProfesional.toString());
    }

    @Override
    public void onReadError(Exception e) {
        LOGGER.info("onReadError");
    }
}
