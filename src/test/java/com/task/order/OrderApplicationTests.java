package com.task.order;

import com.task.order.dto.OrderDTO;
import com.task.order.model.OrderModel;

import com.task.order.repository.OrderRepository;
import com.task.order.service.impl.OrderServiceImpl;

import org.apache.catalina.mapper.Mapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.ExpectedCount;

import javax.swing.text.html.parser.Entity;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class OrderApplicationTests{

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderModel orderModel;


    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	void verifySimilar() throws JSONException {
        JSONObject actual = new JSONObject()
                .put("price", 123)
                .put("quantity", 2)
                .put("item", "testItem");

        assertEquals("{price:123}", actual, false);
        assertEquals("{quantity:2}", actual, false);
        assertEquals("{item:\"testItem\", quantity:2}", actual, false);
        assertEquals("{price:123, quantity:2}", actual, false);
        assertEquals("{item:\"testItem\", price:123}", actual, false);

	}

    @Test
    void saveOrderTest() {

        OrderDTO orderDTO = new OrderDTO(123, 2, "testItem");

        orderService.saveOrder(orderDTO);
        
        Mockito.verify(orderService, times((1))).saveOrder(orderDTO);
    }

    @Test
    void findByItemTest() {

        when(orderModel.getItem()).thenReturn(String.valueOf(new OrderDTO(123, 2, "testItem")));

        OrderDTO dto = (OrderDTO) orderService.findOrderByItem("1");

        Assert.assertEquals(123, dto.getPrice());
        Assert.assertEquals(2, dto.getQuantity());
    }

}
