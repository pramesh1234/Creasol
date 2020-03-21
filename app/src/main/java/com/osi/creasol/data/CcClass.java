
package com.osi.creasol.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CcClass {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("school_id")
    @Expose
    private Integer schoolId;
    @SerializedName("branch_id")
    @Expose
    private Integer branchId;
    @SerializedName("cc_divisions")
    @Expose
    private List<CcDivision> ccDivisions = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<CcDivision> getCcDivisions() {
        return ccDivisions;
    }

    public void setCcDivisions(List<CcDivision> ccDivisions) {
        this.ccDivisions = ccDivisions;
    }

}
