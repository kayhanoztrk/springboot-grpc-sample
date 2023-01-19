package com.grpcsample.grpc.server;


import com.grpcsample.grpc.ProductRequest;
import com.grpcsample.grpc.ProductResponse;
import com.grpcsample.grpc.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@GRpcService
public class Server extends ProductServiceGrpc.ProductServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    public void getProduct(ProductRequest request,
                           StreamObserver<ProductResponse> responseObserver){
            ProductResponse response = ProductResponse.newBuilder()
                    .setId(1).setName("productName").build();

        logger.info("get request {}", request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
