package cloud.reto345.repository;


import cloud.reto345.model.Message;
import cloud.reto345.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int idMessage){
        return messageCrudRepository.findById(idMessage);
    }

    public Message save(Message c){
        return messageCrudRepository.save(c);
    }



}
