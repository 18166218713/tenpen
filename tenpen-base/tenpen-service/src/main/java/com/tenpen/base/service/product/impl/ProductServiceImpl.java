package com.tenpen.base.service.product.impl;

import com.tenpen.base.dao.OrgProductsImagesMapper;
import com.tenpen.base.dao.OrgProductsMapper;
import com.tenpen.base.dao.OrgRecommendsTransactionMapper;
import com.tenpen.base.domain.model.OrgProducts;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.product.ProductService;
import com.tenpen.base.service.product.dto.request.CreateProductDTO;
import com.tenpen.base.service.product.dto.request.QueryMyProductDTO;
import com.tenpen.base.service.product.dto.request.QueryProductDTO;
import com.tenpen.base.service.product.dto.response.MyProductDetailDTO;
import com.tenpen.base.service.product.dto.response.MyProductListResponseDTO;
import com.tenpen.base.service.product.dto.response.ProductDetailDTO;
import com.tenpen.base.service.product.dto.response.ProductListResponseDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by x00376013 on 2019/9/26.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    OrgProductsMapper orgProductsMapper;

    @Autowired
    OrgProductsImagesMapper orgProductsImagesMapper;

    @Autowired
    OrgRecommendsTransactionMapper orgRecommendsTransactionMapper;

    @Override
    public OrgProducts getProduct(String productId) {
        if (StringUtils.isBlank(productId)) {
            throw new ServiceException("productId is null!");
        }
        OrgProducts orgProduct = orgProductsMapper.selectByPrimaryKey(productId);
        if (orgProduct == null) {
            throw new ServiceException("product is null!");
        }
        return orgProduct;
    }

    @Override
    public void createProduct(CreateProductDTO request) {

    }

    @Override
    public void deleteProduct(String productId) {

    }

    @Override
    public List<ProductListResponseDTO> getProducts(QueryProductDTO request) {
        return null;
    }

    @Override
    public ProductDetailDTO getProductDetail(String productId) {
        return null;
    }

    @Override
    public List<MyProductListResponseDTO> getMyProducts(QueryMyProductDTO request) {
        return null;
    }

    @Override
    public MyProductDetailDTO getMyProductDetail(String productId) {
        return null;
    }
}
