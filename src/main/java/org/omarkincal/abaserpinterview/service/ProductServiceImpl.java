package org.omarkincal.abaserpinterview.service;

import org.omarkincal.abaserpinterview.dto.ProductDto;
import org.omarkincal.abaserpinterview.entity.Product;
import org.omarkincal.abaserpinterview.repository.ProductRepository;
import org.omarkincal.abaserpinterview.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {
    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDto> getAll() {
        return repository.findAll().stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());
    }

    // 1. sorunun a şıkkı
    public void calculateTotalAmountOfAllProducts() {
        double totalAmount = 0;
        List<ProductDto> products = getAll();

        for (ProductDto product : products) {
            totalAmount += product.getQuantity() * product.getUnitPrice();
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedTotalAmount = decimalFormat.format(totalAmount);

        System.out.println("Bütün malların toplam tutarı: " + formattedTotalAmount);


        //System.out.printf("Bütün malların toplam tutarı: %.2f%n", totalAmount);
    }


    // 1. sorunun b şıkkı
    public void calculateAveragePriceOfAllProducts() {
        List<ProductDto> products = getAll();
        int totalProductCount = 0;
        double totalAmount = 0;

        for (ProductDto product : products) {
            totalAmount += product.getQuantity() * product.getUnitPrice();
            totalProductCount += product.getQuantity();
        }

        double average = (totalProductCount > 0) ? (totalAmount / totalProductCount) : Double.NaN;

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedAverage = decimalFormat.format(average);

        System.out.println("Bütün malların ortalama fiyatı: " + formattedAverage);
    }

    //1. sorunun c şıkkı
    public void calculateAveragePriceBasedOnProduct() {
        List<ProductDto> products = getAll();
        Map<Integer, Double> averagePrices = new HashMap<>();
        Map<Integer, Integer> productQuantities = new HashMap<>();

        for (ProductDto product : products) {
            int productNo = product.getProductNo();
            double productTotalPrice = product.getQuantity() * product.getUnitPrice();

            averagePrices.merge(productNo, productTotalPrice, Double::sum);
            productQuantities.merge(productNo, product.getQuantity(), Integer::sum);
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        System.out.println("Ürün bazında ortalama fiyatlar:");

        for (Map.Entry<Integer, Double> entry : averagePrices.entrySet()) {
            int productName = entry.getKey();
            double totalProductPrice = entry.getValue();
            int totalProductQuantity = productQuantities.get(productName);

            double averageProductPrice = totalProductPrice / totalProductQuantity;

            String formattedAverage = decimalFormat.format(averageProductPrice);
            System.out.println(productName + ": " + formattedAverage);
        }
    }

    //1. sorunun d şıkkı
    public void calculateProductQuantityAccordingToOrder() {
        List<ProductDto> products = getAll();

        Map<Integer, Map<Integer, Integer>> productQuantitiesPerOrder = new HashMap<>();

        for (ProductDto product : products) {
            Integer productNo = product.getProductNo();
            Integer orderId = product.getOrderId();
            int quantity = product.getQuantity();

            productQuantitiesPerOrder.putIfAbsent(productNo, new HashMap<>());

            productQuantitiesPerOrder.get(productNo).putIfAbsent(orderId, 0);

            int currentQuantity = productQuantitiesPerOrder.get(productNo).get(orderId);
            productQuantitiesPerOrder.get(productNo).put(orderId, currentQuantity + quantity);
        }

        System.out.println("Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğu: ");

        for (Map.Entry<Integer, Map<Integer, Integer>> productEntry : productQuantitiesPerOrder.entrySet()) {
            Integer productNo = productEntry.getKey();
            Map<Integer, Integer> productQuantities = productEntry.getValue();

            System.out.println(productNo + ": " + productQuantities);
        }
    }

    public ProductDto create(ProductDto dto) {
        return ProductMapper.toDto(repository
                .save(ProductMapper.
                        toEntity(new Product(), dto)));
    }

    public List<ProductDto> getAllByOrderId(Integer orderId) {
        return repository
                .findAllByOrderId(orderId)
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }
}
