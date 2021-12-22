package br.com.challenger.resource;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class SomaResource {

    // http://localhost:8080/sum?a=0.5&b=2.3

    @GetMapping("/sum")
    public HashMap<String, Double> sum(@RequestParam("a") Double a, @RequestParam("b") Double b) {
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, Double> result = new HashMap<>();
        Double sum = 0.0;
        map.put("a", a);
        map.put("b", b);

        for (Map.Entry<String, Double> mapElemt : map.entrySet()) {
            sum += mapElemt.getValue();
            result.put("result", sum);
        }

        return result;
    }

    // http://localhost:8080/sub?a=0.5&b=2.3

    @GetMapping("/sub")
    public HashMap<String, Double> sub(@RequestParam("a") Double a, @RequestParam("b") Double b) {
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, Double> result = new HashMap<>();
        Double sub = 0.0;
        map.put("a", a);
        map.put("b", b);
        Double n1 = 0.0;
        Double n2 = 0.0;
        for (Map.Entry<String, Double> mapElemt : map.entrySet()) {
            if (mapElemt.getKey().equals("a")) {
                n1 = mapElemt.getValue();
            }
            if (mapElemt.getKey().equals("b")) {
                n2 = mapElemt.getValue();
            }
        }
       
        sub = n1 - n2;
        DecimalFormat fmt = new DecimalFormat("0.00");      
        String string = fmt.format(sub);
        String[] part = string.split("[,]");
        String string2 = part[0]+"."+part[1];
        double valor = Double.parseDouble(string2);
        
        result.put("result", valor);

        return result;
    }

    // http://localhost:8080/mult?a=0.5&b=2.3

    @GetMapping("/mult")
    public HashMap<String, Double> mult(@RequestParam("a") Double a, @RequestParam("b") Double b) {
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, Double> result = new HashMap<>();
        Double mult = 0.0;
        map.put("a", a);
        map.put("b", b);
        Double n1 = 0.0;
        Double n2 = 0.0;
        for (Map.Entry<String, Double> mapElemt : map.entrySet()) {
            if (mapElemt.getKey().equals("a")) {
                n1 = mapElemt.getValue();
            }
            if (mapElemt.getKey().equals("b")) {
                n2 = mapElemt.getValue();
            }
        }
        mult = n1 * n2;
        DecimalFormat fmt = new DecimalFormat("0.00");      
        String st = fmt.format(mult);
        String[] part = st.split("[,]");
        String st1 = part[0]+"."+part[1];
        double valor = Double.parseDouble(st1);
       
        result.put("result", valor);

        return result;
    }

    // http://localhost:8080/div?a=0.5&b=2.3

    @GetMapping("/div")
    public HashMap<String, Double> div(@RequestParam("a") Double a, @RequestParam("b") Double b) {
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, Double> result = new HashMap<>();
        Double div = 0.0;
        map.put("a", a);
        map.put("b", b);
        Double n1 = 0.0;
        Double n2 = 0.0;
        for (Map.Entry<String, Double> mapElemt : map.entrySet()) {
            if (mapElemt.getKey().equals("a")) {
                n1 = mapElemt.getValue();
            }
            if (mapElemt.getKey().equals("b")) {
                n2 = mapElemt.getValue();
            }
        }

        if(n2 == 0){
            result.put("result", 0.0);
            return result;
        }

        div = n1 / n2;
        DecimalFormat fmt = new DecimalFormat("0.00");      
        String st = fmt.format(div);
        String[] part = st.split("[,]");
        String st1 = part[0]+"."+part[1];
        double valor = Double.parseDouble(st1);
        
        result.put("result", valor);

        return result;
    }

}