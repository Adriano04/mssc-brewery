package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.beer.BeerService;
import guru.springframework.msscbrewery.services.beer.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
        return ResponseEntity.status(HttpStatus.OK).body(beerService.getBeerById(beerId));
    }

    @PostMapping("/")
    public ResponseEntity<BeerDtoV2> addBeer(@RequestBody BeerDtoV2 beerDto) {
        var newBeer = beerService.addBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + newBeer.getId().toString());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .headers(headers)
                .body(newBeer);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        beerService.updateBeer(beerId, beerDto);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeerById(beerId);
    }
}
