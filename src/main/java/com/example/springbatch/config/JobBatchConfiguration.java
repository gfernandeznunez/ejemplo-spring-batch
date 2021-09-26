package com.example.springbatch.config;

import com.example.springbatch.entities.InProfesional;
import com.example.springbatch.entities.OutProfesional;
import com.example.springbatch.job.ProfesionalProcessor;
import com.example.springbatch.job.ProfesionalReader;
import com.example.springbatch.job.ProfesionalWriter;
import com.example.springbatch.listener.ProfesionalJobExecutionListener;
import com.example.springbatch.listener.ProfesionalProcessListener;
import com.example.springbatch.listener.ProfesionalReaderListener;
import com.example.springbatch.listener.ProfesionalWriterListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public ProfesionalReader reader(){
        return new ProfesionalReader();
    }

    @Bean
    public ProfesionalProcessor processor(){
        return new ProfesionalProcessor();
    }

    @Bean
    public ProfesionalWriter writer(){
        return new ProfesionalWriter();
    }

    @Bean
    public ProfesionalJobExecutionListener jobExecutionListener(){
        return new ProfesionalJobExecutionListener();
    }

    @Bean
    public ProfesionalReaderListener readerListener() {
        return new ProfesionalReaderListener();
    }

    @Bean
    public ProfesionalProcessListener profesionalProcessListener() {
        return new ProfesionalProcessListener();
    }

    @Bean
    public ProfesionalWriterListener writerListener() {
        return new ProfesionalWriterListener();
    }


    @Bean
    public Job job(Step step, ProfesionalJobExecutionListener jobExecutionListener){
        Job job = jobBuilderFactory.get("Job01")
                .listener(jobExecutionListener)
                .flow(step)
                .end()
                .build();
        return job;
    }

    @Bean
    public Step step(ProfesionalReader reader,
                     ProfesionalProcessor processor,
                     ProfesionalWriter writer
                     ){
        TaskletStep step = stepBuilderFactory.get("Step01")
                .<InProfesional, OutProfesional>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

        return step;
    }
}
