package com.osi.creasol.data;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HappyMomentsImage
{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("album_name")
    @Expose
    private String albumName;
    @SerializedName("school_id")
    @Expose
    private Integer schoolId;
    @SerializedName("branch_id")
    @Expose
    private Integer branchId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("cc_happy_moment_class_divisions")
    @Expose
    private List<CcHappyMomentClassDivision> ccHappyMomentClassDivisions = null;
    @SerializedName("cc_happy_moments_gallaries")
    @Expose
    private List<Object> ccHappyMomentsGallaries = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<CcHappyMomentClassDivision> getCcHappyMomentClassDivisions() {
        return ccHappyMomentClassDivisions;
    }

    public void setCcHappyMomentClassDivisions(List<CcHappyMomentClassDivision> ccHappyMomentClassDivisions) {
        this.ccHappyMomentClassDivisions = ccHappyMomentClassDivisions;
    }

    public List<Object> getCcHappyMomentsGallaries() {
        return ccHappyMomentsGallaries;
    }

    public void setCcHappyMomentsGallaries(List<Object> ccHappyMomentsGallaries) {
        this.ccHappyMomentsGallaries = ccHappyMomentsGallaries;
    }

}
