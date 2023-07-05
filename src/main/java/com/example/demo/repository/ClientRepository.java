package com.example.demo.repository;

import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByNameLike(String name);

    //Custom query by custom JPQL query.
    //Client se llama la entidad de nuestro programa.

    @Query("SLECT a FROM Client a Where name = :nombre ORDER BY lastname ASC")
    List<Client> getByNameOrderedByLastnameJPQL(@Param("nombre") String name);

    //Si no se especifica el parametro nativeQuery, por default se utiliza JPQL.
    //Como  estamos haciendo nativeQuery, debemos llamar al nombre de la tabla tal cual esta en la db.

    @Query(value = "SELECT * FROM client a WHERE name = ?1 ORDER BY lastname ASC", nativeQuery = true)
    List<Client> getByNameOrderedByLastnameNativeQuery(String name);

    //Difiere JPQL de SQL normal, simplemente llamamos a INNER JOIN pero no especificamos las claves.
    // Porque ya estan en las clases.

    @Query<Tuple> getInvoicesWithClientById(@Param("id") int id);
}
