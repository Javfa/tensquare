package com.tensquare.base.service;

import com.tensquare.base.pojo.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import util.IdWorker;
import com.tensquare.base.dao.LabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.sql.InFragment.NULL;

@Service
@Transactional
public class LabelService {
  @Autowired
  private LabelDao labelDao;
  @Autowired
  private IdWorker idWorker;
  
  public List<Label> findAll() {
    return labelDao.findAll();
  }
  
  /**
   * @Description: findById
   * @Param: [id]
   * @Return: com.javfa.base.pojo.Label
   * @Author: Mr. Jf
   * @Time: 2020/4/9 14:51
   */
  public Label findById(String id) {
    return labelDao.findById(id).get();
  }
  
  /*
    * @Description: save
    * @Param: [label]
    * @Return: void
    * @Author: Mr. Jf
    * @Time: 2020/4/9 14:46
    */
  public void save(Label label) {
    label.setId(idWorker.nextId() + "");
    labelDao.save(label);
  }
  
  /*
   * @Description: update
   * @Param: [label]
   * @Return: void
   * @Author: Mr. Jf
   * @Time: 2020/4/9 14:59
   */
  public void update(Label label) {
    labelDao.save(label);
  }
  
  /*
   * @Description: deleteById
   * @Param: [id]
   * @Return: void
   * @Author: Mr. Jf
   * @Time: 2020/4/9 14:59
   */
  public void deleteById(String id) {
    labelDao.deleteById(id);
  }
  
  /*
   * @Description: findSearch
   * @Param: [label]
   * @Return: java.util.List<com.javfa.base.pojo.Label>
   * @Author: Mr. Jf
   * @Time: 2020/4/9 14:58
   */
  public List<Label> findSearch(Label label) {
    return labelDao.findAll(new Specification<Label>() {
      /*
       * @Description: toPredicate 拼接sql语句
       * @Param: [root 根对象，也就是要把查询条件封装到哪个对象中,
       * query 封装的都是查询关键字 比如group by order by等,
       * cb 用来封装条件对象的]
       * @Return: javax.persistence.criteria.Predicate
       * @Author: Mr. Jf
       * @Time: 2020/4/10 11:09
       */
      @Override
      public Predicate toPredicate(Root<Label> root,
                                   CriteriaQuery<?> query,
                                   CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<>();
        if(label.getLabelname() != NULL & !"".equals(label.getLabelname())) {
          Predicate predicate = cb.like(root.get("labelname").as(String.class),
                  "%" + label.getLabelname() + "%"); // where labelname like
          // "%小明%"
          list.add(predicate);
        }
        if(label.getState() != NULL & !"".equals(label.getState())) {
          Predicate predicate = cb.equal(root.get("state").as(String.class),
                  label.getState()); // where state="1"
        }
        Predicate[] parr = new Predicate[list.size()];
        parr = list.toArray(parr);
        return cb.and(parr);
      }
    });
  }
  
  public Page<Label> pageQuery(Label label, int page, int size) {
    Pageable pageable = PageRequest.of(page-1, size);
    return labelDao.findAll(new Specification<Label>() {
      /*
       * @Description: toPredicate 拼接sql语句
       * @Param: [root 根对象，也就是要把查询条件封装到哪个对象中,
       * query 封装的都是查询关键字 比如group by order by等,
       * cb 用来封装条件对象的]
       * @Return: javax.persistence.criteria.Predicate
       * @Author: Mr. Jf
       * @Time: 2020/4/10 11:09
       */
      @Override
      public Predicate toPredicate(Root<Label> root,
                                   CriteriaQuery<?> query,
                                   CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<>();
        if(label.getLabelname() != NULL & !"".equals(label.getLabelname())) {
          Predicate predicate = cb.like(root.get("labelname").as(String.class),
                  "%" + label.getLabelname() + "%"); // where labelname like
          // "%小明%"
          list.add(predicate);
        }
        if(label.getState() != NULL & !"".equals(label.getState())) {
          Predicate predicate = cb.equal(root.get("state").as(String.class),
                  label.getState()); // where state="1"
        }
        Predicate[] parr = new Predicate[list.size()];
        parr = list.toArray(parr);
        return cb.and(parr);
      }
    }, pageable);
  }
}
