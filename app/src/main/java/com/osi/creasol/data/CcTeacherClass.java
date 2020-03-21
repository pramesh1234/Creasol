
package com.osi.creasol.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CcTeacherClass {

    @SerializedName("teacher_id")
    @Expose
    private Integer teacherId;
    @SerializedName("class_id")
    @Expose
    private Integer classId;
    @SerializedName("cc_class")
    @Expose
    private CcClass ccClass;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public CcClass getCcClass() {
        return ccClass;
    }

    public void setCcClass(CcClass ccClass) {
        this.ccClass = ccClass;
    }

}
