package princeton.core.order.domain.service;

import princeton.core.order.domain.entity.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
