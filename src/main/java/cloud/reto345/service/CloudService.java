package cloud.reto345.service;


import cloud.reto345.model.Cloud;
import cloud.reto345.repository.CloudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudService {

    @Autowired
    private CloudRepository cloudRepository;

    public List<Cloud> getAll(){
        return cloudRepository.getAll();
    }

    public Optional<Cloud> getCloud(int id){
        return cloudRepository.getCloud(id);
    }

    public Cloud save(Cloud c){
        if(c.getId()==null){
            return cloudRepository.save(c);
        }else{
            Optional<Cloud> claux=cloudRepository.getCloud(c.getId());
            if(claux.isEmpty()){
                return cloudRepository.save(c);
            }else{
                return c;
            }
        }

    }
}
