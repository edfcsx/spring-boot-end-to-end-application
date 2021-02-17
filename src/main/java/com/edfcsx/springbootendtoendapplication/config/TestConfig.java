package com.edfcsx.springbootendtoendapplication.config;

import com.edfcsx.springbootendtoendapplication.domain.*;
import com.edfcsx.springbootendtoendapplication.domain.enums.CustomerType;
import com.edfcsx.springbootendtoendapplication.domain.enums.PaymentStatus;
import com.edfcsx.springbootendtoendapplication.repositories.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat = new Category(null, "Informática");
        Category cat1 = new Category(null, "Escritório");

        categoryRepository.saveAll(Arrays.asList(cat, cat1));

        Product p1 = new Product(null, "Computador", 2000.00);
        Product p2 = new Product(null, "Impressora", 800.00);
        Product p3 = new Product(null, "Mouse", 80.00);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        p1.getCategories().addAll(Arrays.asList(cat));
        p2.getCategories().addAll(Arrays.asList(cat, cat1));
        p3.getCategories().addAll(Arrays.asList(cat));

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        State s1 = new State(null, "Pernambuco");
        State s2 = new State(null, "Paraiba");

        stateRepository.saveAll(Arrays.asList(s1, s2));

        City c1 = new City(null, "Recife");
        City c2 = new City(null, "Petrolina");
        City c3 = new City(null, "João Pessoa");

        c1.setState(s1);
        c2.setState(s1);
        c3.setState(s2);

        cityRepository.saveAll(Arrays.asList(c1, c2, c3));

        Customer cli1 = new Customer(
                null,
                "Maria Silva",
                "maria@any_mail.com",
                "9876545688",
                CustomerType.NATURAL_PERSON
        );

        cli1.getPhones().addAll(Arrays.asList("81998030890"));

        Address address1 = new Address(
                null,
                "Rua Flores",
                "18",
                "casa",
                "Jardins",
                "51350320",
                cli1,
                c2
        );

        Address address2 = new Address(
                null,
                "Avenida Matos",
                "300",
                "APT 01",
                "Ipsep",
                "51350320",
                cli1,
                c2
        );

        cli1.getAddresses().addAll(Arrays.asList(address1, address2));

        customerRepository.saveAll(Arrays.asList(cli1));
        addressRepository.saveAll(Arrays.asList(address1, address2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYY HH:mm");

        Order order = new Order(
                null,
                sdf.parse("30/09/2017 10:32"),
                cli1,
                address1
        );

        Order order1 = new Order(
                null,
                sdf.parse("10/10/2017 19:35"),
                cli1,
                address2
        );

        Payment pay = new PaymentWithCard(null, PaymentStatus.PAID.getCod(), order, 6);

        order.setPayment(pay);

        Payment pay1 = new PaymentWithSlip(
                null,
                PaymentStatus.PENDING.getCod(),
                order1,
                sdf.parse("20/10/2017 00:00"),
                null
        );

        order1.setPayment(pay1);

        cli1.getOrders().addAll(Arrays.asList(order, order1));

        orderRepository.saveAll(Arrays.asList(order, order1));
        paymentRepository.saveAll(Arrays.asList(pay, pay1));

        OrderItem o1 = new OrderItem(order, p1, 0.00, 1, 2000.0);
        OrderItem o2 = new OrderItem(order, p3, 0.00, 2, 80.00);
        OrderItem o3 = new OrderItem(order1, p2, 100.00, 1, 800.00);
        
        orderItemRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
