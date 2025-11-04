package com.senac.doador.repository;

import com.senac.doador.entity.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Integer> {

    @Query("SELECT d FROM Doador d WHERE d.status >= 0")
    List<Doador> listarDoadores();

    @Modifying
    @Transactional
    @Query("UPDATE Doador d SET d.status = -1 WHERE d.id =:id")
    int apagadoLogico(@Param("id") int id);
}
