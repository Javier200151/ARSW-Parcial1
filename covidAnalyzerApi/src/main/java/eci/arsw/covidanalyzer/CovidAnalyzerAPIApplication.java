package eci.arsw.covidanalyzer;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidAnalyzerAPIApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CovidAnalyzerAPIApplication.class);
        //app.setDefaultProperties(Collections.singletonMap("spring.data.mongodb.uri","mongodb+srv://admin:arsw1234@tictactoedb.ybcuz.mongodb.net/TicTacToe?retryWrites=true&w=majority"));
        app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
        app.run(args);
        //SpringApplication.run(CovidAnalyzerAPIApplication.class, args);
        
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080; // returns default port if heroku-port isn't set (i.e. onlocalhost)
    }
}
