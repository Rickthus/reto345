package cloud.reto345.service;


import cloud.reto345.model.Message;
import cloud.reto345.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }

    public Message save(Message c){
        if(c.getIdMessage()==null){
            return messageRepository.save(c);
        }else{
            Optional<Message> maux=messageRepository.getMessage(c.getIdMessage());
            if(maux.isEmpty()){
                return messageRepository.save(c);
            }else{
                return c;
            }
        }

    }
}
