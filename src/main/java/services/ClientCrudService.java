package services;
import dao.ClientDao;
import entities.Client;
import models.ClientDTO;
import java.util.List;
import java.util.stream.Collectors;
public class ClientCrudService {

    private ClientDao clientDao = new ClientDao();

    public ClientCrudService() {
    }

    public ClientDTO findClient(long id) {
        Client entity = clientDao.findById(id);
        if (entity == null) return null;
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public ClientDTO createClient(String client) {
        if (client.length() < 3 || client.length() > 300) {
            throw new IllegalArgumentException("Name must be between 2 and 1000 characters long.");
        }
        Client entity = clientDao.create(client);
        if (entity == null) return null;
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public void updateClient(ClientDTO client) {
        Client entity = new Client(client.getId(), client.getName());
        clientDao.update(entity);
    }

    public void deleteClientByID(long id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be between 1 and 9,223,372,036,854,775,807 digital input.");
        }
        Client entity = new Client(id);
       clientDao.delete(entity);
    }


    public List<ClientDTO> findAllClient() {
       List<Client> entityList = clientDao.findAll();
       return entityList.stream().map(e -> {
           ClientDTO dto = new ClientDTO();
           dto.setId(e.getId());
           dto.setName(e.getName());
           return dto;
       }).collect(Collectors.toList());
    }
}
