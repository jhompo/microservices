package com.jsoft.orders_factory.Aplication;

import com.jsoft.orders_factory.Domain.dtos.OrderItemsRequest;
import com.jsoft.orders_factory.Domain.dtos.OrderRequest;
import com.jsoft.orders_factory.Domain.models.Order;
import com.jsoft.orders_factory.Domain.models.OrderItems;
import com.jsoft.orders_factory.Domain.repository.OrderRepository;
import com.jsoft.orders_factory.Domain.dtos.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServices {


    final OrderRepository orderRepository;
    final WebClient.Builder webClientBuilder;


    public void create(OrderRequest orderRequest) {

        // webflux con stock - WebClient programacion reactiva y flujo de datos asincronos
        DataResponse dataResponse = this.webClientBuilder.build()
                .post()
                .uri("http://localhost:8083/inventory/in-stock")
                .bodyValue(orderRequest.getOrderItems())
                .retrieve()
                .bodyToMono(DataResponse.class)//tipo de dato a recibir del servicio
                .block();

        if(dataResponse != null && !dataResponse.hasErrors()){

            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());

            List<OrderItems> mapOrder = new ArrayList<>();
            for(OrderItemsRequest item : orderRequest.getOrderItems() ){
                OrderItems ord = new OrderItems();
                ord.setId( item.getId());
                ord.setSku( item.getSku());
                ord.setPrice( item.getPrice());
                ord.setQuantity( item.getQuantity());
                ord.setOrder(order);
                mapOrder.add(ord);
            }
            order.setOrderItem(mapOrder);

            /*order.setOrderItem(orderRequest.getOrderItems().stream()
                    .map(val -> mapOrderItemRequestToOrderItem(val, order))
                    .toList());*/

            orderRepository.save(order);
        }else{
            throw new IllegalArgumentException("Some of the products are not in stock");
        }

    }

    private OrderItems mapOrderItemRequestToOrderItem(OrderItemsRequest orderItemRequest, Order order) {
        return OrderItems.builder()
                .id(orderItemRequest.getId())
                .sku(orderItemRequest.getSku())
                .price(orderItemRequest.getPrice())
                .quantity(orderItemRequest.getQuantity())
                .order(order)
                .build();
    }

    public OrderItems mapperToItemOrder(OrderItemsRequest orderItemsRequest, Order order)
    {

        return OrderItems.builder()
                .id(orderItemsRequest.getId())
                .sku(orderItemsRequest.getSku())
                .price(orderItemsRequest.getPrice())
                .quantity(orderItemsRequest.getQuantity())
                .order(order)
                .build();

    }

    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    public List<Order> all() {
        return orderRepository.all();
    }
}
