package com.tenpen.base.service.product;

import com.tenpen.base.domain.model.OrgProducts;
import com.tenpen.base.service.product.dto.request.CreateProductDTO;
import com.tenpen.base.service.product.dto.request.QueryMyProductDTO;
import com.tenpen.base.service.product.dto.request.QueryProductDTO;
import com.tenpen.base.service.product.dto.response.MyProductDetailDTO;
import com.tenpen.base.service.product.dto.response.MyProductListResponseDTO;
import com.tenpen.base.service.product.dto.response.ProductDetailDTO;
import com.tenpen.base.service.product.dto.response.ProductListResponseDTO;

import java.util.List;

/**
 * Created by x00376013 on 2019/9/26.
 */
public interface ProductService {

    OrgProducts getProduct(String productId);

    /**
     * 创建产品
     * @param request
     */
    void createProduct(CreateProductDTO request);

    /**
     * 删除产品
     * @param productId
     */
    void deleteProduct(String productId);

    /**
     * 商品分页查询接口
     * @param request
     * @return
     */
    List<ProductListResponseDTO> getProducts(QueryProductDTO request);

    /**
     * 商品详情查询接口
     * @param productId
     * @return
     */
    ProductDetailDTO getProductDetail(String productId);

    /**
     * 我的商品分页查询接口
     * @param request
     * @return
     */
    List<MyProductListResponseDTO> getMyProducts(QueryMyProductDTO request);

    /**
     * 我的商品详情查询接口
     * @param productId
     * @return
     */
    MyProductDetailDTO getMyProductDetail(String productId);
}
