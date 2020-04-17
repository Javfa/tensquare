package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 朱力翁
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
  private final LabelService labelService;
  
  public LabelController(LabelService labelService) {
    this.labelService = labelService;
  }
  
  /**
   * @Description: findAll
   * @Param: []
   * @Return: entity.Result
   * @Author: Mr. Jf
   * @Time: 2020/4/16 10:40
   */
  @RequestMapping(method = RequestMethod.GET)
  public Result findAll() {
    return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
  }
  
  @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
  public Result findById(@PathVariable("labelId") String labelId) {
    return new Result(true, StatusCode.OK, "查询成功",
            labelService.findById(labelId));
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Result save(@RequestBody Label label) {
    labelService.save(label);
    return new Result(true, StatusCode.OK, "保存成功");
  }
  
  /**
   * @Description: update
   * @Param: [labelId, label]
   * @Return: entity.Result
   * @Author: Mr. Jf
   * @Time: 2020/4/17 3:23
   */
  @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
  public Result update(@PathVariable String labelId, @RequestBody Label label) {
    label.setId(labelId);
    labelService.update(label);
    return new Result(true, StatusCode.OK, "更新成功");
  }
  
  /**
   * @Description: deleteById
   * @Param: [labelId]
   * @Return: entity.Result
   * @Author: Mr. Jf
   * @Time: 2020/4/9 14:55
   */
  @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
  public Result deleteById(@PathVariable String labelId) {
    labelService.deleteById(labelId);
    return new Result(true, StatusCode.OK, "删除成功");
  }
  
  /**
   * @Description: findSearch
   * @Param: [label]
   * @Return: entity.Result
   * @Author: Mr. Jf
   * @Time: 2020/4/9 14:54
   */
  @RequestMapping(value = "/search", method = RequestMethod.POST)
  public Result findSearch(@RequestBody Label label){
    List<Label> list = labelService.findSearch(label);
    return new Result(true, StatusCode.OK, "查询成功", list);
  }
  
  @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
  public Result pageQuery(@RequestBody Label label, @PathVariable int page,
                          @PathVariable int size){
    Page<Label> pageData = labelService.pageQuery(label, page, size);
    return new Result(true, StatusCode.OK, "查询成功",
            new PageResult<Label>(pageData.getTotalElements(), pageData.getContent()));
  }
}
