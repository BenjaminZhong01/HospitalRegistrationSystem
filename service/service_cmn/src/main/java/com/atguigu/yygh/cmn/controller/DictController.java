package com.atguigu.yygh.cmn.controller;

import com.atguigu.yygh.cmn.service.DictService;
import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Api(value = "Data Dictionary API")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;

    //import data dictionary
    @PostMapping("importData")
    public Result importDict(MultipartFile file) throws IOException {
        dictService.importDictData(file);
        return Result.ok();
    }

    //Export data dictionary
    @GetMapping("exportData")
    public void exportDict(HttpServletResponse response) throws IOException {
        dictService.exportDictData(response);
    }
    //search children list by id
    @ApiOperation(value = "search children list by id")
    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChildData(id);
        return Result.ok(list);
    }
}
