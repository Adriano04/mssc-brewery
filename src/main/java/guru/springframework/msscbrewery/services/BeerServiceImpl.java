package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto addBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.info("Updating beer with UUID: " + beerId.toString());
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.info("Deleting beer with UUID: " + beerId.toString());
    }
}
