package com.tenpen.base.service.photos.impl;

import com.tenpen.base.dao.OrgPhotosImagesMapper;
import com.tenpen.base.dao.OrgPhotosMapper;
import com.tenpen.base.domain.model.OrgPhotos;
import com.tenpen.base.domain.model.OrgPhotosExample;
import com.tenpen.base.domain.model.OrgPhotosImages;
import com.tenpen.base.domain.model.OrgPhotosImagesExample;
import com.tenpen.base.enums.ImageStatusEnum;
import com.tenpen.base.enums.PhotoStatusEnum;
import com.tenpen.base.exceptions.ServiceException;
import com.tenpen.base.service.order.impl.OrderServiceImpl;
import com.tenpen.base.service.photos.PhotoService;
import com.tenpen.base.util.FastJsonUtils;
import com.tenpen.base.util.ParamsUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PhotoServiceImpl implements PhotoService {

    private static final Logger logger = LoggerFactory.getLogger(PhotoServiceImpl.class);

    @Autowired
    OrgPhotosMapper orgPhotosMapper;

    @Autowired
    OrgPhotosImagesMapper orgPhotosImagesMapper;


    @Override
    public void deletePhoto(String params) {

        ParamsUtils.checkParams(params);

        String photosId = (String) FastJsonUtils.getValueByKey(params, "photosId");
        String userId = (String) FastJsonUtils.getValueByKey(params, "userId");

        if (StringUtils.isBlank(photosId)) {
            throw new ServiceException("photosId is null!");
        }

        if (StringUtils.isBlank(userId)) {
            throw new ServiceException("userId is null!");
        }

        OrgPhotosExample photosExample = new OrgPhotosExample();

        OrgPhotos photos = orgPhotosMapper.selectByPrimaryKey(photosId);
        if (photos == null) {
            throw new ServiceException("photo is null!");
        }
        // 查询对应的图片
        OrgPhotosImagesExample imagesExample = new OrgPhotosImagesExample();
        imagesExample.createCriteria().andSefPhotosIdEqualTo(photos.getId());
        List<OrgPhotosImages> imagesList = orgPhotosImagesMapper.selectByExample(imagesExample);
        // 用于删除阿里云上的照片存储
        List<String> md5List = new ArrayList<>();
        for (OrgPhotosImages images : imagesList) {
            md5List.add(images.getImageMd5());

            OrgPhotosImages newImg = new OrgPhotosImages();
            newImg.setId(images.getId());
            newImg.setLastUpdateTime(new Date());
            newImg.setLastUpdateVersion(images.getLastUpdateVersion() + 1);
            newImg.setStatus(ImageStatusEnum.INVALID.getStatus());
            newImg.setRemark("delete photo!");

            imagesExample.clear();
            imagesExample.createCriteria().andIdEqualTo(images.getId()).andLastUpdateVersionEqualTo(images.getLastUpdateVersion());
            orgPhotosImagesMapper.updateByExampleSelective(newImg, imagesExample);
        }

        OrgPhotos newPhoto = new OrgPhotos();
        newPhoto.setId(photos.getId());
        newPhoto.setLastUpdateTime(new Date());
        newPhoto.setLastUpdateVersion(photos.getLastUpdateVersion() + 1);
        newPhoto.setStatus(PhotoStatusEnum.DELETE.getStatus());

        photosExample.clear();
        photosExample.createCriteria().andIdEqualTo(photos.getId()).andLastUpdateVersionEqualTo(photos.getLastUpdateVersion());
        orgPhotosMapper.updateByExampleSelective(newPhoto, photosExample);

        // todo 调用阿里云删除对应的照片存储
        
    }
}
