package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/*
 * @Description: SpitController
 * @Author: Mr. Jf
 * @Time: 2020/4/11 16:02
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {
  
  @Autowired
  private SpitService spitService;
  
  @RequestMapping(method = RequestMethod.GET)
  public Result findAll() {
    return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Result findOne(@PathVariable String id) {
    return new Result(true, StatusCode.OK, "查询成功", spitService.findById(id));
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public Result add(@RequestBody Spit spit) {
    spitService.add(spit);
    return new Result(true, StatusCode.OK, "增加成功");
  }
  
  /*
   * @Description: update
   * @Param: [spit, id]
   * @Return: entity.Result
   * @Author: Mr. Jf
   * @Time: 2020/4/11 18:58
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Result update(@RequestBody Spit spit, @PathVariable String id) {
    spit.set_id(id);
    spitService.update(spit);
    return new Result(true, StatusCode.OK, "修改成功");
  }
  
  /*
   * @Description: 删除
   * @Param:
   * @Return:
   * @Author: Mr. Jf
   * @Time: 2020/4/11 16:14
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public Result deleteById(@PathVariable String id) {
    spitService.deleteById(id);
    return new Result(true, StatusCode.OK, "删除成功");
  }
  
  /*
   * @Description: findByParentid
   * @Param: [parentid, page, size]
   * @Return: entity.Result
   * @Author: Mr. Jf
   * @Time: 2020/4/11 21:11
   */
  @RequestMapping(value = "/comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
  public Result findByParentid(@PathVariable String parentid,
                               @PathVariable int page, @PathVariable int size) {
    Page<Spit> pageData = spitService.findByParentid(parentid, page, size);
    return new Result(true, StatusCode.OK, "查询成功",
            new PageResult<Spit>(pageData.getTotalElements(), pageData.getContent()));
  }
  
  @RequestMapping(value = "/thumbup/{spitId}", method = RequestMethod.PUT)
  public Result thumbup(@PathVariable String spitId) {
    spitService.thumbup(spitId);
    return new Result(true, StatusCode.OK, "点赞成功");
  }
  
  
}
