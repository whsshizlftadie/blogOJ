package com.whs.bean;

import javax.persistence.*;

@Entity(name = "oj_table")
public class Problem {
    // 题目的编号
    @Id
    @GeneratedValue
    private Long id;
    // 题目的标题
    private String title;
    // 题目的难度级别
    private String level;
    // 题目的详细描述
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String description;
    // 题目的模板代码
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String templateCode;
    // 题目的测试用例代码
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String testCode;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTestCode() {
        return testCode;
    }

    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", level='" + level + '\'' +
                ", description='" + description + '\'' +
                ", templateCode='" + templateCode + '\'' +
                ", testCode='" + testCode + '\'' +
                '}';
    }
}
