package com.country.repository;
import org.springframework.data.repository.CrudRepository;

import com.country.model.Country;
public interface CountryRepository extends CrudRepository<Country, Integer>
{
}
