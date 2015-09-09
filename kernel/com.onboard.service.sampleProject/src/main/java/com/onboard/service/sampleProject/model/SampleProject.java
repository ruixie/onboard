package com.onboard.service.sampleProject.model;

import java.util.List;

import com.onboard.domain.model.Discussion;
import com.onboard.domain.model.Document;
import com.onboard.domain.model.Project;
import com.onboard.domain.model.Todolist;

/**
 * 示例项目的model,与sample-project.json对应
 * 
 * @author xingliang
 * 
 */
public class SampleProject {

    private Project sampleProject;

    private List<Discussion> sampleDiscussions;

    private List<Todolist> sampleTodolists;

    private List<Document> sampleDocuments;

    private List<SampleFile> sampleFiles;

    public Project getSampleProject() {
        return sampleProject;
    }

    public void setSampleProject(Project sampleProject) {
        this.sampleProject = sampleProject;
    }

    public List<Discussion> project() {
        return sampleDiscussions;
    }

    public void setSampleDiscussions(List<Discussion> sampleDiscussions) {
        this.sampleDiscussions = sampleDiscussions;
    }

    public List<Todolist> getSampleTodolists() {
        return sampleTodolists;
    }

    public void setSampleTodolists(List<Todolist> sampleTodolists) {
        this.sampleTodolists = sampleTodolists;
    }

    public List<Discussion> getSampleDiscussions() {
        return sampleDiscussions;
    }

    public List<Document> getSampleDocuments() {
        return sampleDocuments;
    }

    public void setSampleDocuments(List<Document> sampleDocuments) {
        this.sampleDocuments = sampleDocuments;
    }

    public List<SampleFile> getSampleFiles() {
        return sampleFiles;
    }

    public void setSampleFiles(List<SampleFile> sampleFiles) {
        this.sampleFiles = sampleFiles;
    }

}
