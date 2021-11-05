package cloud.reto345.service;


import cloud.reto345.model.Client;
import cloud.reto345.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }

    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> claux=clientRepository.getClient(c.getIdClient());
            if(claux.isEmpty()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }

    }
}
