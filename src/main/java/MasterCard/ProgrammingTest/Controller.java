package MasterCard.ProgrammingTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    Service service ;

    @GetMapping("/connected")
    public String YesNO(@RequestParam(value = "origin") Node source
            ,@RequestParam(value = "destination") Node destination ) throws IOException {
            service.createGraph();
            int s = service.set.get(source.label);
            int d = service.set.get(destination.label);
           return service.boom(s,d) == true ? "Yes":"No";
    }

}
