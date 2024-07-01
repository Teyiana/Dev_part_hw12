
import model.ClientDTO;
import model.PlanetDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ClientCrudService;
import service.PlanetCrudService;

import java.util.List;


public class Main {

    private static  final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Start");
        ClientCrudService clientCrudService = new ClientCrudService();
        LOGGER.info("Create client");
        ClientDTO client = clientCrudService.createClient("Oleh");
        LOGGER.info("Created {}", client);
        ClientDTO find = clientCrudService.findClient(client.getId());
        LOGGER.info("Found {}", find);
        assert client.equals(find);
        List<ClientDTO> listClient = clientCrudService.findAllClient();
        LOGGER.info("Found All size {}", listClient.size());
        assert listClient.contains(client);
        ClientDTO toUpdate = new ClientDTO();
        toUpdate.setId(client.getId());
        toUpdate.setName("Sasha");
        LOGGER.info("Try update from {} to {}", client, toUpdate);
        clientCrudService.updateClient(toUpdate);
        LOGGER.info("Updated {}", clientCrudService.findClient(toUpdate.getId()));
        LOGGER.info("Try delete {}", client);
        clientCrudService.deleteClientByID(client.getId());
        LOGGER.info("Found client {}", clientCrudService.findClient(toUpdate.getId()));

        LOGGER.info("Create planet");
        PlanetCrudService planetCrudService = new PlanetCrudService();
        PlanetDTO planet = planetCrudService.createPlanet("BAN1", "BANANA");
        LOGGER.info("Created {}", planet);
        PlanetDTO findPlanet = planetCrudService.findPlanet(planet.getId());
        LOGGER.info("Found {}", findPlanet);
        assert planet.equals(findPlanet);
        List<PlanetDTO> listPlanet = planetCrudService.findAllPlanet();
        LOGGER.info("Found All size {}", listPlanet.size());
        assert listPlanet.contains(planet);
        PlanetDTO toUpdatePlanet = new PlanetDTO();
        toUpdatePlanet.setId("HTP34");
        toUpdatePlanet.setName("HTTP");
        LOGGER.info("Try update from {} to {}", planet, toUpdatePlanet);
        planetCrudService.updatePlanet(toUpdatePlanet);
        LOGGER.info("Updated {}", planetCrudService.findPlanet(toUpdatePlanet.getId()));
        LOGGER.info("Try delete {}", planet);
        planetCrudService.deletePlanetById(planet.getId());
        LOGGER.info("Round planet {}", planetCrudService.findPlanet(toUpdatePlanet.getId()));
    }

}
