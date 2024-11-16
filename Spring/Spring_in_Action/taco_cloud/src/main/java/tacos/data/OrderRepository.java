package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    // 스프링 데이터는 메서드 이름으로(findByDeliveryZip) deliveryZip속성과 일치히는 모든 개체를 찾아야한다는 걸 안다.
    List<Order> findByDeliveryZip(String deliveryZip);

}
