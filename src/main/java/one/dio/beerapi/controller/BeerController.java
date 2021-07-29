package one.dio.beerapi.controller;

import lombok.AllArgsConstructor;
import one.dio.beerapi.dto.BeerDTO;
import one.dio.beerapi.exception.BeerAlreadyRegisteredException;
import one.dio.beerapi.exception.BeerNotFoundException;
import one.dio.beerapi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController implements BeerControllerDocs {

    private final BeerService beerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO createBeer(@RequestBody @Valid BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        return beerService.createBeer(beerDTO);
    }

    @GetMapping("/{name}")
    public BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException {
        return beerService.findByName(name);

    }

    @GetMapping
    public List<BeerDTO> listBeers() {
        return beerService.listAll();
    }
}
