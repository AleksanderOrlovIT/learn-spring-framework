package com.learnspringframework.business;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Primary
@Component
public class MongoDBDataService implements DataService {
    @Override
    public int[] retriveData() {
        return new int[] {11, 22, 33, 44, 55};
    }
}
