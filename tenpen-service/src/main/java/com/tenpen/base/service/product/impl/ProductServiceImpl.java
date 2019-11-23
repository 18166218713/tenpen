package com.tenpen.base.service.product.impl;

import com.tenpen.base.dao.OrgProductsImagesMapper;
import com.tenpen.base.dao.OrgProductsMapper;
import com.tenpen.base.dao.OrgRecommendsTransactionMapper;
import com.tenpen.base.domain.model.OrgProducts;
import com.tenpen.base.domain.model.OrgProductsImages;
import com.tenpen.base.domain.model.OrgProductsImagesExample;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.product.ProductService;
import com.tenpen.base.dto.product.request.CreateProductDTO;
import com.tenpen.base.dto.product.request.QueryMyProductDTO;
import com.tenpen.base.dto.product.request.QueryProductDTO;
import com.tenpen.base.dto.product.response.MyProductDetailDTO;
import com.tenpen.base.dto.product.response.MyProductListResponseDTO;
import com.tenpen.base.dto.product.response.ProductDetailDTO;
import com.tenpen.base.dto.product.response.ProductListResponseDTO;
import com.tenpen.base.util.IdUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        // TODO: 2019/10/30 添加字段：是否包邮,主图
        OrgProducts orgProducts=new OrgProducts();
        BeanUtils.copyProperties(request,orgProducts);
        orgProducts.setId(IdUtils.getId());
        orgProducts.setQty(1);
        orgProducts.setStatus("2");
        orgProducts.setCreateTime(new Date());
        orgProductsMapper.insert(orgProducts);
        if (request.getImageList()!=null && request.getImageList().size()>0){
            for (String imageUrl:request.getImageList()){
                OrgProductsImages images=new OrgProductsImages();
                images.setId(IdUtils.getId());
                images.setProductId(orgProducts.getId());
                images.setImageUrl(imageUrl);
                images.setStatus("1");
                images.setCreator(request.getCreator());
                images.setCreateTime(new Date());
                orgProductsImagesMapper.insert(images);
            }
        }
    }

    @Override
    public void deleteProduct(String productId) {
        orgProductsMapper.deleteByPrimaryKey(productId);
        OrgProductsImagesExample example=new OrgProductsImagesExample();
        example.createCriteria().andProductIdEqualTo(productId);
        orgProductsImagesMapper.deleteByExample(example);
    }

    @Override
    public List<ProductListResponseDTO> getProducts(QueryProductDTO request) {
        return orgProductsMapper.getProducts(request);
    }

    @Override
    public ProductDetailDTO getProductDetail(String productId) {
        ProductDetailDTO productDetailDTO=new ProductDetailDTO();
        OrgProducts orgProducts=orgProductsMapper.selectByPrimaryKey(productId);
        if (orgProducts==null){
            throw new ServiceException("product is null!");
        }
        BeanUtils.copyProperties(orgProducts,productDetailDTO);
        productDetailDTO.setProductId(orgProducts.getId());
        OrgProductsImagesExample example=new OrgProductsImagesExample();
        example.setOrderByClause("create_time");
        example.createCriteria().andProductIdEqualTo(productId);
        List<OrgProductsImages> imagesList=orgProductsImagesMapper.selectByExample(example);
        productDetailDTO.setImageList(new ArrayList<>());
        for (OrgProductsImages images:imagesList){
            productDetailDTO.getImageList().add(images.getImageUrl());
        }
        return productDetailDTO;
    }

    @Override
    public List<MyProductListResponseDTO> getMyProducts(QueryMyProductDTO request) {
        return orgProductsMapper.getMyProducts(request);
    }

    @Override
    public MyProductDetailDTO getMyProductDetail(String productId) {
        MyProductDetailDTO myProductDetailDTO=new MyProductDetailDTO();
        OrgProducts orgProducts=orgProductsMapper.selectByPrimaryKey(productId);
        if (orgProducts==null){
            throw new ServiceException("product is null!");
        }
        BeanUtils.copyProperties(orgProducts,myProductDetailDTO);
        myProductDetailDTO.setProductId(orgProducts.getId());
        OrgProductsImagesExample example=new OrgProductsImagesExample();
        example.setOrderByClause("create_time");
        example.createCriteria().andProductIdEqualTo(productId);
        List<OrgProductsImages> imagesList=orgProductsImagesMapper.selectByExample(example);
        myProductDetailDTO.setImageList(new ArrayList<>());
        for (OrgProductsImages images:imagesList){
            myProductDetailDTO.getImageList().add(images.getImageUrl());
        }
        return myProductDetailDTO;
    }
}
