package cloud.reto345.web;

import cloud.reto345.model.Message;
import cloud.reto345.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessage(){
        return messageService.getAll();
    }

    @GetMapping("/{idMessage}")
    public Optional<Message> getMessage(@PathVariable("idMessage") int idMessage){
        return messageService.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message c){
        return messageService.save(c);

    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message c){
        return messageService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable("id") int idMessage){
        return messageService.deleteMessage(idMessage);
    }

}
