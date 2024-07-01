package services;

import dao.PlanetDao;
import entities.Planet;
import models.PlanetDTO;
import java.util.List;
import java.util.stream.Collectors;

public class PlanetCrudService {
    private PlanetDao planetDao = new PlanetDao();

    public  PlanetCrudService() {

    }

    public PlanetDTO findPlanet(String id) {
        Planet entity = planetDao.findById(id);
        if( entity == null) {
            return null;
        }
        PlanetDTO dto = new PlanetDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public PlanetDTO createPlanet(String planetId, String planetName) {
        if (planetId.length() < 3 || planetId.length() > 500) {
            throw new IllegalArgumentException("Id must be between 2 and 1000 characters long.");
        }
        if (planetName.length() < 1 || planetName.length() > 500) {
            throw new IllegalArgumentException("Name must be between 2 and 1000 characters long.");
        }
        Planet entity = planetDao.create(planetId, planetName);
        if( entity == null) {
            return null;
        }
        PlanetDTO dto = new PlanetDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public void updatePlanet(PlanetDTO planet) {
        Planet entity = new Planet(planet.getId(), planet.getName());
        planetDao.update(entity);
    }

    public void deletePlanetById(String planetId) {
        if(planetId != null){
            planetDao.delete(new Planet(planetId, null));
        }

    }


    public List<PlanetDTO> findAllPlanet() {
        List<Planet> entityList = planetDao.findAll();
        return entityList.stream().map(e -> {
            PlanetDTO dto = new PlanetDTO();
            dto.setId(e.getId());
            dto.setName(e.getName());
            return dto;
        }).collect(Collectors.toList());
    }

}
