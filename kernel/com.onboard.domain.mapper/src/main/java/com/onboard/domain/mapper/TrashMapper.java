package com.onboard.domain.mapper;

import com.onboard.domain.mapper.model.TrashExample;
import com.onboard.domain.model.Trash;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrashMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    int countByExample(TrashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    int deleteByExample(TrashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    int insert(Trash record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    int insertSelective(Trash record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    List<Trash> selectByExample(TrashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    Trash selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    int updateByExampleSelective(@Param("record") Trash record, @Param("example") TrashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    int updateByExample(@Param("record") Trash record, @Param("example") TrashExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    int updateByPrimaryKeySelective(Trash record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trash
     *
     * @mbggenerated Sat Jul 11 20:33:30 CST 2015
     */
    int updateByPrimaryKey(Trash record);
}
