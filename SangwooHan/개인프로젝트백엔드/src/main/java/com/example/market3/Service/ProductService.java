package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.ProductCommentRequest;
import com.example.market3.Entity.JpaProduct;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    public  void register (JpaProduct jpaProduct)throws  Exception;

    public List<JpaProduct> getProductList() throws  Exception;

    public Optional<JpaProduct> getProduct(Long boardNo) throws Exception;

    public  void comment(ProductCommentRequest productCommentRequest)throws  Exception;

    public  void ModifyComments(ProductCommentRequest productCommentRequest) throws  Exception;

    public  void deleteComment (Long productCommentNo) throws  Exception;

    public List<JpaProduct> getsideProductList(String productType);
}
