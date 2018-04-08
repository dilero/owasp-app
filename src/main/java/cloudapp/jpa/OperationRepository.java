package cloudapp.jpa;

import cloudapp.entity.Book;
import cloudapp.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by z003k81p on 4/4/2018.
 */
@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
