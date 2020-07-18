package com.ssm.entity;

import javax.persistence.*;

@Table(name = "`tab_file`")
public class TabFile {
    @Id
    @Column(name = "`fileid`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileid;

    @Column(name = "`filename`")
    private String filename;

    @Column(name = "`fileurl`")
    private String fileurl;

    /**
     * @return fileid
     */
    public Integer getFileid() {
        return fileid;
    }

    /**
     * @param fileid
     */
    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    /**
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * @return fileurl
     */
    public String getFileurl() {
        return fileurl;
    }

    /**
     * @param fileurl
     */
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }
}