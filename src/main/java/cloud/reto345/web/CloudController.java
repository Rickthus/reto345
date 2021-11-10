package cloud.reto345.web;

import cloud.reto345.model.Cloud;
import cloud.reto345.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cloud")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CloudController {

    @Autowired
    private CloudService cloudService;

    @GetMapping("/all")
    public List<Cloud> getCloud(){
        return cloudService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cloud> getCloud(@PathVariable("id") int id){
        return cloudService.getCloud(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud c){
        return cloudService.save(c);

    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud update(@RequestBody Cloud c){
        return cloudService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCloud(@PathVariable("id") int id){
        return cloudService.deleteCloud(id);
    }

}
