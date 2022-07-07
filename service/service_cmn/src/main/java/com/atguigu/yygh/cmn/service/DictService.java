package com.atguigu.yygh.cmn.service;

import com.atguigu.yygh.model.cmn.Dict;
import com.atguigu.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface DictService extends IService<Dict> {
    //search children list by id
    List<Dict> findChildData(Long id);

    void exportDictData(HttpServletResponse response) throws IOException;

    void importDictData(MultipartFile file) throws IOException;
}
