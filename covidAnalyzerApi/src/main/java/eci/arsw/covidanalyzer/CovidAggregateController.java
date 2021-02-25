package eci.arsw.covidanalyzer;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidAggregateController {
    ICovidAggregateService covidAggregateService;

    //TODO: Implemente todos los metodos POST que hacen falta.

    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.POST)
    public ResponseEntity addTruePositiveResult(Result result) {
        boolean post = covidAggregateService.aggregateResult(result, ResultType.TRUE_POSITIVE);
        if(post){
            return new ResponseEntity<>("Hecho",HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }          
    }
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.POST)
    public ResponseEntity addTrueNegativeResult(Result result) {
        boolean post = covidAggregateService.aggregateResult(result, ResultType.TRUE_NEGATIVE);
        if(post){
            return new ResponseEntity<>("Hecho",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        } 
    }
    
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.POST)
    public ResponseEntity addFalsePositiveResult(Result result) {
        boolean post = covidAggregateService.aggregateResult(result, ResultType.FALSE_POSITIVE);
        if(post){
            return new ResponseEntity<>("Hecho",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        } 
    }
    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.POST)
    public ResponseEntity addFalseNegativeResult(Result result) {
        //TODO
        boolean post = covidAggregateService.aggregateResult(result, ResultType.FALSE_NEGATIVE);
        if(post){
            return new ResponseEntity<>("Hecho",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        } 
    }
    
    
    
    
    
    
    
    //TODO: Implemente todos los metodos GET que hacen falta.

    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.GET)
    public ResponseEntity getTruePositiveResult() {
        //TODO
        //covidAggregateService.getResult(ResultType.TRUE_POSITIVE);      
        return ResponseEntity.ok("Hello World TruePositive");
    }
    
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.GET)
    public ResponseEntity getTrueNegativeResult() {
        //TODO
        //covidAggregateService.getResult(ResultType.TRUE_POSITIVE);      
        return ResponseEntity.ok("Hello World TrueNegative");
    }
    
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.GET)
    public ResponseEntity getFalsePositiveResult() {
        //TODO
        //covidAggregateService.getResult(ResultType.TRUE_POSITIVE);      
        return ResponseEntity.ok("Hello World FalsePositive");
    }
    
    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.GET)
    public ResponseEntity getFalseNegativeResult() {
        //TODO
        //covidAggregateService.getResult(ResultType.TRUE_POSITIVE);      
        return ResponseEntity.ok("Hello World FalseNegative");
    }

    //TODO: Implemente el método.

    @RequestMapping(value = "/covid/result/persona/{id}", method = RequestMethod.PUT)
    public ResponseEntity savePersonaWithMultipleTests() {
        //TODO
        covidAggregateService.getResult(ResultType.TRUE_POSITIVE);
        return null;
    }
    
}