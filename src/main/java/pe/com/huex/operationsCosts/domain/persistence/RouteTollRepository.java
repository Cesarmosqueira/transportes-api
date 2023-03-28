package pe.com.huex.operationsCosts.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.huex.operationsCosts.domain.entities.RouteToll;

import java.util.List;

@Repository
public interface RouteTollRepository extends JpaRepository<RouteToll,Long> {

    @Query(value = "select count(rt.id),t.configuration,r.route_end,sum(t.cost)\n" +
            "from tolls t join route_tolls rt on t.id=rt.toll_id\n" +
            "\t\tjoin route r on r.id=rt.route_id\n" +
            "where r.route_end= ?1 and t.configuration= ?2 \n" +
            "group by t.configuration,r.route_end", nativeQuery = true)
    List<Object[]> costTollRoute(String route, String configuration);

}
