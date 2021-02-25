/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.covidanalyzer;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author javie
 */
public class ThreadAnalyzerTool extends Thread{
    private int a;
    private int b;
    private List<File> files;
    private TestReader tr;
    private ResultAnalyzer ra;
    private AtomicInteger ai;
    private boolean stop = false;
    
    public ThreadAnalyzerTool(int a, int b, List<File> resultFiles, TestReader testReader,ResultAnalyzer resultAnalyzer,AtomicInteger amountOfFilesProcessed) {
        this.a = a;
        this.b= b;
        this.files = resultFiles;
        this.tr = testReader;
        this.ra = resultAnalyzer;
        this.ai = amountOfFilesProcessed;
    }
    
    public void run(){ 
        try {
            startThread();  
	} catch (InterruptedException e) {
            e.printStackTrace();
	}
        
    }
    public void startThread() throws InterruptedException{
        for (int i = a; i<b;i++) {
            List<Result> results = tr.readResultsFromFile(files.get(i));
            for (Result result : results) {
                ra.addResult(result);
            }
            ai.incrementAndGet();
        }
        synchronized (this) {
            while (stop) {                      
                wait();
            }
        }
    }
    synchronized void stopThread(){
        stop=true;
    }
    synchronized void resumeThread(){
        stop=false;
        notify();
    }
}
