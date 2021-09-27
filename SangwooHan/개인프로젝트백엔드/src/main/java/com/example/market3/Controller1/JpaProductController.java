package com.example.market3.Controller1;

import com.example.market3.Controller1.MemberRequset.ProductCommentRequest;
import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaMember;
import com.example.market3.Entity.JpaProduct;
import com.example.market3.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jpaProduct")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class JpaProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<Void> register (@Validated @RequestBody JpaProduct jpaProduct) throws  Exception{

        productService.register(jpaProduct);
        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("getProductList")
    public ResponseEntity<List<JpaProduct>> getProductList() throws  Exception {
        productService.getProductList();

        return new ResponseEntity<>(productService.getProductList(),HttpStatus.OK);
    }
    @GetMapping("/getProduct/{boardNo}")
    public ResponseEntity<JpaProduct> getProduct (@PathVariable("boardNo") Long boardNo) throws  Exception {

        Optional<JpaProduct> jpaProduct = productService.getProduct(boardNo);
        JpaProduct jpaProduct1  = jpaProduct.get();
        return new ResponseEntity<>(jpaProduct1,HttpStatus.OK);
    }

    @PostMapping("/comment/{boardNo}")
    public  ResponseEntity<Void> comment(@PathVariable("boardNo")Long boardNo, @Validated @RequestBody ProductCommentRequest productCommentRequest)throws Exception{
        productCommentRequest.setBoardNo(boardNo);
        productService.comment(productCommentRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/ModifyComments/{boardNo}")
    public ResponseEntity<Void> ModifyComments(@PathVariable("boardNo")Long boardNo, @Validated @RequestBody ProductCommentRequest productCommentRequest) throws  Exception {

        productCommentRequest.setBoardNo(boardNo);
        productService.ModifyComments(productCommentRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{productCommentNo}")
    public ResponseEntity<Void> deleteComment(@PathVariable("productCommentNo")Long productCommentNo) throws  Exception{

        productService.deleteComment(productCommentNo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/getsideProductList")
    public  ResponseEntity<List<JpaProduct>>getsideProductList(@Validated @RequestBody ProductCommentRequest productCommentRequest) throws  Exception{

        String productType = productCommentRequest.getProductType();
        List<JpaProduct> jpaProducts = productService.getsideProductList(productType);


        return  new ResponseEntity<>(jpaProducts,HttpStatus.OK);
    }
}
