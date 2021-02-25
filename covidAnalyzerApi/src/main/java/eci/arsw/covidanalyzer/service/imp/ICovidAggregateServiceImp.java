/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.covidanalyzer.service.imp;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;

/**
 *
 * @author javie
 */
@Controller
public class ICovidAggregateServiceImp implements ICovidAggregateService{

    HashMap<Result,ResultType> results;
    HashMap<UUID,ResultType> mult;
    
    public ICovidAggregateServiceImp() {
        mult = new HashMap<>();
        results= new HashMap<>();
    }
    
    
    @Override
    public boolean aggregateResult(Result result, ResultType type) {
        ResultType r=results.put(result, type);
        if(r!=null)
        {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Result> getResult(ResultType type) {
        List<Result> resultList = new ArrayList<>();
        for(Result r: results.keySet()){
            if(results.get(r).equals(type)){
                resultList.add(r);
            }
        }
        return resultList;
    }

    @Override
    public void upsertPersonWithMultipleTests(UUID id, ResultType type) {
        ResultType r=mult.put(id, type);
    }
}
