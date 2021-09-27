package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.ProductCommentRequest;
import com.example.market3.Entity.JpaProduct;
import com.example.market3.Entity.JpaProductComment;
import com.example.market3.Rapository.ProductCommentRepository;
import com.example.market3.Rapository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceimpl implements  ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCommentRepository productCommentRepository;


    @Override
    public void register(JpaProduct jpaProduct) throws  Exception {
        productRepository.save(jpaProduct);
    }

    @Override
    public List<JpaProduct> getProductList() throws Exception {
        return productRepository.findAll();
    }

    @Override
    public Optional<JpaProduct> getProduct(Long boardNo) throws Exception {
        return productRepository.findById(boardNo);
    }

    @Override
    public void comment(ProductCommentRequest productCommentRequest) throws Exception {
        JpaProductComment jpaProductComment = new JpaProductComment(productCommentRequest.getProductCommentNo(), productCommentRequest.getBoardNo(), productCommentRequest.getUi(), productCommentRequest.getComments(), productCommentRequest.getRegDate());
        productCommentRepository.save(jpaProductComment);
    }

    @Override
    public void ModifyComments(ProductCommentRequest productCommentRequest) throws Exception {
        JpaProductComment jpaProductComment = new JpaProductComment(productCommentRequest.getProductCommentNo(), productCommentRequest.getBoardNo(), productCommentRequest.getUi(), productCommentRequest.getComments(), productCommentRequest.getRegDate());
        productCommentRepository.save(jpaProductComment);
    }

    @Override
    public void deleteComment(Long productCommentNo) throws Exception {

        productCommentRepository.deleteById(productCommentNo);
    }

    @Override
    public List<JpaProduct> getsideProductList(String productType) {
        return productRepository.findByType(productType);
    }
}
