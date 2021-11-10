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

    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> claux=clientRepository.getClient(c.getIdClient());
            if(!claux.isEmpty()){

                if(c.getEmail()!=null){
                    claux.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    claux.get().setPassword(c.getPassword());
                }
                if(c.getName()!=null){
                    claux.get().setName(c.getName());
                }
                if(c.getAge()!=null){
                    claux.get().setAge(c.getAge());
                }
                return clientRepository.save(claux.get());
            }
        }
        return c;

    }

    public boolean deleteClient(int idClient) {
        Optional <Client> c=getClient(idClient);
        if(!c.isEmpty()){
            clientRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
