package solmovdrareeg.htf_soldra.util;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Put;
import org.androidannotations.annotations.rest.RequiresAuthentication;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import solmovdrareeg.htf_soldra.model.City;


/**
 * Created by Drareeg on 15.11.14.
 */
@Rest(rootUrl = "https://hackaton-backend.appspot.com/_ah/api/cities/v1", converters = { MappingJacksonHttpMessageConverter.class})
public interface RestClient {

    @Get("/citycollection")
    City[] getAllCities();

}
