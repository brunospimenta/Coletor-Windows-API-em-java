package br.com.pepper.specs.services.InfoService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ComandoService {

    public List<String> comando(String comando) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", comando);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        List<String> list = new ArrayList<String>();
        while (true) {
            line = r.readLine();
            list.add(line);
            
            list.remove("");
            if (line == null) {
                list.remove(null);
                break;
            }
        }
        return list;
    }
    
}