package cloud.reto345.repository;


import cloud.reto345.model.Cloud;
import cloud.reto345.repository.crud.CloudCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CloudRepository {

    @Autowired
    private CloudCrudRepository cloudCrudRepository;

    public List<Cloud> getAll(){
        return (List<Cloud>) cloudCrudRepository.findAll();
    }

    public Optional<Cloud> getCloud(int id){
        return cloudCrudRepository.findById(id);
    }

    public Cloud save(Cloud c){
        return cloudCrudRepository.save(c);
    }

    public void delete(Cloud c){
        cloudCrudRepository.delete(c);
    }

}
