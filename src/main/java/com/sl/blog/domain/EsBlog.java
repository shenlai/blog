package com.sl.blog.domain;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.Date;

@Document(indexName = "sl_blog", type = "blog")
public class EsBlog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id  // 主键
    private String id;

    private String title;

    //@Field(index = false)
    private Date create_time;

    //@Field(index = false,type = FieldType.Long)
    private  Long user_id;

    private String tags;

    //@Field(index = false,type = FieldType.Long)
    private Long read_size;


    private Long catalog_id;

    private String summary;

    //@Field(index = false,type = FieldType.Long)
    private Long comment_size;

    //@Field(index = false,type = FieldType.Long)
    private Long like_size;

    private String content;

    private String username;

    protected EsBlog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getRead_size() {
        return read_size;
    }

    public void setRead_size(Long read_size) {
        this.read_size = read_size;
    }


    public Long getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(Long catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getComment_size() {
        return comment_size;
    }

    public void setComment_size(Long comment_size) {
        this.comment_size = comment_size;
    }

    public Long getLike_size() {
        return like_size;
    }

    public void setLike_size(Long like_size) {
        this.like_size = like_size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

