package com.onboard.domain.mapper.model;

import com.onboard.domain.mapper.model.common.BaseItem;

public class ProjectTodoStatusObject implements BaseItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_todo_status.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_todo_status.projectId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project_todo_status.status
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_todo_status.id
     *
     * @return the value of project_todo_status.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_todo_status.id
     *
     * @param id the value for project_todo_status.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_todo_status.projectId
     *
     * @return the value of project_todo_status.projectId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_todo_status.projectId
     *
     * @param projectId the value for project_todo_status.projectId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_todo_status.status
     *
     * @return the value of project_todo_status.status
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_todo_status.status
     *
     * @param status the value for project_todo_status.status
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_todo_status
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public ProjectTodoStatusObject(ProjectTodoStatusObject parent) {
        this.id = parent.getId();
        this.projectId = parent.getProjectId();
        this.status = parent.getStatus();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_todo_status
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public ProjectTodoStatusObject() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_todo_status
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public ProjectTodoStatusObject(int id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_todo_status
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    @Override
    public ProjectTodoStatusObject copy() {
        return new ProjectTodoStatusObject(this);
    }
}