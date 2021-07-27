package com.blaller.blaseblallerservice.service;

import com.blaller.blaseblallerApi.data.Division;
import com.blaller.blaseblallerApi.endpoint.DivisionsEndpoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {
    public List<Division> getAllDivisions() {
        return DivisionsEndpoint.getDivisions();
    }
}
