package com.ex;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class ExServiceImpl implements ExService {
    @Override
    public String getInfo() {
        return "Ex-SERVICE";
    }
}
