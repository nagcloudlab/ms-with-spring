package com.example.config;

import com.example.service.TransferServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class BPP implements BeanPostProcessor {

    /*
         wy we need ?

         => reflect any annotation(s) preset in bean
         => validate all required dependencies are injected
         => wrap target bean into proxy , to apply any enterprise features
     */

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("BPP-before-init-{}",beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("BPP-after-init-{}",beanName);
        if(beanName.equals("transferService")){
            //...validate..
            TransferServiceImpl transferService=(TransferServiceImpl)bean;
            if(transferService.getTxrType()==null){
                transferService.setTxrType("NEFT");
            }
            return  transferService;
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
