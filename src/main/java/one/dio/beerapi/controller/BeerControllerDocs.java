package one.dio.beerapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.dio.beerapi.dto.BeerDTO;
import one.dio.beerapi.exception.BeerAlreadyRegisteredException;

import java.util.List;

@Api("Beer stock")
public interface BeerControllerDocs {

    @ApiOperation(value = "Beer creation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success "),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field value.")
    })
    BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException;

    @ApiOperation(value = "Returns a list of all beers registered")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all beers registered"),
    })
    List<BeerDTO> listBeers();
}
