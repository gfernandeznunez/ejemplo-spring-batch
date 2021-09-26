package com.example.springbatch.job;

import com.example.springbatch.entities.InProfesional;
import com.example.springbatch.entities.OutProfesional;

import org.springframework.batch.item.ItemProcessor;

public class ProfesionalProcessor implements ItemProcessor<InProfesional, OutProfesional> {


    @Override
    public OutProfesional process(InProfesional inProfesional) throws Exception {
        OutProfesional outProfesional = new OutProfesional();
        outProfesional.setRut(inProfesional.getRut());
        outProfesional.setNombreCompleto(inProfesional.getNombres()+' '+inProfesional.getApellidos());
        outProfesional.setEspecialidad(inProfesional.getEspecialidad().getDescripcion());

        return outProfesional;
    }
}
