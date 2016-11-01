package com.jyall.config;

import com.jyall.common.Constans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by wang.linqiao on 2016/11/1.
 */
@Component
public class StartUpRunner implements CommandLineRunner {
    @Autowired
    private Constans constans;
    @Override
    public void run(String... strings) throws Exception {
        constans.init();
    }
}
