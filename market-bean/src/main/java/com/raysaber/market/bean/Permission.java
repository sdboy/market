package com.raysaber.market.bean;

import java.util.Date;

/**
 * Database Table Remarks:
 *   权限表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table PERMISSION_TABLE
 */
public class Permission {
    /**
     * Database Column Remarks:
     *   权限id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERMISSION_TABLE.SID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    private Long sid;

    /**
     * Database Column Remarks:
     *   权限唯一id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERMISSION_TABLE.PERMISSION_UUID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    private String permissionUuid;

    /**
     * Database Column Remarks:
     *   资源唯一id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERMISSION_TABLE.RESOURCE_UUID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    private String resourceUuid;

    /**
     * Database Column Remarks:
     *   资源类型唯一id，比如用户、页面
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERMISSION_TABLE.RESOURCE_TYPE_UUID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    private String resourceTypeUuid;

    /**
     * Database Column Remarks:
     *   对资源拥有的操作
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERMISSION_TABLE.RESOURCE_PRIVILEGES
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    private String resourcePrivileges;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERMISSION_TABLE.CREATE_DATE
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    private Date createDate;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PERMISSION_TABLE.UPDATE_DATE
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERMISSION_TABLE
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public Permission(Long sid, String permissionUuid, String resourceUuid, String resourceTypeUuid, String resourcePrivileges, Date createDate, Date updateDate) {
        this.sid = sid;
        this.permissionUuid = permissionUuid;
        this.resourceUuid = resourceUuid;
        this.resourceTypeUuid = resourceTypeUuid;
        this.resourcePrivileges = resourcePrivileges;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PERMISSION_TABLE
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public Permission() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERMISSION_TABLE.SID
     *
     * @return the value of PERMISSION_TABLE.SID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public Long getSid() {
        return sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERMISSION_TABLE.SID
     *
     * @param sid the value for PERMISSION_TABLE.SID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public void setSid(Long sid) {
        this.sid = sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERMISSION_TABLE.PERMISSION_UUID
     *
     * @return the value of PERMISSION_TABLE.PERMISSION_UUID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public String getPermissionUuid() {
        return permissionUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERMISSION_TABLE.PERMISSION_UUID
     *
     * @param permissionUuid the value for PERMISSION_TABLE.PERMISSION_UUID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public void setPermissionUuid(String permissionUuid) {
        this.permissionUuid = permissionUuid == null ? null : permissionUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERMISSION_TABLE.RESOURCE_UUID
     *
     * @return the value of PERMISSION_TABLE.RESOURCE_UUID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public String getResourceUuid() {
        return resourceUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERMISSION_TABLE.RESOURCE_UUID
     *
     * @param resourceUuid the value for PERMISSION_TABLE.RESOURCE_UUID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public void setResourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid == null ? null : resourceUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERMISSION_TABLE.RESOURCE_TYPE_UUID
     *
     * @return the value of PERMISSION_TABLE.RESOURCE_TYPE_UUID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public String getResourceTypeUuid() {
        return resourceTypeUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERMISSION_TABLE.RESOURCE_TYPE_UUID
     *
     * @param resourceTypeUuid the value for PERMISSION_TABLE.RESOURCE_TYPE_UUID
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public void setResourceTypeUuid(String resourceTypeUuid) {
        this.resourceTypeUuid = resourceTypeUuid == null ? null : resourceTypeUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERMISSION_TABLE.RESOURCE_PRIVILEGES
     *
     * @return the value of PERMISSION_TABLE.RESOURCE_PRIVILEGES
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public String getResourcePrivileges() {
        return resourcePrivileges;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERMISSION_TABLE.RESOURCE_PRIVILEGES
     *
     * @param resourcePrivileges the value for PERMISSION_TABLE.RESOURCE_PRIVILEGES
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public void setResourcePrivileges(String resourcePrivileges) {
        this.resourcePrivileges = resourcePrivileges == null ? null : resourcePrivileges.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERMISSION_TABLE.CREATE_DATE
     *
     * @return the value of PERMISSION_TABLE.CREATE_DATE
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERMISSION_TABLE.CREATE_DATE
     *
     * @param createDate the value for PERMISSION_TABLE.CREATE_DATE
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PERMISSION_TABLE.UPDATE_DATE
     *
     * @return the value of PERMISSION_TABLE.UPDATE_DATE
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PERMISSION_TABLE.UPDATE_DATE
     *
     * @param updateDate the value for PERMISSION_TABLE.UPDATE_DATE
     *
     * @mbg.generated Tue Apr 20 04:22:09 CST 2021
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}