package com.grpcsample.grpc.client;

import com.grpcsample.grpc.ProductRequest;
import com.grpcsample.grpc.ProductResponse;
import com.grpcsample.grpc.ProductServiceGrpc;
import com.sun.tools.javac.Main;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class Client {

    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",6565)
                .usePlaintext().build();
        ProductServiceGrpc.ProductServiceBlockingStub blockingStub = ProductServiceGrpc.newBlockingStub(managedChannel);
        ProductResponse response = blockingStub.getProduct(ProductRequest.newBuilder().setName("product").build());
        logger.info("response", response.getName() + response.getId());
    }
}
