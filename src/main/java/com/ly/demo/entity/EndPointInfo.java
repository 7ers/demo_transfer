package com.ly.demo.entity;

import java.util.Date;

public class EndPointInfo {
    private Integer id;

    /**
     * App-name:App name (may be aliased at the publisher’s request).
     */
    private String appName;

    /**
     * App-bundle:A platform-specific application identifier intended to be unique to the app and independent of the exchange. On Android, this should be a bundle or package name (e.g., com.foo.mygame). On iOS, it is a numeric ID.
     */
    private String appBundle;

    /**
     * App-id:Exchange-specific app ID.
     */
    private String appId;

    /**
     * App-storeurl:App store URL for an installed app; for IQG 2.1 compliance.
     */
    private String appStoreurl;

    /**
     * Device-idfa:IDFA of the iOS device.
     */
    private String deviceIdfa;

    /**
     * Device-ip:IPv4 address closest to device.
     */
    private String deviceIp;

    /**
     * Device-ua:Browser user agent string.
     */
    private String deviceUa;

    /**
     * Device-os:Device operating system (e.g., “iOS”)
     */
    private String deviceOs;

    /**
     * Device-osv:Device operating system version (e.g., “3.1.2”).
     */
    private String deviceOsv;

    /**
     * Device-devicetype:The general type of device.
     * Dic:
     * 1-Mobile/Tablet
     * 2-Personal Computer
     * 3-Connected TV
     * 4-Phone
     * 5-Tablet
     * 6-Connected Device
     * 7-Set Top Box
     */
    private String deviceDevicetype;

    /**
     * Device-carrier:Carrier or ISP (e.g., “VERIZON”). “WIFI” is often used in mobile to indicate high bandwidth (e.g., video friendly vs. cellular).
     */
    private String deviceCarrier;

    /**
     * Device-geo:Location of the device assumed to be the user’s current location defined by a Geo object.
     */
    private String deviceGeo;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;

    public Date getPartiDate() {
        return partiDate;
    }

    public void setPartiDate(Date partiDate) {
        this.partiDate = partiDate;
    }

    private Date partiDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppBundle() {
        return appBundle;
    }

    public void setAppBundle(String appBundle) {
        this.appBundle = appBundle == null ? null : appBundle.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppStoreurl() {
        return appStoreurl;
    }

    public void setAppStoreurl(String appStoreurl) {
        this.appStoreurl = appStoreurl == null ? null : appStoreurl.trim();
    }

    public String getDeviceIdfa() {
        return deviceIdfa;
    }

    public void setDeviceIdfa(String deviceIdfa) {
        this.deviceIdfa = deviceIdfa == null ? null : deviceIdfa.trim();
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp == null ? null : deviceIp.trim();
    }

    public String getDeviceUa() {
        return deviceUa;
    }

    public void setDeviceUa(String deviceUa) {
        this.deviceUa = deviceUa == null ? null : deviceUa.trim();
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs == null ? null : deviceOs.trim();
    }

    public String getDeviceOsv() {
        return deviceOsv;
    }

    public void setDeviceOsv(String deviceOsv) {
        this.deviceOsv = deviceOsv == null ? null : deviceOsv.trim();
    }

    public String getDeviceDevicetype() {
        return deviceDevicetype;
    }

    public void setDeviceDevicetype(String deviceDevicetype) {
        this.deviceDevicetype = deviceDevicetype == null ? null : deviceDevicetype.trim();
    }

    public String getDeviceCarrier() {
        return deviceCarrier;
    }

    public void setDeviceCarrier(String deviceCarrier) {
        this.deviceCarrier = deviceCarrier == null ? null : deviceCarrier.trim();
    }

    public String getDeviceGeo() {
        return deviceGeo;
    }

    public void setDeviceGeo(String deviceGeo) {
        this.deviceGeo = deviceGeo == null ? null : deviceGeo.trim();
    }
}