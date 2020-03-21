
package com.osi.creasol.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CcDivision {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("class_id")
    @Expose
    private Integer classId;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
