package com.babacar.app.repositories;

import com.babacar.app.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {

    Optional<Currency> findByUuid(String uuid);

}
