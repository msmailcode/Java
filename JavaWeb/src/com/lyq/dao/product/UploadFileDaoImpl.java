package com.msmailcode.javawebshop.dao.product;

import org.springframework.stereotype.Repository;

import com.msmailcode.javawebshop.dao.DaoSupport;
import com.msmailcode.javawebshop.model.product.UploadFile;
@Repository("uploadFileDao")
public class UploadFileDaoImpl extends DaoSupport<UploadFile> implements UploadFileDao {

}
