package com.example.springbatch.listener;

import com.example.springbatch.entities.InProfesional;
import com.example.springbatch.entities.OutProfesional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;

public class ProfesionalProcessListener implements ItemProcessListener<InProfesional, OutProfesional> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfesionalProcessListener.class);

    @Override
    public void beforeProcess(InProfesional inProfesional) {
        LOGGER.info("beforeProcess");
    }

    @Override
    public void afterProcess(InProfesional inProfesional, OutProfesional outProfesional) {
        LOGGER.info("afterProcess: " + inProfesional + " ---> " + outProfesional);
    }

    @Override
    public void onProcessError(InProfesional inProfesional, Exception e) {
        LOGGER.info("onProcessError");
    }
}
