package com.some;

import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService{
    @Override
    public String getInfo() {
        return "SOME-SERVICE";
    }
}
